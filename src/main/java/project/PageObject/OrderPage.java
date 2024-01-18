package project.PageObject;

import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import project.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}


@FindBy(xpath="//tbody/tr")
List<WebElement> orderList;


	public boolean findOrder(String... cartProductName)
	{
		List<String> products=Arrays.asList(cartProductName);
		boolean allProductFound=true;
		for(String product:products)
		{
			boolean productFound=false;
		for(int i=0; i<orderList.size();i++)
		{
			
		   List<WebElement> rowColumns = orderList.get(i).findElements(By.tagName("td"));
		   Iterator<WebElement> it = rowColumns.iterator();
			while(it.hasNext())
			{
				String productName=it.next().getText();
				if(productName.equalsIgnoreCase(product))
				{
					productFound =true;
					break;
				}
			}
			
		}
		allProductFound=allProductFound && productFound;
		}
		return allProductFound;
	}

}
