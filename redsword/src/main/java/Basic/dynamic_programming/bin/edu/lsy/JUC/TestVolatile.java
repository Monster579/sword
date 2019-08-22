package Basic.dynamic_programming.bin.edu.lsy.JUC;

public class TestVolatile {

	 public static void main(String[] args){
		 ThreadDemo td = new ThreadDemo();
		 new Thread(td).start();
		 
		 while(true){
			 if(td.isFlag()){
				 System.out.println("------");
				 break;
			}
		 }
		 
	 }
}
	 
class ThreadDemo implements Runnable{

	private volatile boolean flag = false;
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true;
		
		System.out.println("flag=" + isFlag());
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
