package pe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PagesRegister {
	private WebDriver driver;
	private By titleText;	
	private By firstNameField;
	private By lastNameField;
	private By phoneField;
	private By emailField;
	private By address1Field;
	private By address2Field;
	private By cityField;
	private By stateField;
	private By postalCodField;
	private By countrySelect;
	private By userNameField;
	private By passwordField;
	private By confirmPasswordField;
	private By registerButtom;
	
	public PagesRegister(WebDriver driver) {
		this.driver = driver;
		this.titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font");
		this.firstNameField = By.name("firstName");
		this.lastNameField = By.name("lastName"); 
		this.phoneField = By.name("phone");
		this.emailField = By.name("userName");
		this.address1Field = By.name("address1");
		this.address2Field = By.name("address2");
		this.cityField = By.name("city");
		this.stateField = By.name("state");
		this.postalCodField = By.name("postalCode");
		this.countrySelect = By.name("country");
		this.userNameField = By.name("email");
		this.passwordField = By.name("password");
		this.confirmPasswordField = By.name("confirmPassword");
		this.registerButtom = By.name("register");
	}
		
	public void assertRegisterPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("To create your account"));
	}
	
	public void registrarContacto(String firstname,String lastname,String phone,String userName,String address1,
			String address2,String city,String state,String postalCod,String country,String email,String password,String confirmPassword) {
		driver.findElement(firstNameField).sendKeys(firstname);
		driver.findElement(lastNameField).sendKeys(lastname);
		driver.findElement(phoneField).sendKeys(phone);
		driver.findElement(userNameField).sendKeys(userName);
		driver.findElement(address1Field).sendKeys(address1);
		driver.findElement(address2Field).sendKeys(address2);
		driver.findElement(cityField).sendKeys(city);
		driver.findElement(stateField).sendKeys(state);
		driver.findElement(postalCodField).sendKeys(postalCod);
		Select selectCountry = new Select(driver.findElement(countrySelect));
		selectCountry.selectByVisibleText(country);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	}
	
	public void submitRegister(){
		WebElement submitRegister = driver.findElement(registerButtom);
		submitRegister.click();
	}
	
}	
