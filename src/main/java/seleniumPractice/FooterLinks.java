package seleniumPractice;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/");
		
		Thread.sleep(3000);
		
		By footers = By.xpath("//footer//a");
		ArrayList<String> actFooterList = getFooterLinksList(footers);
		if(actFooterList.contains("Contact Us")) {
			System.out.println("Pass");
		}

	}
	
	public static ArrayList<String> getFooterLinksList(By locater) {
		List<WebElement> footerList = driver.findElements(locater);
		System.out.println(footerList.size());
		
		ArrayList<String> eleTextList = new ArrayList<String>();
		for(WebElement e : footerList) {
			String text = e.getText();
			System.out.println(text);
			eleTextList.add(text);
			
		}
		return eleTextList;
	}

}
