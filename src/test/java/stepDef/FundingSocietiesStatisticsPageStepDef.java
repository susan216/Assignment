package stepDef;

import io.cucumber.java.en.Then;
import utils.DependencyInjector;

public class FundingSocietiesStatisticsPageStepDef {

	DependencyInjector dependencyInjector;

	public FundingSocietiesStatisticsPageStepDef(DependencyInjector dependencyInjector) {
		this.dependencyInjector = dependencyInjector;
	}

	
	@Then("Verify Total funded amount is displayed to the user")
	public void verify_total_funded_amount_is_displayed_to_the_user() {
	    
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.statistics_TotalFunded();
	}
	
	@Then("Verify No. of financing is displayed to the user")
	public void verify_no_of_financing_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.statistics_NoOfFinancing();
	}

	@Then("Verify Default rate is displayed to the user")
	public void verify_default_rate_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.statistics_DefaultRate();
	}
	
	@Then("Verify Fulfilment Rate is displayed to the user")
	public void verify_fulfilment_rate_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.statistics_FulfilmentRate();
	}
	
	
	@Then("Verify General Tab is displayed to the user")
	public void verify_general_tab_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.GeneralTab();
	}
	@Then("Verify Repayment Tab is displayed to the user")
	public void verify_repayment_tab_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.RepaymentTab();
	}
	@Then("Verify Disbursement Tab is displayed to the user")
	public void verify_disbursement_tab_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.DisbursmentTab();
	}
	
	@Then("Verify total approved loans is displayed to the user")
	public void verify_total_approved_loans_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.totalApproved_GeneralTab();
	}
	@Then("Verify total amount disbursed is displayed to the user")
	public void verify_total_amount_disbursed_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.totalApproved_AmountDisbursed();
	}
	@Then("Verify default rate is displayed to the user under General tab")
	public void verify_default_rate_is_displayed_to_the_user_under_General_tab() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.totalApproved_DefaultRate();
	}
	

	@Then("Verify total repayment amount,principal amount and interest amount is displayed to the user")
	public void verify_total_repayment_amount_is_displayed_to_the_user() {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.RepaymentAmounts();
	}
	
	@Then("Verify Disbursement tab and store all industry names according percentage")
	public void verify_disbursement_tab_and_store_all_industry_names_according_percentage() throws InterruptedException {
		dependencyInjector.pageObjectManager.getFundingSocitiesStatisticsPageAction()
		.DisbursementTabIndustries();
	}
	

}
