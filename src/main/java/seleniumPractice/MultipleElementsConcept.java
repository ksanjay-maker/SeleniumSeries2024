package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleElementsConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?ref_=icp_country_from_us");

		Thread.sleep(3000);

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("Total Links: " + linksList.size());

//		for (int i = 0; i < linksList.size(); i++) {
//			String text = linksList.get(i).getText();
//
//			if (text.length() != 0) {
//				System.out.println(text);
//			}
//
//		}

		for (WebElement e : linksList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
			}
			
			String hrefVal = e.getAttribute("href");
			System.out.println(hrefVal);

		}

	}

}
