package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProductTests extends BaseTest{
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://cms.demo.katalon.com/");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void addProductToCart() throws InterruptedException {
		String productName = excelReader.getData("addProductToCart", 5, 2);
		Thread.sleep(1500);
		shopPage.addProduct1ToCart();
		Thread.sleep(1500);
		mainPage.navigateToCart();
		Thread.sleep(1500);
		String textForAssert = cartPage.getFlyngNinjaProductLabel().getText();
		Assert.assertEquals(textForAssert, productName);
		}
	@Test (priority = 1)
	public void deleteProductFromCart() throws InterruptedException {
		String emptyCartLabel = excelReader.getData("deleteProductFromCart", 6, 2);
		addProductToCart();
		Thread.sleep(2000);
		cartPage.clickRemoveProductButton();
		Thread.sleep(2000);
		String textForAssert = cartPage.getCartEmptyLabel().getText();
		Assert.assertEquals(textForAssert, emptyCartLabel);
		}
	@Test (priority = 2)
	public void add3Products() throws InterruptedException {
		String cartSum = excelReader.getData("Add3Products", 8, 2);
		int numberOfCartItems = Integer.valueOf(excelReader.getData("Add3Products", 7, 2));

		Thread.sleep(1500);
		shopPage.addProduct1ToCart();
		Thread.sleep(1500);
		shopPage.addProduct2ToCart();
		Thread.sleep(1500);
		shopPage.addProduct3ToCart();
		Thread.sleep(1500);
		mainPage.navigateToCart();
		Thread.sleep(3000);

		String textForAssert = cartPage.getCartTotal().getText();
		Assert.assertEquals(textForAssert, cartSum);
		
		List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
		Assert.assertTrue(cartItems.size() == numberOfCartItems);
		
		List<WebElement> quantity = driver.findElements(By.className("qty"));
		for (int i = 0; i < quantity.size(); i++) {
			int value = Integer.parseInt(quantity.get(i).getAttribute("value"));
			Assert.assertEquals(value, 1);
		}
		Assert.assertTrue(cartItems.size() == numberOfCartItems);
		
		}
	@Test (priority = 3)
	public void add2Remove1() throws InterruptedException {
		Thread.sleep(1500);
		shopPage.addProduct1ToCart();
		Thread.sleep(1500);
		shopPage.addProduct2ToCart();
		Thread.sleep(1500);
		mainPage.navigateToCart();
		Thread.sleep(1500);
		cartPage.clickRemoveProductButton();
		Thread.sleep(2500);

		List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
		Assert.assertTrue(cartItems.size() == 1);
		}
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
