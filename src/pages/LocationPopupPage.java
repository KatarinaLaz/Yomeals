package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter, Actions actionProvider) {
		super(driver, js, waiter, actionProvider);
	}

//	METHODS
	
	public void clickLocationSelect() {
		this.getLocationSelect().click();
	}
	
	public void setLocation(String locationName) {
		this.getKeyword().click();
		String value = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), value);
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
		return this.driver.findElement(By.xpath("//*[@id=\"location-popup\"]/div/div/div/div/a"));
	}
	
	public WebElement getKeyword() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}
	
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	
	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id='location_id']"));
	}
	
	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@id='frm_fat_id_frmSetLocation']/span/input"));
	}
	
	
	
	
	
	
}
