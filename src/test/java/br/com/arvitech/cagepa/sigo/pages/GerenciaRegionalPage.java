package br.com.arvitech.cagepa.sigo.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;

public class GerenciaRegionalPage extends PageObjectGeneric<GerenciaRegionalPage> {
	
	@FindBy(id = "sc_b_new_top")
	WebElement newGerenciaRegionalBtn;
	
	@FindBy(id = "last_bot")
	WebElement lastPageBtn;

	public GerenciaRegionalPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public void openIncluirGerenciaRegional() throws InterruptedException {
		newGerenciaRegionalBtn.click();
	}
	
	public void goToLastPage() {
		lastPageBtn.click();
	}
	
	public void openLastRow() {
		List<WebElement> rows = Selenium.getDriver().findElements(By.id("bedit"));
		if (rows.size() > 0) {
			rows.get(rows.size()-1).click();
		}
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
