package Basic.dynamic_programming.bin.edu.lsy.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestABC {

	public static void main(String[] args) {
		final AlternateDemo ad = new AlternateDemo();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					ad.loopA(i);
				}
			}
		},"A").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					ad.loopB(i);
				}
			}
		},"B").start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					ad.loopC(i);
				}
			}
		},"C").start();
		
	}
}

/*
 * ����
 */
class AlternateDemo{
	
	private int num = 1;// ��������ִ���̵߳ı��
	
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition(); 
	private Condition condition2 = lock.newCondition(); 
	private Condition condition3 = lock.newCondition(); 
	
	/**
	 * 
	 * @param totalLoop ѭ������
	 */
	
	public void loopA(int totalLoop){
		lock.lock();
		
		try {
			
			//1. �ж�
			if(num != 1){
				condition1.await();
			}
			//2. ��ӡ
			for (int i = 0; i < 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			
			//3. ����
			num = 2;
			condition2.signal();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void loopB(int totalLoop){
		lock.lock();
		
		try {
			
			//1. �ж�
			if(num != 2){
				condition2.await();
			}
			//2. ��ӡ
			for (int i = 0; i < 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			
			//3. ����
			num = 3;
			condition3.signal();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void loopC(int totalLoop){
		lock.lock();
		
		try {
			//1. �ж�
			if(num != 3){
				condition3.await();
			}
			//2. ��ӡ
			for (int i = 0; i < 1; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			
			//3. ����
			num = 1;
			condition1.signal();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}
