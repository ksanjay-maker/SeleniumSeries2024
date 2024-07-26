package seleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUp {

	public static void main(String[] args) throws InterruptedException {

		// JS pop up
		//alert pop up
		//modal dialog pop up
		
		// 1. alert
		// 2. prompt
		// 3. confirm
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		
		//accept the alert
		alert.accept();
		
		// dismiss the alert
		//alert.dismiss();
		
		//alert.sendKeys("testing");
		


	}

}
