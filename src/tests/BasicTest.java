package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicTest {
	
	protected WebDriver driver;
	protected WebDriverWait waiter;
	protected JavascriptExecutor js;
	protected Actions actionProvider;
	protected AuthPage authPage;
	protected CartSummaryPage cartPage;
	protected LocationPopupPage locationPage;
	protected LoginPage loginPage;
	protected MealPage mealPage;
	protected NotificationSystemPage notificationPage;
	protected ProfilePage profilePage;

	String baseURL = "http://demo.yo-meals.com/";
	String email = "customer@dummyid.com";
	String password = "12345678a";
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",  "driver-lib\\chromedriver.exe"); 
		
		this.driver = new ChromeDriver();
		this.waiter = new WebDriverWait(driver, 10);
		this.js = (JavascriptExecutor) driver;
		this.actionProvider = new Actions(driver);
		this.authPage = new AuthPage(driver, js, waiter, actionProvider);
		this.cartPage = new CartSummaryPage(driver, js, waiter, actionProvider);
		this.locationPage = new LocationPopupPage(driver, js, waiter, actionProvider);
		this.loginPage = new LoginPage(driver, js, waiter, actionProvider);
		this.mealPage = new MealPage(driver, js, waiter, actionProvider);
		this.notificationPage = new NotificationSystemPage(driver, js, waiter, actionProvider);
		this.profilePage = new ProfilePage(driver, js, waiter, actionProvider);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@AfterMethod
	public void screenshot(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			try {
				TakesScreenshot ts =((TakesScreenshot)driver);
				File scrShot=ts.getScreenshotAs(OutputType.FILE);
				Date date = new Date();
				SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				FileHandler.copy(scrShot, new File("screenshots/" + dtf.format(date) + ".png"));
			} catch (Exception e) {
				System.out.println("Screenshot exception.");
			}
		}
		
		driver.quit();
	}
	
	
	
	
	
}
