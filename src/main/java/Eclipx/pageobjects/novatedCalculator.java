package Eclipx.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class novatedCalculator
{
	WebDriver driver;

	public novatedCalculator(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//h5[@class='subtitle']")
	WebElement title;
	
	@FindBy(xpath = "//button[@class='btn-car']")
	WebElement iKnowWhatCarWant;
	
	@FindBy(id = "edit-vehicle-make")
	WebElement carMake;
	
	
	@FindBy(xpath = "(//select[@class='mmv-inp--select form-select required'])[2]")
	WebElement carModel;
	

	@FindBy(xpath = "(//select[@class='mmv-inp--select form-select required'])[3]")
	WebElement carVarient;
	
	@FindBy(id = "edit-annual-salary")
	WebElement annualSalary;
	
	@FindBy(id = "edit-state")
	WebElement state;
	
	@FindBy(id = "edit-submit")
	WebElement submit;
	
	
	public WebElement goToURL()
	{
		driver.get("https://acquia-uat-fpau.eclipx.xyz/novated-leasing");
		return title;
		
	}
	
	public void iKnowWhatCarWant() throws InterruptedException
	{
		iKnowWhatCarWant.click();
		
		Select staticSelect = new Select(carMake);
		staticSelect.selectByVisibleText("AUDI");
		
	    Thread.sleep(2000);
		Select staticSelect1 = new Select(carModel);
		staticSelect1.selectByVisibleText("Q3");
		
		Thread.sleep(2000);
		Select staticSelect2 = new Select(carVarient);
		staticSelect2.selectByValue("173785");
		
		annualSalary.sendKeys("5000");
		Select staticSelect3 = new Select(state);
		staticSelect3.selectByVisibleText("NSW");
		
		submit.click();
		
	}
	
	
}

