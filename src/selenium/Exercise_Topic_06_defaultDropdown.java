package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Exercise_Topic_06_defaultDropdown {
  WebDriver driver;
  Select select1;
  Select select2;
  Select selectDate;
  Select selectMonth;
  Select selectYear;
  String firstName, lastName, email, companyName, passWord, confirmPassword;
 
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  //test data
	  firstName = "Amy";
	  lastName ="too";
	  email = "amy" + randomNumber() + "gmail.com";
	  companyName = "ABC";
	  passWord = "123456";
	  confirmPassword = "123456"; 
	 
}


  @Test
  public void TC_01_() {
	  
	  driver.get("https://automationfc.github.io/basic-form/index.html");
	  select1 = new Select(driver.findElement(By.id("job1")));
	  Assert.assertFalse(select1.isMultiple());
	  select1.selectByVisibleText("Mobile Testing");
	  Assert.assertEquals(select1.getFirstSelectedOption().getText(), "Mobile Testing");
	  
	  select1.selectByValue("manual");
	  select1.getFirstSelectedOption().getText();
	  
	  select1.selectByIndex(9);
	  select1.getFirstSelectedOption().getText();
	  
	  List<WebElement> allItems = select1.getOptions();
	  System.out.println(allItems.size());
	  Assert.assertEquals(select1.getOptions().size(), 10);
	  
	  select2 = new  Select(driver.findElement(By.id("job2")));
	  Assert.assertTrue(select2.isMultiple());
	  select2.selectByVisibleText("Automation");
	  select2.selectByVisibleText("Mobile");
	  select2.selectByVisibleText("Desktop");
	  
	  List<WebElement> allItemsSelected = select2.getAllSelectedOptions();
	  for (WebElement list: allItemsSelected) {
		  System.out.println(list.getText());
	  }
	  select2.deselectAll();
	  Assert.assertEquals(select2.getAllSelectedOptions().size(), 0);
	  }
	  
  
  @Test
  public void TC_02_() {
	  
	  
	  driver.get("https://demo.nopcommerce.com/register");
	  driver.findElement(By.className("ico-register")).click();
	  driver.findElement(By.id("gender-female")).click();
	  driver.findElement(By.id("FirstName")).sendKeys(firstName);
	  driver.findElement(By.id("LastName")).sendKeys(lastName);
	  driver.findElement(By.id("Email")).sendKeys(email);
	  driver.findElement(By.id("Company")).sendKeys(companyName);
	  driver.findElement(By.id("Password")).sendKeys(passWord);
	  driver.findElement(By.id("FirstName")).sendKeys(firstName);
	  driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
	  selectDate = new Select(driver.findElement(By.name("DateOfBirthDay")));
	  selectDate.selectByVisibleText("29");
	  selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
	  selectMonth.selectByVisibleText("May");
	  selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
	  selectYear.selectByVisibleText("1995");
	  
	  List<WebElement> dateItems = selectDate.getOptions();
	  System.out.println(dateItems.size());
	  
	  List<WebElement> monthItems = selectMonth.getOptions();
	  System.out.println(monthItems.size());
	  
	  List<WebElement> yearItems = selectYear.getOptions();
	  System.out.println(yearItems.size());
	  
	  driver.findElement(By.id("register-button")).click();
	  
	  
	  
  }
  
  public int randomNumber() {
	  Random rand = new Random();
	  return rand.nextInt(1000);
  }

  @AfterClass
  public void afterClass() {
  }
  

}
