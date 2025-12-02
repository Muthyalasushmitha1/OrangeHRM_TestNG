package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Pages.PIMPage;

public class DashBoardPageTest extends BaseClass {

	public LoginPage loginpage;
	public DashboardPage dashboardpage;
	public PIMPage pimpage;

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		navigateToApplication();
		loginpage = new LoginPage(driver);
		dashboardpage = new DashboardPage(driver);
		pimpage = new PIMPage(driver);

		String user = prop.getProperty("username");
		String pass = prop.getProperty("password");
		loginpage.loginToApp(user, pass);
	}

	@Test(priority = 3)
	public void verifyDashBoardDisplayed() {
		Assert.assertTrue(dashboardpage.isDashBoardDisplayed(), "DashBoardPage should be displayed");
		System.out.println("DashBoardPage succesfully displayed");
	}

	@Test(priority = 2)
	public void verifyPIMManuDisplayed() {
		Assert.assertTrue(dashboardpage.isPIMMenuDisplayed(), "PIMManuDisplayed successfully");
		System.out.println("PIMManuDisplayed successfully");
	}

	@Test(priority = 1)
	public void verifyAdminManuDisplayed() {
		Assert.assertTrue(dashboardpage.isAdminMenuDisplayed(), "AdminManuDisplayed successfully");
		System.out.println("AdminManuDisplayed successfully");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
