package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {
	public static WebDriver driver;
	public static String path;
	public static Select select;
	public static JavascriptExecutor javaScript;
	public static Logger Log;

	public String Get_Environment_Property(String key) throws IOException {
		Log = Logger.getLogger(this.getClass());
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(new File(".//src//main/resources//Environment.properties"));
		prop.load(fin);
		String value = prop.getProperty(key);
		return value;
	}

	// To launch url of application
	public void launch(String url) throws IOException {
		driver.get(url);
	}

	/*
	 * public void insertText(WebElement element, String value) {
	 * element.sendKeys(value); }
	 * 
	 * public void clickOn(WebElement element) { element.click(); }
	 */

	// To Select a value from Drop Down by using SelectByVisibleTest Method
	public void selectValueFromDropDownByText(WebElement element, String value) {
		select = new Select(element);
		select.selectByVisibleText(value);
	}

	// To Select a value from Drop Down by using SelectByIndex Method.
	public void selectValueFromDropDownByIndex(WebElement element, int value) {
		select = new Select(element);
		select.selectByIndex(value);
	}

	// To create AlphaNumeric random String
	/*
	 * public String randomAlphaNumeric() { String generatedAlphaNumeric =
	 * RandomStringUtils.randomAlphanumeric(7); return generatedAlphaNumeric; }
	 */

	public static String randomNumber() {
		String generatedRandomNumber = RandomStringUtils.randomNumeric(5);
		return "Aut-Test-" + generatedRandomNumber;
	}

	// Explicit Wait to Click on any WebElement.
	public void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	// To Click on any WebElement by using JavaScript Executor.
	public void clickElementByJavaScript( WebDriver driver, WebElement element) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("arguments[0].click();", element);
	}

	// Explicit Wait to Send Data to any WebElement.
	public void insertText(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	// Explicit Wait to check WebElement visible.
	public void visibilityOfElement(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}
	// Explicit Wait to check WebElement visible.
	public WebElement visibilityOfElementSelect(WebDriver driver, WebElement element, int timeout) {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
			return element;
		}

	// Explicit Wait for Element To Be Visible.
	public void waitForElementToBeVisible(WebDriver driver, By locator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// To Match Value with List of Elements and Click on it.
	/*
	 * public String clickOnMatchingValue(List<WebElement> listOfElements, String
	 * valueToBeMatched) { String actId=""; for (WebElement element :
	 * listOfElements) { if (element.getText().equalsIgnoreCase(valueToBeMatched)) {
	 * actId= element.getText();
	 * 
	 * } } return actId; }
	 */

	// To Change the Color of WebElement by using JavaScript Executor.
	public void changeColorByJavaScript(String color, WebElement element, WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
	}

	// To Highlight WebElement by using JavaScript Executor.
	public void highlightElementByJavaScript(WebDriver driver, WebElement element) {
		javaScript = ((JavascriptExecutor) driver);
		String backgroundColor = element.getCssValue("backgroundColor");
		for (int i = 1; i < 2; i++) {
			changeColorByJavaScript("rgb(0, 200, 0)", element, driver);
			changeColorByJavaScript(backgroundColor, element, driver);
		}
	}

	// To Check Element is Displayed or No.
	public boolean isElementDisplayed(WebElement element) {
		boolean elementDisplayed = element.isDisplayed();
		if (elementDisplayed) {
			Log.info("Element is Displayed");
			return true;
		} else {
			Log.info("Element is not Displayed");
			return false;
		}
	}

	// Set Date For Log4J.
	public void setDateForLog4j() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyy_hhmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}
}
