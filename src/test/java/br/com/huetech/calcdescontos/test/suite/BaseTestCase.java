package br.com.huetech.calcdescontos.test.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import br.com.arvitech.cagepa.sigo.Property;
import br.com.arvitech.cagepa.sigo.Selenium;
public class BaseTestCase {
	
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		if (!AllTests.isAllTestsExecution){
			driver = Selenium.getDriver();
			driver.navigate().to(Property.URL);
			driver.manage().window().maximize();
		}
	}
	
	@AfterClass
	public static void afterClass() throws Exception {
		if (!AllTests.isAllTestsExecution){
			Selenium.resetDriver();
		}
	}
}
