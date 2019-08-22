package Basic.dynamic_programming.bin.edu.lsy.JUC;

/**
 *
 * @author ASUS
 * synchronized实现
 * 思路
 * 使用同步块和 wait、notify 的方法控制三个线程的执行次序。
 * 具体方法如下：从大的方向上来讲，该问题为三线程间的同步唤醒
 * 操作，主要的目的就是ThreadA->ThreadB->ThreadC->ThreadA
 * 循环执行三个线程。为了控制线程执行的顺序，那么就必须要确定
 * 唤醒、等待的顺序，所以每一个线程必须同时持有两个对象锁，才
 * 能进行打印操作。一个对象锁是prev，就是前一个线程所对应的
 * 对象锁，其主要作用是保证当前线程一定是在前一个线程操作完成
 * 后（即前一个线程释放了其对应的对象锁）才开始执行。还有一个
 * 锁就是自身对象锁。主要的思想就是，为了控制执行的顺序，必须
 * 要先持有prev锁（也就前一个线程要释放其自身对象锁），然后
 * 当前线程再申请自己对象锁，两者兼备时打印。之后首先调用self.notify()唤醒
 * 下一个等待线程（注意notify不会立即释放对象锁，只有等到
 * 同步块代码执行完毕后才会释放），再调用prev.wait()立即
 * 释放prev对象锁，当前线程进入休眠，等待其他线程的notify操作再次唤醒
 */
public class ABC implements Runnable{
	private  int count;
	private String name ;
	private Object next;
	private Object now;
	
	public ABC (String name, Object next, Object now){
		this.name =name;
		this.next = next;
		this.now = now;
	}
	
	public void run() {
		count = 0;
		while(count++ < 10) {
			synchronized (next) {
				synchronized (now) {
					System.out.println(count + ":" +  name);
					now.notify();
				}
				try {
					if(count == 10){
						next.notify();
					}else{
						next.wait();	
					}
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String [] args){
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		Thread A = new Thread(new ABC("A",c,a));
		Thread B = new Thread(new ABC("B",a,b));
		Thread C = new Thread(new ABC("C",b,c));
		
		
		try {
			A.start();
			Thread.sleep(10);
			B.start();
			Thread.sleep(10);
			C.start();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
	