package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.AddEmployePage;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;

public class AddEmployeePageTest extends BaseClass {
	public LoginPage login;
	public AddEmployePage addemployepage;

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		navigateToApplication();

		login = new LoginPage(driver);
		addemployepage = new AddEmployePage(driver);

		login.loginToApp(prop.getProperty("username"), prop.getProperty("password"));

		// navigate to pages
		navigateTo("pim");
		navigateTo("addemployee");

	}

	@Test(priority = 1)
	public void verifyEmployeeDetailsSaved() {
		Assert.assertTrue(addemployepage.isaddEmployeeDisplayed(), "AddEmployePage should be displayed");
	}

	@Test(priority = 2)
	public void addEmployeTest() {
		addemployepage.addEmployee("ramisetti", "muthyala", "balu", 1432);
		Assert.assertTrue(addemployepage.isEmployeeAddedSuccessfully(), "Employee should be added successfully");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
