package common.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class ResultListners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" Name Of TestCases onStart Is:" +result.getName());

	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println(" Name Of TestCases  onStart Is:" +context.getName());
		

	}

	@Override
	public void onTestSuccess(ITestResult result) {
String  name=	result.getName();
	System.out.println(" Successsfull execute: "+name);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		 System.out.println("The name of FailedTest Cases Is :" +result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("Success Percentage Is:" +result.getName());
	}

	

	@Override
	public void onFinish(ITestContext context) {

		System.out.println(" Name Of TestCases onFinish Is:" +context.getName());
	

		
		
	}

}
