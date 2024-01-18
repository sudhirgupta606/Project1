package project.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.util.Assert;

import project.AbstractComponent.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
@FindBy(tagName="h1")
WebElement confirmationMessageText;


	public String confirmationMessage()
	{
		
		
		return confirmationMessageText.getText();
	}
	
}
