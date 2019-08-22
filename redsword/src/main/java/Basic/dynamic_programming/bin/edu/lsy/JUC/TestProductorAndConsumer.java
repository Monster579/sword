package Basic.dynamic_programming.bin.edu.lsy.JUC;

public class TestProductorAndConsumer {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		
		Productor pro = new Productor(clerk);
		Consumer cus = new Consumer(clerk);
		
		new Thread(pro,"������A").start();
		new Thread(cus,"������B").start();
		
		new Thread(pro,"������C").start();
		new Thread(cus,"������D").start();
		
	}
}
//
//class Clerk{
//	private int product = 0;
//	
//	//����
//	public synchronized void get(){
//		while(product >= 1){
//			System.out.println("��Ʒ����!");
//			
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(Thread.currentThread().getName() +" : " + ++product);
//		this.notifyAll();
//		
//	}
//	
//	//����
//	public synchronized void sale(){
//		while(product <= 0){
//			System.out.println("ȱ��!");
//			try {
//				this.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.println(Thread.currentThread().getName() + " : " + --product);
//		this.notifyAll();
//		
//	}
//}
//
////������
//class Productor implements Runnable{
//	
//	private Clerk clerk;
//	
//	public Productor(Clerk clerk){
//		this.clerk = clerk;
//	}
//	
//	public void run(){
//		for (int i = 0; i < 10; i++) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			clerk.get();
//		}
//	}
//}
//
//// ������
//class Consumer implements Runnable{
//	private Clerk clerk;
//	
//	public Consumer(Clerk clerk) {
//		this.clerk = clerk;
//	}
//	
//	@Override
//	public void run() {
//		for (int i = 0; i < 10; i++) {
//			clerk.sale();
//		}
//	}
//	
//}
