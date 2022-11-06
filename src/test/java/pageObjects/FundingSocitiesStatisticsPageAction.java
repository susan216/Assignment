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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FundingSocitiesStatisticsPageAction {

	WebDriver driver;

	public FundingSocitiesStatisticsPageAction(WebDriver driver) {

		this.driver = driver;
	}

	public By statistics = By.linkText("Statistics");
	public By Statistics_Values = By.cssSelector(".detailNumber");
	public By Statistics_Tabs = By.cssSelector(".tab-button");
	public By GraphPoints = By.cssSelector(".highcharts-markers .highcharts-point");
	public By TotalApprovedBtn = By.cssSelector(".pull-right .btn");
	public By AmountDisbursed = By.cssSelector("label[for='toggle-disbursed']");
	public By defualtRate = By.cssSelector("label[for='toggle-default']");
	public By LatestValue = By.cssSelector("g text tspan:nth-child(4)");
	public By repaymentTab = By.cssSelector(".tab-button:nth-child(2)");
	public By repaymentGraphValues = By.cssSelector(".highcharts-point");
	public By disbursementTab = By.cssSelector(".tab-button:nth-child(3)");
	public By AllIndustries = By.cssSelector(".highcharts-pie-series .highcharts-point");
	public By industryName = By.cssSelector("text tspan");
	public By industryPercentage = By.cssSelector("text tspan:nth-child(4)");
	
	public void clickstatistics() {
		driver.findElement(statistics).click();
	}

	public void statistics_TotalFunded() {
		List<WebElement> statistics = driver.findElements(Statistics_Values);

		for (WebElement caption : statistics) {
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
		List<WebElement> statistics = driver.findElements(Statistics_Values);

		for (WebElement caption : statistics) {
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

		List<WebElement> statistics = driver.findElements(Statistics_Values);

		for (WebElement caption : statistics) {
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
		List<WebElement> statistics = driver.findElements(Statistics_Values);

		for (WebElement caption : statistics) {
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

		List<WebElement> Tabs = driver.findElements(Statistics_Tabs);

		boolean GeneralTab = false;
		for (WebElement tab : Tabs) {

			if (tab.getText().contains("General")) {

				System.out.println("General tab is displayed");
				GeneralTab = true;
				break;

			}

		}
		Assert.assertTrue(GeneralTab);
	}

	public void RepaymentTab() {

		List<WebElement> Tabs = driver.findElements(Statistics_Tabs);

		boolean RepaymentTab = false;
		for(WebElement tab : Tabs) {
			
			if(tab.getText().contains("Repayment")) {
				
				System.out.println("Repayment tab is displayed");
				RepaymentTab = true;
				break;
				
			}
			
		}
		Assert.assertTrue(RepaymentTab);
	}

	public void DisbursmentTab() {

		List<WebElement> Tabs = driver.findElements(Statistics_Tabs);

		boolean DisbursementTab = false;
		for(WebElement tab : Tabs) {
			
			if(tab.getText().contains("Disbursement")) {
				
				System.out.println("Disbursement tab is displayed");
				DisbursementTab = true;
				break;
				
			}
			
		}
		Assert.assertTrue(DisbursementTab);
	}
	
	
	public void totalApproved_GeneralTab() {
		
		List<WebElement> TotalApprovedValues =driver.findElements(GraphPoints);
		driver.findElement(TotalApprovedBtn).click();
		Actions action = new Actions(driver);
		action.moveToElement(TotalApprovedValues.get(TotalApprovedValues.size()-1)).build().perform();
		TotalApprovedValues.get(TotalApprovedValues.size()-1).click();
		System.out.println(driver.findElement(LatestValue).getText() + " is the latest total approved loans");
		
	}
	
	public void totalApproved_AmountDisbursed() {
		driver.findElement(AmountDisbursed).click();
		List<WebElement> TotalApprovedValues =driver.findElements(GraphPoints);
		
		Actions action = new Actions(driver);
		action.moveToElement(TotalApprovedValues.get(TotalApprovedValues.size()-1)).build().perform();
		TotalApprovedValues.get(TotalApprovedValues.size()-1).click();
		System.out.println(driver.findElement(LatestValue).getText() + " is the latest total approved loans");
		
	}

	public void totalApproved_DefaultRate() {
		driver.findElement(defualtRate).click();
		List<WebElement> TotalApprovedValues =driver.findElements(GraphPoints);
		
		Actions action = new Actions(driver);
		action.moveToElement(TotalApprovedValues.get(TotalApprovedValues.size()-1)).build().perform();
		TotalApprovedValues.get(TotalApprovedValues.size()-1).click();
		System.out.println(driver.findElement(LatestValue).getText() + " is the latest total approved loans");
		
	}
	
	public void RepaymentAmounts() {
		
		driver.findElement(repaymentTab).click();
		List<WebElement> GraphValues =driver.findElements(repaymentGraphValues);
		Actions action = new Actions(driver);
		action.moveToElement(GraphValues.get(0)).build().perform();
		GraphValues.get(0).click();
		System.out.println(driver.findElement(LatestValue).getText() + " is the Total Repayment amount");
		
		GraphValues.get(1).click();
		System.out.println(driver.findElement(LatestValue).getText() + " is the Principal amount");
		
		GraphValues.get(2).click();
		System.out.println(driver.findElement(LatestValue).getText() + " is the Interest amount");
		
	}
	
	
	public void DisbursementTabIndustries() throws InterruptedException {
		HashMap<String,String> hm = new HashMap<String,String>();
		driver.findElement(disbursementTab).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		List<WebElement> industries =  driver.findElements(AllIndustries);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		Actions action = new Actions(driver);
		
		 for(WebElement ind : industries) {
			 Thread.sleep(3000);
			 try {
			 wait.until(ExpectedConditions.elementToBeClickable(ind));
			 action.moveToElement(ind).click().build().perform();
			 System.out.println(driver.findElement(industryName).getText()
					  + " - " +
			 driver.findElement(industryPercentage).getText());
			  
			  hm.put(driver.findElement(industryName).getText(), driver.findElement(industryPercentage).getText());
			  
			  }catch(Exception e) { 
				  e.printStackTrace(); 
				  }
			 
		 }
			 
		 
		 System.out.println(hm);
		 
		 LinkedHashMap<String, String> lhm = hm.entrySet().stream().sorted((e1, e2)-> {
			 return (Float.valueOf(e1.getValue()).compareTo(Float.valueOf(e2.getValue())));
		 }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap :: new));
		 
		 for(Entry<String, String> e : lhm.entrySet()) {
			 System.out.println(e.getKey() + "=" + e.getValue());
		 }
	}

}
