package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

//	METHODS
	
	public void clickLocationSelect() {
		this.getLocationSelect().click();
	}
	
	public void setLocation(String locationName) {
		this.getKeyword().click();
		this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), this.getLocationItem(locationName).getAttribute("data-value"));
		js.executeScript("arguments[0].click()", this.getSubmit());
	}
	
	public void clickLocationSelectClose() {
		this.getLocationSelectCloseButton().click();
	}
	
//	GETTERS
	
	public WebElement getLocationSelect() {
		return this.driver.findElement(By.xpath("//div[@class='location-selector']/a"));
	}
	
	public WebElement getLocationSelectCloseButton() {
		return this.driver.findElement(By.xpath("//div[@class='location-search']/a"));
	}
	
	public WebElement getKeyword() {
		return this.driver.findElement(By.id("locality_keyword"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return this.driver.findElement(By.id("location_id"));
	}
	
	public WebElement getSubmit() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	
	
	
	
	
}
