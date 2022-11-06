package runners;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(		
			
		features = "@target/failed_scenarios.txt",
		glue = "stepDef",
		plugin = {"pretty","html:target/cucumber.html", "json:target/cucumber.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true,
		tags = "@Statistics_NoOfFinancing or @Statistics_FulfilmentRate"
		)


public class RerunTestNGRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	
	
}
