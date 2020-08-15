package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
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

	public String Get_Environment_Property(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(new File(".//TestData//Environment.properties"));
		prop.load(fin);
		String value = prop.getProperty(key);
		return value;
	}

	public void launch(String url) throws IOException {
		driver.get(url);
	}

	public void insertText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void clickOn(WebElement element) {
		element.click();
	}

	public void verifyFile(String path) {
		driver.get(path);
	}

	public void selectValueFromDropDownByText(WebElement element, String value) {
		select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void selectValueFromDropDownByIndex(WebElement element, int value) {
		select = new Select(element);
		select.selectByIndex(value);
	}

	public String randomAlphaNumeric() {
		String generatedAlphaNumeric = RandomStringUtils.randomAlphanumeric(7);
		return generatedAlphaNumeric;
	}
	
	//5.
	//Explicit Wait to Click on any WebElement.
	public static void clickOn(WebDriver driver, WebElement element, int timeout) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	//6.
	//Explicit Wait to Send Data to any WebElement.
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	//7.
	//Explicit Wait for Element To Be Visible.
	public static void waitForElementToBeVisible(WebDriver driver, By locator, int timeout)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//17.
		//To Match Value with List of Elements and Click on it.
		public void clickOnMatchingValue(List<WebElement> listOfElements, String valueToBeMatched) 
		{
			for(WebElement element : listOfElements) 
			{
				if(element.getText().equalsIgnoreCase(valueToBeMatched)) 
				{
					element.click();
					return;
				}
			}
		}
		
		//To Change the Color of WebElement by using JavaScript Executor.
		public static void changeColorByJavaScript(String color, WebElement element, WebDriver driver) 
		{
			javaScript = ((JavascriptExecutor) driver);
			javaScript.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
			try 
			{
				Thread.sleep(2000);
			} 
			catch(InterruptedException e) 
			{

			}
		}

		
		//To Highlight WebElement by using JavaScript Executor.
		public static void highlightElementByJavaScript(WebElement element, WebDriver driver) 
		{
			javaScript = ((JavascriptExecutor) driver);
			String backgroundColor = element.getCssValue("backgroundColor");
			for(int i = 0; i < 10; i++) 
			{
				changeColorByJavaScript("rgb(0, 200, 0)", element, driver);
				changeColorByJavaScript(backgroundColor, element, driver);
			}
		}
}
