package br.com.huetech.calcdescontos.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuCadastros;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuSigo;
import br.com.arvitech.cagepa.sigo.pages.servico.EditServicoPage;
import br.com.arvitech.cagepa.sigo.pages.servico.NewServicoPage;
import br.com.arvitech.cagepa.sigo.pages.servico.ServicoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Servico extends BaseTestCase {
	private MenuSigo menuSigo;
	private MenuCadastros menuCadastros;
	private ServicoPage servicoPage;
	
	private NewServicoPage newServico;
	private EditServicoPage editServico;
	private String baseIframeId = "//iframe[@id='iframe_item_21']";
	private String applicationIframeId = "iframe_item_3";

	@Before
	public void init() throws InterruptedException {
		driver = Selenium.getDriver();
		goToBaseIframe();
		menuSigo = new MenuSigo();
		menuSigo.openMenuCadastros();
		menuCadastros = new MenuCadastros();
		menuCadastros.openManterServico();
	}

	@Test
	public void test1_Arv36_IncluirServico() throws InterruptedException {
		synchronized (driver) {
			Selenium.sleep();
			driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
			servicoPage = new ServicoPage();
			servicoPage.openIncluirServico();
			Selenium.sleep();
			
			newServico = new NewServicoPage();
//			String result = 
			newServico.incluirServico();
//			Assert.assertEquals("Sistema cadastrado com sucesso!", result);
			
//			This part is different because, this application dont behave like the others, on conclusion include
			Selenium.sleep();
			newServico.clickCancel();
			servicoPage.goToLastPage();
			Selenium.sleep();
			Assert.assertEquals(servicoPage.getLastRowName(), NewServicoPage.getDescricaoValue());
		}
	}

	@Test
	public void test2_Arv14_InativarServico() throws InterruptedException {
		synchronized (driver) {
			Selenium.sleep();
			driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
			Selenium.sleep();
			servicoPage = new ServicoPage();
			servicoPage.goToLastPage();
			Selenium.sleep();
			Assert.assertEquals(servicoPage.getLastRowName(), NewServicoPage.getDescricaoValue());
			servicoPage.openLastRow();
			Selenium.sleep();
			
			editServico = new EditServicoPage();
			editServico.clickDelete();
			Selenium.getDriver().switchTo().alert().accept();
			Selenium.sleep();
			goToApplicationIframe();
			Selenium.sleep();
			
			editServico.clickBack();
			Assert.assertFalse(servicoPage.getLastRowName() == NewServicoPage.getDescricaoValue());
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
