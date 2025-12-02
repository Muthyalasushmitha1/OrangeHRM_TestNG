package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;

public class PIMPage extends BaseClass {
	
	// .........locators.........
	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement addemployee;
	
	@FindBy(xpath = "//h6[text()='Add Employee']")
    private WebElement addEmployeeHeader;
	

	// .....constructor......
	public PIMPage(WebDriver driver) { 
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// ...action methods......
	public void clickAddEmployee() {
		waitForClickable(addemployee);
		click(addemployee);
		System.out.println("AddEmployee page is displayed....");
	}
	public boolean isAddEmployeDisplayed() {
		waitForVisibility(addEmployeeHeader);
		return addEmployeeHeader.isDisplayed();
	}
	

}
