package seleniumPractice;

public class SeleniumTopCasting {

	public static void main(String[] args) {
		
		//Valid 
		//ChromeDriver driver=new ChromeDriver();
		
		//Valid 
//		WebDriver driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new SafariDriver();
//        driver = new EdgeDriver();
//		
		//Valid but not useful
		//SearchContext driver = new ChromeDriver();
		
		//Valid but useful
		//RemoteWebDriver driver = new ChromeDriver();
		
		//WebDriver-remote web driver
		// to run the test cases on remote machine
		//WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities); - grid , cloud, server, AWS 
		
		
		//SC - RWD - valid but not useful
		
        
	}

}
