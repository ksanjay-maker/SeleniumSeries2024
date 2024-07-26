package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		By searchKey = By.name("q");
		By suggestions = By.xpath("//div[@class='wM6W7d']/span");
		googleSearch(searchKey, "selenium", suggestions, "selenium testing");
		
	}
	
	public static List<WebElement> getElements(By locater) {
		return driver.findElements(locater);
	}
	
	public static WebElement getElement(By locater) {
		return driver.findElement(locater);
	}
	
	public static void googleSearch(By serchLocater, String searchKey, By suggLocater, String value) throws InterruptedException {
		getElement(serchLocater).sendKeys(searchKey);
		Thread.sleep(3000);
		
		List<WebElement> suggList = getElements(suggLocater);
		
		System.out.println(suggList.size()-1);
		
		for(WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value));
			e.click();
			break;			
		}
		
	}

}
