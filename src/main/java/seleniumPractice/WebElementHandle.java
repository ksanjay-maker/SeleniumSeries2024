package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementHandle {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		//1.
		//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
		//		driver.findElement(By.id("input-password")).sendKeys("test@123");

		//2.
		//		WebElement emailId = driver.findElement(By.id("input-email"));
		//		emailId.sendKeys("test@gmail.com");
		//		WebElement password = driver.findElement(By.id("input-password"));
		//		password.sendKeys("test@123");

		//3. By locater
		//		By email = By.id("input-email");
		//		By password = By.id("input-password");
		//		
		//		WebElement emailId = driver.findElement(email);
		//		WebElement pwd = driver.findElement(password);
		//		
		//		emailId.sendKeys("test@gmail.com");
		//		pwd.sendKeys("test@123");

		//4. By locater with some generic functions
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//
//       getElement(email).sendKeys("input-password");
//       getElement(password).sendKeys("test@123");
		
		//5. By locater + getElement + actions generic function
//		By email = By.id("input-email");
//		By password = By.id("input-password");
//		
//		doSendKeys(email, "input-password");
//		doSendKeys(password, "test@123");
		
		//6. By locater + ElementUtil --->  generic functions
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "test@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
 
	}
	public static void doSendKeys(By locater, String value) {
		getElement(locater).sendKeys(value);
	}
	
	public static WebElement getElement(By locater) {
		return driver.findElement(locater);
	}

}
