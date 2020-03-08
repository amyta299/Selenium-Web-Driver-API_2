package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_05_TextboxAndTextArea {
  WebDriver driver;
  String address = "123 Drake Road\nSudbury\nSuffolk";
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  
	  driver.get("http://automationfc.github.io/basic-form/index.html");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}


  @Test
  public void TC_01_TextBox_TextArea() {
	  driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("abc@gmail.com");
	  sleepInSecond(2);
	  
	  driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys(address);
	  sleepInSecond(2);
  }
  
  @Test
  public void TC_02_Button() {
	  driver.findElement(By.xpath("//button[@id='button-enabled']")).click();
	  sleepInSecond(2);
	  Assert.assertEquals(driver.getCurrentUrl(), "http://automationfc.com/");
  }
  
  
 public void sleepInSecond(long second) {
	 try {
		Thread.sleep(second*1000);
	 } catch (InterruptedException e) {
		 e.printStackTrace();
	 }
 }

  @AfterClass
  public void afterClass() {
  }

}
