package br.com.arvitech.cagepa.sigo.pages.servico;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class NewServicoPage extends GenericPageObject<NewServicoPage> {
	
	@FindBy(id = "sc_b_ins_t")
	WebElement includeBtn;
	
	@FindBy(id = "sc_b_sai_t")
	WebElement cancelBtn;
	
	@FindBy(id = "id_sc_field_descricao")
	WebElement descricaoField;
	
	@FindBy(id = "id_sc_field_tipo")
	WebElement tipoSelect;
	
	@FindBy(id = "id_sc_field_tipos_unidade_operacional")
	WebElement unidadeOperacionalSelect;
	
	private static String tipoValue = "E";
	private static String descricaoValue = "Vazamento Teste";
	
	public NewServicoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public String incluirServico() throws InterruptedException {
		fillField(descricaoField, descricaoValue);
		fillSelect(tipoSelect, tipoValue);
		includeBtn.click();
		
		acceptAlert();
		String result = getElementText(getElementByClassName("scFormDataOdd"));
		return result;
	}
	
	public static String getDescricaoValue() {
		return descricaoValue;
	}
	
	public static String getTipoValue() {
		return tipoValue;
	}
	
	public void clickCancel() {
		cancelBtn.click();
	}
}
