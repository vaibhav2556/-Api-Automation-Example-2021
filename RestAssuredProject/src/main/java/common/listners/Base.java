package common.listners;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Base {

	static String url = "F:\\Jars\\Chrome driver 88 version\\chromedriver.exe";
	static WebDriver driver;
	static String openUrl = "https://opensource-demo.orangehrmlive.com/";

	public void init()

	{

		System.setProperty("webdriver.chrome.driver", url);
		driver = new ChromeDriver();
		driver.get(openUrl);

	}

	public void failedTest(String methodName) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("G:\\Core java\\RestAssuredProject\\Screenshots" + methodName + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
