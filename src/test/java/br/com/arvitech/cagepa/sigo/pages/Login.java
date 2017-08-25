package br.com.arvitech.cagepa.sigo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Property;
import br.com.arvitech.cagepa.sigo.Selenium;

public class Login extends PageObjectGeneric<Login> {

	public Login() {
		PageFactory.initElements(Selenium.getDriver(), this);
	}

	@FindBy(id = "id_sc_field_login")
	WebElement login;
	
	@FindBy(id = "id_sc_field_pswd")
	WebElement password;
	
	@FindBy(id = "sub_form_b")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@id='sub_form_b']")
	WebElement confirmationButton;
	
	public void login() throws InterruptedException{
		login.sendKeys(Property.LOGIN);
		password.sendKeys(Property.PASSWORD);
		loginButton.click();
	}
	
	public void confirmLogin() {
		confirmationButton.click();
	}
}

