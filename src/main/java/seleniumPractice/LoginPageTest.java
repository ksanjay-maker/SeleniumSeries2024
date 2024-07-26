package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) throws Exception {

		BrowserUtil bUtil = new BrowserUtil();
		WebDriver driver = bUtil.launchBrowser("chrome");
		bUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		System.out.println(bUtil.getPageUrl());
		System.out.println(bUtil.getPageTitle());
        
		By email = By.id("input-email");
	 	By password = By.id("input-password");

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(email, "test@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
		
		//driver.quit();
	}

}
