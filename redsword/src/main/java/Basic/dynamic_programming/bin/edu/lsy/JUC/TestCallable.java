package Basic.dynamic_programming.bin.edu.lsy.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 *1. ����ִ���̵߳ķ�ʽ����ʵ��Callable�ӿڡ������ʵ��Runnable�ӿڵķ�ʽ����ʽ�����з���ֵ�����ҿ����ܳ��쳣
 * 
 *2. ִ��callable��ʽ����ҪFutureTask ʵ�����֧�֣����ڽ�����������FutureTask��Future�ӿڵ�ʵ����
 */
public class TestCallable {
	
	public static void main(String[] args) {
		CallableDemo td = new CallableDemo();
		
		// 1. ��ҪFutureTaskʵ�����֧�֣����ڽ��ܼ�����
		FutureTask<Integer> result = new FutureTask<>(td);
		
		new Thread(result).start();
		
		// 2. �����߳������Ľ��
		try {
			Integer sum = result.get();  // FuntureTas �����ڱ���
			System.out.println(sum + "============");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
class CallableDemo implements Callable<Integer>{

	public Integer call() throws Exception {
		int sum = 0;
		
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		
		return sum;
	}
	
}