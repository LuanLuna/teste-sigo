package br.com.arvitech.cagepa.sigo.pages.sistemaabastecimento;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class NewSistemaDeAbastecimentoPage extends GenericPageObject<NewSistemaDeAbastecimentoPage> {
	
	@FindBy(id = "sc_b_ins_t")
	WebElement includeBtn;
	
	@FindBy(id = "sc_b_sai_t")
	WebElement cancelBtn;
	
	@FindBy(id = "id_sc_field_codigoid_gerencia_regional")
	WebElement gerenciaRegionalSelect;
	
	@FindBy(id = "id_sc_field_nome")
	WebElement nomeField;
	
	@FindBy(id = "id_sc_field_tipo")
	WebElement tipoSelect;
	
	@FindBy(id = "id_sc_field_setores_responsaveis")
	WebElement setoresResponsaveisSelect;
	
	private static String gerenciaRegionalValue = "6";
	private static String tipoValue = "A";
	private static String nomeValue = "Sistema Unipê";
	
	public NewSistemaDeAbastecimentoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public String incluirSistemaDeAbastecimento() throws InterruptedException {
		fillSelect(gerenciaRegionalSelect, gerenciaRegionalValue);
		fillField(nomeField, nomeValue);
		fillSelect(tipoSelect, tipoValue);
		includeBtn.click();
		
		acceptAlert();
		String result = getElementText(getElementByClassName("scFormDataOdd"));
		return result;
	}

	public static String getSiglaValue() {
		return gerenciaRegionalValue;
	}
	
	public static String getNomeValue() {
		return nomeValue;
	}
	
	public static String getTipoValue() {
		return tipoValue;
	}
	
	public void clickCancel() {
		cancelBtn.click();
	}
}
