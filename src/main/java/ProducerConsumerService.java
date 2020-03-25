import java.net.URL;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {

	public static void main(String[] args) {
		BlockingQueue<URL> queue = new ArrayBlockingQueue<URL>(10);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer).start();
		new Thread(consumer).start();
		System.out.println("Producer and Consumer has been started");
	}

}