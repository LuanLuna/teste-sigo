package br.com.huetech.calcdescontos.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.EditSistemaDeAbastecimento;
import br.com.arvitech.cagepa.sigo.pages.MenuCadastros;
import br.com.arvitech.cagepa.sigo.pages.MenuSigo;
import br.com.arvitech.cagepa.sigo.pages.NewSistemaDeAbastecimento;
import br.com.arvitech.cagepa.sigo.pages.SistemaDeAbastecimentoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SistemaDeAbastecimento extends BaseTestCase {
	private MenuSigo menuSigo;
	private MenuCadastros menuCadastros;
	private SistemaDeAbastecimentoPage sistemaDeAbastecimentoPage;
	
	private NewSistemaDeAbastecimento newSistemaDeAbastecimento;
	private EditSistemaDeAbastecimento editSistemaDeAbastecimento;
	private String baseIframeId = "//iframe[@id='iframe_item_21']";
	private String applicationIframeId = "iframe_item_6";

	@Before
	public void init() throws InterruptedException {
		driver = Selenium.getDriver();
		goToBaseIframe();
		menuSigo = new MenuSigo();
		menuSigo.openMenuCadastros();
		menuCadastros = new MenuCadastros();
		menuCadastros.openManterSistemaDeAbastecimento();
	}

	@Test
	public void test1_Arv34_IncluirSistemaDeAbastecimento() throws InterruptedException {
		synchronized (driver) {
			Selenium.sleep();
			driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
			sistemaDeAbastecimentoPage = new SistemaDeAbastecimentoPage();
			sistemaDeAbastecimentoPage.openIncluirSistemaDeAbastecimento();
			Selenium.sleep();
			
			newSistemaDeAbastecimento = new NewSistemaDeAbastecimento();
//			String result = 
			newSistemaDeAbastecimento.incluirSistemaDeAbastecimento();
//			Assert.assertEquals("Sistema cadastrado com sucesso!", result);
			
//			This part is different because, this application dont behave like the others, on conclusion include
			Selenium.sleep();
			newSistemaDeAbastecimento.clickCancel();
			sistemaDeAbastecimentoPage.goToLastPage();
			Selenium.sleep();
			Assert.assertEquals(sistemaDeAbastecimentoPage.getLastRowName(), NewSistemaDeAbastecimento.getNomeValue());
		}
	}

	@Test
	public void test2_Arv20_InativarSIstemaDeAbastecimento() throws InterruptedException {
		synchronized (driver) {
			Selenium.sleep();
			driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
			Selenium.sleep();
			sistemaDeAbastecimentoPage = new SistemaDeAbastecimentoPage();
			sistemaDeAbastecimentoPage.goToLastPage();
			Selenium.sleep();
			Assert.assertEquals(sistemaDeAbastecimentoPage.getLastRowName(), NewSistemaDeAbastecimento.getNomeValue());
			sistemaDeAbastecimentoPage.openLastRow();
			Selenium.sleep();
			
			editSistemaDeAbastecimento = new EditSistemaDeAbastecimento();
			editSistemaDeAbastecimento.clickDelete();
			Selenium.getDriver().switchTo().alert().accept();
			Selenium.sleep();
			goToApplicationIframe();
			Selenium.sleep();
			
			editSistemaDeAbastecimento.clickBack();
			Assert.assertFalse(sistemaDeAbastecimentoPage.getLastRowName() == NewSistemaDeAbastecimento.getNomeValue());
			Selenium.sleep();
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
