package testdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LaunchFirefox {
	
  @Test
  public static void launchBrowser(WebDriver webDriver) {
	  	  	
		String appUrl = "http://demo.rtcamp.com/rtmedia/";
		
		webDriver.get(appUrl);
		
		//Wait for page to load
		new WebDriverWait(webDriver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("masthead")));	
		
		//Maximize browser
		webDriver.manage().window().maximize();
		
		//Wait for page to load
		new WebDriverWait(webDriver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("bp-login-widget-submit")));	
  }
    
}
