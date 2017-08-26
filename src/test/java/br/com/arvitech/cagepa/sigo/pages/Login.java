package br.com.arvitech.cagepa.sigo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.arvitech.cagepa.sigo.Selenium;
import br.com.arvitech.cagepa.sigo.pages.menus.MenuSic;

public class Login extends GenericPageObject<Login> {
	private static final String LOGIN = "132829";
	private static final String PASSWORD = "123556";

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
		login.sendKeys(LOGIN);
		password.sendKeys(PASSWORD);
		loginButton.click();
	}
	
	public void confirmLogin() {
		confirmationButton.click();
	}
	
	public MenuSic executeLogin() throws InterruptedException {
		synchronized (driver) {
			MenuSic menu;
			login();
			sleep();
			try {
				switchToIframe(Selenium.getDriver().findElement(By.xpath("//iframe[@id='TB_iframeContent']")));
				confirmLogin();
				switchToDefaultContent();
				sleep();
				menu = new MenuSic();
			} catch(Exception e) {
				menu = null;
			}
			return menu;
		}
	}
}

