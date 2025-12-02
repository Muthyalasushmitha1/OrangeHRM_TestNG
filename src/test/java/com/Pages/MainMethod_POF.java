package com.Pages;

import com.Base.BaseClass;

public class MainMethod_POF extends BaseClass {

	public static void main(String[] args) {
		BaseClass base = new BaseClass();
		base.initializeDriver();
		base.navigateToApplication();

		// Create Login Page object
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp("Admin", "admin123");
		
		// Create DashboardPage object
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.goToPIMPage();
		
		// Create PIMPage object
		PIMPage pim=new PIMPage(driver);
		pim.clickAddEmployee();
		
		// Create PIMPage object
		AddEmployePage addemploye=new AddEmployePage(driver);
		addemploye.addEmployee("muthyala ","Ramisetti ","Sushmitha",1816);
	}

}
