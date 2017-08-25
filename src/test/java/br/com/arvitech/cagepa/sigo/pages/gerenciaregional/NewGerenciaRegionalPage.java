package br.com.arvitech.cagepa.sigo.pages.gerenciaregional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.PageObjectGeneric;

public class NewGerenciaRegionalPage extends PageObjectGeneric<NewGerenciaRegionalPage> {
	
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
		siglaField.sendKeys(siglaValue);
		nomeField.sendKeys(nomeValue);
		includeBtn.click();
		
		Selenium.getDriver().switchTo().alert().accept();
		Selenium.sleep();
		String result = Selenium.getDriver().findElement(By.className("scFormDataOdd")).getText();
		
		return result;
	}

	public static String getSiglaValue() {
		return siglaValue;
	}
	
	public static String getNomeValue() {
		return nomeValue;
	}
}
