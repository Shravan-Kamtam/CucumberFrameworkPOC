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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestBase;

public class CommonFunctions extends TestBase{
	
	Logger log = Logger.getLogger(this.getClass().getName());
	WebDriverWait wait = new WebDriverWait(driver, 30);;
	
	public void explicitWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void javaScriptclick(WebElement we) {
		
		try {
			explicitWait(we);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", we);
			Assert.assertTrue("Clicked on element "+we+" successfully", true);
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
			explicitWait(we);
			Select sel = new Select(we);
			sel.selectByVisibleText(value);
			Assert.assertTrue("Selected "+value+" successfully", true);
			log.info("Element is seleced from slect dropdown "+ we);
			getScreenshot();
		}
		catch (ElementNotVisibleException e) {
			log.info("Element is not seleced from slect dropdown "+ we);
			Assert.fail();
		}	
	}
	
	public void enterData(WebElement we, String value) {
		try {
			explicitWait(we);
			we.sendKeys(value);
			getScreenshot();
			log.info("Entered details successfully for field "+ we);
		}
		catch (ElementNotVisibleException e) {
			log.info("Not able to enter details for field "+ we);
			Assert.fail();
		}	
	}
	
	public void javaScriptEnterData(WebElement we, String value) {
		try {
			explicitWait(we);
			we.clear();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='"+value+"'",we);
			log.info("Entered details successfully for field "+ we);
		}
		catch (ElementNotVisibleException e) {
			log.info("Not able to enter details for field "+ we);
			Assert.assertTrue("Not able to enter details for field "+ we , false);
		}	
	}
	
	public void getScreenshot() {
		File sht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\screenshots\\"+Clock.systemUTC().instant().toString().replaceAll("[^\\d]","")+".png");
		try {
			FileUtils.copyFile(sht, dest);			
		} catch (IOException e) {
			log.info("Capture screenshot  failed ");
			Assert.assertTrue("Cannot capture screenshot ", false);
		}				
	}
	
	public static byte[] getByteScreenshot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] data = FileUtils.readFileToByteArray(src);
		return data;
	}
		
	public void acceptAlert(String msg) {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
//			Assert.assertEquals(driver.switchTo().alert().getText(),msg);
			driver.switchTo().alert().accept();
			log.info("Accepted alert successfully");
			Assert.assertTrue("Accepted alert successfully", true);
		}
		catch (NoAlertPresentException e) {
			log.info("Alert pop up is not displayed");
			Assert.assertTrue("Alert pop up is not displayed" , false);
		}	
	}

}
