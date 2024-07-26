package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessIncognitoConcept {

	public static void main(String[] args) {

		//headless - no browser
		//testing in the background
		//faster than normal browser
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
	
		//options.addArguments("--headless=new");
		options.addArguments("--incognito");
		
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();

		
	}

}
