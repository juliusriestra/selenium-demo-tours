package pe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PagesPurchaseVuelo {

	private WebDriver driver;
	private By titleText;
	private By passFirst0Text;
	private By passLast0Text;
	private By mealDrop;
	private By creditCardDrop;
	private By creditnumberText;
	private By cc_exp_dt_mnDrop;
	private By cc_exp_dt_yrDrop;
	private By ticketLessChk1;
	private By billCountryDrop;
	private By ticketLessChk2;
	private By delCountryDrop;
	private By buyFlightsButton;

	public PagesPurchaseVuelo(WebDriver driver) {
		this.driver = driver;     
		this.titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		this.passFirst0Text = By.name("passFirst0");
		this.passLast0Text = By.name("passLast0");
		this.mealDrop = By.tagName("select");
		this.creditCardDrop = By.name("creditCard");
		this.creditnumberText = By.name("creditnumber");
		this.cc_exp_dt_mnDrop = By.name("cc_exp_dt_mn");
		this.cc_exp_dt_yrDrop = By.name("cc_exp_dt_yr");
		this.ticketLessChk1 = By.xpath("//input[@type='checkbox']");
		this.billCountryDrop = By.name("billCountry");
		this.ticketLessChk2 = By.xpath("//input[@type='checkbox' and @name='ticketLess']");
		this.delCountryDrop = By.name("delCountry");
		this.buyFlightsButton = By.name("buyFlights");
	}
	
	public void assertPagesPurchaseVuelo() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Please review your travel itinerary and make your purchase"));
	}
//	Passengers
	public void inFirstName(String firstname) {
		WebElement inFirstName = driver.findElement(passFirst0Text);
		inFirstName.sendKeys(firstname);
	}
	
	public void inLastName(String lastname) {
		WebElement inLastName = driver.findElement(passLast0Text);
		inLastName.sendKeys(lastname);
	}
//	Credit Card
	public void selectCardType(int index) {
		Select selectCardType = new Select(driver.findElement(creditCardDrop));
		selectCardType.selectByIndex(index);
	}
	
	public void selectExpireMoth(String valor) {				
		Select selectExpireMoth = new Select(driver.findElement(cc_exp_dt_mnDrop));
		selectExpireMoth.selectByVisibleText(valor);
	}
	
	public void selectExpireYear(String fecha) {
		Select selectExpireYear = new Select(driver.findElement(cc_exp_dt_yrDrop));
		selectExpireYear.selectByVisibleText(fecha);
	}
//	Billing Address
	public void checkRadioBillingAddress(boolean isChecked) {
		WebElement checkRadioBilling = driver.findElement(ticketLessChk1);
		isChecked = checkRadioBilling.isSelected();
		if (!isChecked) {
			checkRadioBilling.click();
		} 		
	}
	
	public void selectBillCountry(int num) {
		Select selectBillCountry = new Select(driver.findElement(billCountryDrop));
		selectBillCountry.selectByValue(Integer.toString(num));
	}
	
	public void checkRadioDeliveryAddress(boolean isChecked) {
		WebElement checkRadioDelivery = driver.findElement(ticketLessChk2);
		isChecked = checkRadioDelivery.isSelected();
		if (!isChecked) {
			checkRadioDelivery.click();
		} 		
	}
	
	public void selectDeliveryCountry(int num) {
		Select selectDeliveryCountry = new Select(driver.findElement(delCountryDrop));
		selectDeliveryCountry.selectByValue(Integer.toString(num));
	}
	
	public void submitBuyFlights() {
		WebElement submitBuyFlights = driver.findElement(buyFlightsButton);
		submitBuyFlights.click();
	}
}
