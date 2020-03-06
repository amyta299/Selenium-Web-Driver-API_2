package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_04_WebElementCommands {
  WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  
	  driver.get("http://google.com.vn");
}


  @Test
  public void TC_01_() {
	  //declare 1 web element
	  
	  WebElement textBox = driver.findElement(By.id("email"));
	  
	  //input value into web element
	  
	  textBox.sendKeys("abc");
	  sleepInSecond(1);
	  
	  textBox.clear();
	  textBox.click();
	  
	  //sub-element
	  textBox.findElement(By.id("abc"));
	  
	  //get attribute "Email needed to be filled in "
	  String textBoxAttribute = textBox.getAttribute("area-label");
	  
	  
	  //declare list of web elements
	  
	  List<WebElement> textBoxes = driver.findElements(By.xpath(".//input[@textarea='email']"));
	  textBoxes.size();
	  
	  //get css value
	  WebElement logInButton = driver.findElement(By.id("loginbutton"));
	  String logInButtonbackgroundcolor = logInButton.getCssValue("background-color");
	  String logInButtonTagName = logInButton.getTagName();
	  String logInButtonText =logInButton.getText();
	  
	  //check if element is displayed/enabled/selected- boolean
	  logInButton.isDisplayed();
	  
	  //submit- only works with form
	  textBox.submit();
	  
	  
	  
	  
  }
  
  @Test
  public void TC_02_() {
  }
  
  
 

  @AfterClass
  public void afterClass() {
  }

  public void sleepInSecond(long second) {
	  try {
	    Thread.sleep(second*1000);
	  } catch (InterruptedException e) {
		  e.printStackTrace();
	  }
	  
  }
}
