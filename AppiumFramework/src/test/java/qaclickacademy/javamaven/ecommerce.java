package qaclickacademy.javamaven;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce extends base{



@Test
public void totalValidation() throws IOException, InterruptedException

{

     AndroidDriver<AndroidElement> driver=Capabilities("GeneralStoreApp ");

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

     driver.hideKeyboard();

     driver.findElement(By.xpath("//*[@text='Female']")).click();

     driver.findElement(By.id("android:id/text1")).click();

     

     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     

     driver.findElement(By.xpath("//*[@text='Argentina']")).click();

     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();   

   
     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
     driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
     driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
     Thread.sleep(3000);
     
    String price1 =  driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
    String price2 =  driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
    
double amtprice1 =    convertAmtToDouble(price1); 
double amtprice2 = convertAmtToDouble(price2);  
double  finalprice = amtprice1 + amtprice2; 
   System.out.println(finalprice);
   String finalCartAmt=   driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
   double finalCardAmount =  Double.parseDouble(finalCartAmt.substring(1));
   System.out.println(finalCardAmount);
 
   Assert.assertEquals(finalprice, finalCardAmount, 0.001 );
  WebElement tC =  driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
  WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
  TouchAction action =new TouchAction(driver);
  
  action.tap(tapOptions().withElement(element(checkBox))).perform();   
  
  action.longPress(longPressOptions().withElement(element(tC)).withDuration(ofSeconds(2))).release().perform();
  
  driver.findElement(By.xpath("//*[@text='CLOSE']")).click();
  Thread.sleep(2000);
  driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
  Thread.sleep(4000);
  Set<String>contexts= driver.getContextHandles();
  
  for (String contextName : contexts) 
  {
	  System.out.println(contextName);
  }
  driver.context("WEBVIEW_com.androidsample.generalstore");
  Thread.sleep(4000); 
  driver.findElement(By.xpath("//*[@text='IMAGES']")).click();
  driver.findElement(By.name("q")).click();
  driver.findElement(By.name("q")).sendKeys("hello");
  
  
  
}
  
  
  


    public static double convertAmtToDouble(String value)
{
	value = value.substring(1);
   double amt2value = Double.parseDouble(value);
	
	return amt2value ;
	}
}

