package StandAloneTest;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;

import Eclipx.pageobjects.serviceLocator;
import io.github.bonigarcia.wdm.WebDriverManager;
import testComponents.base;

public class testcaseStart extends base
{
	WebDriver driver;

	@Test(dataProvider = "getData")
	public void start(String serviceall,String postalcode,String address) throws InterruptedException, IOException 
	{
		ExtentReports report =   extentReport();
		report.createTest("start");
	    WebDriver driver =     driverInitialize();
		serviceLocator serviceLocatorobj = new serviceLocator(driver);
		serviceLocatorobj.goTo();
		serviceLocatorobj.SearchFunctionality(serviceall,postalcode,address);
		getScreenshot();
		report.flush();
		//driverClose();
		
			
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][]  data =new Object[1][3];
		data[0][0]="Service";
		data[0][1]="5092";
		data[0][2]="5092, Modbury";
		
		return data;
	}
}
