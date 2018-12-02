package pe.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PagesReservationVuelo {
	private WebDriver driver;
	private By titleText;
	private By departFlightDrop;
	private By returnFlightDrop;
	private By reserveFlightsButton;
	
	public PagesReservationVuelo(WebDriver driver) {
		this.driver = driver;
		this.titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		this.departFlightDrop = By.name("outFlight");
		this.returnFlightDrop = By.name("inFlight");
		this.reserveFlightsButton = By.name("reserveFlights");
	}
	
	public void assertReservationVueloPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Select your departure and return flight"));
	}
	
	public void checkRadioDepart(int index) {
		List<WebElement> checkRadioDepart = driver.findElements(departFlightDrop);
		for (int i = 0; i < checkRadioDepart.size(); i++) {
			if (!checkRadioDepart.get(i).isSelected()) {
				checkRadioDepart.get(i).isSelected();
			}
		}
		checkRadioDepart.get(index).click();
	}
	
	public void checkRadioReturn(int num) {
		List<WebElement> checkRadioReturn = driver.findElements(returnFlightDrop);
		for (WebElement element : checkRadioReturn) {
			if (element.isSelected()) {
				element.click();
			}
		}
		checkRadioReturn.get(num).click();
	}
	
	public void submitReservarVuelo(){
		WebElement submitReservarVuelo = driver.findElement(reserveFlightsButton);
		submitReservarVuelo.click();
	}
}
