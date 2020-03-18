package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_11_PopUp_Iframe {
  WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  
}


  @Test
  public void TC_01_PopUp() throws Exception {
	  driver.get("http://www.javacodegeeks.com/");
	  Thread.sleep(10000);
	  
	  if (driver.findElement(By.xpath("//div[@class='ulp-window ulp-window-middle-center']")).isDisplayed()) {
		  driver.findElement(By.xpath("//a[text()= 'No Thanks!']")).click();
		  Thread.sleep(3000);
	  }
	  
	  Assert.assertFalse(driver.findElement(By.xpath("//div[@class='ulp-window ulp-window-middle-center']")).isDisplayed());
	  
	  driver.findElement(By.xpath("//div[@data-title='Home Inline']//input[@name='ulp-email']")).sendKeys("amy" + randomNumber() + "@gmail.com");
	  
	  //click agree checkbox
	  driver.findElement(By.xpath("//input[@name='ulp-custom-field-rxdX']/following-sibling::label")).click();
	  
	  //click signup button
	  driver.findElement(By.xpath("//div[@data-title='Home Inline']//a[text()= 'Sign up']")).click();
	  
  }
  
  @Test
  public void TC_02_iFrame() throws Exception {
	  
	  driver.get("http://kyna.vn/");
	  
	  Thread.sleep(10000);
	  
	  WebElement facebookIframe = driver.findElement(By.xpath("//iframe[contains(@src, 'facebook.com/kyna.vn')]"));
	  Assert.assertTrue(facebookIframe.isDisplayed());
	  
	  //switch to iframe
	  //index
	  //driver.switchTo().frame(0);
	  //string- for id and name
	  //driver.switchTo().frame("cs_chat_iframe");
	  
	  //web element
	  driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'facebook.com/kyna.vn')]")));
	  
	  String kynaLikesNumber = driver.findElement(By.xpath("//div[@class='lfloat']//div[@class]")).getText();
	  Assert.assertEquals(kynaLikesNumber, "170K likes");
	  
	  
	  //switch back to parent page
	  driver.switchTo().defaultContent();
	  driver.findElement(By.cssSelector(".login-signup .button-login")).click();
	  driver.findElement(By.cssSelector("#user-login")).sendKeys("automationfc.vn@gmail.com");
	  driver.findElement(By.cssSelector("#user-password")).sendKeys("automationfc.vn@gmail.com");
	  Thread.sleep(10000);
	  
	  driver.findElement(By.cssSelector("#btn-submit-login")).click();
	  
	  String usernameDisplay = driver.findElement(By.xpath("//li[@class='account dropdown wrap']//span[@class='user']")).getText();
	  Assert.assertEquals(usernameDisplay, "Automation FC");
  }
  
  
 public int randomNumber() {
	 Random rand = new Random();
	 return rand.nextInt(9999);
 }

  @AfterClass
  public void afterClass() {
  }

}
