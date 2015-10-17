package testdemo;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ValidLogin {
	
  @Test
  public static void verifyValidLogin() throws InterruptedException, AWTException {
	  
	  	WebDriver webDriver = new FirefoxDriver();
	    
	  	//Launch Firefox
	  	LaunchFirefox.launchBrowser(webDriver);
	  
		//Testing for valid username and password
		validLogin(webDriver);
		
		webDriver.close();
		
		//Close the browser
		System.exit(0);
  }
  
  public static void validLogin(WebDriver webDriver) throws InterruptedException, AWTException{
		// TODO Auto-generated method stub
		
		WebElement userNameTxt, passowrdTxt, loginButton;
		
		try{
			//Valid Username
			userNameTxt = webDriver.findElement(By.id("bp-login-widget-user-login"));
			userNameTxt.clear();
			userNameTxt.sendKeys("demo");
			
			//Valid Password
			 passowrdTxt = webDriver.findElement(By.id("bp-login-widget-user-pass"));
			passowrdTxt.clear();
			passowrdTxt.sendKeys("demo");
			
			//click to login
			loginButton = webDriver.findElement(By.id("bp-login-widget-submit"));
			loginButton.click();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//wait for page to load
		new WebDriverWait(webDriver, 80).until(ExpectedConditions.visibilityOfElementLocated(By.id("aw-whats-new-submit")));
		
	}

  
}
