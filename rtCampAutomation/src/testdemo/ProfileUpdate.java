package testdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;

import org.testng.annotations.Test;
public class ProfileUpdate {
	@Test
	public static void profileupdate_main() throws InterruptedException, AWTException {
		WebDriver webDriver = new FirefoxDriver();
	  	LaunchFirefox.launchBrowser(webDriver);
	  
		//For Valid user login
	  	ValidLogin.validLogin(webDriver);
	  	
		updateprofile(webDriver);
		
		webDriver.close();
		System.exit(0);
	}
	public static void updateprofile(WebDriver driver) throws InterruptedException, AWTException
	{
		//Click on the edit profile link
		driver.findElement(By.cssSelector("a[href*='/profile/edit/']")).click();
		Thread.sleep(10000);
		
		//Update name
		driver.findElement(By.id("field_1")).clear();
		driver.findElement(By.id("field_1")).sendKeys("TestDemo");
		driver.findElement(By.id("profile-group-edit-submit")).click();
		//wait until profile is updated
		new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		System.out.println("Profile updated successfully");
	}
}
