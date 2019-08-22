package Basic.dynamic_programming.bin.edu.lsy.JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * ������̰߳�ȫ����ķ�ʽ��
 * 
 * synchronized:��˽��
 * 1. ͬ�������
 * 
 * 2. ͬ������
 * 
 * 3. ͬ����lock  ��ʾ����ͨ��lock()����  unlock()�ͷ���
 */
public class TestLock {
	
	public static void main(String[] args) {
		LockDemo ticket = new LockDemo();
		
		new Thread(ticket,"1�Ŵ���").start();
		new Thread(ticket,"2�Ŵ���").start();
		new Thread(ticket,"3�Ŵ���").start();
	}
}

class LockDemo implements Runnable{

	private int tick = 100; 
 	private Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		while(tick > 0){
			lock.lock();
			try {
				if(tick > 0){
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName() + "��Ʊ����" + --tick);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally{
				lock.unlock();
			}
		}
	}
}
