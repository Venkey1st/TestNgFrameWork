package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pagefactory {

	public WebDriver driver;
	public Pagefactory(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements( driver, this);
	}
}
