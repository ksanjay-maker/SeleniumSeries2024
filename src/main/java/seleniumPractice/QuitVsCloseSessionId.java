package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessionId {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sanjay Kumar\\eclipse-workspace\\SeleniumProjectSessions\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        
        String title = driver.getTitle();
        System.out.println("The Title of the page is:" +title);
        
        //To close the rowser
        driver.quit();//session id will be null
       // driver.close(); // invalid session id 
        
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getCurrentUrl());
        //NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
        driver.quit();

	}

}
