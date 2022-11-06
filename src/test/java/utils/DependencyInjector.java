package utils;

import org.openqa.selenium.WebDriver;

public class DependencyInjector extends SeleniumDriver{
	
	
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public SeleniumHelper seleniumHelper;
	
	
	public DependencyInjector() throws Exception {
				
			System.out.println("Setting up Driver...");
			pageObjectManager = new PageObjectManager(getDriver());
			seleniumHelper = new SeleniumHelper(getDriver());
		
	}
	
	
	
	

}
