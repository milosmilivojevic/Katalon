package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	WebElement flyngNinjaProductLabel;
	WebElement removeProductButton;
	WebElement cartEmptyLabel;
	WebElement cartTotal;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRemoveProductButton() {
		return driver.findElement(By.className("remove"));
	}

	public WebElement getFlyngNinjaProductLabel() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/form/table/tbody/tr[1]/td[3]/a"));
	}
	
	public WebElement getCartEmptyLabel() {
		return driver.findElement(By.className("cart-empty"));
	}

	public WebElement getCartTotal() {
		return driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div[2]/div[2]/table/tbody/tr[3]/td"));
		
	}

	public void clickRemoveProductButton() {
		this.getRemoveProductButton().click();
	}
	
	
}
