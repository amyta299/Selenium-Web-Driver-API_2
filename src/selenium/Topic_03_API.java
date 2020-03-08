package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.awt.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterClass;

public class Topic_03_API {
  WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  // Open browser
	  driver = new FirefoxDriver();
	  
	
}


  @Test
  public void TC_01_webBrowserAPI() {
	  
	  //close tabs which are active
	  driver.close();
	  
	  //close all tabs
	  driver.quit();
	  
	  //work with 1 element
	  WebElement emailTextBox = driver.findElement(By.id("email"));
	  emailTextBox.clear();
	  emailTextBox.sendKeys("amyta.iae@gmail.com");
	  
	  //work with more than 1 elements
	  List <WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	  for(WebElement link:homePageLinks) {
		  System.out.println("Home Page Link = " + link.getAttribute("href"));
	  }
	  
	  
	  //open url
	  driver.get("http://google.com.vn");
	  
	  //get url
	  String homePageUrl = driver.getCurrentUrl();
	  System.out.println("Home Page Url = " + homePageUrl);
	  
	  //get source code for current page
	  String homePageSource = driver.getPageSource();
	  Assert.assertTrue(homePageSource.contains("This is a demo site for"));
	  
	  //get tittle for current page
	  String homePageTitle = driver.getTitle();
	  Assert.assertEquals(homePageTitle, "Home page");
	  
	  //get ID for current tab
	  String homePageTabID = driver.getWindowHandle();
	  System.out.println("Tab ID =" + homePageTabID);
	  
	  //get ID for all tabs
	  
	  Set <String> allIDs = driver.getWindowHandles();
	  
	  //Work with Cookies. Get/Delete/Add
	  driver.manage().deleteAllCookies();
	  
	  //Work with log(Driver/ Browser/ Network/ Performance)
	  driver.manage().logs().get(LogType.DRIVER);
	  
	  //wait for element to be stable and visible before action
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  //wait for page to load successfully
	  driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	  
	  //for Javascript Executor
	  driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
	  
	  //F11
	  driver.manage().window().fullscreen();
	  
	  //Test GUI (font,size,color,position)
	  
	  //get position of browser on screen resolution
	  driver.manage().window().getPosition();
	  
	  //set position of browser
	  Point newPoint = new Point(300, 500);
	  driver.manage().window().setPosition(newPoint);
	  
	  //get size of browser
	  driver.manage().window().getSize();
	  
	  //set size of browser
	  Dimension newDimension = new Dimension(1000,1000);
	  driver.manage().window().setSize(newDimension);
	  
	  //open browser in full/not full screen
	  driver.manage().window().maximize();
	  
	  //navigate
	  driver.navigate().back();
	  driver.navigate().forward();
	  driver.navigate().refresh();
	  
	  //open url and track history:back/forward/gps
	  driver.navigate().to("http://automationfc.com");
	  
	  //Alert/ Iframe/ Windows
	  
	  driver.switchTo().alert().accept();
	  driver.switchTo().alert().dismiss();
	  driver.switchTo().alert().getText();
	  
	  driver.switchTo().frame(driver.findElement(By.xpath("")));
	  
	  driver.switchTo().window("Window/ Tab ID");
		  
	  
  }
  
  @Test
  public void TC_02_() {
  }
  
  
 

  @AfterClass
  public void afterClass() {
  }

}
