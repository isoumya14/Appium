package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Perferences {
	
	public Perferences(AppiumDriver driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator( driver), this);
	}
	

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Preference']")
    public WebElement Perference;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3. Preference dependencies']")
	public WebElement dependencies;
	
}
