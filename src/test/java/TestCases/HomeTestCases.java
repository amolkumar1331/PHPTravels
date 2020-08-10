package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.BrowserActivity;
import PageObject.HomePO;

public class HomeTestCases extends BrowserActivity {

	public static HomePO hp;

	@Test
	public void signin() throws InterruptedException {
		hp = PageFactory.initElements(driver, HomePO.class);
		hp.signIn();

	}

	
	
	
	/*@Test()
	public void register() throws InterruptedException {
		hp = PageFactory.initElements(driver, HomePO.class);
		hp.register();

	}
*/
}
