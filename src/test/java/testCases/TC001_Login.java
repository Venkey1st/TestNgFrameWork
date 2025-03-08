package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import factory.BrowserBase;
import pageobjects.HomePage;
import pageobjects.Loginpage;

public class TC001_Login extends BrowserBase {
	
	@org.testng.annotations.Test( groups = "rgression")
	public void testmethod() throws InterruptedException {
		getloger().info("method start");
		Loginpage l1 = new Loginpage(driver);
		l1.login(propertiesFromConfogFile.getProperty("username"),propertiesFromConfogFile.getProperty("Password"));
		HomePage h1 = new HomePage(driver);
		h1.succelogin();
		if (h1.succelogin()== true) {
			assertTrue(true);
		}
		else {
			Assert.fail();
		}
		Thread.sleep(2000);
		
		getloger().info("method end");
	}

}
