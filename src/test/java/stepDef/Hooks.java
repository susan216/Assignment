package stepDef;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DependencyInjector;

public class Hooks {
	
	
	DependencyInjector dependancyInjector;
	WebDriver driver;
	
	public Hooks(DependencyInjector dependancyInjector) {
		this.dependancyInjector = dependancyInjector;
	}
	
	
		
	
	@After()
	public void closeDriverAfterScenario() throws IOException {
		driver = dependancyInjector.getDriver();
		driver.quit();
	}
	
	@AfterStep()
	public void takeScreenshot(Scenario scenario) throws IOException {
		driver = dependancyInjector.getDriver();
		
		File SourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		byte[] file =  FileUtils.readFileToByteArray(SourcePath);
		
		
		scenario.attach(file, "image/png", "Screenshot");
		
		
		
	}

}
