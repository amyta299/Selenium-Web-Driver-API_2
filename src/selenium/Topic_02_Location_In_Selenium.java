package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Location_In_Selenium {
  WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  
}


  @Test
  public void TC_01_ID() throws Exception {
	  
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  driver.findElement(By.id("email")).sendKeys("automationfc.vn@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("123456");
	  
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id("send2")).click();
  }
  
  @Test
  public void TC_02_ClassName() {
	  
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  driver.findElement(By.className("validate-email")).sendKeys("automationfc.vn@gmail.com");
	  driver.findElement(By.className("validate-password")).sendKeys("123456");
	  driver.findElement(By.id("send2")).click();
	  
  }
  
  @Test
  public void TC_03_Name() {
	  
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  driver.findElement(By.name("login[username]")).sendKeys("automationfc.vn@gmail.com");
	  driver.findElement(By.name("login[password]")).sendKeys("123456");
	  driver.findElement(By.name("send")).click();
	  
  }
  
  @Test
  public void TC_04_LinkText() {
	  
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  driver.findElement(By.linkText("CONTACT US")).click();
	  driver.findElement(By.linkText("ADVANCED SEARCH")).click();
	  
  }
 
  @Test
  public void TC_05_PartialLinkText() {
	  
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  driver.findElement(By.partialLinkText("CONTACT")).click();
	  driver.findElement(By.partialLinkText("ADVANCED")).click();
  }
  
  @Test
  public void TC_06_CSS() {
	  
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  
	  driver.findElement(By.cssSelector("#email")).sendKeys("automationfc.vn@gmail.com");
	  driver.findElement(By.cssSelector("#email")).clear();
	  
	  driver.findElement(By.cssSelector(".validate-email")).sendKeys("automationfc.v@gmail.com");
	  driver.findElement(By.cssSelector(".validate-email")).clear();
	  
	  driver.findElement(By.cssSelector("input[id='email']")).sendKeys("automationfc@gmail.com");
	  driver.findElement(By.cssSelector("input[id='email']")).clear();
	  
  }
  
  @Test
  public void TC_07_Xpath() {
	  
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='email']")).clear();
	  
	  
	  driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("automationf@gmail.com");
	  driver.findElement(By.xpath("//input[@title='Email Address']")).clear();
	  
	  driver.findElement(By.xpath("//form[@id='login-form']//input[contains(@class,'validate-email']")).sendKeys("automationf@gmail.com");
	  driver.findElement(By.xpath("//form[@id='login-form']//input[contains(@class,'validate-email']")).clear();
	  
	  
  }
  @Test
  public void TC_08_Tagname() {
	  
	  driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
	  System.out.println("Links in My Account Page = " + driver.findElement(By.tagName("a")).getSize());
	  System.out.println("Buttons in My Account Page = " + driver.findElement(By.tagName("button")).getSize());
	  System.out.println("Textboxes or Radio or Checkbox or Upload  in My Account Page = " + driver.findElement(By.tagName("input")).getSize());
	  
	  
	  
  }
  
  @AfterClass
  public void afterClass() {
  }

}
