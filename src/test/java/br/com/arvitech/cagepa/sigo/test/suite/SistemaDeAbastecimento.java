package br.com.arvitech.cagepa.sigo.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.arvitech.cagepa.sigo.pages.menus.MenuCadastros;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuSigo;
import br.com.arvitech.cagepa.sigo.pages.sistemaabastecimento.EditSistemaDeAbastecimentoPage;
import br.com.arvitech.cagepa.sigo.pages.sistemaabastecimento.NewSistemaDeAbastecimentoPage;
import br.com.arvitech.cagepa.sigo.pages.sistemaabastecimento.SistemaDeAbastecimentoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SistemaDeAbastecimento extends BaseTestCase {
	private MenuSigo menuSigo;
	private MenuCadastros menuCadastros;
	private SistemaDeAbastecimentoPage sistemaDeAbastecimentoPage;
	private NewSistemaDeAbastecimentoPage newSistemaDeAbastecimento;
	private EditSistemaDeAbastecimentoPage editSistemaDeAbastecimento;

	@Before
	public void init() throws InterruptedException {
		baseIframeId = "//iframe[@id='iframe_item_21']";
		applicationIframeId = "iframe_item_6";
		synchronized (driver) {
			goToBaseIframe();
			menuSigo = new MenuSigo();
			menuCadastros = menuSigo.openMenuCadastros();
			sistemaDeAbastecimentoPage = menuCadastros.openManterSistemaDeAbastecimento();
		}
	}

	@Test
	public void test1_Arv34_IncluirSistemaDeAbastecimento() throws InterruptedException {
		synchronized (driver) {
			sistemaDeAbastecimentoPage.switchToIframe(sistemaDeAbastecimentoPage.getElementById(applicationIframeId));
			newSistemaDeAbastecimento = sistemaDeAbastecimentoPage.openIncluirSistemaDeAbastecimento();
			String result = newSistemaDeAbastecimento.incluirSistemaDeAbastecimento();
			Assert.assertEquals("Sistema cadastrado com sucesso!", result);
		}
	}

	@Test
	public void test2_Arv20_InativarSIstemaDeAbastecimento() throws InterruptedException {
		synchronized (driver) {
			menuSigo.sleep();
			menuSigo.switchToIframe(menuSigo.getElementById(applicationIframeId));
			
			sistemaDeAbastecimentoPage = new SistemaDeAbastecimentoPage();
			sistemaDeAbastecimentoPage.goToLastPage();
			Assert.assertEquals(sistemaDeAbastecimentoPage.getLastRowName(), NewSistemaDeAbastecimentoPage.getNomeValue());
			
			editSistemaDeAbastecimento = sistemaDeAbastecimentoPage.openLastRow();
			editSistemaDeAbastecimento.clickDelete();
			editSistemaDeAbastecimento.acceptAlert();
			goToApplicationIframe();
			
			editSistemaDeAbastecimento.sleep();
			editSistemaDeAbastecimento.clickBack();
			Assert.assertFalse(sistemaDeAbastecimentoPage.getLastRowName() == NewSistemaDeAbastecimentoPage.getNomeValue());
		}
	}
}
