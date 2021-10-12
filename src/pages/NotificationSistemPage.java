package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage {

	public NotificationSistemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

//	METHODS
	
	public void messageExist() {
		waiter.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'alert--success') or"
						+ " //*contains(@class, 'alert--danger')][contains(@style,'display: block')]"),
							"style", "display: none"));
	}
	
//	GETTERS
	
	public WebElement getMessage() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success') or"
						+ " //*contains(@class, 'alert--danger')][contains(@style,'display: block')]"));
	}
	
	public String getMessageText() {
		return this.getMessage().getText();
	}
	
	
	
	
	
	
}
