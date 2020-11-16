package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

	public FormPage(AppiumDriver<AndroidElement> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator( driver), this);
	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement name;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	private WebElement gender;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countryDropdown;
	
	@AndroidFindBy(xpath="//*[@text='Argentina']")
	private WebElement selectCountry;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement LetsShopBtn;
	
	
		public WebElement getName()
		{
			return name;
		}	
		
		public WebElement getGender()
		{
			return gender;
		}	
		public WebElement getCountryDropdown()
		{
			return countryDropdown;
		}	
		public WebElement getSelectCountry()
		{
			return selectCountry;
		}	
		public WebElement getLetsShopBtn()
		{
			return LetsShopBtn;
		}	
		
}
