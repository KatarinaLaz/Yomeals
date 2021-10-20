package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter, Actions actionProvider) {
		super(driver, js, waiter, actionProvider);
	}
	
//	METHODS
	
	public void login(String email, String password) {
		this.getEmailInput().clear();
		this.getEmailInput().sendKeys(email);
		this.getPasswordInput().clear();
		this.getPasswordInput().sendKeys(password);
		this.getLoginButton().click();
	}
	
//	GETTERS
	
	public WebElement getEmailInput() {
		return this.driver.findElement(By.name("username"));
	}
	
	public WebElement getPasswordInput() {
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getLoginButton() {
		return this.driver.findElement(By.xpath("//input[@value='Login']"));
	}
	
	
	
	
	
	
	
	
	
	
	

}
