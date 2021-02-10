package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement cartTab;
	WebElement myAccountTab;
	WebElement shopTab;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getCartTab() {
		return driver.findElement(By.className("page-item-8"));
	}

	public WebElement getMyAccauntTab() {
		return driver.findElement(By.className("page-item-10"));
	}


	public WebElement getShopTab() {
		return driver.findElement(By.className("page-item-7"));
	}

	public void navigateToMyAccount() {
		this.getMyAccauntTab().click();
	}
	
	public void navigateToShop() {
		this.getShopTab().click();
	}
	
	public void navigateToCart() {
		this.getCartTab().click();
	}
}
