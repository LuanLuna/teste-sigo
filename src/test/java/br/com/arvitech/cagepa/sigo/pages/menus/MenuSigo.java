package br.com.arvitech.cagepa.sigo.pages.menus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.PageObjectGeneric;

public class MenuSigo extends PageObjectGeneric<MenuSigo> {

	public MenuSigo() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(text(), 'Cadastros')]")
	WebElement botaoCadastros;
	
	public void openMenuCadastros() throws InterruptedException{
		botaoCadastros.click();
	}
}
