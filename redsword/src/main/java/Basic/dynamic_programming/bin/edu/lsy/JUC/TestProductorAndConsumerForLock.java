package Basic.dynamic_programming.bin.edu.lsy.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestProductorAndConsumerForLock {

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

class Clerk{
	private int product = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	//����
	public void get(){
		lock.lock();
		try {
			while(product >= 1){
				System.out.println("��Ʒ����!");
				
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() +" : " + ++product);
			condition.signalAll();
		} finally {
			lock.unlock();
		}
			
	}
	
	//����
	public synchronized void sale(){
		lock.lock();
		
		try {
			while(product <= 0){
				System.out.println("ȱ��!");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " : " + --product);
			condition.signalAll();

		} finally {
			lock.unlock();
		}
	}
}

//������
class Productor implements Runnable{
	
	private Clerk clerk;
	
	public Productor(Clerk clerk){
		this.clerk = clerk;
	}
	
	public void run(){
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.get();
		}
	}
}

// ������
class Consumer implements Runnable{
	private Clerk clerk;
	
	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			clerk.sale();
		}
	}
	
}
