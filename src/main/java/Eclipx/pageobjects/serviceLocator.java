package Eclipx.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class serviceLocator 
{

	WebDriver driver;
	public serviceLocator(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@class='button js-form-submit form-submit']")
	WebElement searchButton;
	
	@FindBy(id = "search-for-services-1")
	WebElement services;
	
	@FindBy(id = "edit-field-services-target-id")
	WebElement dropdown;
	
	@FindBy(id = "edit-field-post-sub-value")
	WebElement postalCode;
	
	@FindBy(xpath = "//li[@class='ui-menu-item']")
	List<WebElement> dynamicPostal;
	
	
	
	
	public void goTo()
	{
		driver.get("https://acquia-stg-fpau.eclipx.xyz/service-locator");
	}
	
	public void SearchFunctionality(String serviceall,String postalcode,String address) throws InterruptedException
	{
		services.click();
		Select staticDropdown = new Select(dropdown);
		staticDropdown.selectByVisibleText(serviceall);
		postalCode.sendKeys(postalcode);
		for(int i=0;i<dynamicPostal.size();i++)
		{
			String firstDrop = dynamicPostal.get(i).getText();
			if(firstDrop.contains(address))
			{
			
				dynamicPostal.get(i).click();
				break;
			
		    }
		

		}
		
	 	Thread.sleep(3000);
		
		//wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}
}
