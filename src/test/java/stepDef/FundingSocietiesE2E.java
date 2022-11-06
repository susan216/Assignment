package stepDef;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FundingSocietiesE2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://fundingsocieties.com/");

		// click statistics
		driver.findElement(By.linkText("Statistics")).click();

		Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Statistics")));
		List<WebElement> statistics = driver.findElements(By.cssSelector(".detailNumber"));

		// verify total funded is displayed
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

		// verify no. of financing is displayed
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

		// verify Default rate is displayed
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

		// verify fulfillment rate is displayed
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

		List<WebElement> Tabs = driver.findElements(By.cssSelector(".tab-button"));

		// Verify General Tab is present
		boolean GeneralTab = false;
		for (WebElement tab : Tabs) {

			if (tab.getText().contains("General")) {

				System.out.println("General tab is displayed");
				GeneralTab = true;
				break;

			}

		}
		Assert.assertTrue(GeneralTab);

		// Verify Repayment Tab is present
		boolean RepaymentTab = false;
		for (WebElement tab : Tabs) {

			if (tab.getText().contains("Repayment")) {

				System.out.println("Repayment tab is displayed");
				RepaymentTab = true;
				break;

			}

		}
		Assert.assertTrue(RepaymentTab);

		// Verify Disbursement Tab is present
		boolean DisbursementTab = false;
		for (WebElement tab : Tabs) {

			if (tab.getText().contains("Disbursement")) {

				System.out.println("Disbursement tab is displayed");
				DisbursementTab = true;
				break;

			}

		}
		Assert.assertTrue(DisbursementTab);

		// Get GeneralTab> Total approved

		List<WebElement> TotalApprovedValues = driver
				.findElements(By.cssSelector(".highcharts-markers .highcharts-point"));
		driver.findElement(By.cssSelector(".pull-right .btn")).click();
		Actions action = new Actions(driver);
		action.moveToElement(TotalApprovedValues.get(TotalApprovedValues.size() - 1)).build().perform();
		TotalApprovedValues.get(TotalApprovedValues.size() - 1).click();
		System.out.println(driver.findElement(By.cssSelector("g text tspan:nth-child(4)")).getText()
				+ " is the latest total approved loans");

		// Get GeneralTab> Amount disbursed
		driver.findElement(By.cssSelector("label[for='toggle-disbursed']")).click();
		List<WebElement> disbursedAmountValues = driver
				.findElements(By.cssSelector(".highcharts-markers .highcharts-point"));
		action.moveToElement(disbursedAmountValues.get(disbursedAmountValues.size() - 1)).build().perform();
		disbursedAmountValues.get(disbursedAmountValues.size() - 1).click();
		System.out.println(driver.findElement(By.cssSelector("g text tspan:nth-child(4)")).getText()
				+ " is the latest total Disbursed amount");

		// Get Default rate
		driver.findElement(By.cssSelector("label[for='toggle-default']")).click();
		List<WebElement> defaultRateValues = driver
				.findElements(By.cssSelector(".highcharts-markers .highcharts-point"));
		action.moveToElement(defaultRateValues.get(defaultRateValues.size() - 1)).build().perform();
		defaultRateValues.get(defaultRateValues.size() - 1).click();
		System.out.println(driver.findElement(By.cssSelector("g text tspan:nth-child(4)")).getText()
				+ " is the latest Default Rate");

		// Repayment tab > repayment
		driver.findElement(By.cssSelector(".tab-button:nth-child(2)")).click();
		List<WebElement> GraphValues = driver.findElements(By.cssSelector(".highcharts-point"));
		action.moveToElement(GraphValues.get(0)).build().perform();
		GraphValues.get(0).click();
		System.out.println(driver.findElement(By.cssSelector("g text tspan:nth-child(4)")).getText()
				+ " is the Total Repayment amount");

		GraphValues.get(1).click();
		System.out.println(
				driver.findElement(By.cssSelector("g text tspan:nth-child(4)")).getText() + " is the Principal amount");

		GraphValues.get(2).click();
		System.out.println(
				driver.findElement(By.cssSelector("g text tspan:nth-child(4)")).getText() + " is the Interest amount");

		// Repayment tab > repayment
		driver.findElement(By.cssSelector(".tab-button:nth-child(3)")).click();

		List<WebElement> industries = driver.findElements(By.cssSelector(".highcharts-pie-series .highcharts-point"));

		/*
		 * for(WebElement ind : industries) { Thread.sleep(3000); try {
		 * wait.until(ExpectedConditions.elementToBeClickable(ind));
		 * action.moveToElement(ind, 8, 18).click().build().perform();
		 * //driver.findElement(By.cssSelector(".highcharts-point-select")).click();
		 * }catch(Exception e) { e.printStackTrace(); }
		 * System.out.println(driver.findElement(By.cssSelector("text tspan")).getText()
		 * + " - " +
		 * driver.findElement(By.cssSelector("text tspan:nth-child(4)")).getText()); }
		 */

		for (int i = 0; i <= industries.size(); i++) {

			wait.until(ExpectedConditions.elementToBeClickable(
					By.cssSelector(".highcharts-pie-series .highcharts-point:nth-child(" + i + ")")));
			try {

				driver.findElement(By.cssSelector(".highcharts-pie-series .highcharts-point:nth-child(" + i + ")"))
						.click();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
