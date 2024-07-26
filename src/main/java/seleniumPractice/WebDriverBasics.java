package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanjay Kumar\\eclipse-workspace\\SeleniumProjectSessions\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println("The Title of the page is:" +title);
        
        if(title.equals("Google")) {
        	System.out.println("Pass");
        }
        else {
        	System.out.println("Fail");
        }
        
        String url = driver.getCurrentUrl();
        System.out.println(url);
        
        String source = driver.getPageSource();
        //System.out.println(source);
        if(source.contains("Google Inc")) {
        	System.out.println("Pass");
        }
        else {
        	System.out.println("Fail");
        }
        
        //To close the rowser
        driver.quit();//session id will be null
       // driver.close(); // invalid session id 
        
	}

}
