package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDriver {
	
	public SeleniumDriver() throws Exception {
		
	}
	WebDriver driver;
	FileInputStream fis = new FileInputStream(
			"C:\\Users\\91955\\E2EFramework\\WithTestNG\\src\\test\\java\\config\\global.properties");
	Properties prop = new Properties();
	
	public WebDriver getDriver() throws IOException {
		prop.load(fis);
		DesiredCapabilities caps = new DesiredCapabilities();
		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");
		caps.setBrowserName(browser);
		caps.setPlatform(providePlatform());
		if (driver == null) {
			driver = new RemoteWebDriver(new URL("http://192.168.29.103:4444/"), caps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
		}else {
			return driver;
		}

		// boolean headless = System.getProperty("headless")!=null?
		// Boolean.parseBoolean(System.getProperty("headless")):
		// Boolean.parseBoolean(prop.getProperty("headless"));

		/*
		 * DesiredCapabilities dc =DesiredCapabilities(); LoggingPreferences logprefs =
		 * new LoggingPreferences(); logprefs.enable(LogType.PERFORMANCE, Level.ALL);
		 * dc.setCapability(CapabilityType.LOGGING_PREFS, logprefs); RemoteWebDriver
		 * driver2 = new RemoteWebDriver(dc);
		 */
		/*
		 * if(browser.equalsIgnoreCase("chrome")) { if(driver== null) {
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options = new
		 * ChromeOptions(); //options.setHeadless(headless); driver = new
		 * ChromeDriver(options);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); } }else
		 * if(browser.equalsIgnoreCase("edge")) { if(driver== null) {
		 * WebDriverManager.edgedriver().setup(); EdgeOptions options = new
		 * EdgeOptions(); //options.setHeadless(headless); driver = new
		 * EdgeDriver(options);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); } }
		 */
		

	}

	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

	public static Object[] getJsonData(String fileName) throws IOException {

		String fileAsString = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\deepthi\\dataProvider\\" + fileName),
				StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();

		/* String to Json */
		List<HashMap<String, String>> map = mapper.readValue(fileAsString,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return map.toArray();
	}

	public void openURL(String url) {

		driver.get(url);
	}
	
	public Platform providePlatform() throws IOException {
		prop.load(fis);
		String platform = prop.getProperty("platform");
		if (platform.equalsIgnoreCase("MAC")) {
			return Platform.MAC;
			
		}else if (platform.equalsIgnoreCase("Linux")) {
			return Platform.LINUX;
			
		}else {
			return Platform.WIN10;
		}
	}

}
