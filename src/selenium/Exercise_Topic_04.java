package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Exercise_Topic_04 {
  WebDriver driver;
  By emailTextBoxBy = By.xpath("//input[@id='mail']");
  By ageUnder18RadioBy = By.cssSelector("#under_18");
  By educationTextAreaBy = By.id("edu");
  By jobRole1DropdownBy = By.cssSelector("#job1");
  By developmentCheckboxBy = By.cssSelector("#development");
  By slider01By = By.cssSelector("#slider-1");
  
  
  By jobRole02DropDownBy = By.cssSelector("#job2");
  By slider02By = By.cssSelector("#slider-2");
  By passwordTextboxBy = By.cssSelector("#password");
  By ageRadioBy = By.cssSelector("#password");
  By biographyTextAreaBy= By.cssSelector("#bio");
  By interestCheckboxBy = By.cssSelector("#check-disbaled");
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }
	  
	  



  @Test
  public void TC_01_webElementDisplayed() {
	  
	  
	  if(isElementDisplayed(emailTextBoxBy)) {
		  
	     sendKeyToElement(emailTextBoxBy,"Automation Testing");
	     sleepInSecond(2);
	  }
	  
	  
	  
	  
	  if(isElementDisplayed(educationTextAreaBy)) {
		  sendKeyToElement(educationTextAreaBy,"Automation Testing");
		  sleepInSecond(2);
	  }
	  
	  if(isElementDisplayed(ageUnder18RadioBy)) {
		  clickElement(ageUnder18RadioBy);
		  sleepInSecond(2);
	  }
	  
	  
	  
	  
	  
  }
  
  @Test
  public void TC_02_webElementEnabaled() {
	  
	 driver.navigate().refresh();
	 
	 //enable
	 Assert.assertTrue(isElementEnabled(emailTextBoxBy));
	 Assert.assertTrue(isElementEnabled(ageUnder18RadioBy));
	 Assert.assertTrue(isElementEnabled(educationTextAreaBy));
	 Assert.assertTrue(isElementEnabled(jobRole1DropdownBy));
	 Assert.assertTrue(isElementEnabled(developmentCheckboxBy));
	 Assert.assertTrue(isElementEnabled(slider01By));
	 Assert.assertTrue(isElementEnabled(jobRole02DropDownBy));
	 
	 //disabled
	 Assert.assertFalse(isElementEnabled(slider02By));
	 Assert.assertFalse(isElementEnabled(passwordTextboxBy));
	 Assert.assertFalse(isElementEnabled(ageRadioBy));
	 Assert.assertFalse(isElementEnabled(biographyTextAreaBy));
	 Assert.assertFalse(isElementEnabled(interestCheckboxBy));
	 
	 
	 
	 
	  
	  
	  
	  
	  
  }
  @Test
  public void TC_03_webElementSelected() {
	 driver.navigate().refresh();
	 
	 clickElement(ageUnder18RadioBy);
	 clickElement(developmentCheckboxBy);
	 
	 Assert.assertTrue(isElementSelected(ageUnder18RadioBy));
	 Assert.assertTrue(isElementSelected(developmentCheckboxBy));
	 
	 clickElement(developmentCheckboxBy);
	 Assert.assertFalse(isElementSelected(developmentCheckboxBy));
	  
	  
 }
  
 
  public WebElement find(By by) {
	  return driver.findElement(by);
  }
  
  public boolean isElementDisplayed(By by) {
	  WebElement element = find(by);
	  if (element.isDisplayed()) {
		  System.out.println("Element [" + by +  "] is displayed!");
		  return true;
	  } else {
		  System.out.println("Element [" + by + "] is not displayed!");
		  return false;
	  }
  }
  
  public boolean isElementEnabled(By by) {
	  WebElement element = find(by);
	  if (element.isEnabled()) {
		  System.out.println("Element [" + by + "] is enabled!");
		  return true;
	  } else {
		  System.out.println("Element ["+ by + ") is disabled");
		  return false;
	  }
  }
  
  public boolean isElementSelected(By by) {
	  WebElement element = find(by);
	  if (element.isSelected()) {
		  System.out.println("Element [" + by + "] is selected!");
		  return true;
	  } else {
		  System.out.println("Element ["+ by + ") is not selected!");
		  return false;
	  }
		  
  }
  
  public void sendKeyToElement(By by, String value) {
	  WebElement element = find(by);
	  element.sendKeys(value);
  }
  
  public void clickElement(By by) {
	  WebElement element = find(by);
	  element.click();
  }
  
  public void sleepInSecond(long second) {
	  try {
	    Thread.sleep(second*1000);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  
  }
  
  //public void checkTrue(boolean status) {
  //assert.assertTrue(status);
  // }  
  
  
  
 

  @AfterClass
  public void afterClass() {
  }

}
