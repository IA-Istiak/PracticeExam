package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ContactPage;
import pages.MyStoreHome;

public class ContactUsTestCase extends BaseTest {
	WebDriverWait wait;

	@Test
	public void verifyContactUs() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		driver.get("http://www.automationpractice.pl/index.php");
		MyStoreHome msh = new MyStoreHome(driver);
		msh.clickOnContactUs();

		System.out.println(driver.getCurrentUrl());

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		String actualTitle = driver.getTitle();
		String expectedTitle = "Contact us - My Shop";
		// Assert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertEquals(actualTitle, expectedTitle);

		////////////////////
		ContactPage cp = new ContactPage(driver);
		cp.clickSubHandling();
		cp.selectFormSubHandling();

		cp.enterEmail();
		cp.enterOreference();
		cp.enterText();

		cp.enterSend();

		WebElement success = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		wait.until(ExpectedConditions.visibilityOf(success));

		softAssert.assertAll();

	}

	@Test
	public void verifyContactUs2() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();
		driver.get("http://www.automationpractice.pl/index.php");
		MyStoreHome msh = new MyStoreHome(driver);
		msh.clickOnContactUs();

		System.out.println(driver.getCurrentUrl());

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		String actualTitle = driver.getTitle();
		String expectedTitle = "Contact usuu - My Shop";
		// 

		try {
			// Your test code with assertions
			//softAssert.assertEquals(actualTitle, expectedTitle);
			Assert.assertEquals(actualTitle, expectedTitle);

		} catch (AssertionError e) {
			BaseTest.takeScreenshot(driver, "D:\\ProgramFiles\\CodeStudio\\MyStoreV1\\screenshot\\testExample.png");
			throw e; // Re-throw to let the test framework handle the failure
		}

		////////////////////
		ContactPage cp = new ContactPage(driver);
		cp.clickSubHandling();
		cp.selectFormSubHandling();

		cp.enterEmail();
		cp.enterOreference();
		cp.enterText();

		cp.enterSend();

		WebElement success = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
		wait.until(ExpectedConditions.visibilityOf(success));

		softAssert.assertAll();

	}

	public void waitUntilPageLoaded() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
	}

}
