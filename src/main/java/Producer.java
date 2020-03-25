import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
	private BlockingQueue<URL> queue;

	public Producer(BlockingQueue<URL> q)
	{
		this.queue = q;
	}

	public void run()
	{
		URLsFromFile urls = new URLsFromFile();
		ArrayList<URL> normalizeUrls = null;
		URL endUrls = null;
		try
		{
			normalizeUrls = urls.getNormalizeUrlFromFile();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//produce messages
		for (URL url : normalizeUrls)
		{

			try
			{
				Thread.sleep(10);
				queue.put(url);
				System.out.println("Produced " + url.getPath());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		try
		{

			queue.put(new URL("https://End"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
