package project.ErrorTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import project.PageObject.LandingPage;
import project.PageObject.ProductPage;
import project.PostiveScenario.StandaloneTest;
import project.testcomponent.BaseTestComponent;

public class ErrorValidationTestCase extends BaseTestComponent{

	
	@Test(dataProvider=("getData"), dataProviderClass = StandaloneTest.class,groups= {"purchase"})
	public void errorTestCase(String username,String password)
	{
	LandingPage landingPage=new LandingPage(driver);
	landingPage.goTo();
	ProductPage productPage=landingPage.loginApplication(username,password);
	//ProductPage productPage=landingPage.loginApplication("sudhirgupta606@gmail.com", "Password1");
	String invalidMessage=landingPage.incorrectIdOrPassword();
	Assert.assertEquals(invalidMessage, "Incorrect email or password.","error message mismatched");
	
	
	
	}
	
	
	
	
	
	
	
}
