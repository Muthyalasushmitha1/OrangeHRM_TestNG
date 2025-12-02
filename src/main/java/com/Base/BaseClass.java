package com.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	protected static WebDriverWait wait;

	// .................. Load Configuration ....................
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					"C:\\Users\\Vinod\\New_workspace\\OrangeHRM\\src\\main\\java\\com\\config\\config.properties");
			prop.load(file);
		} catch (IOException e) {
			System.out.println("Failed to load config.properties: " + e.getMessage());
		}
	}

	// .............. Initialize Browser ...................
	public void initializeDriver() {
		loadConfig();
		String browser = prop.getProperty("browser", "chrome").toLowerCase();

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}

	// ........... Navigate to URL .................
	public void navigateToApplication() {
		String url = prop.getProperty("url");
		driver.get(url);
		System.out.println("Navigated to: " + url);
	}

	// ................ Explicit Wait Utility Methods ..................
	public void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void click(WebElement element) {
		waitForClickable(element);
		element.click();
	}

	public void writeText(WebElement element, String text) {
		waitForVisibility(element);
		element.clear();
		element.sendKeys(text);
	}
	public void h6Header(WebElement element) {
		waitForVisibility(element);
		element.getText();
	}
	// ........... Common Dynamic Click Method ..................
	public void clickElement(By locator) {
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
	    element.click();
	}

	// .............. Dynamic Navigation Helper .............
	public void navigateTo(String pageName) {
	    pageName = pageName.toLowerCase();

	    By locator = null;

	    switch (pageName) {
	        case "login":
	            locator = By.xpath("//button[@type='submit']");
	            break;
	        case "dashboard":
	            locator = By.xpath("//h6[text()='Dashboard']");
	            break;
	        case "pim":
	            locator = By.xpath("//span[text()='PIM']");
	            break;
	        case "addemployee":
	            locator = By.xpath("//a[text()='Add Employee']");
	            break;
	        default:
	            throw new IllegalArgumentException(" Unknown page name: " + pageName);
	    }

	    clickElement(locator);
	    System.out.println(" Navigated to: " + pageName + " page");
	}

}
