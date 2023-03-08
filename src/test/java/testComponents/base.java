package testComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base 
{
	ExtentReports extentReport;

	String filePath = "C:\\Users\\ppv\\eclipse-workspace\\EclipxTools\\target\\file.png";
	WebDriver driver;
	public WebDriver driverInitialize()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public void driverClose()
	{
		driver.close();
	}
	
	public void getScreenshot() throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source =     ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(source, new File(filePath));
			
			
	}
	
	public ExtentReports extentReport()
	{
		String filePath = "C:\\Users\\ppv\\eclipse-workspace\\EclipxTools\\target\\index.html";
		ExtentSparkReporter reportSpark = new ExtentSparkReporter(filePath);
		reportSpark.config().setReportName("Service locator");
		extentReport = new ExtentReports();
		extentReport.attachReporter(reportSpark);
		extentReport.setSystemInfo("Tester", "QA team");
		return extentReport;
	}
}
