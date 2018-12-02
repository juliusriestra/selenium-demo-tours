package pe.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PagesLogin {

	private WebDriver driver;
	private By userField;
	private By passField;
	private By loginButton;
	
	public PagesLogin(WebDriver driver) {
		this.driver = driver;
		this.userField = By.name("userName");
		this.passField = By.name("password");
		this.loginButton = By.name("login");
	}
	
	public void login(String user, String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(loginButton).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
