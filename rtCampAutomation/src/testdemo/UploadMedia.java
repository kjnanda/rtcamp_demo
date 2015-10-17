package testdemo;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class UploadMedia {

	@Test
	public static void verifyUploadMedia() throws InterruptedException,
	AWTException {

		WebDriver webDriver = new FirefoxDriver();
		LaunchFirefox.launchBrowser(webDriver);

		// For Valid user login
		ValidLogin.validLogin(webDriver);

		// Identify path to upload media
		findPath(webDriver);

	}

	public static void findPath(WebDriver webDriver)
			throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		String strPath = "/Users/javalnanda/Desktop/download.jpeg";

		// Redirect to media page
		webDriver.get("http://demo.rtcamp.com/rtmedia/members/demo/media/");
		new WebDriverWait(webDriver, 60).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("rtm_show_upload_ui")));

		// Click upload
		webDriver.findElement(By.id("rtm_show_upload_ui")).click();
		new WebDriverWait(webDriver, 60).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("drag-drop-area")));

		// Select album
		Select selecAlbum = new Select(webDriver.findElement(By
				.className("rtmedia-user-album-list")));
		selecAlbum.selectByVisibleText("Wall Posts");
		Thread.sleep(2000);

		// Set privacy
		Select selectPrivacy = new Select(webDriver.findElement(By
				.id("rtSelectPrivacy")));
		selectPrivacy.selectByVisibleText("Private");
		Thread.sleep(2000);

		// Click on select your files button
		webDriver.findElement(By.id("rtMedia-upload-button")).click();
		Thread.sleep(8000);

		//Call uploadmedia utility method
		UploadMediaUtility.uploadMedia(strPath, webDriver);

		webDriver.findElement(By.className("start-media-upload")).click();
		Thread.sleep(3000);

		PrivacySettingPostUpdate.logout(webDriver);

		webDriver.close();
		System.exit(0);

	}
}
