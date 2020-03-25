import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{

	private BlockingQueue<URL> queue;

	public Consumer(BlockingQueue<URL> q)
	{
		this.queue = q;
	}

	public void run()
	{
		try
		{
			URL url;
			while (!(url = queue.take()).getPath().equals(""))
			{
				Thread.sleep(10);
				System.out.println("Consumed " + url.getPath());
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
