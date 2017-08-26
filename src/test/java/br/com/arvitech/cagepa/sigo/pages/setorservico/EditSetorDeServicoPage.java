package br.com.arvitech.cagepa.sigo.pages.setorservico;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class EditSetorDeServicoPage extends GenericPageObject<EditSetorDeServicoPage> {
	
	@FindBy(id = "sc_b_upd_t")
	WebElement saveBtn;
	
	@FindBy(xpath = "//a[@title='Voltar à pagina anterior']")
	WebElement backBtn;
	
	@FindBy(id = "id_sc_field_codigoid_gerencia_regional")
	WebElement gerenciaRegionalSelect;
	
	@FindBy(id = "id_sc_field_sigla")
	WebElement siglaField;
	
	@FindBy(id = "id_sc_field_nome")
	WebElement nomeField;
	
	@FindBy(id = "id_sc_field_atuacao")
	WebElement atuacaoSelect;
	
	@FindBy(id = "id_sc_field_area")
	WebElement areaField;
	
	@FindBy(id = "id_sc_field_sistemas_atendidos")
	WebElement sistemaSelect;
	
	@FindBy(id = "sc_b_del_t")
	WebElement deleteBtn;
	
	public EditSetorDeServicoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public void clickDelete() {
		deleteBtn.click();
	}
	
	public void clickBack() {
		backBtn.click();
	}
}
