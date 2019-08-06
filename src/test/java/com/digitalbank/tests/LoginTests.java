package com.digitalbank.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTests {

    private static WebDriver driver;
    
    private static final String VALID_USERNAME = "jsmith@demo.io";
    private static final String VALID_PASSWORD = "Demo123!";
    private static final String BASE_URL = "http://localhost:8080";

    @BeforeSuite(alwaysRun=true)
    public static void setupSuite() throws MalformedURLException {
    	// Setting up driver manager
    	WebDriverManager.chromedriver().setup();
    }
    
    @BeforeTest(alwaysRun=true)
    public void testSetupTest() {
    	// Initializing Chrome driver
    	driver = new ChromeDriver();
    }

    @AfterSuite(alwaysRun=true)
    public static void testTearDown() {
    	// Close the browser window
        driver.quit();
    }

    @Test(description="Navigate to URL and verify correct page")
    public void browserInitTest() {
    	driver.get(BASE_URL);
        Assert.assertEquals(driver.getTitle(), "Digital Bank");
    }
    
    @Test(description="Login successfully with valid credentials")
    public void validLoginTest() throws InterruptedException {
    	driver.get(BASE_URL+"/login");
    	Assert.assertEquals(driver.getTitle(), "Digital Bank");
        
        driver.findElement(By.id("username")).sendKeys(VALID_USERNAME);
        driver.findElement(By.id("password")).sendKeys(VALID_PASSWORD);
        
        driver.findElement(By.id("submit")).click();
      
        Assert.assertEquals(driver.getCurrentUrl(), BASE_URL+"/home");
    }
}



//ExtentHtmlReporter reporter= new ExtentHtmlReporter("./Reports/learn_automation1.html");
//
//// Create object of ExtentReports class- This is main class which will create report
//ExtentReports extent = new ExtentReports();
//
//// attach the reporter which we created in Step 1
//extent.attachReporter(reporter);
//
//// call createTest method and pass the name of TestCase- Based on your requirement
//ExtentTest logger=extent.createTest("LoginTest");

//extent.flush();