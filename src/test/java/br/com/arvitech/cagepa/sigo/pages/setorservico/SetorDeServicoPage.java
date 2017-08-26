package br.com.arvitech.cagepa.sigo.pages.setorservico;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class SetorDeServicoPage extends GenericPageObject<SetorDeServicoPage> {
	
	@FindBy(id = "sc_b_new_top")
	WebElement newSetorDeServicoBtn;
	
	@FindBy(id = "last_bot")
	WebElement lastPageBtn;

	public SetorDeServicoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public NewSetorDeServicoPage openIncluirSetorServico() throws InterruptedException {
		newSetorDeServicoBtn.click();
		sleep();
		return new NewSetorDeServicoPage();
	}
	
	public void goToLastPage() throws InterruptedException {
		lastPageBtn.click();
		sleep();
	}
	
	public EditSetorDeServicoPage openLastRow() throws InterruptedException {
		List<WebElement> rows = Selenium.getDriver().findElements(By.id("bedit"));
		if (rows.size() > 0) {
			rows.get(rows.size()-1).click();
		}
		sleep();
		return new EditSetorDeServicoPage();
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
