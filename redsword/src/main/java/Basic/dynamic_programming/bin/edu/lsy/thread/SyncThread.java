package Basic.dynamic_programming.bin.edu.lsy.thread;

public class SyncThread implements Runnable{

	private static int count ;
	
	public void run() {
		int i = 0;
		synchronized(this){
			while(i++ < 5){
				try {
					System.out.println(Thread.currentThread().getName() + " : " + count++);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getCount(){
		return count;
	}

	public static void main(String[] args) {
		SyncThread sy1 = new SyncThread();
		Thread th1 = new Thread(sy1, "A");
		Thread th2 = new Thread(sy1, "B");
		th1.start();
		th2.start();
	}

}
