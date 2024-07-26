package seleniumPractice;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class FullPageScreenshot {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		
		//capture the screenshot and store the image
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        ImageIO.write(s.getImage(), "PNG", new File("C:\\Users\\Sanjay Kumar\\eclipse-workspace\\SeleniumProjectSessions\\screenshots\\fullpage.png"));
        
        //Screenshot screenshot=new AShot().takeScreenshot(driver); 
        //ImageIO.write(screenshot.getImage(),"PNG",new File("C:\\Users\\Sanjay Kumar\\eclipse-workspace\\SeleniumProjectSessions\\screenshots\\entirepage.png"));
        
        driver.close();
	}
}
