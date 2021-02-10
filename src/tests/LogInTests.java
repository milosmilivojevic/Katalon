package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogInTests extends BaseTest{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void logIn() throws InterruptedException {
		String username = excelReader.getData("LogIn", 5, 2);
		String password = excelReader.getData("LogIn", 6, 2);
		String logOutText = excelReader.getData("LogIn", 9, 2);

		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		myAccountPage.insertUsername(username);
		myAccountPage.insertPassword(password);
		Thread.sleep(2000);
		myAccountPage.clickLogInButton();
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getLogOutLabel().getText();
		Assert.assertEquals(textForAssert, logOutText);
		
		}
	
	@Test (priority = 1)
	public void logInFail() throws InterruptedException {
		String username = excelReader.getData("WrongCredentials", 3, 2);
		String password = excelReader.getData("WrongCredentials", 4, 2);
		String errorLabel = excelReader.getData("WrongCredentials", 7, 2);

		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		myAccountPage.insertUsername(username);
		Thread.sleep(2000);
		myAccountPage.insertPassword(password);
		Thread.sleep(2000);
		myAccountPage.clickLogInButton();
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getWrongCredentialsLabel().getText();
		Assert.assertEquals(textForAssert, errorLabel);
		}
	@Test (priority = 2)
	public void logInBlank() throws InterruptedException {
		String errorLabel = excelReader.getData("LogInBlank", 5, 2);
		mainPage.navigateToMyAccount();
		Thread.sleep(2000);
		myAccountPage.clickLogInButton();
		Thread.sleep(2000);
		
		String textForAssert = myAccountPage.getNoCredentialsLabel().getText();
		Assert.assertEquals(textForAssert, errorLabel);
		}
	@Test (priority = 3)
	public void logOut() throws InterruptedException {
		String LoginText = excelReader.getData("LogOut", 10, 2);
		logIn();
		myAccountPage.clickLogOutButton();
		Thread.sleep(2000);
		String textForAssert = myAccountPage.getLogInLabel().getText();
		Assert.assertEquals(textForAssert, LoginText);
		
		}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
