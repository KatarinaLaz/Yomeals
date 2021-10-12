package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}
	
//	METHODS
	
	public void uploadProfilePicture(String imgSource) {
		js.executeScript("arguments[0].click()", this.getImageUploadButton());
		File image = new File(imgSource);
		String imgPath = image.getAbsolutePath();
		this.getImageUploadButton().sendKeys(imgPath);
	}
	
	public void removeProfilePicture() {
		js.executeScript("arguments[0].click()", this.getImageRemoveButton());
	}
	
	public void editUserInfo(String fName, String lName, String address, String phone, String zipCode, String countryName, String stateName, String cityName) {
		this.getFirstNameInput().clear();
		this.getFirstNameInput().sendKeys(fName);
		this.getLastNameInput().clear();
		this.getLastNameInput().sendKeys(lName);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhone().clear();
		this.getPhone().sendKeys(phone);
		this.getZip().clear();
		this.getZip().sendKeys(zipCode);
		Select country = new Select(this.getCountrySelect());
		country.selectByVisibleText(countryName);
		Select state = new Select(this.getStateSelect());
		state.selectByVisibleText(stateName);
		Select city = new Select(this.getCitySelect());
		city.selectByVisibleText(cityName);
	}
		
	
//	GETTERS

	public WebElement getFirstNameInput() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastNameInput() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getAddress() {
		return this.getAddress().findElement(By.name("user_address"));
	}
	
	public WebElement getPhone() {
		return this.getAddress().findElement(By.name("user_phone"));
	}
	
	public WebElement getZip() {
		return this.getAddress().findElement(By.name("user_zip"));
	}

	public WebElement getImageUploadButton() {
		return this.driver.findElement(By.className("upload"));
	}
	
	public WebElement getImageRemoveButton() {
		return this.getAddress().findElement(By.className("remove"));
	}
	
	public WebElement getCountrySelect() {
		return this.driver.findElement(By.name("user_country_id"));
	}
	
	public WebElement getStateSelect() {
		return this.driver.findElement(By.name("user_state_id"));
	}
	
	public WebElement getCitySelect() {
		return this.driver.findElement(By.name("user_city"));
	}
	
	
	
	
	
	
}
