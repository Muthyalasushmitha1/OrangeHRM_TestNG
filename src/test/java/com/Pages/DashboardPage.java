package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;

public class DashboardPage extends BaseClass {
	

	@FindBy(xpath = "//h6[text()='Dashboard']")
	private WebElement dashBoardHeader;
	
	@FindBy(xpath = " //span[text()='PIM']")
	private WebElement PIMmanu;
	
	
	@FindBy(xpath = " //span[text()='Admin']")
	private WebElement Adminmanu;
	
	@FindBy(xpath = "//h6[text()='PIM']")
	private WebElement PIMHeader;
	
	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pim;



	// ...... Constructor ..........
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//.............Actions methods............
	
	public boolean isDashBoardDisplayed() {
		waitForVisibility(dashBoardHeader);
		return dashBoardHeader.isDisplayed();
		
	}
	public boolean isPIMMenuDisplayed() {
        waitForVisibility(PIMmanu);
        return PIMmanu.isDisplayed();
    }

    public boolean isAdminMenuDisplayed() {
        waitForVisibility(Adminmanu);
        return Adminmanu.isDisplayed();
    }
	public void goToPIMPage() {
		waitForClickable(pim);
		click(pim);
		System.out.println("Navigate to PIMPage....");
	}
	public boolean isPIMPageDisplayed() {
		waitForVisibility(PIMHeader);
		return PIMHeader.isDisplayed();
	}

}
