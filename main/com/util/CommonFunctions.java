package com.util;

import java.io.File;
import java.io.IOException;
import java.time.Clock;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Base.TestBase;

public class CommonFunctions extends TestBase{
	
	Logger log = Logger.getLogger(this.getClass().getName());
	
	public void javaScriptclick(WebElement we) {
		
		try {
			we.isDisplayed();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", we);
			log.info("Clicked on element "+we+" successfully");
			getScreenshot();
		}
		catch (ElementNotVisibleException e) {
			log.info("Click on element "+we+" failed");
			Assert.fail();
		}		
	}
	
	public void selectByVisiblTextfromDropdown(WebElement we, String value) {
		try {
			we.isDisplayed();
			Select sel = new Select(we);
			sel.selectByVisibleText(value);
			Assert.assertTrue("Selected "+value+" successfully", true);
			getScreenshot();
		}
		catch (ElementNotVisibleException e) {
			log.info("Element is not seleced from slect dropdown "+ we);
			Assert.fail();
		}	
	}
	
	public void enterData(WebElement we, String value) {
		try {
			we.isDisplayed();
			we.sendKeys(value);
			getScreenshot();
		}
		catch (ElementNotVisibleException e) {
			log.info("Not able to enter details for field "+ we);
			Assert.fail();
		}	
	}
	
	public void javaScriptEnterData(WebElement we, String value) {
		try {
			we.click();
			we.clear();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='"+value+"'",we);
		}
		catch (ElementNotVisibleException e) {
			Assert.assertFalse("Not able to enter details for field "+ we , false);
		}	
	}
	
	public void getScreenshot() {
		File sht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\screenshots\\"+Clock.systemUTC().instant().toString().replaceAll("[^\\d]","")+".png");
		try {
			FileUtils.copyFile(sht, dest);
		} catch (IOException e) {
			Assert.assertFalse("Cannot capture screenshot ", false);
		}			
	}
	
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			Assert.assertTrue("Accepted alert successfully", true);
		}
		catch (NoAlertPresentException e) {
			Assert.assertFalse("Alert pop up is not displayed" , false);
		}	
	}

}
