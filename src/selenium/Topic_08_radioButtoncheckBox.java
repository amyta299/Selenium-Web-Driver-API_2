package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_08_radioButtoncheckBox {
  WebDriver driver;
  JavascriptExecutor javascriptExe;
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  javascriptExe = (JavascriptExecutor) driver;
}


  @Test
  public void TC_01_default() {
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  checkToCheckboxRadio("//input[@id='under_18']");
	  Assert.assertTrue(isRadioOrCheckboxSelected("//input[@id='under_18']"));
	  
	  checkToCheckboxRadio("//input[@id='development']");
	  Assert.assertTrue(isRadioOrCheckboxSelected("//input[@id='development']"));
	  
	  //unselect checkbox
	  
	  uncheckToCheckboxRadio ("//input[@id='development']");
	  Assert.assertFalse(isRadioOrCheckboxSelected("//input[@id='development']"));
  }
  
  @Test
  public void TC_02_default2() {
	  driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
	  checkToCheckboxRadio("//input[@id='eq5']");
	  Assert.assertTrue(isRadioOrCheckboxSelected("//input[@id='eq5']"));
	  
	  uncheckToCheckboxRadio ("//input[@id='eq5']");
	  Assert.assertTrue(isRadioOrCheckboxSelected("//input[@id='eq5']"));
	  
  }
  
  @Test
  //when input xpath is not highlighted
  public void TC_03_custom() {
	  //div- click; input-verify
	  driver.get("https://material.angular.io/components/radio/examples");
	  checkToCheckboxRadio("//input[@value='Spring']/preceding-sibling::div[@class='mat-radio-outer-circle']");
	  Assert.assertTrue(isRadioOrCheckboxSelected("//input[@value='Spring']"));
	  
	  //Way 2
	  //clickByJS("input[@value='Spring']");
  }
  
  public void checkToCheckboxRadio(String locator) {
	  WebElement element = driver.findElement(By.xpath(locator));
	  if(!element.isSelected()) {
		element.click();
	  }
  }
  
  public void uncheckToCheckboxRadio(String locator) {
	  WebElement element = driver.findElement(By.xpath(locator));
	  if(element.isSelected()) {
		element.click();
	  }
  }
	  
  public boolean isRadioOrCheckboxSelected(String locator) {
	  WebElement element = driver.findElement(By.xpath(locator));
	  if(element.isSelected()) {
		  System.out.println("Checkbox or radio is selected");
		  return true;
	  }else {
		  System.out.println("Checkbox or radio is not selected");
		  return false;
		  
	  }
  
  }
  
  public void clickByJS(String locator) {
	  WebElement element = driver.findElement(By.xpath(locator));
	  javascriptExe.executeScript("arguments[0].click();", element);
  }
  
 

  @AfterClass
  public void afterClass() {
  }

}
