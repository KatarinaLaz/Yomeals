package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter, Actions actionProvider) {
		super(driver, js, waiter, actionProvider);
	}

//	METHODS
	
	public void MessageWaitDisappear() {
		waiter.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'system_message')]"),"style", "display: none"));
	}
	
	public void SuccessMessageWait() {
		waiter.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class, 'alert--success') or "
				+ "contains(@class, 'alert--danger')][contains(@style,'display: block')]")));
	}
	
	
//	GETTERS
	
	public WebElement getMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or "
				+ "contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
	public String getMessageText() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or "
				+ "contains(@class, 'alert--danger')][contains(@style,'display: block')]")).getText();
	}
	
	
	
	
	
	
	
	
	
}
