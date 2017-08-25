package br.com.arvitech.cagepa.sigo.pages.servico;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.PageObjectGeneric;

public class EditServicoPage extends PageObjectGeneric<EditServicoPage> {
	
	@FindBy(id = "sc_b_upd_t")
	WebElement saveBtn;
	
	@FindBy(xpath = "//a[@title='Voltar à pagina anterior']")
	WebElement backBtn;
	
	@FindBy(id = "id_sc_field_descricao")
	WebElement descricaoField;
	
	@FindBy(id = "id_sc_field_tipo")
	WebElement tipoSelect;
	
	@FindBy(id = "id_sc_field_tipos_unidade_operacional")
	WebElement unidadeOperacionalSelect;
	
	@FindBy(id = "sc_b_del_t")
	WebElement deleteBtn;
	
	public EditServicoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public void clickDelete() {
		deleteBtn.click();
	}
	
	public void clickBack() {
		backBtn.click();
	}
}