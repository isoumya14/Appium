package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class commonMethods {
	
	AndroidDriver<AndroidElement> driver;
	
	public commonMethods (AndroidDriver<AndroidElement> driver) 
	{
		this.driver = driver;
	}
	
	
	public void scrollIntoText(String text) 
	{
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}

}
