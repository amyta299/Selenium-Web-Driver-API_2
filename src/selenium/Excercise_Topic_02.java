package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Excercise_Topic_02 {
  WebDriver driver;
  By emailTextboxBy = By.id("email");
  By passwordTextboxBy = By.id("pass");
  By loginButtonBy = By.name("send");
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  
}
  @BeforeMethod
  public void beforeMethod() {
	  driver.get("http://live.guru99.com/index.php/customer/account/login/");
  }
 


  @Test
  public void TC_01_LogInWithEmailAndPasswordEmpty()  {
	  
	  driver.findElement(emailTextboxBy).sendKeys("");
	  driver.findElement(passwordTextboxBy).sendKeys("");
	  
	  
	  driver.findElement(loginButtonBy).click();
	  
	  String emailErrorMessage = driver.findElement(By.id("advice-required-entry-email")).getText();
	  Assert.assertEquals(emailErrorMessage , "This is a required field.");
	  
	  String passwordErrorMessage = driver.findElement(By.id("advice-required-entry-pass")).getText();
	  Assert.assertTrue(passwordErrorMessage.equals("This is a required field."));
	  
  }
  
  @Test
  public void TC_02_LogInWithEmailInvalid()  {
	  
	  
	  driver.findElement(emailTextboxBy).sendKeys("abc@bcd");
	  driver.findElement(passwordTextboxBy).sendKeys("abcdefg ");
	  
	  driver.findElement(loginButtonBy).click();
	  
	  String emailInvalidErrorMessage = driver.findElement(By.cssSelector("#advice-validate-email-email")).getText();
	  Assert.assertFalse(emailInvalidErrorMessage.equals("Please enter a valid email address. For example johndoe@gmail.com."));
	  
  
  }
  @Test
  public void TC_03_LogInWithPasswordLessThanSixChars()  {
	  
	  
	  driver.findElement(emailTextboxBy).sendKeys("amyta.iae@gmail.com");
	  driver.findElement(passwordTextboxBy).sendKeys("banan");
	  
	  driver.findElement(loginButtonBy).click();
	  
	  String passwordInvalidErrorMessage = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
	  Assert.assertEquals(passwordInvalidErrorMessage, "Please enter 6 or more characters without leading or trailing spaces.");
  }
  
  
}
  
  