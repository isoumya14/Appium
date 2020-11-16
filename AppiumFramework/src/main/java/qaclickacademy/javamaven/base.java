package qaclickacademy.javamaven;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;



import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;



public class base {


	  public static AppiumDriverLocalService service;
	  public static AndroidDriver<AndroidElement>  driver;
	
	//To start Appium server 
	   public AppiumDriverLocalService startServer()
	{
		//
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
public static void startEmulator() throws IOException, InterruptedException
{

	Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
	Thread.sleep(6000);
}

	
public static AndroidDriver<AndroidElement> Capabilities(String app) throws IOException, InterruptedException {
	
	
	
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\qaclickacademy\\javamaven\\globalProperties.properties");
	
	Properties pros = new Properties();
	pros.load(fis);

    File appDir= new File("Src");
    File fs=new File(appDir,(String) pros.get(app));

    DesiredCapabilities cap=new DesiredCapabilities();

    /*getting the property file    */
  //  String device = (String) pros.get("DeviceName"); 
    
    String device = System.getProperty("deviceName");

    if(device.contains("emulator"))
{
     startEmulator();
}
cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);

cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");

cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
cap.setCapability("noReset", "true");
cap.setCapability("fullReset", "false");
//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//cap.setCapability("autoWebview", false);
//cap.setCapability("chromedriverExecutable", "C:\\Users\\Happie\\AppData\\Roaming\\npm\\node_modules\\appium\\node_modules\\appium-chromedriver\\chromedriver\\win\\chromedriver.exe");

//cap.setCapability("appPackage", "com.qaddoo");

//cap.setCapability("appActivity", "com.qaddoo.activity.SplashActivity");

cap.setCapability("autoGrantPermissions", "true");

cap.setCapability(MobileCapabilityType.SUPPORTS_LOCATION_CONTEXT, "True");

AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);

return driver;

}

public static void getScreenshot(String s) throws IOException
{
File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));

}





}