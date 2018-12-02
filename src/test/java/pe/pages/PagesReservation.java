package pe.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PagesReservation {

	private WebDriver driver;
	private By titleText;
	
	private By typeDrop;
	private By passengerDrop;
	private By fromPortDrop;
	private By fromMonthDrop;
	private By fromDayDrop;
	private By toPortDrop;
	private By toMonthDrop;
	private By toDayDrop;
	private By serviceClassDrop;
	private By lineaAirDrop;
	private By findButton;
	
	public PagesReservation(WebDriver driver) {
		this.driver = driver;
		this.titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		this.typeDrop = By.name("tripType");
		this.passengerDrop = By.name("passCount");
		this.fromPortDrop = By.name("fromPort");
		this.fromMonthDrop = By.name("fromMonth");
		this.fromDayDrop = By.name("fromDay");
		this.toPortDrop = By.name("toPort");
		this.toMonthDrop = By.name("toMonth");
		this.toDayDrop = By.name("toDay");
		this.serviceClassDrop = By.name("servClass");
		this.lineaAirDrop = By.name("airline");
		this.findButton = By.name("findFlights");
	}

	public void assertReservationPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Flight Finder to search"));
	}
	
	public void checkRadioType(int num) {
		List<WebElement> checkRadioTypes = driver.findElements(typeDrop);
		for (WebElement element : checkRadioTypes) {
			if (!element.isSelected()) {
				element.click();
			}
		}
		checkRadioTypes.get(num).click();
	}
	
	public void selectPassengers(int cant) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement cantidadPasajeros = wait.until(ExpectedConditions.presenceOfElementLocated(passengerDrop));
		Select selectPasajeros = new Select(cantidadPasajeros);
		selectPasajeros.selectByVisibleText(Integer.toString(cant));
	}
	
	public void selectFromPort(int index) {
		Select selectOrigen = new Select(driver.findElement(fromPortDrop));
		selectOrigen.selectByIndex(index);
	}
	
	public void selectFromMonth(int index) {
		Select selectFromMonth = new Select(driver.findElement(fromMonthDrop));
		selectFromMonth.selectByIndex(index);
	}
	
	public void selectFromDay(int cant) {
		Select selectFromDay = new Select(driver.findElement(fromDayDrop));
		selectFromDay.selectByVisibleText(Integer.toString(cant));
	}
	
	public void selectToPort(String city) {
		Select selectToPort = new Select(driver.findElement(toPortDrop));
		selectToPort.selectByValue(city);
	}
	
	public void selectToMonth(int index) {
		Select selectToMonth = new Select(driver.findElement(toMonthDrop));
		selectToMonth.selectByIndex(index);
	}
	
	public void selectToDay(int cant) {
		Select selectToDay = new Select(driver.findElement(toDayDrop));
		selectToDay.selectByVisibleText(Integer.toString(cant));
	}
	
	public void checkServiceClass(int index) {
		List<WebElement> checkServiceClass = driver.findElements(serviceClassDrop);
		int listSize = checkServiceClass.size();
		for (int i = 0; i < listSize; i++) {
			if (!checkServiceClass.get(i).isSelected()) {
				checkServiceClass.get(i).click();
			}
		}
		checkServiceClass.get(index).click();
	}

	public void selectLineAir(int index) {
		Select selectLineAir = new Select(driver.findElement(lineaAirDrop));
		selectLineAir.selectByIndex(index);
	}
	
	public void submitReservar() {
		WebElement element = driver.findElement(findButton);
		element.click();
	}
	
}
