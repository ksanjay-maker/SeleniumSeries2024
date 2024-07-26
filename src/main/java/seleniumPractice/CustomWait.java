package seleniumPractice;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		By demo = By.linkText("Demo");
		
		retryingElement(demo, 2, 2000);


	}
	
	public static WebElement getElement(By locater) {
		return driver.findElement(locater);
	}

	public static WebElement retryingElement(By locater, int timeOut, int pollingTime) {
		
		WebElement element = null;
		int attempts = 0;
		
		while (attempts > timeOut) {
			
			try {
				element = getElement(locater);
				System.out.println("element is found in attempt: " + attempts);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("element is not found in attempt : " + attempts + " : " + " for " + locater );
				
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();					
				}
			}
			
			attempts++;
		}
		
		if(element==null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println("element is not found exception...tried for : " + timeOut + "secs" 
			     + "with the interval of : " + pollingTime + "ms" );				
			}
		}
		
		return element;
	}
}
