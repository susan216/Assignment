package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumDriver;

public class FundingSocitiesLandingPageAction {
	
	WebDriver driver;
	
	public FundingSocitiesLandingPageAction(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Statistics")
	private WebElement statistics;
		
	@FindBy(css = "div h1")
	private WebElement OurProgressText;
	
	public void clickstatistics() {
		statistics.click();
	}
	
	public boolean validateOurProgressText() {
		return OurProgressText.isDisplayed();
	}
	
	

}
