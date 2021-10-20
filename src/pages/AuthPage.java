package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter, Actions actionProvider) {
		super(driver, js, waiter, actionProvider);
	}

//	METHODS
	
	public void logout() throws InterruptedException {
		this.getMyAccountButton().click();
		Thread.sleep(200);
		this.getLogoutButton().click();
	}
	
//	GETTERS
	
	public WebElement getAccountPopupButton() {
		return this.driver.findElement(By.className("accounts-popup"));
	}
	
	public WebElement getMyAccountButton() {
		return this.driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/a"));
	}
	
	public WebElement getLogoutButton() {
		return this.driver.findElement(By.xpath("//div[@class='my-account-dropdown']/ul/li[2]/a"));
	}
	
	
	
	
	
}
