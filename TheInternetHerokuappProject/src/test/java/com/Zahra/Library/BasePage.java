package com.Zahra.Library;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasePage {
	final static Logger logger = Logger.getLogger(BasePage.class);

	public static WebDriver driver;
	public static CustomLibrary library;
	private JavaPropertiesManager configProperty;
	private static String browser;

	@BeforeTest

	public void setup() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();// open Chrome browser
			library = new CustomLibrary(driver);// move this to before class
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			logger.error("Error- ", e);
			assertTrue(false);
		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(10 * 1000);
		driver.close();
		driver.quit();
	}

	@Test
	public void herokuappTest() throws Exception {

		driver.get("http://the-internet.herokuapp.com");
		String title = driver.getTitle();
		System.out.print("Title=" + title);
		String expectedTitle = "The Internet";
		assertEquals(title, expectedTitle);

	}

	/*
	 * @AfterTest public void afterEachTestComplete(ITestResult result) { try { if
	 * (ITestResult.FAILURE == result.getStatus()) {
	 * library.captureScreenshot(result.getName(),
	 * ".src/test/resources/screenshots/"); } Thread.sleep(5 * 1000); // stops the
	 * test for 5 seconds } catch (Exception e) { e.printStackTrace(); } finally {
	 * driver.close(); // close the browser driver.quit(); // kill the driver
	 * process } }
	 * 
	 * //@AfterClass // public void afterAllTestsComplete() { // if (driver != null)
	 * // if there is any open browser left, close it. { //driver.close(); //
	 * driver.quit(); }
	 * 
	 * 
	 * /* @BeforeTest public void beforeAllTestStart() {
	 * 
	 * configProperty = new
	 * JavaPropertiesManager(".src/test/resources/config.properties"); browser =
	 * configProperty.readProperty("browserType"); library = new
	 * CustomLibrary(driver);
	 * if(configProperty.readProperty("demoMode").contains("true")){
	 * library.isDemoMode = true;
	 * System.out.println("Test is running Demo mode = ON ..."); }else {
	 * System.out.println("Test is running Demo mode = OFF ..."); }
	 */

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public CustomLibrary getMyLib() {
		return library;
	}

	public void setMyLib(CustomLibrary myLib) {
		this.library = myLib;
	}

	public JavaPropertiesManager getConfigProperty() {
		return configProperty;
	}

	public void setConfigProperty(JavaPropertiesManager configProperty) {
		this.configProperty = configProperty;
	}
}
