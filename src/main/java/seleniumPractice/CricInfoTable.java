package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoTable {
static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.get("https://www.espncricinfo.com/series/afghanistan-in-india-2023-24-1389384/india-vs-afghanistan-1st-t20i-1389396/full-scorecard");

        Thread.sleep(4000);
        
//        getWicketTaker("Rahmanullah Gurbaz");
//        getWicketTaker("Rahmat Shah");
        
//       List<WebElement> batterDetailsList = driver.findElements(By.xpath("//span[text()='Rahmat Shah']/ancestor::td/following-sibling::td"));
//       for(WebElement e : batterDetailsList) {
//    	   String text = e.getText();
//    	   System.out.println(text);
//       }
        
        getBatterDetails("Rahmat Shah");
        getBatterDetails("Rahmanullah Gurbaz");
      
	}
	
	public static String getWicketTaker(String name) {
		  String wkt_xpath = "//span[text()='"+name+"']/ancestor::td/following-sibling::td";
		  
	      String wkt_Name = driver.findElement(By.xpath(wkt_xpath)).getText();
	      System.out.println(wkt_Name);
	      return wkt_Name;
	}
	
	public static void getBatterDetails(String BatterName){
		 List<WebElement> batterDetailsList = driver.findElements(By.xpath("//span[text()='"+BatterName+"']/ancestor::td/following-sibling::td"));
	       for(WebElement e : batterDetailsList) {
	    	   String text = e.getText();
	    	   System.out.println(text);
	       }
	}

}
