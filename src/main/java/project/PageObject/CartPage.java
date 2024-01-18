package project.PageObject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(css="div[class='cart'] ul[class='cartWrap ng-star-inserted']")   
List<WebElement> cartList;         //List<WebElement> cartList = driver.findElements(By.xpath("//div/ul[@class='cartWrap ng-star-inserted']"));
	
	public List<WebElement> cartList()
	{
		return cartList;
	}
	
	public boolean verifyProducts(String... productNames)
	{
		List<String> products=Arrays.asList(productNames);
		boolean allProductFound=true;
		
		for(String product: products)
		{
			boolean productFound=false;
		for(int i=0;i<=cartList.size();i++)
		{
			
			String cartListName = cartList.get(i).findElement(By.tagName("h3")).getText();
		
			if(cartListName.equalsIgnoreCase(product))
			{
				productFound=true;
				break;
				
			}
			
		}
		System.out.println("Product: " + product + ", Found: " + productFound);
		allProductFound=allProductFound && productFound;
	}
		
		return allProductFound;
	}

}
