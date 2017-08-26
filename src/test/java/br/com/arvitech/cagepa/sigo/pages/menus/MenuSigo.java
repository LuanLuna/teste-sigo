package br.com.arvitech.cagepa.sigo.pages.menus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class MenuSigo extends GenericPageObject<MenuSigo> {

	public MenuSigo() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(xpath = "//span[contains(text(), 'Cadastros')]")
	WebElement botaoCadastros;
	
	public MenuCadastros openMenuCadastros() throws InterruptedException{
		botaoCadastros.click();
		sleep();
		return new MenuCadastros();
	}
}
