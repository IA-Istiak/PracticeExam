package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStoreHome {
	WebDriver ldriver;
	WebDriverWait wait;
	
	public MyStoreHome(WebDriver rdriver) {
		ldriver = rdriver;
		this.wait = new WebDriverWait(rdriver,Duration.ofSeconds(10));
		
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath ="//a[normalize-space()='Contact us']") WebElement contactUs;
	
	public void clickOnContactUs() {
		wait.until(ExpectedConditions.elementToBeClickable(contactUs));
		contactUs.click();
		
	}
	

}
