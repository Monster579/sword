package Basic.dynamic_programming.bin.edu.lsy.JUC;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {
	
	public static void main(String[] args) {
		AtomicDemo a = new AtomicDemo();
		for(int i = 0; i < 10; i++){
			new Thread(a).start();
		}
	}
}

class AtomicDemo implements Runnable{

//	private volatile int serialNumber = 0;
	private AtomicInteger serialNumber = new AtomicInteger();
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getSerialNumber());
	}
	
	public int getSerialNumber(){
		return serialNumber.getAndIncrement();
	}
	
}
