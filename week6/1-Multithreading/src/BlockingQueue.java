import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue{
	public static void main(String[] args) {
		QueueThread q = new QueueThread();
		Customer c = new Customer(q, "Pesho");
		c.start();
		Customer c1 = new Customer(q, "Ivan");
		c1.start();
		Customer c2 = new Customer(q, "Stoqn");
		c2.start();
		Producer p = new Producer(q);
		p.start();
	}
}
class QueueThread {

	int QUEUE_SIZE =5;
	Queue<String> q = new LinkedList<String>();
	
	synchronized void put(String msg) throws InterruptedException{
		while(q.size()==QUEUE_SIZE){
			wait();
		}
		q.add(msg);
		notifyAll();
	}
	synchronized String get() throws InterruptedException{
		while(q.size()==0){
			wait();
		}
		String msg =q.poll();
		notifyAll();
		return msg;
	}
}

class Customer extends Thread{
	public QueueThread q;
	String name;
	public Customer(QueueThread q,String name) {
		// TODO Auto-generated constructor stub
		this.q = q;
		this.name= name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				String msg =q.get();
				System.out.println(name+ " "+ msg);
				sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Producer extends Thread{
	public QueueThread q;
	public Producer(QueueThread q) {
		// TODO Auto-generated constructor stub
		this.q = q;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while(true){
				String msg = new Date().toString();
				q.put(msg);
				System.out.println(msg);
				sleep(200);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


