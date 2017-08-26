package br.com.arvitech.cagepa.sigo;

import org.openqa.selenium.WebDriver;

/**
 * Classe para definir vari�vel para identifi��o dos browsers
 */
public class Browser {

	public static final String FIREFOX = "firefox";
	public static final String CHROME = "chrome";
	public static final String IE = "ie";
	private static WebDriver driver;
	
	public void open() {
		driver = Selenium.getDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://187.86.29.117/scriptcase/app/SIC_CAGEPA/app_Login/");
	}
}
