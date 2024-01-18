package project.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestComponent {
public WebDriver driver;
	  @BeforeMethod(alwaysRun=true)
	public void initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream path = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\project\\resources\\GlobalData.properties");
		prop.load(path);// here we have to give file path of global properties to load
		String browserName=prop.getProperty("browser");		
		if(browserName.equalsIgnoreCase("chrome"))
		{

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{

			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		
	}
	  @AfterMethod(alwaysRun=true)
	  public void close()
	  {
		  driver.quit();
	  }

	  public String takeScreenshot(String testCaseName,WebDriver driver) throws IOException {
		  
		  TakesScreenshot ts= (TakesScreenshot)driver;  //initialize
		  File source=ts.getScreenshotAs(OutputType.FILE); //takesscreenshot of entire browser
		  //file path name where we want to save the screenshot
		  File destination=new File(System.getProperty("user.dir")+"\\standlone\\reports\\"+ testCaseName+".png");
		  //now below move screenshot file  to desired location
		  FileUtils.copyFile(source, destination);
		  return System.getProperty("user.dir")+"\\standlone\\reports\\"+ testCaseName+".png";
		  
		  
	  }
	  
	  
}
