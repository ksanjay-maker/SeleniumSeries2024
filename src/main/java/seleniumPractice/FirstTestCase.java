package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String act_title = driver.getTitle();

		if (act_title.equals("Google")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		//driver.close();
		driver.quit();
	}

}
