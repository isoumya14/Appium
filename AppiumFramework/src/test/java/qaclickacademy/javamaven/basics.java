package qaclickacademy.javamaven;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Perferences;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;




public class basics extends base {

	
	@Test (dataProvider= "InputData", dataProviderClass= TestData.class)
	public void apiDemoTest(String input) throws IOException, InterruptedException  {
		
		  service= startServer();
		     startEmulator();
		
		AndroidDriver<AndroidElement> driver = Capabilities("ApiDemo");
		System.out.println("soumya aa");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
      HomePage hp = new HomePage(driver);
      Perferences p = new Perferences(driver);
      
      
     p.Perference.click();
     p.dependencies.click();
     driver.findElementById("android:id/checkbox").click();
     driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
     driver.findElementById("android:id/edit").sendKeys(input);
     driver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
