package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasicPage {

	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait waiter;
	protected Actions actionProvider;
	
	public BasicPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter, Actions actionProvider) {
		this.driver = driver;
		this.js = js;
		this.waiter = waiter;
		this.actionProvider = actionProvider;
	}
	
	
	
	
	
}
