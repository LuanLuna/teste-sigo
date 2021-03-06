package br.com.arvitech.cagepa.sigo.pages.sistemaabastecimento;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class SistemaDeAbastecimentoPage extends GenericPageObject<SistemaDeAbastecimentoPage> {
	
	@FindBy(id = "sc_b_new_top")
	WebElement newSistemaDeAbastecimentoBtn;
	
	@FindBy(id = "last_bot")
	WebElement lastPageBtn;

	public SistemaDeAbastecimentoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public NewSistemaDeAbastecimentoPage openIncluirSistemaDeAbastecimento() throws InterruptedException {
		newSistemaDeAbastecimentoBtn.click();
		sleep();
		return new NewSistemaDeAbastecimentoPage();
	}
	
	public void goToLastPage() {
		lastPageBtn.click();
	}
	
	public EditSistemaDeAbastecimentoPage openLastRow() throws InterruptedException {
		List<WebElement> rows = Selenium.getDriver().findElements(By.id("bedit"));
		if (rows.size() > 0) {
			rows.get(rows.size()-1).click();
		}
		sleep();
		return new EditSistemaDeAbastecimentoPage();
	}
	
	public String getLastRowName() {
		String result = "";
		List<WebElement> rows = Selenium.getDriver().findElements(By.className("css_nome_grid_line"));
		if (rows.size() > 0) {
			result = rows.get(rows.size()-1).getText();
		}
		return result;
	}
}
