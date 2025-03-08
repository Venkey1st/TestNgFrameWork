package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends Pagefactory {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className = "oxd-userdropdown-name") WebElement username;
	@FindBy(linkText = "Logout") WebElement logout;
	@FindBy(tagName ="h6") WebElement DashBoard;
	
	public boolean  succelogin() {
		try {
			return DashBoard.isDisplayed();
		} 
		catch (Exception e) 
		{
			return false;
		}
		
	}

	public void logout() {
		username.click();
		logout.click();
	}
}
