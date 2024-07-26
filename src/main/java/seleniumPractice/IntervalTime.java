package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IntervalTime {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");

		By youTUbeLinkLocater = By.xpath("//img[@alt='youtube logo1']");

//		ElementUtil el = new ElementUtil(driver);
//		el.waitForElementVisible(youTUbeLinkLocater, 10).click();

//		driver.findElement(By.xpath("//img[@alt='youtube logo']")).click(); //YT
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
			 wait.until(ExpectedConditions.visibilityOfElementLocated(youTUbeLinkLocater));
	}

}
