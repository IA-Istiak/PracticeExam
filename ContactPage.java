package pages;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ContactPage {
	WebDriver ldriver;
	WebDriverWait wait;
	
	public ContactPage(WebDriver rdriver) {
		ldriver = rdriver;
		this.wait = new WebDriverWait(rdriver,Duration.ofSeconds(10));
		
		PageFactory.initElements(rdriver,this);
	}
	
	//Dropdown
	@FindBy(xpath ="//select[@id='id_contact']") WebElement SubHandling;
	
	public void clickSubHandling() {
		
		SubHandling.click();
	}
	
	public void selectFormSubHandling() {
		
		Select select = new Select(SubHandling);
		
		select.selectByValue("2");
		
		String optionText = select.getFirstSelectedOption().getText();
		
		String expectedText = "Customer service";
		
		Assert.assertEquals(expectedText, optionText);
		
		
		
		
	}
	
	@FindBy(xpath = "//input[@id='email']")WebElement email;
	
	public void enterEmail() {
		String randomString = RandomStringUtils.randomAlphanumeric(5);
		
		String randomEmail = randomString + "@example.com";
		
		email.sendKeys(randomEmail);
		System.out.println(randomEmail);
	}
	
	@FindBy(xpath ="//input[@id='id_order']") WebElement Oreference;
	public void enterOreference() {
		Random random = new Random();
		int randnumber = random.nextInt(10000);
		String number = Integer.toString(randnumber);
		Oreference.sendKeys(number);
		System.out.println(number);
	}
	
	@FindBy(xpath ="//textarea[@id='message']") WebElement textarea;
	public void enterText() {
		String randomString = RandomStringUtils.randomAlphanumeric(50);
		
		
		
		textarea.sendKeys(randomString);
		System.out.println(randomString);
	}
	@FindBy(xpath ="//span[normalize-space()='Send']") WebElement Send;
	public void enterSend() {
		Actions action = new Actions(ldriver);
		action.moveToElement(Send);
		Send.click();
		
	}

}
