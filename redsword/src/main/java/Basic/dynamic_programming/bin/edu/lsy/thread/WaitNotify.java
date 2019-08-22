package Basic.dynamic_programming.bin.edu.lsy.thread;
class NumberPrint implements Runnable{  
    private int number;  
    public byte res[];  
    public static int count = 5;  
    public NumberPrint(int number, byte a[]){  
        this.number = number;  
        res = a;  
    }  
    public void run(){  
        synchronized (res){  
            while(count-- > 0){  
                try {  
                    res.notify();//���ѵȴ�res��Դ���̣߳����������̣߳���ͬ����ִ������Զ��ͷ�����  
                    System.out.println(" "+number);  
                    res.wait();//�ͷ�CPU����Ȩ���ͷ�res���������߳��������ȴ������ѡ�  
                    System.out.println("------�߳�"+Thread.currentThread().getName()+"�������wait()��Ĵ���������У�"+number);  
                } catch (InterruptedException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }//end of while  
            return;  
        }//synchronized  
          
    }  
}  
public class WaitNotify {  
    public static void main(String args[]){  
        final byte a[] = {0};//�Ըö���Ϊ������Դ  
        new Thread(new NumberPrint((1),a),"1").start();  
        new Thread(new NumberPrint((2),a),"2").start();  
    }
}