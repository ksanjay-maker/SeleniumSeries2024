package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownHandlingWithoutSelect {

	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		
		By country = By.xpath("//select//option");
		doSelectValueFromDropdown(country, "Germany");
		
		}
	
	    public static List<WebElement> getElements(By locater) {
	    	return driver.findElements(locater);
	    	
	    }

		public static void doSelectValueFromDropdown(By locater, String value) {
			List<WebElement> optionsList = getElements(locater);
			System.out.println(optionsList);
			
			for(WebElement e : optionsList) {
				String text = e.getText();
				System.out.println(text);
				
				if(text.equals(value)) {
					e.click();
					break;
				}		
		}
	}

}
