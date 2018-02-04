package com.automation.pages;

import static org.testng.Assert.assertEquals;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Zahra.Library.BasePage;

public class TheInternetHerokuappPages extends BasePage {

	//final static Logger logger = Logger.getLogger(BasePage.class);

	// Test case 1 with valid user name and password
	public TheInternetHerokuappPages formAuthentication() throws Exception {

		library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) > a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "tomsmith");
		library.clickAndSendKeys(By.id("password"), "SuperSecretPassword!");
		library.clickOnButton(By.cssSelector("#login > button"));
		library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

	// Test case 2 using invalid User name and Password
	public TheInternetHerokuappPages formAuthentication2() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
	
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "tomhanks");
		library.clickAndSendKeys(By.id("password"), "SuperSecretPass!");
		library.clickOnButton(By.cssSelector("#login > button"));
		//String  message = library.findElement(By.id("flash")).getText();
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
		//library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

	
	// Test case 3 using valid user name and invalid password
	public TheInternetHerokuappPages formAuthentication3() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
		// a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "tomsmith");
		library.clickAndSendKeys(By.id("password"), "SuperSecretPass!");
		library.clickOnButton(By.cssSelector("#login > button"));
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
		//library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

	// TestCase 4 using invalid user-name and valid password
	public TheInternetHerokuappPages formAuthentication4() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
		// a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "tomhanks");
		library.clickAndSendKeys(By.id("password"), "SuperSecretPassword!");
		library.clickOnButton(By.cssSelector("#login > button"));
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
		//library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

	// Test Case 5 using special characters in user-name
	public TheInternetHerokuappPages formAuthentication5() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
		// a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "@tomhanks");
		library.clickAndSendKeys(By.id("password"), "SuperSecretPassword!");
		library.clickOnButton(By.cssSelector("#login > button"));
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
	//	library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;

	}

	// Test Case 6 using numeric values in user-name and password
	public TheInternetHerokuappPages formAuthentication6() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
		// a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "tomsmith1");
		library.clickAndSendKeys(By.id("password"), "SuperSecretPassword007!");
		library.clickOnButton(By.cssSelector("#login > button"));
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
	//	library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

	// Test Case 7 using numeric values in password and valid user-name
	public TheInternetHerokuappPages formAuthentication7() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
		// a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "tomsmith");
		library.clickAndSendKeys(By.id("password"), "007");
		library.clickOnButton(By.cssSelector("#login > button"));
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
	//	library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

	// Test Case 8 placing Blank values in password and user-name
	public TheInternetHerokuappPages formAuthentication8() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
		// a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "");
		library.clickAndSendKeys(By.id("password"), "");
		library.clickOnButton(By.cssSelector("#login > button"));
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
	//	library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

	// Test Case 9 placing Blank values in password and valid user-name
	public TheInternetHerokuappPages formAuthentication9() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
		// a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "tomsmith");
		library.clickAndSendKeys(By.id("password"), "");
		library.clickOnButton(By.cssSelector("#login > button"));
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
	//	library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

	// Test Case 10 placing Blank values in user-name and valid password
	public TheInternetHerokuappPages formAuthentication10() throws Exception {
		// library.clickOnButton(By.cssSelector("#content > ul > li:nth-child(18) >
		// a"));
		library.fluentWait(By.cssSelector("#login > button > i"));
		library.clickAndSendKeys(By.id("username"), "");
		library.clickAndSendKeys(By.id("password"), "SuperSecretPassword!");
		library.clickOnButton(By.cssSelector("#login > button"));
		WebElement errorMessage= driver.findElement(By.id("flash"));
		String tempText = errorMessage.getText();
		Assert.assertEquals(errorMessage.getText(), tempText);
	//	library.clickOnButton(By.cssSelector("#content > div > a"));
		return this;
	}

}
