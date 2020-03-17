package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_10_UserInteraction {
  WebDriver driver;
  Actions action;
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  FirefoxProfile profile = new FirefoxProfile();
	  profile.setPreference("dom.webnotifications.enabled", false);
	  driver = new FirefoxDriver(profile);
	  
	  action = new Actions(driver);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}


  @Test
  public void TC_01_HoverMouse() throws Exception {
	  driver.get("http://www.myntra.com/");
	  WebElement discoverLink = driver.findElement(By.xpath("//a[@class='desktop-main' and text()='Discover'] "));
	  //hover
	  action.moveToElement(discoverLink).perform();
	  Thread.sleep(3000);
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='desktop-navBlock']//a[text()='American Eagle']")).isDisplayed());
	  
	  driver.findElement(By.xpath("//ul[@class='desktop-navBlock']//a[text()='American Eagle']")).click();
	  Thread.sleep(3000);
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb' and text()='American Eagle']")).isDisplayed());
  }
  
  @Test
  public void TC_02_ClickandHoldBlock() throws Exception {
	  driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
	  List <WebElement> allItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	  System.out.println(allItems.size());
	  action.clickAndHold(allItems.get(0)).moveToElement(allItems.get(7)).release().perform();
	  Thread.sleep(5000);
	  
	  List <WebElement> allItemsSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class, 'ui-selected')]"));
	  System.out.println(allItemsSelected.size());
	  Assert.assertEquals(allItemsSelected.size(), 8);
	  //control flow for, each item duyet qua ca list item de in ra text; in cac so ra tu 1-8
	  for (WebElement item: allItemsSelected) {
		  System.out.println(item.getText());
	  }
	  
	  
  }
  
  @Test
  public void TC_03_ClickandHoldRandom() {
	  driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
	  List <WebElement> allItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	  System.out.println(allItems.size());
	  
	  action.keyUp(Keys.CONTROL).perform();
	  action.click(allItems.get(0)).perform();
	  action.click(allItems.get(2)).perform();
	  action.keyDown(Keys.CONTROL).perform();
	  
	  List <WebElement> allItemsSelected = driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class, 'ui-selected')]"));
	  
	  Assert.assertEquals(allItemsSelected.size(), 2);
	  //control flow for, each item duyet qua ca list item de in ra text; in cac so ra tu 1-8
	  for (WebElement item: allItems) {
		  System.out.println(item.getText());
	  }
	  
  }
  
  @Test
  public void TC_04_doubleClick() throws Exception {
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  WebElement doubleClickLink= driver.findElement(By.xpath("//button[text()='Double click me']"));
	  action.doubleClick(doubleClickLink).perform();
	  Thread.sleep(3000);
	  
	  String textAppear = driver.findElement(By.xpath("//p[@id='demo']")).getText();
	  
	  Assert.assertEquals(textAppear, "Hello Automation Guys!");
	  
	  
  }
  
  @Test
  public void TC_05_rightClick() throws Exception {
	  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	  WebElement rightClickme = driver.findElement(By.xpath("//span[text()='right click me']"));
	  action.contextClick(rightClickme).perform();
	  Thread.sleep(3000);
	  
	  WebElement quitClick = driver.findElement(By.xpath("//li[contains(@class, 'context-menu-icon-quit')]"));
	  action.moveToElement(quitClick).perform();
	  Thread.sleep(3000);
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class, 'quit') and contains(@class, 'visible') and contains(@class, 'hover')]")).isDisplayed());
	  
	  action.click(quitClick).perform();
	  
  }
  
  @Test
  public void TC_06_dragDrop() throws Exception {
	  driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular");
	  Thread.sleep(3000);
	  
	  WebElement smallCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
	  WebElement bigCircle = driver.findElement(By.xpath("//div[@id='droptarget']"));
	  action.dragAndDrop(smallCircle, bigCircle).perform();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals(bigCircle.getText(), "You did great!");
	  
  }
  
 

  @AfterClass
  public void afterClass() {
  }

}
