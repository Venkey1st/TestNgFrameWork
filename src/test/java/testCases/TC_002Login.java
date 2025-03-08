package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import factory.BrowserBase;
import pageobjects.HomePage;
import pageobjects.Loginpage;
import utility.Data;

public class TC_002Login extends BrowserBase {

	@Test(  groups = "sanity", dataProvider = "dp",dataProviderClass =Data.class)
	public void testmethod2(String name, String passwrd, String valid ) throws InterruptedException {
		getloger().info("method start");
		Loginpage l1 = new Loginpage(driver);
		l1.login(name,passwrd);
		HomePage h1 = new HomePage(driver);
		h1.succelogin();
		if (valid.equalsIgnoreCase("valid")) {
			if(h1.succelogin()== true) {
				h1.logout();
				assertTrue(true);
			}
			else {
				assertTrue(false);
			}
		}
		if (valid.equalsIgnoreCase("In-valid")) {
			if(h1.succelogin()== true) {
				h1.logout();
				assertTrue(false);
			}
			else {
				assertTrue(true);
			}
		}
		

		getloger().info("method end");
	}

}
