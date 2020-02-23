package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Run on Chrome version  80.0.3987.16
		System.setProperty("webdriver.chrome.driver", 
			"C:\\Users\\DMedcal1\\OneDrive - Greene King PLC\\Desktop\\MAI\\selenium webdriver api\\src\\selenium-webdriver-api\\libraries\\chromedriver.exe");
		    
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("headless");
		    options.addArguments("window-size=1366x768");
		driver = new ChromeDriver(options);
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Login Page Url matching
		String loginPageUrl = driver.getCurrentUrl();
		System.out.println(loginPageUrl);
		Assert.assertEquals(loginPageUrl, "http://demo.guru99.com/v4/");
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		// Login Page title
		String loginPageTitle = driver.getTitle();
		System.out.println (loginPageTitle );
		Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		// Login form displayed
		boolean loginFormStatus = driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed(); 
		System.out.println("Login form status = " + loginFormStatus);
		Assert.assertTrue(true);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}