package testdemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.io.File;

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

		// Steps to upload file for MAC OS

		File file = new File(stringPath);
		StringSelection stringSelection = new StringSelection(
				file.getAbsolutePath());

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard()
		.setContents(stringSelection, null);

		Robot robot = new Robot();

		// Cmd + Tab is needed since it launches a Java app and the browser
		// looses focus
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);

		// Open Goto window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);

		// Paste the clipboard value
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);

		// Press Enter key to close the Goto window and Upload window

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Wait for file to upload
		robot.delay(3000);

		// Update text with media file
		webDriver2.findElement(By.id("whats-new")).sendKeys("media testing");
		webDriver2.findElement(By.id("aw-whats-new-submit")).click();

		// wait for page to load
		Thread.sleep(3000);

	}

}
