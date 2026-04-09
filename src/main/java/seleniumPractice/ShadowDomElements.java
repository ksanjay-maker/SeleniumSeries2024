package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomElements {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//https://dev.automationtesting.in/shadow-dom
		
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		
		//Handle shadow dom element

		//This Element is inside single shadow DOM.
		
		//String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
		//Thread.sleep(1000);
		
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");
	}

}
