package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
	WebDriver driver;
	WebElement product1AddToCardButton;
	WebElement product2AddToCardButton;
	WebElement product3AddToCardButton;
	
	public ShopPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getProduct1AddToCardButton() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[1]/div/a[2]"));
	}
	
	public WebElement getProduct2AddToCardButton() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[2]/div/a[2]"));
	}

	public WebElement getProduct3AddToCardButton() {
		return driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/ul/li[3]/div/a[2]"));
	}
	public void addProduct1ToCart() {
		getProduct1AddToCardButton().click();
	}
	public void addProduct2ToCart() {
		getProduct2AddToCardButton().click();
	}
	public void addProduct3ToCart() {
		getProduct3AddToCardButton().click();
	}
}
