package br.com.arvitech.cagepa.sigo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.arvitech.cagepa.sigo.Selenium;

public class NewServico extends PageObjectGeneric<NewServico> {
	
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
	
	public NewServico() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public String incluirServico() throws InterruptedException {
		descricaoField.sendKeys(descricaoValue);
		(new Select(tipoSelect)).selectByValue(tipoValue);
		includeBtn.click();
		
//		Selenium.getDriver().switchTo().alert().accept();
//		Selenium.sleep();
//		String result = Selenium.getDriver().findElement(By.className("scFormDataOdd")).getText();
		String result = "";
		
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
