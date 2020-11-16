package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class checkoutPage {
	
	public checkoutPage(AppiumDriver<?> driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator( driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
	private List<WebElement> name;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement addToCardBtn;
	
	// driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	
	 /* driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")
	 * ).click();
	 */
}
