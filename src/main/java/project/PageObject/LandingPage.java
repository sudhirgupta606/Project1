package project.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import project.AbstractComponent.AbstractComponent;


public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(id="userEmail")               //WebElement	userEmail = driver.findElement(By.id("userEmail"));
WebElement userEmail;

@FindBy(id="userPassword") 
WebElement userPassword; 				//	driver.findElement(By.id("userPassword")).sendKeys("Password1$");

@FindBy(id="login")
WebElement login;						//	driver.findElement(By.id("login")).click();
By loginsuccess=By.id("toast-container");

@FindBy(css="div[aria-label='Incorrect email or password.']")
WebElement incorrectidpassword;

	public ProductPage loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		loginSucessful();
		ProductPage productPage=new ProductPage(driver);
		return productPage;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
		
	}
	
	public void loginSucessful()
	{
		super.waitForTheElementToAppear(loginsuccess);
	}
	public String incorrectIdOrPassword()
	{
		return incorrectidpassword.getText();
	}




}
