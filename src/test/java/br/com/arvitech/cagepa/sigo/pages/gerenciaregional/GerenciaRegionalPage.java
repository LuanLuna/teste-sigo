package br.com.arvitech.cagepa.sigo.pages.gerenciaregional;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class GerenciaRegionalPage extends GenericPageObject<GerenciaRegionalPage> {
	
	@FindBy(id = "sc_b_new_top")
	WebElement newGerenciaRegionalBtn;
	
	@FindBy(id = "last_bot")
	WebElement lastPageBtn;

	public GerenciaRegionalPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public NewGerenciaRegionalPage openIncluirGerenciaRegional() throws InterruptedException {
		newGerenciaRegionalBtn.click();
		sleep();
		return new NewGerenciaRegionalPage();
	}
	
	public void goToLastPage() throws InterruptedException {
		lastPageBtn.click();
		sleep();
	}
	
	public EditGerenciaRegionalPage openLastRow() throws InterruptedException {
		List<WebElement> rows = Selenium.getDriver().findElements(By.id("bedit"));
		if (rows.size() > 0) {
			rows.get(rows.size()-1).click();
		}
		sleep();
		return new EditGerenciaRegionalPage();
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
