package com.Zahra.Library;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
//import com.automation.pages.ParkingCalculaterPage;
import com.google.common.base.Function;
import com.google.common.io.Files;

/***
 * 
 * @author Zahra
 *
 */
public class CustomLibrary {
	final static Logger logger = Logger.getLogger(CustomLibrary.class);
	private WebDriver driver;
	public boolean isDemoMode = false;

	/***
	 * * This is the constructor method
	 */
	public CustomLibrary(WebDriver _driver) {
		driver = _driver;
	}

	/***
	 * This method starts ChromeBrowser
	 */
	// startChromeBrowser()
	public WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();// open Chrome browser
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		} catch (Exception e) {
			logger.error("Error- ", e);
			assertTrue(false);
		}
		return driver;
	}

	// click on a button
	public WebElement clickOnButton(By by) throws Exception {
		WebElement element = driver.findElement(by);
		element.click();
		Thread.sleep(5 * 1000);
		return element;

	}

	// Switch to iframe
	public int switchToIframe(By by) {

		int size = driver.findElements(by).size();
		System.out.println("Number of iframes in webpage: " + size);
		driver.switchTo().frame(0);
		return size;
	}

	// send keys
	public void sendKeys(By by, String userInput) throws Exception {
		WebElement element = driver.findElement(by);
		element.sendKeys(userInput);
		Thread.sleep(2000);
	}

	// click element and send keys
	public void clickAndSendKeys(By by, String userInput) throws Exception {
		WebElement element = driver.findElement(by);
		element.click();
		element.sendKeys(userInput);
		Thread.sleep(2000);
	}

	// Drag and Drop the Draggable Element

	public void DragAndDrop(By by) throws Exception {
		try {
			WebElement from = driver.findElement(by);
			Actions builder = new Actions(driver);
			Action dragAndDrop = builder.dragAndDropBy(from, 100, 100).release().build();
			dragAndDrop.perform();
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			logger.error("Error- " + "dropable not performed.", e);
			assertTrue(false);
		}
		// System.out.println("drag and drop performed.");

	}

	// switch to default from iframe
	public void SwitchToDefault() {
		driver.switchTo().defaultContent();
	}

	// drag and drop theDropable Element
	public void DragAndDrop(By from, By to) throws Exception {
		try {
			WebElement source = driver.findElement(from);
			WebElement myTarget = driver.findElement(to);
			Actions builder = new Actions(driver);
			Action dragAndDrop1 = builder.dragAndDrop(source, myTarget).release().build();
			dragAndDrop1.perform();
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			logger.error("Error- " + "dropable not performed.", e);
			assertTrue(false);
		}
		// Thread.sleep(5 * 1000);
		// System.out.println("dropable performed.");
	}

	// Resizable Element (click & hold and drag & drop)
	public void Resizable(By by) throws Exception {
		try {
			WebElement resizeElem = driver.findElement(by);
			Actions builder = new Actions(driver);
			Action resizeButton = builder.clickAndHold(resizeElem).dragAndDropBy(resizeElem, 100, 100).release()
					.build();
			resizeButton.perform();
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			logger.error("Error- " + "drag and drop not performed.", e);
			assertTrue(false);
		}
		// System.out.println("drag and drop performed.");
	}

	public void moveMouseToElement(WebElement toElement) {
		try {
			WebElement element = driver.findElement(By.cssSelector("#Lot > option:nth-child(2)"));
			Actions action = new Actions(driver);
			action.moveToElement(toElement).click().build().perform();
		} catch (Exception e) {
			logger.error("Error- " + " Not selecting 'economy'", e);
			assertTrue(false);
		}
		// System.out.println("selecting 'economy'");
	}

	public void clickInvisibleWebElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			logger.error("Error- ", e);
			assertTrue(false);
		}
	}

	//
	public WebElement dynamicWait_presenceOfElementLocated(By by) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(by));
		return myDynamicElement;
	}

	// wait until Element is vissiable
	public void WaitUntilVisiable(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1000);
			WebElement fiveStarElem = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			logger.error("Error- ", e);
			assertTrue(false);
		}
	}

	// Locate a list
	public void loop(By by) {

		WebElement elem = driver.findElement(by);
		for (int i = 0; i < 2; i++) {
			elem.click();
		}
	}

	//
	public void selectDropDown(By by, String userOptionValue) throws Exception {
		try {
			Select dropdown = new Select(driver.findElement(by));
			dropdown.selectByVisibleText(userOptionValue);
		} catch (Exception e) {
			logger.error("Error- " + " not Selecting '" + userOptionValue + "'", e);
			assertTrue(false);
		}
		// System.out.println("Selecting '" + userOptionValue + "'");

	}

	// clear textBox and entering text

	public void clearTextBox(By by, String userInputValue) throws Exception {
		try {
			WebElement elem = driver.findElement(by);
			elem.clear();
			Thread.sleep(1000);
			elem.sendKeys(userInputValue);
			Thread.sleep(3000);
		} catch (Exception e) {
			logger.error("Error- " + "userInPut", e);
			assertTrue(false);
		}
		// System.out.println("clearing text");
		// Thread.sleep(3000);
	}

	public void SwitchToAlert() {
		Alert alert = driver.switchTo().alert();
	}

	public void getList(By by) {
		int size = driver.findElements(by).size();
		System.out.println("number of options : " + size);
	}

	public void switchtoWindowHandle(By by) throws Exception {
		try {
			driver.findElement(by).click();
			// wait till two windows are not opened
			waitForNumberofWindowsToEqual(2);// this method is for wait
			Set handles = driver.getWindowHandles();
			String firstWinHandle = driver.getWindowHandle();
			handles.remove(firstWinHandle);
			String winHandle = (String) handles.iterator().next();
			if (winHandle != firstWinHandle)
				;
			// To retrieve the handle of second window, extracting the handle which does not
			// match to first window handle
			String secondWinHandle = winHandle; // Storing handle of second window handle
			// Switch control to new window
			driver.switchTo().window(secondWinHandle);
			driver.manage().window().maximize();
			// driver.switchTo().window(firstWinHandle);
		} catch (Exception e) {
			logger.error("Error- " + "window not opening ", e);
			assertTrue(false);
		}
	}

	public void customWait(double inSeconds) throws Exception {
		Thread.sleep((long) (inSeconds * 1000));
	}

	public WebElement fluentWait(final By by) {
		WebElement targetElem = null;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		targetElem = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
		return targetElem;
	}

	public String captureScreenshot(String screenshotFileName, String filePath) throws IOException {
		String screenCaptureFile = null;
		String tempTime = getCurrentTime();
		File tempFile = new File(filePath);
		if (!tempFile.isDirectory()) {
			tempFile.mkdir(); // create the folder
		}
		if (!filePath.isEmpty()) {
			screenCaptureFile = filePath + screenshotFileName + tempTime + ".png";
		} else {
			screenCaptureFile = "src/test/resources/screenshots/" + screenshotFileName + tempTime + ".png";
		}
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File(screenCaptureFile));
		File absFile = new File(screenCaptureFile);
		String absPath = absFile.getAbsolutePath();
		System.out.println("Screenshot Path: " + absPath);
		return screenCaptureFile;
	}

	public String getCurrentTime() {
		Date date = new Date();
		String tempTime = new Timestamp(date.getTime()).toString();
		String finalTimeStamp = tempTime.replace(":", "_").replace("-", "_").replace(" ", "_").replace(".", "_");
		// System.out.println("TempTime: " + tempTime);
		// System.out.println("FinalTime: " + finalTimeStamp);
		return finalTimeStamp;
	}

	public String getCurrentTimeStamp() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		String dateToStr = format.format(date).replace("-", "").replace(" ", "").replace(":", "");
		System.out.println(dateToStr);

		return dateToStr;
	}

	private void waitForNumberofWindowsToEqual(int i) {
		// TODO Auto-generated method stub

	}

}
