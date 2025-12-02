package com.Test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.DashboardPage;
import com.Pages.LoginPage;
 

public class LoginPageTest extends BaseClass {
	private LoginPage loginpage;
	private DashboardPage dashboard;

	
	@BeforeMethod
	public void setUp() {
		
        // initialize driver and load config
		initializeDriver();
		navigateToApplication();
		
		 // initialize page objects
		loginpage = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		
		
	}
	
  @Test
  public void testLoginDashboard() {
	  
      // read credentials from config.properties
	 String uname= prop.getProperty("username");
	 String password= prop.getProperty("password");
	 
     // Step: perform login
	 loginpage.loginToApp(uname, password);

	// Assertion: verify Dashboard visible
	 boolean showdashboard=dashboard.isDashBoardDisplayed();
	 Assert.assertTrue(showdashboard, "Dashboard ");
  }
  
  @AfterMethod
	public void tearDown() {
	  driver.quit();	  //to close all tabs 
//	  driver.close();    //to close current tab
		
		
	}
}
