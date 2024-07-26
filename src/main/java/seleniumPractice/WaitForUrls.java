package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrls {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");

		By youTUbeLinkLocater = By.xpath("//img[@alt='youtube logo']");

		ElementUtil el = new ElementUtil(driver);
		el.waitForElementVisible(youTUbeLinkLocater, 10).click();

		// driver.findElement(By.xpath("//img[@alt='youtube logo']")).click(); //YT

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (wait.until(ExpectedConditions.urlContains("orangehrm"))) {
			System.out.println(driver.getCurrentUrl());
		}
	}

	public static String waitForUrlContains(int timeOut, String urlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		} else {
			return null;
		}
	}
	
	public static String waitForUrlIs(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(urlValue))) {
			return driver.getCurrentUrl();
		} else {
			return null;
		}
	}

}
