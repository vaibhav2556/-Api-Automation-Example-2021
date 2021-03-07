package common.listners;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(common.listners.BaseTest.class)
public class OrangeHrm extends Base {


	// Entent Report Generation

	/*static ExtentHtmlReporter reporter;
	static ExtentReports report;
	static ExtentTest test;
	static String reportUrl="G:\\Core java\\RestAssuredProject\\test-output\\extentReportMarch2021";
*/
	@BeforeTest
	void setup() {

		init();
/*		reporter = new ExtentHtmlReporter(reportUrl);
		report = new ExtentReports();
		report.attachReporter(reporter);
*/
	}

	@AfterTest
	void tearDown() {
		//report.flush();
		driver.close();
		
	}

	@Test
	public void Test1() {
		
		//test=	report.createTest("Test1 started","Passs");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin111");
		driver.findElement(By.id("txtPassword")).sendKeys("admin125553");
		driver.findElement(By.id("btnLogin")).click();
		//test=report.createTest("Test1 End ..");
	}

	/*
	 * @Test public void Test2() {
	 * 
	 * }
	 */
	
/*	  @AfterMethod
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
*/
}
