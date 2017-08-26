package br.com.arvitech.cagepa.sigo.pages.menus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;
import br.com.arvitech.cagepa.sigo.pages.gerenciaregional.GerenciaRegionalPage;
import br.com.arvitech.cagepa.sigo.pages.servico.ServicoPage;
import br.com.arvitech.cagepa.sigo.pages.setorservico.SetorDeServicoPage;
import br.com.arvitech.cagepa.sigo.pages.sistemaabastecimento.SistemaDeAbastecimentoPage;

public class MenuCadastros extends GenericPageObject<MenuCadastros> {

	public MenuCadastros() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	@FindBy(xpath = "//a[contains(text(), 'Manter Setor')]")
	WebElement manterSetorMenu;
	
	@FindBy(xpath = "//a[contains(text(), 'Manter Gerência Regional')]")
	WebElement manterGerenciaRegionalMenu;
	
	@FindBy(xpath = "//a[contains(text(), 'Manter Sistema')]")
	WebElement manterSistemaDeAbastecimentoMenu;
	
	@FindBy(xpath = "//a[contains(text(), 'Manter Serviço')]")
	WebElement manterServicoMenu;
	
	public SetorDeServicoPage openManterSetorDeServico() throws InterruptedException {
		manterSetorMenu.click();
		sleep();
		return new SetorDeServicoPage();
	}
	
	public GerenciaRegionalPage openManterGerenciaRegional() throws InterruptedException {
		manterGerenciaRegionalMenu.click();
		sleep();
		return new GerenciaRegionalPage();
	}
	
	public SistemaDeAbastecimentoPage openManterSistemaDeAbastecimento() throws InterruptedException {
		manterSistemaDeAbastecimentoMenu.click();
		sleep();
		return new SistemaDeAbastecimentoPage();
	}
	
	public ServicoPage openManterServico() throws InterruptedException {
		manterServicoMenu.click();
		sleep();
		return new ServicoPage();
	}
}
