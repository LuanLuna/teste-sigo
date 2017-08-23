package br.com.huetech.calcdescontos.test.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;

import br.com.arvitech.cagepa.sigo.Property;
import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.huetech.calcdescontos.test.calculos.TestCalculosDescontosIT;
import br.com.huetech.calcdescontos.test.contato.TestTiposMensangensContatoIT;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestTiposMensangensContatoIT.class,
	TestCalculosDescontosIT.class
})

public class AllTests {
protected static WebDriver driver;
	
	public static Boolean isAllTestsExecution = false;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		isAllTestsExecution = true;
		driver = Selenium.getDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Property.URL);
	}

	@AfterClass
	public static void afterClass() throws Exception {
		Selenium.resetDriver();
	}

}
