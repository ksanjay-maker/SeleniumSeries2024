package seleniumPractice;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * this method is used to initialize the driver on the basis of browser name
	 * @param browser
	 */
	public WebDriver launchBrowser(String browser) {
		
		System.out.println("browser name is : " + browser );

		switch (browser.toLowerCase()) {
		case "chrome":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanjay Kumar\\eclipse-workspace\\SeleniumProjectSessions\\Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanjay Kumar\\eclipse-workspace\\SeleniumProjectSessions\\Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
			break;

		default:
			System.out.println("please pass the right browser.....");
			//break;
		} 

		return driver;
	}

	
	
	public void launchUrl(URL url) throws Exception{

		String newUrl = String.valueOf(url);

		if(newUrl==null) {
			System.out.println("url is null");
			throw new Exception("URLISNULL");
		}

		if(newUrl.length() == 0) {
			System.out.println("url is blank");
			throw new Exception("URLBLANKEXCEPTION");	
		}

		if(newUrl.indexOf("http")!=0 || newUrl.indexOf("https")!=0) {
			System.out.println("http(s) is missing in the url");
			throw new Exception("HTTP(s)MISSINGEXCEPTION");
		}

		driver.navigate().to(url);

	}

	public void launchUrl(String url) throws Exception{

		if(url==null) {
			System.out.println("url is null");
			throw new Exception("URLISNULL");
		}

		if(url.length() == 0) {
			System.out.println("url is blank");
			throw new Exception("URLBLANKEXCEPTION");	
		}

		if(url.indexOf("http")!=0 || url.indexOf("https")!=0) {
			System.out.println("http(s) is missing in the url");
			throw new Exception("HTTP(s)MISSINGEXCEPTION");
		}

		driver.get(url);

	}

	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("page title is :" +title);
		if(title!=null) {
			return title;			
		}
		else {
			System.out.println("getting null title....");
			return null;
		}
	}

	public String getPageUrl() {
		String url = driver.getTitle();
		System.out.println("page title is :" +url);
		if(url!=null) {
			return url;			
		}
		else {
			System.out.println("getting null title....");
			return null;
		}
	}

	public void closeBrowser() {
		if(driver!=null) {
			driver.close();
			System.out.println("browser is closed....");
		}
	}

	public void quitBrowser() {
		if(driver!=null) {
			driver.quit();
			System.out.println("browser is closed....");
		}
	}
}
