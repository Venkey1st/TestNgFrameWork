package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrowserBase {

	public static WebDriver driver;
	public Properties propertiesFromConfogFile;
	public Logger logs;
	
	public Properties getProperties() throws IOException {
		
		FileReader configfile = new FileReader(System.getProperty("user.dir")+ "//src//test//resources//Config.properties");
		propertiesFromConfogFile = new Properties();
		propertiesFromConfogFile.load(configfile);
		return propertiesFromConfogFile;
	}
	public Logger getloger() {
		
		logs=LogManager.getLogger(this.getClass());// we have to add log4j2.xml file in src/test/resource
		return logs;
		
	}
	@BeforeClass (groups = {"sanity","rgression"})
	public void setBrowser() throws IOException {
		
		
		getloger().info("strated");
		switch (getProperties().getProperty("browser")) {
		case "chrome":
			driver= new ChromeDriver();
			break;

		default:
			System.out.println("no browser");
		}
	
		driver.get(propertiesFromConfogFile.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@AfterClass(groups = {"sanity","rgression"})
	public void closeBrowser() {
		driver.quit();
	}
	
	public String capturescree(String name) throws IOException {// providing screenshot name
		String stamp= new SimpleDateFormat("yyyy,MM,dd,HH,mm.ss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourefile = screenshot.getScreenshotAs(OutputType.FILE);
		String targetpath = "./Screenshots//"+name+stamp+".png";
		File targetfile = new File(targetpath);
		FileUtils.copyFile(sourefile,targetfile);
		
		return targetpath;
		
	}
	
	
}
