package tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	

	@Test
	public void editProfileTest() throws InterruptedException {
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		locationPage.clickLocationSelectClose();
		loginPage.login(email, password);
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Login Successfull"), "[ERROR] Unexpected logint message");
		
		driver.get("http://demo.yo-meals.com/member/profile");
		profilePage.editUserInfo("Zika", "Zikic", "Zikina ulica 5", "062358296", "13450", "United Kingdom", "Belfast", "Holywood");
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Setup Successful"), "[ERROR] Unexpected setup message");
		
		authPage.logout();
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Logout Successfull!"), "[ERROR] Unexpected logout message");
	}
	
	@Test
	public void changeProfileImageTest() throws IOException, AWTException, InterruptedException {
		driver.get("http://demo.yo-meals.com/guest-user/login-form");
		locationPage.clickLocationSelectClose();
		loginPage.login(email, password);
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Login Successfull"), "[ERROR] Unexpected login message");
		
		driver.get("http://demo.yo-meals.com/member/profile");
		profilePage.uploadProfilePicture("profileIMG.jpg");
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Profile Image Uploaded Successfully"),
						"[ERROR] Unexpected image upload message");
		
		notificationPage.MessageWaitDisappear();
		profilePage.removeProfilePicture();
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Profile Image Deleted Successfully"),
						"[ERROR] Unexpected image remove message");
		
		notificationPage.MessageWaitDisappear();
		authPage.logout();
		
		notificationPage.SuccessMessageWait();
		Assert.assertTrue(notificationPage.getMessageText().contains("Logout Successfull!"), "[ERROR] Unexpected logout message");
		
	}
	
	
	
	
	
	
	
}
