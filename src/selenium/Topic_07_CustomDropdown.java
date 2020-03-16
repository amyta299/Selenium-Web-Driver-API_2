package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_07_CustomDropdown {
  WebDriver driver;
  WebDriverWait wait;
  JavascriptExecutor javascriptExe;
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver, 20);
	  javascriptExe = (JavascriptExecutor) driver;
	  
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
}


  @Test
  public void TC_01_() throws Exception {
	  //speed
	  
	  driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
	  selectItemInCustomDropdown("//span[@id='speed-button']", "//ul[@id='speed-menu']//div", "Medium");
	  Assert.assertTrue(verifyItemSelected("//span[@id='speed-button']//span[@class='ui-selectmenu-text' and text()='Medium']"));
	  
	  selectItemInCustomDropdown("//span[@id='speed-button']", "//ul[@id='speed-menu']//div", "Faster");
	  selectItemInCustomDropdown("//span[@id='speed-button']", "//ul[@id='speed-menu']//div", "Slow");
	  
	  //number
	  
	  selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "19");
  }
  
  @Test
  public void TC_02_() {
  }
  
  public void selectItemInCustomDropdown(String parentXpath, String childXpath, String expectedItem) throws Exception {
	  //click all items needed
	  driver.findElement(By.xpath(parentXpath)).click();
	  //wait until all items appear
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
	  //send all items to one list, get text and compare with expected result
	  List<WebElement> allItems = driver.findElements(By.xpath(childXpath));
	  //use vong lap de duyet qua (loop)
	  for (WebElement oneItem : allItems) {
		if(oneItem.getText().equals(expectedItem)) {
			  
			  javascriptExe.executeScript("argument[0].scrollIntoView(true);", oneItem);
			  oneItem.click();
			  
			  Thread.sleep(1000);
			  break;
		  }
	  }
  }
  
  
  public boolean verifyItemSelected(String xpathlocator) {
	  boolean status = driver.findElement(By.xpath(xpathlocator)).isDisplayed();
	  if(status) {
		  return true;
	  }else {
		  return false;
	  }
			  
  }
 

  @AfterClass
  public void afterClass() {
  }

}
