package utils;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SeleniumHelper {
	
	
		
	WebDriver driver;
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
			"\\src\\test\\java\\config\\global.properties");
	Properties prop = new Properties();
	
	
	public SeleniumHelper(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public void SwitchToChildWindow() {
		
		Set<String> s =  driver.getWindowHandles();
		Iterator<String> i = s.iterator();
		i.next();
		String ChildWindow = i.next();
		driver.switchTo().window(ChildWindow);
	}
	
	

}
