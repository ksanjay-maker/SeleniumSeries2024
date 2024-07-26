package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		
		WebElement country = driver.findElement(By.id("Form_getForm_Country"));
		
		Select select = new Select(country);
		//select.selectByIndex(5);
		//select.selectByVisibleText("India");
		//select.selectByValue("Brazil");
		
		List<WebElement>countryOptions = select.getOptions();
		System.out.println("The Country List:" +(countryOptions.size()-1));
		//By country = By.id("Form_getForm_Country");
		
		for(WebElement e : countryOptions) {
			String text = e.getText();
			System.out.println(text);
		}
		//doSelectDropdownByIndex(country, 2);
		//doSelectDropdownByVisibleText(country, "India");
		//doSelectDropdownByValue(country, "Brazil");
	}
	
	public static void doSelectDropdownByIndex(By locater, int index) {
		Select select = new Select(getElement(locater));
		select.selectByIndex(index);
	}
	
	public static void doSelectDropdownByVisibleText(By locater, String text) {
		Select select = new Select(getElement(locater));
		select.deselectByVisibleText(text);
	}
	
	public static void doSelectDropdownByValue(By locater, String value) {
		Select select = new Select(getElement(locater));
		select.deselectByValue(value);
	}
	public static WebElement getElement(By locater) {
		return driver.findElement(locater);
	}
	
	public static List<WebElement> getDropDownCount(By locater) {
		Select select = new Select(getElement(locater));
		return select.getOptions();
	}
	
	public static int getDropDownOptionsCount(By locater) {
		return getDropDownCount(locater).size();
	}

}
