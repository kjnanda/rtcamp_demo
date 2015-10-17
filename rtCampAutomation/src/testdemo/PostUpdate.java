package testdemo;

import java.awt.AWTException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PostUpdate {
	static WebDriver webDriver;

	@Test
	public static void verifyPostUpdate() throws InterruptedException,
	AWTException {

		WebDriver webDriver = new FirefoxDriver();

		// Launch Firefox
		LaunchFirefox.launchBrowser(webDriver);

		// For Valid user login
		ValidLogin.validLogin(webDriver);

		// To Upload media file.
		defaultUpdatePublic(webDriver);

	}

	public static void defaultUpdatePublic(WebDriver webDriver)
			throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		WebElement addMediaButton;

		addMediaButton = webDriver.findElement(By
				.id("rtmedia-add-media-button-post-update"));
		addMediaButton.click();

		Thread.sleep(8000);

		uploadFile("/Users/javalnanda/Desktop/download.jpeg", webDriver);

		Thread.sleep(3000);

		webDriver.close();

		System.exit(0);

	}

	public static void uploadFile(String stringPath, WebDriver webDriver2)
			throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		//Call upload media utility method
		UploadMediaUtility.uploadMedia(stringPath, webDriver2);

		// Update text with media file
		webDriver2.findElement(By.id("whats-new")).sendKeys("media testing");
		webDriver2.findElement(By.id("aw-whats-new-submit")).click();

		// wait for page to load
		Thread.sleep(3000);

	}

}
