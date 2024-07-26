package seleniumPractice;

public class AmazonTest {

	public static void main(String[] args) throws Exception {
		
		String browser = "chrome";
		BrowserUtil brUtil = new BrowserUtil();
		brUtil.launchBrowser(browser);
		
		brUtil.launchUrl("https://www.flipkart.com");
		String title = brUtil.getPageTitle();
		if(title.contains("Amazon")) {
		System.out.println("correct title - PASS");
		}
		else {
			System.out.println("incorrect title - FAIL");
		}
		
		brUtil.getPageUrl();
		brUtil.closeBrowser();

	}

}
