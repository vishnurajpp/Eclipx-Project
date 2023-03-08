package StandAloneTest;

import static org.testng.Assert.assertEquals;

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

import Eclipx.pageobjects.novatedCalculator;
import Eclipx.pageobjects.serviceLocator;
import io.github.bonigarcia.wdm.WebDriverManager;
import testComponents.base;

public class testcaseStartNovated extends base
{
	WebDriver driver;

	@Test
	public void start() throws InterruptedException, IOException 
	{
		ExtentReports report =   extentReport();
		report.createTest("start");
	    WebDriver driver =     driverInitialize();
	    novatedCalculator novated = new novatedCalculator(driver);
	    WebElement title=  novated.goToURL();
	   // assertEquals(title, "NOVATED CALCULATOR");
	    novated.iKnowWhatCarWant();
		getScreenshot();
		report.flush();
		//driverClose();
		
			
	}
	
	
}
