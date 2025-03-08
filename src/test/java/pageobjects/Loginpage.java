package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Pagefactory {

	public Loginpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name='username']") 
	WebElement textinpu1;
	@FindBy(xpath = "//input[@name='password']") 
	WebElement textinpu2;
	
	@FindBy(xpath = "//button[@type='submit']") 
	WebElement submitbutton;
	
	public void login(String a, String b) throws InterruptedException {
		
		textinpu1.sendKeys(a);
		textinpu2.sendKeys(b);
		submitbutton.click();
		Thread.sleep(2000);
	}
	

}
