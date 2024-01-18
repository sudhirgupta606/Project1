package project.PageObject;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.AbstractComponent.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
WebDriver driver;
String p1;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	
@FindBy(css="li button[type='button']")	
WebElement checkoutButton;
@FindBy(css="input[placeholder='Select Country'")
WebElement selectCountry;
	//		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
@FindBy(xpath="//section/button")
List<WebElement> dropdownCountryList;		//List<WebElement> countryList = driver.findElements(By.xpath("//section/button"));

@FindBy(css="a[class='btnn action__submit ng-star-inserted']")
WebElement submitOrder;
public void checkOut() {
    try {
        // Scroll into view using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutButton);

        // Wait for the checkout button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickableCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));

        // Click the checkout button using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickableCheckoutButton);

        // Alternatively, you can use Actions for clicking
        // Actions action = new Actions(driver);
        // action.moveToElement(clickableCheckoutButton).click().build().perform();
    } catch (NoSuchElementException e) {
        // Handle the exception (e.g., log the error, capture screenshot, etc.)
        e.printStackTrace();
    }
}

	public void fillShippingInfo(String p1)
	{
		this.p1=p1;
		selectCountry.sendKeys(p1);
	}
	public List<WebElement> countryList()
	{
		return dropdownCountryList;
	}
	public void selectCountry()
	{
		for(int i=0;i<dropdownCountryList.size();i++)
		{
			if(dropdownCountryList.get(i).getText().equalsIgnoreCase(p1))
			{
				dropdownCountryList.get(i).click();
				break;
			}
		}
	}
	public void submitOrder()
	{
		submitOrder.click();
	}

}
