package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundingSocitiesLandingPageAction  {
	
	WebDriver driver;
	public FundingSocitiesLandingPageAction(WebDriver driver) {
		
		this.driver = driver;
	}
	public By statistics = By.linkText("Statistics");
	
	public void clickstatistics() {
		driver.findElement(statistics).click();
	}
	
	

}
