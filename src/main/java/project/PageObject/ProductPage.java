package project.PageObject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import project.AbstractComponent.AbstractComponent;

public class ProductPage extends AbstractComponent{
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='row']/div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
	List<WebElement> productList;        //List<WebElement> productList = driver.findElements(By.cssSelector("div[class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
	//driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	
	By buttonVisibility = By.xpath("//div[@aria-label='Product Added To Cart']");
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));

	
	
	public List<WebElement> productList()
	{
		
		return productList;
	}
	
	public void addProductToCart(String... productnames)
	{
		List<String> products=Arrays.asList(productnames);
		for(String product: products)
		{
		for(int i=0;i<productList.size();i++)
		{
			 String pName = productList.get(i).findElement(By.tagName("b")).getText();
	//		 System.out.println("Product found: " + pName);
			 if(pName.equalsIgnoreCase(product))
			 {
				 productList.get(i).findElement(By.cssSelector("button[class='btn w-10 rounded']")).click();
				 super.waitForTheElementToAppear(buttonVisibility);
				 break;
			}
		}
	}
	}
	

}
