package project.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporters {
	
	
	public static ExtentReports extentReport()
	{
	
	
	String path = System.getProperty("user.dir")+"\\standlone\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("First Report");
	reporter.config().setDocumentTitle("Submit Order Test Case");
	
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester","Sudhir Gupta");
	//extent.createTest("First TestName");
			return extent;
	}
	
	
	
}
