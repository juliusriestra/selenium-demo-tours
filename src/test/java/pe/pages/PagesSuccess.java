package pe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PagesSuccess {
	
	private WebDriver driver;
	private By titleText;
	private By linkSignIn;
	
	public PagesSuccess(WebDriver driver) {
		this.driver = driver;
		this.titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font");
		this.linkSignIn= By.linkText("sign-in"); 
	}
	
	public void assertSuccessPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Thank you for registering"));
	}
	
	public void linkSignIn() {
		WebElement registerLink = driver.findElement(linkSignIn);
		registerLink.click();
	}

}
