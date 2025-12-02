package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;

public class AddEmployePage extends BaseClass {

	// .......... Locators ...........
	@FindBy(xpath = "//h6[text()='Add Employee']")
	private WebElement addEmployeeHeader;

	@FindBy(xpath = "//input[@name='firstName']")
	private WebElement firstNameField;

	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement middleNameField;

	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement lastNameField;

	@FindBy(xpath = "//label[text()='Employee Id']/following::input[1]")
	private WebElement employeeIdField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//h6[text()='Personal Details']")
    private WebElement personalDetailsHeader;


	// ........ Constructor ............
	public AddEmployePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// .......... Actions .............
	public boolean isaddEmployeeDisplayed() {
		waitForVisibility(addEmployeeHeader);
		return addEmployeeHeader.isDisplayed();
	}

	public void addEmployee(String fName, String mName, String lName, Integer empId) {
		waitForVisibility(firstNameField);
		writeText(firstNameField, fName);
		writeText(middleNameField, mName);
		writeText(lastNameField, lName);
		writeText(employeeIdField, String.valueOf(empId));
		click(saveButton);
		System.out.println("Employee added successfully: " + fName + " " + lName);
	}
	
	public boolean isEmployeeAddedSuccessfully() {
		waitForVisibility(personalDetailsHeader);
		return personalDetailsHeader.isDisplayed();
	}

}
