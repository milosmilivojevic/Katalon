package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.CartPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.ShopPage;



public class BaseTest {
	WebDriver driver;
	MyAccountPage myAccountPage;
	MainPage mainPage;
	ExcelReader excelReader;
	ShopPage shopPage;
	CartPage cartPage;
	
	
	
	@BeforeClass
	public void beforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.myAccountPage = new MyAccountPage(driver);
		this.mainPage = new MainPage(driver);
		this.excelReader = new ExcelReader("data\\test plan.xlsx");
		this.shopPage = new ShopPage(driver);
		this.cartPage = new CartPage(driver);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
		
	}
	
	
}
