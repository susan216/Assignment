package utils;

import org.openqa.selenium.WebDriver;

import pageObjects.FundingSocitiesLandingPageAction;
import pageObjects.FundingSocitiesStatisticsPageAction;


public class PageObjectManager {
	
	
	
	WebDriver driver;
	public FundingSocitiesLandingPageAction fundingSocitiesLandingPageAction;
	public FundingSocitiesStatisticsPageAction fundingSocitiesStatisticsPageAction;
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public FundingSocitiesLandingPageAction getFundingSocitiesLandingPageAction() {
		return fundingSocitiesLandingPageAction = new FundingSocitiesLandingPageAction(driver);
	}
	
	public FundingSocitiesStatisticsPageAction getFundingSocitiesStatisticsPageAction() {
		return fundingSocitiesStatisticsPageAction = new FundingSocitiesStatisticsPageAction(driver);
	}
	
	
	
	

	
	
	

}
