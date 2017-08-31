package br.com.arvitech.cagepa.sigo.test.suite;
//teste commit pedro
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.arvitech.cagepa.sigo.Browser;
import br.com.arvitech.cagepa.sigo.pages.Login;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuSic;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	SetorDeServico.class,
	GerenciaRegional.class,
	SistemaDeAbastecimento.class,
	Servico.class,
	Insumo.class
})

public class AllTests {
	static Login loginPage;
	static MenuSic menuSic;
	static Browser browser;
	public static Boolean isAllTestsExecution = false;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		isAllTestsExecution = true;
		browser = new Browser();
		browser.open();
		loginPage = new Login();
		menuSic = loginPage.executeLogin();
		menuSic.openMenuSigo();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		loginPage.resetDriver();
	}
}

