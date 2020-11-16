package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import qaclickacademy.javamaven.base;





public class Listensers implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot 
		String s=result.getName();
		try {
		base.getScreenshot(s);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
