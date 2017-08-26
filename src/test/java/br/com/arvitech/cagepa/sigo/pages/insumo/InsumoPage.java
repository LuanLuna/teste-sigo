package br.com.arvitech.cagepa.sigo.pages.insumo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class InsumoPage extends GenericPageObject<InsumoPage> {
	
	@FindBy(id = "sc_b_new_top")
	WebElement newInsumoBtn;
	
	@FindBy(id = "last_bot")
	WebElement lastPageBtn;

	public InsumoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public NewInsumoPage openIncluirInsumo() throws InterruptedException {
		newInsumoBtn.click();
		sleep();
		return new NewInsumoPage();
	}
	
	public void goToLastPage() {
		lastPageBtn.click();
	}
	
	public EditInsumoPage openLastRow() throws InterruptedException {
		List<WebElement> rows = Selenium.getDriver().findElements(By.id("bedit"));
		if (rows.size() > 0) {
			rows.get(rows.size()-1).click();
		}
		sleep();
		return new EditInsumoPage();
	}
	
	public String getLastRowName() {
		String result = "";
		List<WebElement> rows = Selenium.getDriver().findElements(By.className("css_descricao_grid_line"));
		if (rows.size() > 0) {
			result = rows.get(rows.size()-1).getText();
		}
		return result;
	}
}
