package screenshots;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

        // 1. Capture full page screenshots
	/*	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\fullpage.png");
		sourcefile.renameTo(targetfile); // copy source file to target file

     */
		
		
		// 2. Capture the screenshot of the specific section
	/*	WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File sourcefile = featuredProducts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\featuredProducts.png");
		sourcefile.renameTo(targetfile);
	*/	
		
		
		// 3. capture the screenshot of web element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourcefile = logo.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\logo.png");
		sourcefile.renameTo(targetfile);
		
		driver.quit();
	}

}
