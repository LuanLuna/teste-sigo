package br.com.arvitech.cagepa.sigo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.arvitech.cagepa.sigo.Selenium;

public class NewSetorDeServicoPage extends PageObjectGeneric<NewSetorDeServicoPage> {
	
	@FindBy(id = "sc_b_ins_t")
	WebElement includeBtn;
	
	@FindBy(id = "sc_b_sai_t")
	WebElement cancelBtn;
	
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
	
	private static String gerenciaRegionalValue = "9";
	private static String siglaValue = "SQS";
	private static String nomeValue = "Subgerência de Qualidade de Software";
	private static String atuacaoValue = "AE";
	private static String areaValue = "Qualidade";
	
	public NewSetorDeServicoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public String incluirSetorServico() throws InterruptedException {
		(new Select(gerenciaRegionalSelect)).selectByValue(gerenciaRegionalValue);
		siglaField.sendKeys(siglaValue);
		nomeField.sendKeys(nomeValue);
		(new Select(atuacaoSelect)).selectByValue(atuacaoValue);
		areaField.sendKeys(areaValue);
		
		includeBtn.click();
		Selenium.getDriver().switchTo().alert().accept();
		Selenium.sleep();
		String result = Selenium.getDriver().findElement(By.className("scFormDataOdd")).getText();
		
		return result;
	}

	public static String getGerenciaRegionalValue() {
		return gerenciaRegionalValue;
	}

	public static String getSiglaValue() {
		return siglaValue;
	}
	
	public static String getNomeValue() {
		return nomeValue;
	}

	public static String getAtuacaoValue() {
		return atuacaoValue;
	}

	public static String getAreaValue() {
		return areaValue;
	}
	
	
}
