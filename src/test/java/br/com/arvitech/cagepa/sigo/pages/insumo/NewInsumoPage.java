package br.com.arvitech.cagepa.sigo.pages.insumo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.GenericPageObject;

public class NewInsumoPage extends GenericPageObject<NewInsumoPage> {
	
	@FindBy(id = "sc_b_ins_t")
	WebElement includeBtn;
	
	@FindBy(id = "sc_b_sai_t")
	WebElement cancelBtn;
	
	@FindBy(id = "id_sc_field_descricao")
	WebElement descricaoField;
	
	@FindBy(id = "id_sc_field_valor")
	WebElement valorField;
	
	@FindBy(id = "codigoid_unidade_autocomp_cap")
	WebElement unidadeSearch;
	
	@FindBy(id = "codigoid_grupo_insumo_autocomp_cap")
	WebElement groupSearch;
	
	@FindBy(id = "id_ac_codigoid_unidade")
	WebElement unidadeSearchField;
	
	@FindBy(id = "id_ac_codigoid_grupo_insumo")
	WebElement groupSearchField;
	
	private static String descricaoValue = "Material de Teste";
	private static String unidadeValue = "a";
	private static String valorValue = "30";
	private static String groupValue = "a";
	
	public NewInsumoPage() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}
	
	public String incluirServico() throws InterruptedException {
		fillField(descricaoField, descricaoValue);
		fillField(valorField, valorValue);
		
		unidadeSearch.click();
		sleep();
		List<WebElement> unidadeList = fillSearchField(unidadeSearchField, unidadeValue);
		unidadeList.get(0).click();
		sleep();
		
		groupSearch.click();
		sleep();
		List<WebElement> groupList = fillSearchField(groupSearchField, groupValue);
		groupList.get(0).click();
		sleep();
		
		includeBtn.click();
		
		acceptAlert();
		String result = getElementText(getElementByClassName("scFormDataOdd"));
		return result;
	}
	
	public WebElement getIncludeBtn() {
		return includeBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}

	public WebElement getDescricaoField() {
		return descricaoField;
	}

	public WebElement getValorField() {
		return valorField;
	}

	public WebElement getUnidadeSearch() {
		return unidadeSearch;
	}

	public WebElement getGroupSearch() {
		return groupSearch;
	}

	public void clickCancel() {
		cancelBtn.click();
	}
	
	public static String getDescricaoValue() {
		return descricaoValue;
	}
}
