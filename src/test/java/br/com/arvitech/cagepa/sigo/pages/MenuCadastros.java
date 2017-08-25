package br.com.arvitech.cagepa.sigo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;

public class MenuCadastros extends PageObjectGeneric<MenuCadastros> {

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
	
	public void openManterSetorDeServico() throws InterruptedException {
		manterSetorMenu.click();
	}
	
	public void openManterGerenciaRegional() throws InterruptedException {
		manterGerenciaRegionalMenu.click();
	}
	
	public void openManterSistemaDeAbastecimento() throws InterruptedException {
		manterSistemaDeAbastecimentoMenu.click();
	}
	
	public void openManterServico() throws InterruptedException {
		manterServicoMenu.click();
	}
}
