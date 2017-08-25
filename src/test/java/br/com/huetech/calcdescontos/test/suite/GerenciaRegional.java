package br.com.huetech.calcdescontos.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.EditGerenciaRegional;
import br.com.arvitech.cagepa.sigo.pages.GerenciaRegionalPage;
import br.com.arvitech.cagepa.sigo.pages.MenuCadastros;
import br.com.arvitech.cagepa.sigo.pages.MenuSigo;
import br.com.arvitech.cagepa.sigo.pages.NewGerenciaRegional;

public class GerenciaRegional extends BaseTestCase {
	private MenuSigo menuSigo;
	private MenuCadastros menuCadastros;
	private GerenciaRegionalPage gerenciaRegionalPage;
	
	private NewGerenciaRegional newGerenciaRegional;
	private EditGerenciaRegional editGerenciaRegional;
	private String baseIframeId = "//iframe[@id='iframe_item_21']";
	private String applicationIframeId = "iframe_item_1";

	@Before
	public void init() throws InterruptedException {
		driver = Selenium.getDriver();
		goToBaseIframe();
		menuSigo = new MenuSigo();
		menuSigo.openMenuCadastros();
		menuCadastros = new MenuCadastros();
		menuCadastros.openManterGerenciaRegional();
	}

	@Test
	public void Arv1_GerenciaRegional() throws InterruptedException {
		synchronized (driver) {
			Selenium.sleep();
			driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
			gerenciaRegionalPage = new GerenciaRegionalPage();
			gerenciaRegionalPage.openIncluirGerenciaRegional();
			Selenium.sleep();
			
			newGerenciaRegional = new NewGerenciaRegional();
			String result = newGerenciaRegional.incluirGerenciaRegional();
			Assert.assertEquals("Gerência Regional cadastrada com sucesso!", result);
		}
	}

	@Test
	public void Arv2_InativarGerenciaRegional() throws InterruptedException {
		synchronized (driver) {
			Selenium.sleep();
			driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
			Selenium.sleep();
			gerenciaRegionalPage = new GerenciaRegionalPage();
			gerenciaRegionalPage.goToLastPage();
			Selenium.sleep();
			Assert.assertEquals(gerenciaRegionalPage.getLastRowName(), NewGerenciaRegional.getNomeValue());
			gerenciaRegionalPage.openLastRow();
			Selenium.sleep();
			editGerenciaRegional = new EditGerenciaRegional();
			editGerenciaRegional.clickDelete();
			Selenium.getDriver().switchTo().alert().accept();
			Selenium.sleep();
			goToApplicationIframe();
			Selenium.sleep();
			editGerenciaRegional.clickBack();
			Assert.assertFalse(gerenciaRegionalPage.getLastRowName() == NewGerenciaRegional.getNomeValue());
		}
	}
	
	private void goToApplicationIframe() {
		goToBaseIframe();
		driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
	}
	
	private void goToBaseIframe() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(baseIframeId)));
	}
}
