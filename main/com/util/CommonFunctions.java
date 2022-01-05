package com.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class CommonFunctions extends TestBase{
	
	public void javaScriptclick(WebElement we) {
		
		try {
			we.isDisplayed();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", we);
			Assert.assertTrue("Clicked on element "+we+" successfully", true);
		}
		catch (ElementNotVisibleException e) {
			System.out.print("Element is not displayed "+ we );
		}		
	}
	
	public void selectByVisiblTextfromDropdown(WebElement we, String value) {
		try {
			we.isDisplayed();
			Select sel = new Select(we);
			sel.selectByVisibleText(value);
			Assert.assertTrue("Selected "+value+" successfully", true);
		}
		catch (ElementNotVisibleException e) {
			Assert.assertFalse("Element is not seleced from slect dropdown "+ we , false);
		}	
	}
	
	public void enterData(WebElement we, String value) {
		try {
			we.isDisplayed();
			we.sendKeys(value);
		}
		catch (ElementNotVisibleException e) {
			Assert.assertFalse("Not able to enter details for field "+ we , false);
		}	
	}
	
	public void getScreenshot() {
		File sht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
			
	}

}
