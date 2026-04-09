package seleniumPractice;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		// capture all the links from website
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links : " + links.size());
		
		int noOfBrokenLinks=0;

		for (WebElement linkElement : links) {
			String hrefAttValue = linkElement.getAttribute("href");

			if (hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("href attribute value is null or empty. So not possible to check");
				continue;
			}

			// hit url to the server

			try {
				// converted href value from string to URL format
				URL linkURL = new URL(hrefAttValue);
				// open connection the server
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
				// connect to the server and sent request to the server
				conn.connect();

				if (conn.getResponseCode() >= 400) {
					System.out.println(hrefAttValue + " ======> Broken Links");
					noOfBrokenLinks++;
				} else {
					System.out.println(hrefAttValue + " ======> Not a broken links");
				}
			} catch (Exception e) {

			}
		}
		
		System.out.println("Number of broken links: " + noOfBrokenLinks);
	}

}
