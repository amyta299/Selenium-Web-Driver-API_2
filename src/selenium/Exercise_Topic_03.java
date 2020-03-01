package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Exercise_Topic_03 {
  WebDriver driver;
 
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  
}
  
  
  
@Test
  public void TC_01_verifyUrl() {
	  
	  driver.get("http://live.guru99.com/index.php/customer/account/login/");
	  
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  
	  String logInPageUrl= driver.getCurrentUrl();
	  Assert.assertEquals(logInPageUrl, "http://live.demoguru99.com/index.php/customer/account/login/");
	  
	  driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
	  String registerPageUrl= driver.getCurrentUrl();
	  Assert.assertEquals(registerPageUrl, "http://live.demoguru99.com/index.php/customer/account/create/");
	  
}


  
  @Test
  public void TC_02_verifyTitle() {
	  
	  driver.get("http://live.guru99.com/index.php/customer/account/login/");
	 
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  String logInPageTitle= driver.getTitle();
	  Assert.assertEquals(logInPageTitle, "Customer Login");
	  
	  driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
	  String registerPageTitle= driver.getTitle();
	  Assert.assertEquals(registerPageTitle, "Create New Customer Account");
	  
  }
  
  @Test
  public void TC_03_navigateFunction() {
	  driver.get("http://live.guru99.com");
	  
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
	  String registerPageUrl= driver.getCurrentUrl();
	  Assert.assertEquals(registerPageUrl, "http://live.demoguru99.com/index.php/customer/account/create/");
	  
	  driver.navigate().back();
	  String logInPageUrl= driver.getCurrentUrl();
	  Assert.assertEquals(logInPageUrl, "http://live.demoguru99.com/index.php/customer/account/login/");
	  
	  driver.navigate().forward();
	  String registerPageTitle= driver.getTitle();
	  Assert.assertEquals(registerPageTitle, "Create New Customer Account");
	  
	  

  }
  
  @Test
  public void TC_04_getPageSourceCode() {
	  
	  driver.get("http://live.guru99.com");
	  
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  String logInPageSourceCode= driver.getCurrentUrl();
	  Assert.assertFalse(logInPageSourceCode.contains("Log in or Create an Account"));
	  
	  driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
	  String registerPageSourceCode= driver.getCurrentUrl();
	  Assert.assertFalse(registerPageSourceCode.contains("Create an Account"));
	  
	  
  }
  
  
  
  
  
  
 

  @AfterClass
  public void afterClass() {
  }

}
