package project.PostiveScenario;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import project.PageObject.CartPage;
import project.PageObject.CheckOutPage;
import project.PageObject.ConfirmationPage;
import project.PageObject.LandingPage;
import project.PageObject.OrderPage;
import project.PageObject.ProductPage;
import project.testcomponent.BaseTestComponent;
@Test
public class StandaloneTest extends BaseTestComponent {
	String productName="ZARA COAT 3";
	@Test(dataProvider="getData",dataProviderClass = BaseTestComponent.class,groups= {"purchaseOrder"})
	public  void submitOrderTestCase(String email, String password) throws IOException  {
		// TODO Auto-generated method stub
		
		
		LandingPage landingPage=new LandingPage(driver);
		landingPage.goTo();
		ProductPage productPage=landingPage.loginApplication(email, password);
	//	ProductPage productPage=landingPage.loginApplication("sudhirgupta606@gmail.com", "Password1$");
//		List<WebElement> productList = productPage.productList();   // noo need to call
	//	List<String> productnameList=Arrays.asList("ZARA COAT 3","IPHONE 13 PRO"); we can do this as well
		
		productPage.addProductToCart("ZARA COAT 3","IPHONE 13 PRO");
		productPage.cartClick(); // wo dont need to create object of abstract class because child can access parents methods
		CartPage cartPage= new CartPage(driver);
		boolean match=cartPage.verifyProducts(productName,"IPHONE 13 PRO"); // we can also pass the productnameList
		Assert.assertTrue(match,"Not Matched");
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		checkOutPage.checkOut();
		checkOutPage.fillShippingInfo("india");
		List<WebElement> countryList = checkOutPage.countryList();
		checkOutPage.selectCountry();
		checkOutPage.submitOrder();
		ConfirmationPage confirmationPage= new ConfirmationPage(driver);
		String message=confirmationPage.confirmationMessage();
		AssertJUnit.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
	
	@Test(dependsOnMethods= {"submitOrderTestCase"},groups= {"purchaseOrder2"})
	public void verifyProduct()
	{
		LandingPage landingPage=new LandingPage(driver);
		landingPage.goTo();
		ProductPage productPage=landingPage.loginApplication("sudhirgupta606@gmail.com", "Password1$");
		OrderPage orderPage= new OrderPage(driver);
		orderPage.orderClick();
		boolean productFound=orderPage.findOrder(productName);
		Assert.assertTrue(productFound, "Product Not Found");
		
	}
	
	
	
	
	
	
	
	
}
