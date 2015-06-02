
public class RaceCondition extends Thread{
	static int counter=0;
	Thread toWait;
	public static void increment(){ 
		for(int i=0;i<2000000;i++){
			counter++;
		}
		System.out.println(counter);
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		RaceCondition A = new RaceCondition();
		RaceCondition B = new RaceCondition();
		A.toWait=B;
		A.start();
		A.join();
		B.start();
		B.join();

		
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method  
		if (toWait!=null) {
			try {
				toWait.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName());
		increment();
		
	}

}
