package br.com.arvitech.cagepa.sigo.pages.gerenciaregional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class NewGerenciaRegionalPage extends GenericPageObject<NewGerenciaRegionalPage> {
	
	@FindBy(id = "sc_b_ins_t")
	WebElement includeBtn;
	
	@FindBy(id = "sc_b_sai_t")
	WebElement cancelBtn;
	
	@FindBy(id = "id_sc_field_sigla")
	WebElement siglaField;
	
	@FindBy(id = "id_sc_field_nome")
	WebElement nomeField;
	
	private static String siglaValue = "GQS";
	private static String nomeValue = "Gerência de Qualidade de Software";
	
	public NewGerenciaRegionalPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public String incluirGerenciaRegional() throws InterruptedException {
		fillField(siglaField, siglaValue);
		fillField(nomeField, nomeValue);
		includeBtn.click();
		
		acceptAlert();
		String result = getElementText(getElementByClassName("scFormDataOdd"));
		return result;
	}
	
	public String incluirGerenciaRegionalSemCamposObrigatorios() throws InterruptedException {
		includeBtn.click(); 
		
		acceptAlert();
		String result = getElementText(getElementByClassName("scFormErrorTitleFont"));
		return result;
	}

	public static String getSiglaValue() {
		return siglaValue;
	}
	
	public static String getNomeValue() {
		return nomeValue;
	}
}
