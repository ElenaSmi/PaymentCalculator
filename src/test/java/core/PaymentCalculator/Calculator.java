package core.PaymentCalculator;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calculator {
	
	static WebDriver driver = new FirefoxDriver();
	static String baseUrl = "http://www.scion.com/buy/payment_calculator/";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*On load of Payment Calculator, if the user does not have any PC-specific data
	stored in their browser cookie, the "Credit Score" should be set to "Other".*/ 
	
	@Test
	public void testDefaultCreditScore() {
		String creditScore;
		String attribute;
		creditScore = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/form/div[1]"
				+ "/div/div/div/table/tbody/tr[2]/td[2]/select/option[1]")).getText();
		attribute = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/form/div[1]"
				+ "/div/div/div/table/tbody/tr[2]/td[2]/select/option[1]")).getAttribute("selected");
		
		
		assertEquals(creditScore, "OTHER");
		assertEquals(attribute, "selected");
		
		
		
	}

}
