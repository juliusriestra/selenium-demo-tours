package pe.demo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pe.util.TestUtils;

public class DemoTest {
	
	public WebDriver driver;
		
	@BeforeMethod
	public void setUp(){
	System.setProperty("webdriver.chrome.driver", "H:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("http://newtours.demoaut.com");
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
	}
	
	@DataProvider(name="getDataContacto")
	public Iterator<Object[]> getDataContacto() {
		ArrayList<Object[]> dataTest = TestUtils.getDataFromExcel();
		return dataTest.iterator();
	}
		
	@Test(dataProvider="getDataContacto")
	public void registrarContacto(String firstname,String lastname,String phone,String userName,String address1,String address2,
		String city,String state,String postalCode,String country,String email,String password,String confirmPassword) {
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(postalCode);			
		Select selectCountry = new Select(driver.findElement(By.name("country")));
		selectCountry.selectByVisibleText(country);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
		driver.findElement(By.name("register")).click();
//		PagesSuccess pagesSuccess = new PagesSuccess(driver);
//		pagesSuccess.assertSuccessPage();
		
//		PagesRegister pagesRegister = new PagesRegister(driver);
//		pagesRegister.assertRegisterPage();
//		
//		pagesRegister.registrarContacto(firstname,lastname,phonep,userName,address1,address2,city,state,postalCod,country,email,password,confirmPassword);
//		pagesRegister.submitRegister(); 
	}
				
	@AfterMethod
	public void tearDown(){	
		driver.close();
	}

}
