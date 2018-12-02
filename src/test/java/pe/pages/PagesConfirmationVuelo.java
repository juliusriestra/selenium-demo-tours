package pe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PagesConfirmationVuelo {

	private WebDriver driver;
	private By titleText;
	
	public PagesConfirmationVuelo(WebDriver driver) {
		this.driver = driver;
		this.titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]");
	}
	
	public void assertPagesConfirmationVuelo() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Your itinerary has been booked!"));
	}
}
