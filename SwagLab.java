package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwagLab {
	WebDriver ldriver;
	WebDriverWait wait;
	
	public SwagLab(WebDriver rdriver) {
		ldriver = rdriver;
		this.wait = new WebDriverWait(rdriver,Duration.ofSeconds(10)) ;
		PageFactory.initElements(rdriver, this);
	}

}
