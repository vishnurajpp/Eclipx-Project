package StandAloneTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest 
{

	@Test
	public void start() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://acquia-stg-fpau.eclipx.xyz/service-locator");
		driver.findElement(By.id("search-for-services-1")).click();
		WebElement dropdown  =  driver.findElement(By.id("edit-field-services-target-id"));
		Select staticDropdown = new Select(dropdown);
		staticDropdown.selectByVisibleText("Service");
		driver.findElement(By.id("edit-field-post-sub-value")).sendKeys("5092");
		List<WebElement> dyanamicDropdown =  driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for(int i=0;i<dyanamicDropdown.size();i++)
		{
			String firstDrop = dyanamicDropdown.get(i).getText();
			if(firstDrop.contains("5092, Modbury"))
			{
			
				dyanamicDropdown.get(i).click();
				break;
			
		    }
		

		}
		
		Thread.sleep(3000);
		WebElement searchButton = driver.findElement(By.xpath("//input[@class='button js-form-submit form-submit']"));
		//wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
		driver.close();
	}
}
