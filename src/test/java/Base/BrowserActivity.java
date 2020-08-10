package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BrowserActivity {

	public static WebDriver driver;
	public static FileInputStream fp;
	public static Properties prop;

	@BeforeSuite
	public void luanchBrowser() throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream("D:\\Class\\PHPTravesl\\src\\test\\java\\Resources\\Config.properties"));
		if (prop.get("Browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Class\\PHPTravesl\\src\\test\\java\\Resources\\chromedriver_Version83.exe");
			driver = new ChromeDriver();
		} else if (prop.get("Browser").equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\Class\\PHPTravesl\\src\\test\\java\\Resources\\iedriver.exe");
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Browser not found");
		}

		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void validatetitle(){
			
		String title= driver.getTitle();	
		
		Assert.assertEquals(title, "Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com");
	}
	
	
	@Test
	public void validateURL(){
		
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "https://www.easemytrip.com/");
	}
	

	
	public void CloseBrowser() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}
