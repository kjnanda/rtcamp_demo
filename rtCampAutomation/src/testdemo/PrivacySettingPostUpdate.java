package testdemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PrivacySettingPostUpdate {

	@Test
	public static void checkPrivacySettings() throws InterruptedException,
	AWTException {

		WebDriver webDriver = new FirefoxDriver();

		// Launch browser
		LaunchFirefox.launchBrowser(webDriver);

		// For Valid user login
		ValidLogin.validLogin(webDriver);

		verifyPrivacySetting(webDriver);

	}

	public static void verifyPrivacySetting(WebDriver webDriver2)
			throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		String strPath = "/Users/javalnanda/Desktop/download.jpeg";
		webDriver2.findElement(By.id("rtmedia-add-media-button-post-update"))
		.click();
		Thread.sleep(5000);

		// Steps to upload file for MAC OS

		File file = new File(strPath);
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

		// To set Privacy
		webDriver2.findElement(By.id("whats-new")).sendKeys(
				"media testing for private option");
		postToPrivate(webDriver2);
		webDriver2.findElement(By.id("aw-whats-new-submit")).click();
		Thread.sleep(3000);

		// To post in club football album
		/*
		 * webDriver2.findElement(By.id("whats-new")).sendKeys(
		 * "media testing for club football"); postToFootball(webDriver2);
		 * webDriver2.findElement(By.id("aw-whats-new-submit")).click();
		 * Thread.sleep(3000);
		 */

		// To post in demo group album
		/*
		 * webDriver2.findElement(By.id("whats-new")).sendKeys(
		 * "media testing for demo group"); postToDemoGroup(webDriver2);
		 * webDriver2.findElement(By.id("aw-whats-new-submit")).click();
		 * Thread.sleep(3000);
		 */

		// To post in test album
		/*
		 * webDriver2.findElement(By.id("whats-new")).sendKeys(
		 * "media testing for demo group"); postToTest(webDriver2);
		 * webDriver2.findElement(By.id("aw-whats-new-submit")).click();
		 * Thread.sleep(3000);
		 */

		// To check if private post is not displayed on public wall
		logout(webDriver2);

		webDriver2.close();
		System.exit(0);

	}

	public static void postToTest(WebDriver webDriver2)
			throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement whatIsNewInGroupPost = webDriver2.findElement(By
				.id("whats-new-post-in"));
		org.openqa.selenium.support.ui.Select selectPrivacy = new org.openqa.selenium.support.ui.Select(
				whatIsNewInGroupPost);

		selectPrivacy.selectByVisibleText("test");

		// Wait to post
		Thread.sleep(3000);

	}

	public static void postToDemoGroup(WebDriver webDriver2)
			throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement whatIsNewInGroupPost = webDriver2.findElement(By
				.id("whats-new-post-in"));
		org.openqa.selenium.support.ui.Select selectPrivacy = new org.openqa.selenium.support.ui.Select(
				whatIsNewInGroupPost);

		selectPrivacy.selectByVisibleText("Demo Group");

		// Wait to post
		Thread.sleep(3000);

	}

	public static void postToFootball(WebDriver webDriver2)
			throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement whatIsNewInGroupPost = webDriver2.findElement(By
				.id("whats-new-post-in"));
		org.openqa.selenium.support.ui.Select selectPrivacy = new org.openqa.selenium.support.ui.Select(
				whatIsNewInGroupPost);

		selectPrivacy.selectByVisibleText("Club Football");

		// Wait to post
		Thread.sleep(3000);
	}

	public static void logout(WebDriver webDriver2) {
		// TODO Auto-generated method stub
		webDriver2.findElement(By.linkText("Log Out")).click();
		new WebDriverWait(webDriver2, 60).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("bp-login-widget-submit")));

		System.out.println("Post is visible as per proved privacy option.");

	}

	public static void postToPrivate(WebDriver webDriver2)
			throws InterruptedException {
		// TODO Auto-generated method stub
		WebElement privacy = webDriver2.findElement(By.id("rtSelectPrivacy"));
		org.openqa.selenium.support.ui.Select selectPrivacy = new org.openqa.selenium.support.ui.Select(
				privacy);

		selectPrivacy.selectByVisibleText("Private");

		// Wait to post
		Thread.sleep(3000);
	}
}
