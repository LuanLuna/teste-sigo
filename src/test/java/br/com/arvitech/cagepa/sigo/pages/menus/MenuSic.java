package br.com.arvitech.cagepa.sigo.pages.menus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class MenuSic extends GenericPageObject<MenuSic> {

	public MenuSic() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(xpath = "//a[@title='Sistema de Gestão Operacional']")
	WebElement botaoMenuSigo;
	
	public void openMenuSigo() throws InterruptedException{
		botaoMenuSigo.click();
	}
}
