package stepDef;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DependencyInjector;
import utils.SeleniumDriver;

public class FundingSocietiesLandingPageStepDef extends SeleniumDriver{

	DependencyInjector dependencyInjector;

	public FundingSocietiesLandingPageStepDef(DependencyInjector dependencyInjector) throws Exception {
		this.dependencyInjector = dependencyInjector;
	}

	@Given("User launches {string}")
	public void user_launches(String string) throws IOException {
		dependencyInjector.seleniumHelper.openUrl(string); 
	}

	@When("User clicks Statistics button")
	public void user_clicks_statistics_button() {
	    dependencyInjector.pageObjectManager.getFundingSocitiesLandingPageAction().clickstatistics();
	}
	@Then("Verify user is navigated to Statistics page")
	public void verify_user_is_navigated_to_statistics_page() throws IOException {
	    Assert.assertTrue(dependencyInjector.pageObjectManager.fundingSocitiesLandingPageAction.validateOurProgressText());
	}

}
