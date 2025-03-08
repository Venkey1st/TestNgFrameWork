package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factory.BrowserBase;

public class ReportsUtility implements ITestListener {

	public ExtentSparkReporter extentreports;
	public ExtentReports reports;
	public ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		String stamp = new SimpleDateFormat("yyyy,MM,dd.HH,mm,ss").format(new Date());
		
	    extentreports= new ExtentSparkReporter("./Reports/"+stamp+".html");
	    extentreports.config().setDocumentTitle("Testing")	;
	    extentreports.config().setReportName("orangeHRM Repoer");
	    extentreports.config().setTheme(Theme.DARK);
	    reports= new ExtentReports();
	    reports.attachReporter(extentreports);
	  }
	public void onTestSuccess(ITestResult result) {
	    test= reports.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.PASS,result.getName());
	    try {
	    	BrowserBase b1 = new BrowserBase();
		    String filepath =b1.capturescree(result.getTestClass().getName());
		    test.addScreenCaptureFromPath(filepath);
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	   
		
	  }
	public void onTestFailure(ITestResult result) {
		test= reports.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.FAIL,result.getName());
	    test.log(Status.INFO, result.getThrowable().getLocalizedMessage());
	    try {
	    	BrowserBase b1 = new BrowserBase();
		    String filepath =b1.capturescree(result.getTestClass().getName());
		    test.addScreenCaptureFromPath(filepath);
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	  }
	public void onTestSkipped(ITestResult result) {
		test= reports.createTest(result.getTestClass().getName());
	    test.assignCategory(result.getMethod().getGroups());
	    test.log(Status.SKIP,result.getName());
		
	  }
	public void onFinish(ITestContext context) {
	   reports.flush();
	   
	   
	  }
	
}
