package screenshots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--headless=new"); // setting for headless mode for execution
		
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.google.com/");
		String act_title = driver.getTitle();

		if (act_title.equals("Google")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		driver.quit();

	}

}
