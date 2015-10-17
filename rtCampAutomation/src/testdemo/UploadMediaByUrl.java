package testdemo;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UploadMediaByUrl {
  @Test
  public static void verifyMediaUploadUrl() throws InterruptedException, AWTException {
	  
	  	WebDriver webDriver = new FirefoxDriver();
	  	LaunchFirefox.launchBrowser(webDriver);
	  
		//For Valid user login
	  	ValidLogin.validLogin(webDriver);
	  	
		//Identify path to upload media
		checkForPath(webDriver);
	  
  }

  public static void checkForPath(WebDriver webDriver) throws InterruptedException {
		// TODO Auto-generated method stub
	  
	  //Click on user name link
	  webDriver.findElement(By.cssSelector("a[href*='/members/demo/']")).click();
	  
	  // Click on activity
	  webDriver.findElement(By.id("user-activity")).click();
	  Thread.sleep(3000);
	  
	  //Click on media button
	  webDriver.findElement(By.id("user-media")).click();
	  new WebDriverWait(webDriver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("rtm_show_upload_ui")));
	  
	  //Click on upload button
	  webDriver.findElement(By.id("rtm_show_upload_ui")).click();
	  new WebDriverWait(webDriver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("drag-drop-area")));
	  
	  //Select album
	  Select selecAlbum = new Select(webDriver.findElement(By.className("rtmedia-user-album-list")));
	  selecAlbum.selectByVisibleText("Wall Posts");
	  Thread.sleep(2000);
	  
	  // Set privacy settings
	  Select selectPrivacy = new Select(webDriver.findElement(By.id("rtSelectPrivacy")));
	  selectPrivacy.selectByVisibleText("Private");
	  Thread.sleep(2000);
	  
	  //Switch to Url Import tab
	  webDriver.findElement(By.cssSelector("[class^='rtm-url-import-tab']")).click();
	  Thread.sleep(2000);
	  
	  //Enter image url
	  webDriver.findElement(By.id("rtmedia_url_upload_input")).sendKeys("http://cdn.softwaretestinghelp.com/wp-content/qa/uploads/2014/10/Selenium-IDE-4.jpg");
	  Thread.sleep(2000);
	  
	  // Click start upload button
	  webDriver.findElement(By.className("start-media-upload")).click();
	  
	  //Wait for upload
	  Thread.sleep(3000);
	  
	  PrivacySettingPostUpdate.logout(webDriver);
	  
	  webDriver.close();
	  System.exit(0);
  }
}
