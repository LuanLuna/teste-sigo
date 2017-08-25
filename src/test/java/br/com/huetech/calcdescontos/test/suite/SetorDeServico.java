package br.com.huetech.calcdescontos.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuCadastros;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuSigo;
import br.com.arvitech.cagepa.sigo.pages.setorservico.EditSetorDeServicoPage;
import br.com.arvitech.cagepa.sigo.pages.setorservico.NewSetorDeServicoPage;
import br.com.arvitech.cagepa.sigo.pages.setorservico.SetorDeServicoPage;

public class SetorDeServico extends BaseTestCase {
	private MenuSigo menuSigo;
	private MenuCadastros menuCadastros;
	private SetorDeServicoPage setorDeServico;
	private NewSetorDeServicoPage newSetorDeServico;
	private EditSetorDeServicoPage editSetorDeServico;
	private String baseIframeId = "//iframe[@id='iframe_item_21']";
	private String applicationIframeId = "iframe_item_2";

	@Before
	public void init() throws InterruptedException {
		driver = Selenium.getDriver();
		goToBaseIframe();
		menuSigo = new MenuSigo();
		menuSigo.openMenuCadastros();
		menuCadastros = new MenuCadastros();
		menuCadastros.openManterSetorDeServico();
	}

	@Test
	public void Arv33_IncluirSetorDeServico() throws InterruptedException {
		synchronized (driver) {
			Selenium.sleep();
			driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
			setorDeServico = new SetorDeServicoPage();
			setorDeServico.openIncluirSetorServico();
			Selenium.sleep();
			
			newSetorDeServico = new NewSetorDeServicoPage();
			String result = newSetorDeServico.incluirSetorServico();
			Assert.assertEquals("Setor cadastrado com sucesso!", result);
		}
	}

	@Test
	public void Arv8_InativarSetorDeServico() throws InterruptedException {
		synchronized (driver) {
			Selenium.sleep();
			driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
			Selenium.sleep();
			setorDeServico = new SetorDeServicoPage();
			setorDeServico.goToLastPage();
			Selenium.sleep();
			Assert.assertEquals(setorDeServico.getLastRowName(), NewSetorDeServicoPage.getNomeValue());
			setorDeServico.openLastRow();
			Selenium.sleep();
			editSetorDeServico = new EditSetorDeServicoPage();
			editSetorDeServico.clickDelete();
			Selenium.getDriver().switchTo().alert().accept();
			Selenium.sleep();
			goToApplicationIframe();
			Selenium.sleep();
			editSetorDeServico.clickBack();
			Assert.assertFalse(setorDeServico.getLastRowName() == NewSetorDeServicoPage.getNomeValue());
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
