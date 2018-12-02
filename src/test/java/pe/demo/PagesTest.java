package pe.demo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pe.pages.PagesConfirmationVuelo;
import pe.pages.PagesLogin;
import pe.pages.PagesLogon;
import pe.pages.PagesPurchaseVuelo;
import pe.pages.PagesRegister;
import pe.pages.PagesReservation;
import pe.pages.PagesReservationVuelo;
import pe.pages.PagesSuccess;
import pe.util.TestUtils;

public class PagesTest {
	
	public WebDriver driver;
		
	@BeforeMethod
	public void setUp(){
	System.setProperty("webdriver.chrome.driver", "H:\\webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
	}
		
//	@Test
//	public void inicio() {
//		PagesLogin pagesLogin = new PagesLogin(driver);
//		pagesLogin.login("user", "user");		
//		PagesLogon pagesLogon = new PagesLogon(driver);
//		pagesLogon.assertLogonPage();
//		pagesLogon.linkRegister();
//		PagesRegister pagesRegister = new PagesRegister(driver);
//		pagesRegister.assertRegisterPage();
//		pagesRegister.registrarContacto("Jorge", "Sanchez", "898340644", "jsanchez", "address 1 ", "address 2", "Lima", "Huaral", 
//				"12", "ALBANIA", "jsanchez@gmail.com", "1359", "1359");
//		pagesRegister.submitRegister();
//		PagesSuccess pagesSuccess = new PagesSuccess(driver);
//		pagesSuccess.assertSuccessPage();
//		pagesSuccess.linkSignIn();
//	}
		
//	@Test(priority = 2)
	@Test
	public void finder() {
			PagesLogin pagesLogin = new PagesLogin(driver);
			pagesLogin.login("mercuri", "mercuri");
			//valid that next page is correct(PagesReservation)
			PagesReservation pagesReservation = new PagesReservation(driver);
			pagesReservation.assertReservationPage();		
			pagesReservation.checkRadioType(0);
			pagesReservation.selectPassengers(2);		
			pagesReservation.selectFromPort(3);
			pagesReservation.selectFromMonth(0);
			pagesReservation.selectFromDay(20);
			pagesReservation.selectToPort("London");
			pagesReservation.selectToMonth(11);
			pagesReservation.selectToDay(2);
			pagesReservation.checkServiceClass(0);
			pagesReservation.selectLineAir(1);		
			pagesReservation.submitReservar();
			//valid that next page is correct(PagesReservationVuelo)
			PagesReservationVuelo pagesReservationVuelo = new PagesReservationVuelo(driver);
			pagesReservationVuelo.assertReservationVueloPage();			
			pagesReservationVuelo.checkRadioDepart(3);
			pagesReservationVuelo.checkRadioReturn(1);
			pagesReservationVuelo.submitReservarVuelo();
			//valid that next page is correct(PagesPurchaseVuelo)
			PagesPurchaseVuelo pagesPurchaseVuelo = new PagesPurchaseVuelo(driver);
			pagesPurchaseVuelo.assertPagesPurchaseVuelo();
			//data load
			pagesPurchaseVuelo.inFirstName("Mario");
			pagesPurchaseVuelo.inLastName("Zumaran");
			pagesPurchaseVuelo.selectCardType(5);
			pagesPurchaseVuelo.selectExpireMoth("02");
			pagesPurchaseVuelo.selectExpireYear("2010");
			pagesPurchaseVuelo.checkRadioBillingAddress(true);
			pagesPurchaseVuelo.selectBillCountry(8);
			pagesPurchaseVuelo.checkRadioDeliveryAddress(true);
			pagesPurchaseVuelo.submitBuyFlights();		
			//valid that next page is correct(PagesConfirmationVuelo)
			PagesConfirmationVuelo pagesConfirmationVuelo = new PagesConfirmationVuelo(driver);
			pagesConfirmationVuelo.assertPagesConfirmationVuelo();
		}
		
		@AfterMethod
		public void tearDown(){	
			driver.close();
		}

	}
