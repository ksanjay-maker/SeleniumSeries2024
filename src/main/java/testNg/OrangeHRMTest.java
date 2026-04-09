package testNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRMTest {
	
	WebDriver driver;
	
	@Test(priority=1)
	void openapp() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	void testLogo() throws InterruptedException {
		Thread.sleep(3000);
		boolean imgStatus = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Logo displayed: " +  imgStatus);
	}
	
	@Test(priority=3)
	void testLogin() {
	WebElement eleUsername = driver.findElement(By.xpath("//input[@placeholder='Username']"));
	eleUsername.clear();
	eleUsername.sendKeys("Admin");
	
	WebElement elePassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	elePassword.clear();
	elePassword.sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Test(priority=4)
	void closeApp() {
		driver.quit(); 
	}

}
