package seleniumPractice;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/?ref_=icp_country_from_us");

		Thread.sleep(3000);

//		List<WebElement>imgList = driver.findElements(By.xpath("//img"));
//		for(WebElement e : imgList) {
//			String srcVal = e.getAttribute("src");
//			String altVal = e.getAttribute("alt");
//			
//			System.out.println(srcVal + " : " + altVal);
//		}

		By images = By.xpath("//img");
		By links = By.xpath("//a");

//		System.out.println("total links : " + getElements(links).size());
//		System.out.println("total images : " + getElements(images).size());

		int totalLinks = getElementsCount(links);
		System.out.println(totalLinks);

		if (totalLinks > 100) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		int totalImages = getElementsCount(images);
		System.out.println(totalImages);
		
		
		ArrayList<String> linksTestList = getElementsTextList(links);
		System.out.println(linksTestList);
		
	}

	public static List<WebElement> getElements(By locater) {
		return driver.findElements(locater);
	}

	public static int getElementsCount(By locater) {
		return getElements(locater).size();
	}

	public static ArrayList<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> eleTextList = new ArrayList<String>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println(text);
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}
}
