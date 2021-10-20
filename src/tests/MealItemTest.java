package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {

	@Test
	public void addMealToCartTest() throws InterruptedException {
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPage.clickLocationSelectClose();
		mealPage.addFoodToCart("2");
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("The Following Errors Occurred:"),
				"[ERROR] Unexpected add food fail message");
		Assert.assertTrue(notificationPage.getMessageText().contains("Please Select Location"),
				"[ERROR] Unexpected add food to cart fail message");
		
		notificationPage.MessageWaitDisappear();
		locationPage.clickLocationSelect();
		locationPage.setLocation("City Center - Albany");
		
		mealPage.addFoodToCart("2");
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Meal Added To Cart"),
				"[ERROR] Unexpected add food to cart message");
	}
	
	@Test
	public void addMealToFavoriteTest() {
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		locationPage.clickLocationSelectClose();
		
		mealPage.addFoodToFavorites();
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Please login first!"),
				"[ERROR] Unexpected add food to favorites message");
		
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		loginPage.login(email, password);
		
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		
		mealPage.addFoodToFavorites();
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Product has been added to your favorites."),
				"[ERROR] Unexpected add food to favorites message");
	}

	@Test
	public void clearCartTest() throws IOException {
		driver.get("http://demo.yo-meals.com/meals");
		locationPage.setLocation("City Center - Albany");
		SoftAssert sa = new SoftAssert();
		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheetMeals = wb.getSheet("Meals");
		
		String firstMeal = sheetMeals.getRow(1).getCell(0).getStringCellValue();
		String secondMeal = sheetMeals.getRow(2).getCell(0).getStringCellValue();
		String thirdMeal = sheetMeals.getRow(3).getCell(0).getStringCellValue();
		String fourthMeal = sheetMeals.getRow(4).getCell(0).getStringCellValue();
		String fifthMeal = sheetMeals.getRow(5).getCell(0).getStringCellValue();
		
		driver.get(firstMeal);
		mealPage.addFoodToCart("2");
		sa.assertTrue(notificationPage.getMessageText().contains("Meal Added To Cart"),
				"[ERROR] Unexpected add food to cart message");
		
		driver.get(secondMeal);
		mealPage.addFoodToCart("1");
		sa.assertTrue(notificationPage.getMessageText().contains("Meal Added To Cart"),
				"[ERROR] Unexpected add food to cart message");
		
		driver.get(thirdMeal);
		mealPage.addFoodToCart("3");
		sa.assertTrue(notificationPage.getMessageText().contains("Meal Added To Cart"),
				"[ERROR] Unexpected add food to cart message");
		
		driver.get(fourthMeal);
		mealPage.addFoodToCart("2");
		sa.assertTrue(notificationPage.getMessageText().contains("Meal Added To Cart"),
				"[ERROR] Unexpected add food to cart message");
		
		driver.get(fifthMeal);
		mealPage.addFoodToCart("4");
		sa.assertTrue(notificationPage.getMessageText().contains("Meal Added To Cart"),
				"[ERROR] Unexpected add food to cart message");
		
		sa.assertAll();
		
		cartPage.clearCart();
		Assert.assertTrue(notificationPage.getMessageText().contains("All meals removed from Cart successfully"),
				"[ERROR] Unexpected clear cart message");
		
		wb.close();
	}


	
	
	
	
	
	
}
