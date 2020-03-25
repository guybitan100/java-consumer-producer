import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class URLsFromFile
{
	private ArrayList<URL> urls;

	private ArrayList<URL> normalize()
	{
		ArrayList<URL> normalizeUrls = new ArrayList<URL>();
		for (URL url : urls)
		{
			try
			{
				url.toURI();
				normalizeUrls.add(url);
			}

			catch (Exception e)
			{
				System.out.println("Invalid Url !! " + url.getPath());
			}
		}
		return normalizeUrls;
	}

	public ArrayList<URL> getNormalizeUrlFromFile() throws MalformedURLException
	{
		this.urls = new ArrayList<URL>();
		this.urls.add(new URL("https://app.codility.com/c/run/CL-B5MX85-2RX/"));
		this.urls.add(new URL("https:"));
		return normalize();
	}

	public static void main(String args[]) throws MalformedURLException
	{
		URLsFromFile urls = new URLsFromFile();
		urls.getNormalizeUrlFromFile();
	}
}