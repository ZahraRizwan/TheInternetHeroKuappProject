package com.automation.tests;

import org.testng.annotations.Test;

import com.Zahra.Library.BasePage;
import com.automation.pages.TheInternetHerokuappPages;

public class theInternetHerokuappTests extends BasePage {

	// Test case 1 using valid user-name and valid password
	@Test(priority = 1, enabled = true)
	public void formAuthentication() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication();

	}

	// Test case 2 using invalid user-name and invalid password
	@Test(priority = 2, enabled = true)
	public void formAuthentication2() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication2();
	}

	// Test Case 3 using valid user-name and invalid password
	@Test(priority = 3, enabled = true)
	public void formAuthentication3() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication3();
	}

	// Test Case 4 using invalid user-name and valid password
	@Test(priority = 4, enabled = true)
	public void formAuthentication4() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication4();
	}

	// Test case 5 using special characters in user-name
	@Test(priority = 5, enabled = true)
	public void formAuthentication5() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication5();
	}

	// Test case 6 using numeric values in user-name and password
	@Test(priority = 6, enabled = true)
	public void formAuthentication6() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication6();
	}

	// Test Case 7 using numeric values in password and valid user-name

	@Test(priority = 7, enabled = true)
	public void formAuthentication7() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication7();
	}

	// Test Case 8 placing Blank values in password and user-name
	@Test(priority = 8, enabled = true)
	public void formAuthentication8() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication8();
	}

	// Test Case 9 placing Blank values in password and valid user-name
	@Test(priority = 9, enabled = true)
	public void formAuthentication9() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication9();
	}

	// Test Case 10 placing Blank values in user-name and valid password
	@Test(priority = 10, enabled = true)
	public void formAuthentication10() throws Exception {

		TheInternetHerokuappPages theInternetHerokuappPages = new TheInternetHerokuappPages();
		theInternetHerokuappPages.formAuthentication10();
	}

}