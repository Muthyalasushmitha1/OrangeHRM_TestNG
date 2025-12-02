package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.LoginPage;
import com.Pages.PIMPage;

public class PIMPageTest extends BaseClass {
	public LoginPage login;
	public PIMPage pimpage;


	@BeforeMethod
	public void setUp() {
		initializeDriver();
		navigateToApplication();
		login = new LoginPage(driver);
		pimpage = new PIMPage(driver);

		login.loginToApp(prop.getProperty("username"), prop.getProperty("password"));

		// Navigate dynamically
		navigateTo("dashboard");
		navigateTo("pim");
		System.out.println("Navigated to Dashboard and PIM pages successfully.");

	}

	@Test
	public void verifyAddEmployee() {
		navigateTo("addemployee");
		Assert.assertTrue(pimpage.isAddEmployeDisplayed(), "AddEmployeDisplayed should be visible");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
