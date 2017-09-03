package br.com.arvitech.cagepa.sigo.pages.gerenciaregional;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.basicas.GerenciaRegional;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;
import br.com.arvitech.cagepa.sigo.utils.GerenciaRegionalExcelReader;

public class NewGerenciaRegionalPage extends GenericPageObject<NewGerenciaRegionalPage> {
	
	@FindBy(id = "sc_b_ins_t")
	WebElement includeBtn;
	
	@FindBy(id = "sc_b_sai_t")
	WebElement cancelBtn;
	
	@FindBy(id = "id_sc_field_sigla")
	WebElement siglaField;
	
	@FindBy(id = "id_sc_field_nome")
	WebElement nomeField;
	
//	private static String siglaValue = "GQS";
//	private static String nomeValue = "Gerência de Qualidade de Software";
	
	private static String siglaValue;
	private static String nomeValue;
	
	public NewGerenciaRegionalPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
		try {
			GerenciaRegionalExcelReader gerenciaregionalexcelreader = new GerenciaRegionalExcelReader();
			
			Random r = new Random();
			int indice = r.nextInt(101);
			
			GerenciaRegional gerenciaregional = gerenciaregionalexcelreader.getGerenciaRegional(indice);
			
			siglaValue = gerenciaregional.getSigla();
			nomeValue = gerenciaregional.getNome();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String incluirGerenciaRegional() throws InterruptedException {
		fillField(siglaField, siglaValue);
		fillField(nomeField, nomeValue);
		includeBtn.click();
		
		acceptAlert();
		String result = getElementText(getElementByClassName("scFormDataOdd"));
		return result;
	}

	public static String getSiglaValue() {
		return siglaValue;
	}
	
	public static String getNomeValue() {
		return nomeValue;
	}
}
