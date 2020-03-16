package selenium;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class Exercise_Topic7_CustomDropdown {
  WebDriver driver;
  WebDriverWait wait;
  JavascriptExecutor javascriptexe;
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver, 20);
	  javascriptexe = (JavascriptExecutor) driver;
}

  
  @Test
  public void TC_02_Angular() throws Exception {
    driver.get("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding");
    selectItem("//ejs-dropdownlist[@id='games']//span[contains(@class,'e-search-icon')]", "//div[@id='games_popup']//li", "Football");
    Assert.assertEquals(getTextbyJQuery("ejs-dropdownlist[id='games'] option"), "Football");
    sleepInSecond(1000);
  }
  
  @Test
  public void TC_03_React() throws Exception {
	 driver.get("http://react.semantic-ui.com/maximize/dropdown-example-selection/");
	 selectItem("//i[@class='dropdown icon']", "//div[@class='item'//span", "Christian");
	 Assert.assertEquals(getTextElement("//div[@role='listbox'//div[@class='text']"), "Christian");
  }
  
  @Test 
  public void TC_04_VueJS() throws Exception {
	  driver.get("http://mikerodham.github.io/vue-dropdowns/");
	  selectItem("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "First Option");
	  Assert.assertEquals(getTextElement("//div[@role='listbox']/div[@class='text']"), "First Option");
  }
  
  //in case there are too many selections to choose, cannot check each items, search and send keys is quicker
  @Test
  public void TC_05_Editable() throws Exception {
	  driver.get("http://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
	  sendKeyToCustomDropdown("//input[@class='search']", "Albania");
	  Assert.assertEquals(getTextElement("//div[@role='combobox']//div[@class='text']"), "Albania");
  }
  
  
  public void selectItem(String parentXpath, String childXpath, String expectedItem) {
	  driver.findElement(By.xpath(parentXpath)).click();
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
	  List<WebElement> allItems = driver.findElements(By.xpath(childXpath));
	  for (WebElement oneItem: allItems) {
		  if(oneItem.getText().equals(expectedItem)) {
			  javascriptexe.executeScript("arguments[0].scrollIntoView(true);", oneItem);
			  oneItem.click();
			  break;
		  }
	  }
	  
  }
  
  public boolean verifyItem(String xpathlocator) {
	  boolean status = driver.findElement(By.xpath(xpathlocator)).isDisplayed();
	  if(status) {
		  return true;
	  }else{
		  return false;
	  }
    
  }
  public String getTextElement(String xpathlocator) {
	  String actualText = driver.findElement(By.xpath(xpathlocator)).getText();
	  System.out.println(actualText);
	  return actualText;
  }
  
  public String getTextbyJQuery(String csslocator) {
	  return (String) javascriptexe.executeScript("return document.querySelector(\"" + csslocator + "\").text" );
  }
  
  public void sleepInSecond(long second) {
	  try {
		  Thread.sleep(second*1000);
	  } catch(InterruptedException e) {
		  e.printStackTrace(); 
		  }
  }
	  
  public void sendKeyToCustomDropdown(String inputTextbox, String expectedItem) {
		  WebElement textBoxElement = driver.findElement(By.xpath(inputTextbox));
		  textBoxElement.clear();
		  textBoxElement.sendKeys(expectedItem);
		  textBoxElement.sendKeys(Keys.ENTER);
		  
	  }
  
  @AfterClass
  public void afterClass() {
  }

}
