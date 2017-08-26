package br.com.arvitech.cagepa.sigo.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.arvitech.cagepa.sigo.pages.menus.MenuCadastros;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuSigo;
import br.com.arvitech.cagepa.sigo.pages.setorservico.EditSetorDeServicoPage;
import br.com.arvitech.cagepa.sigo.pages.setorservico.NewSetorDeServicoPage;
import br.com.arvitech.cagepa.sigo.pages.setorservico.SetorDeServicoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SetorDeServico extends BaseTestCase {
	private MenuSigo menuSigo;
	private MenuCadastros menuCadastros;
	private SetorDeServicoPage setorDeServico;
	private NewSetorDeServicoPage newSetorDeServico;
	private EditSetorDeServicoPage editSetorDeServico;

	@Before
	public void init() throws InterruptedException {
		baseIframeId = "//iframe[@id='iframe_item_21']";
		applicationIframeId = "iframe_item_2";
		synchronized (driver) {
			goToBaseIframe();
			menuSigo = new MenuSigo();
			menuCadastros = menuSigo.openMenuCadastros();
			setorDeServico = menuCadastros.openManterSetorDeServico();
		}
	}

	@Test
	public void test1_Arv33_IncluirSetorDeServico() throws InterruptedException {
		synchronized (driver) {
			setorDeServico.switchToIframe(setorDeServico.getElementById(applicationIframeId));
			newSetorDeServico = setorDeServico.openIncluirSetorServico();
			String result = newSetorDeServico.incluirSetorServico();
			Assert.assertEquals("Setor cadastrado com sucesso!", result);
		}
	}

	@Test
	public void test2_Arv8_InativarSetorDeServico() throws InterruptedException {
		synchronized (driver) {
			menuSigo.sleep();
			menuSigo.switchToIframe(menuSigo.getElementById(applicationIframeId));
			
			setorDeServico = new SetorDeServicoPage();
			setorDeServico.goToLastPage();
			Assert.assertEquals(setorDeServico.getLastRowName(), NewSetorDeServicoPage.getNomeValue());
			
			editSetorDeServico = setorDeServico.openLastRow();
			editSetorDeServico.clickDelete();
			editSetorDeServico.acceptAlert();
			Assert.assertEquals((editSetorDeServico.getVisibleElementsById("id_error_display_fixed")).size(), 0);
			menuSigo.sleep();
			goToApplicationIframe();
			
			editSetorDeServico.sleep();
			editSetorDeServico.clickBack();
			Assert.assertFalse(setorDeServico.getLastRowName() == NewSetorDeServicoPage.getNomeValue());
		}
	}
}
