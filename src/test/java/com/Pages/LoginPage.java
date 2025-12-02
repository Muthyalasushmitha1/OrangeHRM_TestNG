package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseClass;

public class LoginPage extends BaseClass {

	// ...........web element..................
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernamefield;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordfield;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	// ............... Constructor ...................
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApp(String uamne,String pwd) {
		writeText(usernamefield, uamne);
		writeText(passwordfield, pwd);
		click(loginButton);
		System.out.println("Login Successfull..:)");
	}

}
