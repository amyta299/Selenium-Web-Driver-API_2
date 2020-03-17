package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_09_JSalert {
  WebDriver driver;
  Alert alert;
  
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  
	  driver.get("http://automationfc.github.io/basic-form/index.html");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
}


  @Test
  public void TC_01_acceptAlert() throws Exception {
	  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	  alert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals(alert.getText(), "I am a JS Alert");
	  alert.accept();
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText().trim(), "You clicked an alert successfully");
	  
	  
	  
  }
 
  
  @Test
  public void TC_02_confirmAlert() throws Exception {
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	  alert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  Assert.assertEquals(alert.getText(), "I am a JS Confirm");
	  
	  alert.dismiss();
	  Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You clicked: Cancel");
  }
  
  @Test
  public void TC_03_promptAlert() throws Exception {
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	  alert = driver.switchTo().alert();
	  Thread.sleep(3000);
	  Assert.assertEquals(alert.getText(), "I am a JS prompt");
	  
	  alert.sendKeys("amy");
	  Thread.sleep(2000);
	  alert.accept();
	  Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: amy");
  }
  
  @Test
  public void TC_04_authenticationAlert() {
	  driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	  //input directly username and password to url
	  Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	  
  }
  
  @Test
  
  public void TC_05_navigatetoAuthenticationAlert() throws Exception {
	  driver.get("http://the-internet.herokuapp.com/");
	  Thread.sleep(3000);
	  String basicAuthUrl = driver.findElement(By.xpath("//a[@text()='Basic Auth']")).getAttribute("href");
	  inputToUrl(basicAuthUrl, "admin", "admin");
	  driver.get(basicAuthUrl);
	  Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")).isDisplayed());
	  
  }
  
 public String inputToUrl(String urlValue, String username, String password) {
	 String urlSplit[] = urlValue.split("//");
	 //0:http
	 //1: url after //
	 urlValue = urlSplit[0] +"//" + username + ":" + password + "@" + urlSplit[1];
	 System.out.println("urlValue");
	 return urlValue;
 }

  @AfterClass
  public void afterClass() {
  }

}
