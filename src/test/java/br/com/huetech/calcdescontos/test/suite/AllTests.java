package br.com.huetech.calcdescontos.test.suite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.arvitech.cagepa.sigo.Property;
import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.Login;
import br.com.arvitech.cagepa.sigo.pages.MenuSic;

@RunWith(Suite.class)
@Suite.SuiteClasses({
//	SetorDeServico.class,
//	GerenciaRegional.class,
//	SistemaDeAbastecimento.class,
//	Servico.class,
})

public class AllTests {
	static Login loginPage;
	static MenuSic mainPage;
	
	protected static WebDriver driver;
	
	public static Boolean isAllTestsExecution = false;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		isAllTestsExecution = true;
		driver = Selenium.getDriver();
		driver.manage().window().maximize();
		driver.navigate().to(Property.URL);

		loginPage = new Login();
		mainPage = new MenuSic();
		login();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		Selenium.resetDriver();
	}
	
	private static void login() throws InterruptedException {
		synchronized (driver) {
			loginPage.login();
			Selenium.sleep();
			try {
				Selenium.getDriver().switchTo().frame(Selenium.getDriver().findElement(By.xpath("//iframe[@id='TB_iframeContent']")));
				loginPage.confirmLogin();
				Selenium.getDriver().switchTo().defaultContent();
			} catch(Exception e) {}
			mainPage.openMenuSigo();
		}
	}

}
