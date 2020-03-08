package selenium;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Excercise_Topic_05_HandleTextBoxTextAreaButton {
  WebDriver driver;
  By createAccountLinkBy = By.xpath("//a[@href='http://demo.guru99.com/']");
  By createEmailBy = By.xpath("//input[@type='text']");
  By emailSubmitBy = By.xpath("//input[@type='submit']");
  By userNameBy = By.xpath("//td[text()='User ID :']/following-sibling::td");
  By passwordBy = By.xpath("//td[text()='Password :']/following-sibling::td");
  By userIDBy = By.xpath("//input[@name='uid']");
  By passwordLogInBy = By.xpath("//input[@type='password']");
  By loginBy = By.xpath("//input[@type='submit']");
  By welcomeMessageBy = By.xpath("//marquee[@class='heading3']");
  By newCustomerLinkBy = By.xpath("//a[text()='New Customer']");
  By customerNameBy = By.xpath("//input[@name='name']");
  By femaleGenderBy = By.xpath("//input[@value='f']");
  By dateOfBirthBy = By.xpath("//input[@id='dob']");
  By customerAddressBy = By.xpath("//textarea[@name='addr']");
  By cityNameBy = By.xpath("//input[@name='city']");
  By stateNameBy = By.xpath("//input[@name='state']");
  By pinNumberBy = By.xpath("//input[@name='pinno']");
  By telephoneNumberBy = By.xpath("//input[@name='telephoneno']");
  By customerEmailBy = By.xpath("//input[@name='emailid']");
  By customerPasswordBy = By.xpath("//input[@name='password']");
  By customerSubmitBy = By.xpath("//input[@name='sub']");
  By customerIDBy = By.linkText("51301");
  By editCustomerLinkBy = By.xpath("//a[@href=\"EditCustomer.php\"]");
  By editCustomerIDBy = By.xpath("//input[@name='cusid']");
  String emailAddress, name, gender, dob, address, city, state, pin, phone, password;
  By successMessageBy = By.xpath("//p[@class='heading3']");
  
  
  @BeforeClass
  public void beforeClass() {
	  // Firefox 47 + Selenium 2.xx + No GeckoDriver
	  driver = new FirefoxDriver();
	  driver.get("http://demo.guru99.com/v4");
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  
	  //test data
	  emailAddress = "amyta" + randomNumber() + "@gmail.com";
	  name = "amy";
	  gender ="female";
	  dob = "2000-05-05";
	  address ="40 Windermere";
	  city = "london";
	  state = "essex";
	  pin = "123456";
	  phone = "0123456789";
	  password = "987654";
	  
	  
}


  @Test
  public void TC_01_createNewCustomer() {
	 //register
	  
	  String logInUrl = driver.getCurrentUrl();
	  
	  find(createAccountLinkBy).click();
	  sleepInSecond(2);
	  
	  find(createEmailBy).sendKeys(emailAddress);
	  find(emailSubmitBy).click();
	  sleepInSecond(2);
	  
	  String userID = find(userNameBy).getText();
	  String password = find(passwordBy).getText();
	  
	  driver.get(logInUrl);
	  sleepInSecond(2);
	  
	  //log in
	  find(userIDBy).sendKeys(userID);
	  find(passwordLogInBy).sendKeys(password);
	  find(loginBy).click();
	  sleepInSecond(2);
	  
	  String currentURL = driver.getCurrentUrl();
	  Assert.assertEquals(currentURL, "http://demo.guru99.com/v4/manager/Managerhomepage.php");
	  
	  String welcomeMessage = find(welcomeMessageBy).getText();
	  Assert.assertEquals(welcomeMessage, "Welcome To Manager's Page of Guru99 Bank");
	  
	  //new customer
	  find(newCustomerLinkBy).click();
	  sleepInSecond(2);
	  
	  find(customerNameBy).sendKeys(name);
	  find(femaleGenderBy).click();
	  find(dateOfBirthBy).sendKeys(dob);
	  find(customerAddressBy).sendKeys(address);
	  find(cityNameBy).sendKeys(city);
	  find(stateNameBy).sendKeys(state);
	  find(pinNumberBy).sendKeys(pin);
	  find(telephoneNumberBy).sendKeys(phone);
	  find(customerEmailBy).sendKeys(emailAddress);
	  find(customerPasswordBy).sendKeys(password);
	  find(customerSubmitBy).click();
	  sleepInSecond(3);
	  
	  //verify register success
	  Assert.assertEquals(driver.findElement(successMessageBy).getText(), "Customer Registered Successfully!!!");
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dob);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
	  String customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
	  
	  
	  // open edit customer
	  find(editCustomerLinkBy).click();
	  sleepInSecond(2);
	  find(editCustomerIDBy).sendKeys(customerID);
	  
	    
	  
	  
  }
  
  @Test
  public void TC_02_() {
  }
  
  public void sleepInSecond(long second) {
	  try {
		  Thread.sleep(second*1000);
	  } catch(InterruptedException e) {
		  e.printStackTrace();
		  
	  }
  }
  
  public WebElement find(By by) {
	  return driver.findElement(by);
	  
  }
  
  public void send(By by, String value) {
	  WebElement element = find(by);
	  element.sendKeys(value);
  }
  
  public int randomNumber() {
	  Random rand = new Random ();
	  int number = rand.nextInt(10000);
	  return number;
  }
			  
			  
  
 

  @AfterClass
  public void afterClass() {
  }

}
