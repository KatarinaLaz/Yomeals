package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter, Actions actionProvider) {
		super(driver, js, waiter, actionProvider);
	}

//	METHODS
	
	public void addFoodToCart(String amount) {
		this.getFoodQuantityInput();
		this.getFoodQuantityInput().sendKeys(Keys.CONTROL + "a");;
		this.getFoodQuantityInput().sendKeys(amount);
		this.getAddToCartButton();
		this.getAddToCartButton().click();
	}
	
	public void addFoodToFavorites() {
		this.getFavoriteButton();
		this.getFavoriteButton().click();
	}
	
	
	//*[@id="body"]/section[1]/div/div/div[2]/div/div[3]/div[2]/a
	//*[@id="body"]/section[1]/div/div/div[2]/div/div[3]/div[2]/a
	
//	GETTERS
	
	public WebElement getFoodQuantityInput() {
		return this.driver.findElement(By.xpath("//*[@id='body']/section[1]/div/div/div[2]/div/div[3]/div[1]/ul/li[3]/input"));
	}
	
	public WebElement getFavoriteButton() {
		return this.driver.findElement(By.className("itemfav"));
	}
	
	public WebElement getAddToCartButton() {
		return this.driver.findElement(By.className("js-proceedtoAddInCart"));
	}
	
	
	
	
}
