package project.testcomponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	// this is all to retry the test which has failed
	//also to rerun we have to go to particular test and provide in anottation retryAnalyzer=Retry.class
	int count=0;
	int maxTry=1;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<maxTry)
		{
			count++;
			return true;
		}
		
		return false;
	}

	
	
	
}
