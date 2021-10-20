package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter, Actions actionProvider) {
		super(driver, js, waiter, actionProvider);
	}
	
//	METHODS
	
	public void uploadProfilePicture(String imgName) throws IOException, AWTException, InterruptedException {
		actionProvider.moveToElement(this.getProfileImgArea()).build().perform();
		this.getImageUploadButton().click();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		String imgPath = new File(System.getProperty("user.dir") + "/img/" + imgName).getAbsolutePath();
		this.getImageInput();
		this.getImageInput().sendKeys(imgPath);
		Thread.sleep(1000);
	}
	
	public void removeProfilePicture() throws InterruptedException {
		actionProvider.moveToElement(this.getProfileImgArea()).build().perform();
		this.getImageRemoveButton().click();
		Thread.sleep(1000);
	}
	
	public void editUserInfo(String fName, String lName, String address, String phone, String zipCode,
			String countryName, String stateName, String cityName) throws InterruptedException {
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
		Thread.sleep(500);
		Select state = new Select(this.getStateSelect());
		state.selectByVisibleText(stateName);
		Select city = new Select(this.getCitySelect());
		city.selectByVisibleText(cityName);
		this.getSaveButton().click();
	}
		
	
//	GETTERS

	public WebElement getFirstNameInput() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastNameInput() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
	}
	
	public WebElement getPhone() {
		return this.driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZip() {
		return this.driver.findElement(By.name("user_zip"));
	}

	public WebElement getImageUploadButton() {
		return this.driver.findElement(By.className("upload"));
	}
	
	public WebElement getImageRemoveButton() {
		return this.driver.findElement(By.className("remove"));
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
	
	public WebElement getSaveButton() {
		return this.getAddress().findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[5]/div/fieldset/input"));
	}
	
	public WebElement getProfileImgArea() {
		return this.driver.findElement(By.xpath("//*[@id=\"profileInfo\"]/div/div[1]/img"));
	}
	
	public WebElement getImageInput() {
		return this.driver.findElement(By.xpath("//*[@id='form-upload']/input"));
	}
	
	
	
	
}
