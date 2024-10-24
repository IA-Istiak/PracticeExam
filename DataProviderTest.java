package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest extends BaseTest {
	
	@Test(dataProvider = "UserData")
	void VerifyLogin(String username)
	{
		driver.get("https://www.saucedemo.com/v1/index.html");
		 // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter the login credentials (username and password)
        usernameField.sendKeys(username); // Example username
        passwordField.sendKeys("secret_sauce"); // Example password

        // Click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

     // Wait for the page to load after login 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bm-burger-button']")));

        // Click on the menu button
        WebElement menuButton = driver.findElement(By.xpath("//div[@class='bm-burger-button']"));
        menuButton.click();

        // Wait for the logout button to be visible and click it
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logoutButton.click();

        // Verify successful logout (optional)
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/v1/index.html"));
        System.out.println("Successfully logged out.");
        
        
		
	}
	
	@DataProvider(name = "UserData")
	public Object[][] dataProviderMethod()
	{
		return new Object[][]
				{{"standard_user"},{"locked_out_user"}};
	}

}
