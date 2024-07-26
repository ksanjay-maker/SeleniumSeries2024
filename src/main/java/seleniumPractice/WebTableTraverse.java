package seleniumPractice;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableTraverse {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		Thread.sleep(4000);

		int rowCount = getRowCount();
		System.out.println("Rows :" + rowCount);

		int columnCount = getColumnCount();
		System.out.println("Column :" + columnCount);

//      System.out.println("------------");

		// table[@id='customers']/tbody/tr[2]/td[1]

//        String beforeXpth = "//table[@id='customers']/tbody/tr[";
//        String afterXpath = "]/td[1]";
//        
//        for(int i=2; i<=getRowCount()+1;i++) {
//        String actualXpath = beforeXpth + i + afterXpath;
//        	//System.out.println(actualXpath);
//        	String companyName = driver.findElement(By.xpath(actualXpath)).getText();
//        	System.out.println(companyName);
//        }
//        
//        System.out.println("------------");
//        
//        String  cont_beforeXpth = "//table[@id='customers']/tbody/tr[";
//        String cont_afterXpath = "]/td[2]";
//        
//        for(int i=2; i<=getRowCount()+1;i++) {
//        String actualXpath = cont_beforeXpth + i + cont_afterXpath;
//        	//System.out.println(actualXpath);
//        	String contactName = driver.findElement(By.xpath(actualXpath)).getText();
//        	System.out.println(contactName);
//        }

//		getColData(1);
//		getColData(2);
		
		ArrayList<String> countryList= getColData(3);
		if(countryList.contains("Canada")) {
			System.out.println("Pass");
		}
		
		getRowValues(7, 3);

	}
	
	public static void getRowValues(int rowNum, int colNum) {
		System.out.println("---------");
		for(int j=1; j<=getColumnCount(); j++) {
			String xpath = "// table[@id='customers']/tbody/tr["+rowNum+"]/td["+j+"]";
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
		
		
	}
	

	public static ArrayList<String> getColData(int colNum) {
		System.out.println("---------");
		String beforeXpth = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[" + colNum + "]";
		ArrayList<String> colValuesList = new ArrayList<String>();
		for (int i = 2; i <= getRowCount() + 1; i++) {
			String actualXpath = beforeXpth + i + afterXpath;
			// System.out.println(actualXpath);
			String text = driver.findElement(By.xpath(actualXpath)).getText();
			System.out.println(text);
			colValuesList.add(text);
		}
		return colValuesList;
	}

	public static int getRowCount() {
		int rows = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		return rows - 1;

	}

	public static int getColumnCount() {
		int column = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		return column;

	}
}
