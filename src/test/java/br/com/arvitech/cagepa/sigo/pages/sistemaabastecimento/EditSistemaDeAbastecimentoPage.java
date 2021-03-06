package br.com.arvitech.cagepa.sigo.pages.sistemaabastecimento;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class EditSistemaDeAbastecimentoPage extends GenericPageObject<EditSistemaDeAbastecimentoPage> {
	
	@FindBy(id = "sc_b_upd_t")
	WebElement saveBtn;
	
	@FindBy(xpath = "//a[@title='Voltar à pagina anterior']")
	WebElement backBtn;
	
	@FindBy(id = "id_sc_field_codigoid_gerencia_regional")
	WebElement gerenciaRegionalSelect;
	
	@FindBy(id = "id_sc_field_nome")
	WebElement nomeField;
	
	@FindBy(id = "id_sc_field_tipo")
	WebElement tipoSelect;
	
	@FindBy(id = "id_sc_field_setores_responsaveis")
	WebElement setoresResponsaveisSelect;
	
	@FindBy(id = "sc_b_del_t")
	WebElement deleteBtn;
	
	public EditSistemaDeAbastecimentoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public void clickDelete() {
		deleteBtn.click();
	}
	
	public void clickBack() {
		backBtn.click();
	}
}
