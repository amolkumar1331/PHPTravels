package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePO {

	WebDriver driver;

	public HomePO(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "spnMyAcc")
	WebElement myAccLink;

	
	@FindBy(xpath = "//*[@id='divSignInPnl']/a[1]")
	WebElement signInbtn;

	@FindBy(xpath = "//*[@id='divSignInPnl']/a[2]")
	WebElement registerBtn;

	public void signIn() throws InterruptedException {
		myAccLink.click();
		Actions act = new Actions(driver);
		act.moveToElement(signInbtn).click().build().perform();
	}

	public void register() throws InterruptedException {
		myAccLink.click();
		Thread.sleep(3000);
		registerBtn.click();
	}


}


