package br.com.arvitech.cagepa.sigo.test.suite;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.arvitech.cagepa.sigo.Selenium;
public class BaseTestCase {
	protected static WebDriver driver;
	protected String baseIframeId;
	protected String applicationIframeId;
	
	@BeforeClass
	public static void initClass() {
		driver = Selenium.getDriver();
	}
	
	protected void goToApplicationIframe() {
		goToBaseIframe();
		driver.switchTo().frame(driver.findElement(By.id(applicationIframeId)));
	}
	
	protected void goToBaseIframe() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath(baseIframeId)));
	}
}
