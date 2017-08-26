package br.com.arvitech.cagepa.sigo.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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

	@Before
	public void init() throws InterruptedException {
		baseIframeId = "//iframe[@id='iframe_item_21']";
		applicationIframeId = "iframe_item_3";
		synchronized (driver) {
			goToBaseIframe();
			menuSigo = new MenuSigo();
			menuCadastros = menuSigo.openMenuCadastros();
			servicoPage = menuCadastros.openManterServico();
		}
	}

	@Test
	public void test1_Arv36_IncluirServico() throws InterruptedException {
		synchronized (driver) {
			servicoPage.switchToIframe(servicoPage.getElementById(applicationIframeId));
			newServico = servicoPage.openIncluirServico();
			String result = newServico.incluirServico();
			Assert.assertEquals("Serviço cadastrado com sucesso!", result);
		}
	}

	@Test
	public void test2_Arv14_InativarServico() throws InterruptedException {
		synchronized (driver) {
			menuSigo.sleep();
			menuSigo.switchToIframe(menuSigo.getElementById(applicationIframeId));
			
			servicoPage = new ServicoPage();
			servicoPage.goToLastPage();
			Assert.assertEquals(servicoPage.getLastRowName(), NewServicoPage.getDescricaoValue());
			
			editServico = servicoPage.openLastRow();
			editServico.clickDelete();
			editServico.acceptAlert();
			goToApplicationIframe();
			
			editServico.sleep();
			editServico.clickBack();
			Assert.assertFalse(servicoPage.getLastRowName() == NewServicoPage.getDescricaoValue());
		}
	}
}
