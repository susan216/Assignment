package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SeleniumHelper {
	
	
	//take screenshot etc
	
	WebDriver driver;
	
	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SwitchToChildWindow() {
		
		Set<String> s =  driver.getWindowHandles();
		Iterator<String> i = s.iterator();
		i.next();
		String ChildWindow = i.next();
		driver.switchTo().window(ChildWindow);
	}
	
	

}
