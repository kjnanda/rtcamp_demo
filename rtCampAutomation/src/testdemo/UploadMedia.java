package testdemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

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

		webDriver.findElement(By.className("start-media-upload")).click();
		Thread.sleep(3000);

		PrivacySettingPostUpdate.logout(webDriver);

		webDriver.close();
		System.exit(0);

	}
}
