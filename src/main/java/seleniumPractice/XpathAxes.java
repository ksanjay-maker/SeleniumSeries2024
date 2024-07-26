package seleniumPractice;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.get("https://classic.crmpro.com/index.html");
        
        driver.findElement(By.name("username")).sendKeys("newautomation");
        driver.findElement(By.name("password")).sendKeys("Selenium@12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        
        Thread.sleep(3000);
        
        driver.switchTo().frame("mainpanel");
        
        driver.findElement(By.linkText("CONTACTS")).click();
        
        Thread.sleep(3000);
        
//        selectContacts("Romi singh");
//        selectContacts("Ali khan");
        
//        List<WebElement> contList = driver.
//        		findElements(By.xpath("//a[text()='"+username+"']/parent::id/preceding-sibling::td"));
//        
//        for(WebElement e : contList) {
//        	String text = e.getText();
//        	if(text.length() !=0) {
//        		System.out.println(text);
//        	}
//        }
        
        getUesrDetails("Ali khan");
        getUesrDetails("Romi singh");
        

	}
	
	public static ArrayList<String> getUesrDetails (String username) {
		 List<WebElement> contList = driver.
	        		findElements(By.xpath("//a[text()='"+username+"']/parent::id/preceding-sibling::td"));
		 ArrayList<String> contValues = new ArrayList<String>();
	        for(int i=0; i<contList.size(); i++) {
	        	String text = contList.get(i).getText();
	        	System.out.println(text);
	        	contValues.add(text);  
	        }
	        return contValues;
	}
	
	
	public static void selectContacts(String username) {
		String contacts_xpath = "//a[text()='"+username+"']/parent::id/preceding-sibling::td/input[@type='checkbox']";
        driver.findElement(By.xpath(contacts_xpath)).click();
	}

	
}
