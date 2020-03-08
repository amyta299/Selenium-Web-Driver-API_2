package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_00_Test_Class_Template {
  WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  
	  driver.get("http://google.com.vn");
}


  @Test
  public void TC_01_() {
  }
  
  @Test
  public void TC_02_() {
  }
  
  
 

  @AfterClass
  public void afterClass() {
  }

}
