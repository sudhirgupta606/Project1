package project.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent{
	WebDriver driver;
	
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartClick;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	By waitToClick= By.xpath("//div[@aria-label='Product Added To Cart']");

	public void waitForTheElementToAppear(By findby)
	{	//By.id("toast-container")
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void invisibilityOfElementLocated(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	public void cartClick()
	{
		invisibilityOfElementLocated(waitToClick);
		cartClick.click();
	}
	public void orderClick()
	{
		orderHeader.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
