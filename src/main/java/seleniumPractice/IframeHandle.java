package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {
	
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.formsite.com/templates/registration-form-templates/club-registration-signup-form/");

			driver.findElement(By.xpath("//img[@title='Club-Signup-Forms-and-Examples']")).click();
			
			Thread.sleep(3000);
			
			//frame
			driver.switchTo().frame("frame-one102941247");
			
			driver.findElement(By.xpath("//input[@id='RESULT_TextField-3']")).sendKeys("sanjay");
			
			//driver.close();
			
			driver.switchTo().defaultContent(); // back to normal page
			
			
	}

}
