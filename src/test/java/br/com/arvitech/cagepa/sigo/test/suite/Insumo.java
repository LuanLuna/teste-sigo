package br.com.arvitech.cagepa.sigo.test.suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.arvitech.cagepa.sigo.pages.insumo.EditInsumoPage;
import br.com.arvitech.cagepa.sigo.pages.insumo.InsumoPage;
import br.com.arvitech.cagepa.sigo.pages.insumo.NewInsumoPage;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuCadastros;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuSigo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Insumo extends BaseTestCase {
	private MenuSigo menuSigo;
	private MenuCadastros menuCadastros;
	private InsumoPage insumoPage;
	private NewInsumoPage newInsumoPage;
	private EditInsumoPage editInsumo;

	@Before
	public void init() throws InterruptedException {
		baseIframeId = "//iframe[@id='iframe_item_21']";
		applicationIframeId = "iframe_item_10";
		synchronized (driver) {
			goToBaseIframe();
			menuSigo = new MenuSigo();
			menuCadastros = menuSigo.openMenuCadastros();
			insumoPage = menuCadastros.openManterInsumo();
		}
	}

	@Test
	public void test1_Arv43_IncluirInsumo() throws InterruptedException {
		synchronized (driver) {
			insumoPage.switchToIframe(insumoPage.getElementById(applicationIframeId));
			newInsumoPage = insumoPage.openIncluirInsumo();
			String result = newInsumoPage.incluirServico();
			Assert.assertEquals("Insumo cadastrado com sucesso!", result);
		}
	}

	@Test
	public void test2_Arv44_InativarInsumo() throws InterruptedException {
		synchronized (driver) {
			menuSigo.sleep();
			menuSigo.switchToIframe(menuSigo.getElementById(applicationIframeId));
			
			insumoPage = new InsumoPage();
			insumoPage.goToLastPage();
			Assert.assertEquals(insumoPage.getLastRowName(), NewInsumoPage.getDescricaoValue());
			
			editInsumo = insumoPage.openLastRow();
			editInsumo.clickDelete();
			editInsumo.acceptAlert();
			Assert.assertEquals((editInsumo.getVisibleElementsById("id_error_display_fixed")).size(), 0);
			menuSigo.sleep();
			goToApplicationIframe();
			
			editInsumo.sleep();
			editInsumo.clickBack();
			Assert.assertFalse(insumoPage.getLastRowName() == NewInsumoPage.getDescricaoValue());
		}
	}
	
	@Test
	public void test3_Arv42_RegistroJaExistente() throws InterruptedException {
		synchronized (driver) {
			insumoPage.switchToIframe(insumoPage.getElementById(applicationIframeId));
			newInsumoPage = insumoPage.openIncluirInsumo();
			String result = newInsumoPage.incluirGerenciaRegionalJaExistente();
			Assert.assertEquals(result.contentEquals("Erro na inclusão - O registro já existe: Sigla"),true);

		}
	}
}
