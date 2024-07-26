package seleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementsSectionLinks {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		List<WebElement> sectionslinks = driver.findElements(By.xpath("//a[@class='list-group-item']"));
		System.out.println(sectionslinks.size());
		for (WebElement e : sectionslinks) {
			String text = e.getText();
			System.out.println(text);
		}

		By rightSecsLinks = By.xpath("//a[@class='list-group-item']");

		ElementUtil eleUtil = new ElementUtil(driver);
		ArrayList<String> textList = eleUtil.getElementsTextList(rightSecsLinks);
		System.out.println(textList);
		if (textList.contains("Order History")) {
			System.out.println("Pass");
		}
	}
}
