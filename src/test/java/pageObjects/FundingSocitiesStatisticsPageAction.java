package pageObjects;

import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FundingSocitiesStatisticsPageAction {

	WebDriver driver;
	public FundingSocitiesStatisticsPageAction(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = ".detailNumber")
	private List<WebElement> Statistics_Values;
	
	@FindBy(css = ".tab-button")
	private List<WebElement> Statistics_Tabs;
	
	@FindBy(css = ".highcharts-markers .highcharts-point")
	private List<WebElement> GraphPoints;
	
	@FindBy(css = ".pull-right .btn")
	private WebElement TotalApprovedBtn;
	
	@FindBy(css = "label[for='toggle-disbursed']")
	private WebElement AmountDisbursed;
	
	@FindBy(css = "label[for='toggle-default']")
	private WebElement defualtRate;
	
	@FindBy(css = "g text tspan:nth-child(4)")
	private WebElement LatestValue;
	
	@FindBy(css = ".tab-button:nth-child(2)")
	private WebElement repaymentTab;
	
	@FindBy(css = ".highcharts-point")
	private List<WebElement> repaymentGraphValues;
	
	@FindBy(css = ".tab-button:nth-child(3)")
	private WebElement disbursementTab;
	
	@FindBy(css = ".highcharts-pie-series .highcharts-point")
	private List<WebElement> AllIndustries;
	
	@FindBy(css = "text tspan")
	private WebElement industryName;
	
	@FindBy(css = "text tspan:nth-child(4)")
	private WebElement industryPercentage;
	
	

	public void statistics_TotalFunded() {
		

		for (WebElement caption : Statistics_Values) {
			WebElement text = caption.findElement(By.cssSelector(".detailNumber .detailCaption"));
			if (text.isDisplayed()) {
				if (text.getText().equalsIgnoreCase("Total funded")) {
					System.out.println(text.getText() + " is Displayed");
					Assert.assertTrue(caption.findElement(By.cssSelector(".detailNumber font")).isDisplayed());
					System.out.println(caption.findElement(By.cssSelector(".detailNumber font")).getText()
							+ " amount is Displayed");
				}
			}

		}

	}

	public void statistics_NoOfFinancing() {
		
		for (WebElement caption : Statistics_Values) {
			WebElement text = caption.findElement(By.cssSelector(".detailNumber .detailCaption"));
			if (text.isDisplayed()) {
				if (text.getText().contains("No. of")) {
					System.out.println(text.getText() + " is Displayed");
					Assert.assertTrue(caption.findElement(By.cssSelector(".detailNumber font")).isDisplayed());
					System.out.println(caption.findElement(By.cssSelector(".detailNumber font")).getText()
							+ " amount is Displayed");
				}
			}

		}
	}

	public void statistics_DefaultRate() {

		for (WebElement caption : Statistics_Values) {
			WebElement text = caption.findElement(By.cssSelector(".detailNumber .detailCaption"));
			if (text.isDisplayed()) {
				if (text.getText().contains("Default")) {
					System.out.println(text.getText() + " is Displayed");
					Assert.assertTrue(caption.findElement(By.cssSelector(".detailNumber font")).isDisplayed());
					System.out.println(caption.findElement(By.cssSelector(".detailNumber font")).getText()
							+ " amount is Displayed");
				}
			}

		}
	}

	public void statistics_FulfilmentRate() {
		
		for (WebElement caption : Statistics_Values) {
			WebElement text = caption.findElement(By.cssSelector(".detailNumber .detailCaption"));
			if (text.isDisplayed()) {
				if (text.getText().contains("fulfillment rate")) {
					System.out.println(text.getText() + " is Displayed");
					Assert.assertTrue(caption.findElement(By.cssSelector(".detailNumber font")).isDisplayed());
					System.out.println(caption.findElement(By.cssSelector(".detailNumber font")).getText()
							+ " amount is Displayed");
				}
			}

		}

	}

	public void GeneralTab() {

		boolean GeneralTab = false;
		for (WebElement tab : Statistics_Tabs) {

			if (tab.getText().contains("General")) {

				System.out.println("General tab is displayed");
				GeneralTab = true;
				break;

			}

		}
		Assert.assertTrue(GeneralTab);
	}

	public void RepaymentTab() {

		boolean RepaymentTab = false;
		for(WebElement tab : Statistics_Tabs) {
			
			if(tab.getText().contains("Repayment")) {
				
				System.out.println("Repayment tab is displayed");
				RepaymentTab = true;
				break;
				
			}
			
		}
		Assert.assertTrue(RepaymentTab);
	}

	public void DisbursmentTab() {

		boolean DisbursementTab = false;
		for(WebElement tab : Statistics_Tabs) {
			
			if(tab.getText().contains("Disbursement")) {
				
				System.out.println("Disbursement tab is displayed");
				DisbursementTab = true;
				break;
				
			}
			
		}
		Assert.assertTrue(DisbursementTab);
	}
	
	
	public void totalApproved_GeneralTab() {
		TotalApprovedBtn.click();
		Actions action = new Actions(driver);
		action.moveToElement(GraphPoints.get(GraphPoints.size()-1)).build().perform();
		GraphPoints.get(GraphPoints.size()-1).click();
		System.out.println(LatestValue.getText() + " is the latest total approved loans");
		
	}
	
	public void totalApproved_AmountDisbursed() {
		AmountDisbursed.click();
		Actions action = new Actions(driver);
		action.moveToElement(GraphPoints.get(GraphPoints.size()-1)).build().perform();
		GraphPoints.get(GraphPoints.size()-1).click();
		System.out.println(LatestValue.getText() + " is the latest total approved loans");
		
	}

	public void totalApproved_DefaultRate() {
		defualtRate.click();
		Actions action = new Actions(driver);
		action.moveToElement(GraphPoints.get(GraphPoints.size()-1)).build().perform();
		GraphPoints.get(GraphPoints.size()-1).click();
		System.out.println(LatestValue.getText() + " is the latest total approved loans");
		
	}
	
	public void RepaymentAmounts() {
		
		repaymentTab.click();
		Actions action = new Actions(driver);
		action.moveToElement(repaymentGraphValues.get(0)).build().perform();
		repaymentGraphValues.get(0).click();
		System.out.println(LatestValue.getText() + " is the Total Repayment amount");
		
		repaymentGraphValues.get(1).click();
		System.out.println(LatestValue.getText() + " is the Principal amount");
		
		repaymentGraphValues.get(2).click();
		System.out.println(LatestValue.getText() + " is the Interest amount");
		
	}
	
	
	public void DisbursementTabIndustries() throws InterruptedException {
		
		
		HashMap<String,String> hm = new HashMap<String,String>();
		disbursementTab.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		Actions action = new Actions(driver);

		System.out.println("***Fetching Industries....***");
		 for(WebElement ind : AllIndustries) {
			 Thread.sleep(3000);
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(ind));
			 
			 action.moveToElement(ind).click().build().perform();
			  
			  hm.put(industryName.getText(), industryPercentage.getText());
			  
			  }catch(Exception e) { 
				  System.out.println(e);
			  }
			 
		 }		 
		 
		 LinkedHashMap<String, String> lhm = hm.entrySet().stream().sorted((e1, e2)-> {
			 return (Float.valueOf(e1.getValue()).compareTo(Float.valueOf(e2.getValue())));
		 }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap :: new));
		 
		 
		 
		 System.out.println("**************INDUSTIRES IN ASCENDING ORDER OF PERCENTAGE***************");
		 for(Entry<String, String> e : lhm.entrySet()) {
			 System.out.println(e.getKey() + "=" + e.getValue());
		 }
		 System.out.println("**********************************************************");
	
	
	}

}
