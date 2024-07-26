package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanjay Kumar\\eclipse-workspace\\SeleniumProjectSessions\\Drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sanjay Kumar\\eclipse-workspace\\SeleniumProjectSessions\\Drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		//cross browser logic
		String browser = "CHROME";
		
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
			break;
		}
		
		
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("The Title of the page is:" +title);
         
        String url = driver.getCurrentUrl();
        System.out.println(url);
        
        //close the browser
        driver.quit(); 

	}

}
