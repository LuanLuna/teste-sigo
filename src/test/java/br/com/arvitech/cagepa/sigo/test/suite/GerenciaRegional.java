package br.com.arvitech.cagepa.sigo.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.arvitech.cagepa.sigo.pages.gerenciaregional.EditGerenciaRegionalPage;
import br.com.arvitech.cagepa.sigo.pages.gerenciaregional.GerenciaRegionalPage;
import br.com.arvitech.cagepa.sigo.pages.gerenciaregional.NewGerenciaRegionalPage;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuCadastros;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuSigo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GerenciaRegional extends BaseTestCase {
	private MenuSigo menuSigo;
	private MenuCadastros menuCadastros;
	private GerenciaRegionalPage gerenciaRegionalPage;
	private NewGerenciaRegionalPage newGerenciaRegional;
	private EditGerenciaRegionalPage editGerenciaRegional;

	@Before
	public void init() throws InterruptedException {
		baseIframeId = "//iframe[@id='iframe_item_21']";
		applicationIframeId = "iframe_item_1";
		synchronized (driver) {
			goToBaseIframe();
			menuSigo = new MenuSigo();
			menuCadastros = menuSigo.openMenuCadastros();
			gerenciaRegionalPage = menuCadastros.openManterGerenciaRegional();
		}
	}

	@Test
	public void test1_Arv1_GerenciaRegional() throws InterruptedException {
		synchronized (driver) {
			gerenciaRegionalPage.switchToIframe(gerenciaRegionalPage.getElementById(applicationIframeId));
			newGerenciaRegional = gerenciaRegionalPage.openIncluirGerenciaRegional();
			String result = newGerenciaRegional.incluirGerenciaRegional();
			Assert.assertEquals("Gerência Regional cadastrada com sucesso!", result);
		}
	}

	@Test
	public void test2_Arv2_InativarGerenciaRegional() throws InterruptedException {
		synchronized (driver) {
			menuSigo.sleep();
			menuSigo.switchToIframe(menuSigo.getElementById(applicationIframeId));
			
			gerenciaRegionalPage = new GerenciaRegionalPage();
			gerenciaRegionalPage.goToLastPage();
			Assert.assertEquals(gerenciaRegionalPage.getLastRowName(), NewGerenciaRegionalPage.getNomeValue());
			
			editGerenciaRegional = gerenciaRegionalPage.openLastRow();
			editGerenciaRegional.clickDelete();
			editGerenciaRegional.acceptAlert();
			goToApplicationIframe();
			
			editGerenciaRegional.sleep();
			editGerenciaRegional.clickBack();
			Assert.assertFalse(gerenciaRegionalPage.getLastRowName() == NewGerenciaRegionalPage.getNomeValue());
		}
	}
}
