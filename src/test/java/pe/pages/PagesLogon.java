package pe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PagesLogon {

	private WebDriver driver;
	private By titleText;
	private By linkRegister;
	
	public PagesLogon(WebDriver driver) {
		this.driver = driver;
		this.titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b");
		this.linkRegister= By.linkText("registration form"); 
	}
	
	public void assertLogonPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Welcome back to Mercury Tours!"));
		
	}
	
	public void linkRegister() {
		WebElement registerLink = driver.findElement(linkRegister);
		registerLink.click();
	}
}
