package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement logInButton;
	WebElement userNameInputField;
	WebElement passwordInputField;
	WebElement logOutLabel;
	WebElement noCredentialsLabel;
	WebElement wrongCredentialsLabel;
	WebElement logOutButton;
	WebElement logInLabel; 

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLogInButton() {
		return driver.findElement(By.name("login"));
	}

	public WebElement getUserNameInputField() {
		return driver.findElement(By.id("username"));
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getLogOutLabel() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/p[1]/a"));
	}
	
	public WebElement getNoCredentialsLabel() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/div/ul/li"));
	}
	
	public WebElement getWrongCredentialsLabel() {
		return driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/main/article/div/div/div/ul/li/strong"));
	}
	public WebElement getLogOutButton() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/nav/ul/li[6]/a"));
	}
	public WebElement getLogInLabel() {
		return driver.findElement(By.xpath("//*[@id=\"post-10\"]/div/div/h2"));
	}


	public void insertUsername(String korisnickoIme) {
		this.getUserNameInputField().clear();
		this.getUserNameInputField().sendKeys(korisnickoIme);
	}
	
	public void insertPassword(String lozinka) {
		this.getPasswordInputField().sendKeys(lozinka);
	}
	
	public void clickLogInButton() {
		this.getLogInButton().click();
	}
	public void clickLogOutButton() {
		this.getLogOutButton().click();
	}
	public void logIn(String username, String password) {
		this.getUserNameInputField().sendKeys(username);
		this.getPasswordInputField().sendKeys(password);
		this.logInButton.click();
	}

}
