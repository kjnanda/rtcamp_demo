package testdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class InvalidLogin {
  @Test
  public static void verifyInvalidLogin() {
	  
	  	WebDriver webDriver = new FirefoxDriver();
	 
	  	//Launch Firefox
	  	LaunchFirefox.launchBrowser(webDriver);
	
	  //Testing for Invalid username and password

		WebElement userNameTxt, passowrdTxt, loginButton;
		
		try{
			//Pass Invalid Username
			userNameTxt = webDriver.findElement(By.id("bp-login-widget-user-login"));
			userNameTxt.clear();
			userNameTxt.sendKeys("dem");
			
			//Pass Invalid Password
			 passowrdTxt = webDriver.findElement(By.id("bp-login-widget-user-pass"));
			passowrdTxt.clear();
			passowrdTxt.sendKeys("dem");
			
			 loginButton = webDriver.findElement(By.id("bp-login-widget-submit"));
			 loginButton.click();
		}catch(Exception e){
			e.printStackTrace();			
		}
		
		//Wait for error message to be displayed on page
		new WebDriverWait(webDriver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-submit")));
		
		webDriver.close();
		
		//Close the browser
		System.exit(0);
				
	   }
}
