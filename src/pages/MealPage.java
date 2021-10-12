package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor js, WebDriverWait waiter) {
		super(driver, js, waiter);
	}

//	METHODS
	
	public void addFoodToCart(String amount) {
		this.getFoodQuantityInput().clear();
		this.getFoodQuantityInput().sendKeys(amount);
		this.getAddToCartButton().click();
	}
	
	public void addFoodToFavorites() {
		this.getFavoriteButton().click();
	}
	
//	GETTERS
	
	public WebElement getFoodQuantityInput() {
		return this.driver.findElement(By.className("product_qty"));
	}
	
	public WebElement getFavoriteButton() {
		return this.driver.findElement(By.className("item_153"));
	}
	
	public WebElement getAddToCartButton() {
		return this.driver.findElement(By.xpath("//div[@class='price-feature--wrapper']/div[2]/a"));
	}
	
	
	
	
}
