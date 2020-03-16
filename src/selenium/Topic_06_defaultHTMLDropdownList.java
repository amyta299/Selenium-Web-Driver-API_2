package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_06_defaultHTMLDropdownList {
  WebDriver driver;
  Select select;
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  
	  driver.get("http://google.com.vn");
}


  @Test
  public void TC_01_() {
	  select = new Select(driver.findElement(By.xpath("//select[@id='job1']")));
	  select.selectByIndex(0);
	  select.selectByValue("integration");
	  select.deselectByVisibleText("Functional UI Testing");
	  //only apply to multiple drowdown
	  select.deselectAll();
	  
	  //check if dropdown is multiple
	  Assert.assertTrue(select.isMultiple());
	  
	  //check all selected items in dropdown list
	  List<WebElement> itemsSelected = select.getAllSelectedOptions();
	  System.out.println(itemsSelected.size());
	  
	  //select all items both selected and not selected in dropdown list
	  List<WebElement> allItems = select.getOptions();
	  for (WebElement list: allItems) {
		  System.out.println(list.getText());
	  }
	  
	  //verify selection
	  select.getFirstSelectedOption().getText();
	  
  }
  
  @Test
  public void TC_02_() {
  }
  
  
 

  @AfterClass
  public void afterClass() {
  }

}
