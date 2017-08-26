package br.com.arvitech.cagepa.sigo.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.arvitech.cagepa.sigo.Selenium;

public abstract class GenericPageObject<T> {

	private static final String MAIN_URL = "http://187.86.29.117/scriptcase/app/SIC_CAGEPA/app_Login/";
	private static final int LOAD_TIMEOUT = 10;
	private static final long DEFAULT_SLEEP_TIME = 1000;
	protected WebDriver driver;

	public GenericPageObject() {
		driver = Selenium.getDriver();
		PageFactory.initElements(driver, this);
	}

	public T openMainPage(Class<T> clazz) {
		T pagina = PageFactory.initElements(driver, clazz);
		driver.navigate().to(MAIN_URL);
		return pagina;
	}

	public void fillField(WebElement element, String value) {
		try {
			element.clear();
			element.sendKeys(value);
		} catch (WebDriverException e) {
			Assert.fail("["+element+"] não encontrado, valor ["+value+"] não pode ser preenchido.");
		}
	}
	
	public void fillSelect(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
		} catch (WebDriverException e) {
			Assert.fail("["+element+"] não encontrado, valor ["+value+"] não pode ser preenchido.");
		}
	}
	
	public void click(WebElement element) {
		try {
			getVisibleElement(element);
			element.click();
		} catch (WebDriverException e) {
			Assert.fail("Erro ao clicar no elemento ["+element+"].");
		}
	}
	
	public WebElement getElementById(String id) {
		try {
			return driver.findElement(By.id(id));
		} catch (Exception e) {
			Assert.fail("Erro ao buscar pelo id ["+id+"].");
			return null;
		}
	}
	
	public WebElement getElementByClassName(String clazz) {
		try {
			return driver.findElement(By.className(clazz));
		} catch (Exception e) {
			Assert.fail("Erro ao buscar pela class ["+clazz+"].");
			return null;
		}
	}

	public String getAttributeValue(WebElement element) {
		try {
			return element.getAttribute("value");
		} catch (Exception e) {
			Assert.fail("Erro ao buscar valor de atributo do elemento ["+element+"].");
			return null;
		}
	}

	public void selectElementByVisibleText(WebElement element, String textVisible) {
		try {
			new Select(element).selectByVisibleText(textVisible);
		} catch (WebDriverException e) {
			Assert.fail("["+element+"] do combobox não encontrado, valor ["+textVisible+"] não pode ser selecionado.");
		}
	}

	public void selectElementByVisibleValue(WebElement element, String valueVisible) {
		try {
			new Select(element).selectByValue(valueVisible);
		} catch (WebDriverException e) {
			Assert.fail("["+element+"] do combobox não encontrado, valor ["+valueVisible+"] não pode ser selecionado.");
		}
	}

	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			sleep();
		} catch (Exception e) {
			Assert.fail("Erro ao realizar a confirmacao do Alerta");
		}
	}

	public String getAlert() {
		String alerta = "";
		try {
			Alert alert = driver.switchTo().alert();
			alerta = alert.getText();
		} catch (Exception e) {
			Assert.fail("Erro ao realizar a confirmacao do Alerta");
		}
		return alerta;
	}

	public void getVisibleElement(WebElement element) {
		try {
			WebDriverWait driverWait = new WebDriverWait(driver,
					LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Assert.fail("Tempo excedido para aguardar elemento: " + element);
		}
	}

	public void waitVisibleElementWithText(WebElement element, String text) {
		try {
			WebDriverWait driverWait = new WebDriverWait(driver,
					LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.textToBePresentInElement(
					element, text));
		} catch (Exception e) {
			Assert.fail("Tempo excedido para aguardar elemento: " + element);
		}
	}

	public boolean isVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isVisible(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public void clickRightButton(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void moveCursorTo(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public boolean containsText(WebElement element, String text) {
		getVisibleElement(element);
		return element.getText().contains(text);
	}

	public void backOnePage() {
		driver.navigate().back();
	}

	public void acceptVisibleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public WebElement getElement(By by) {
		return driver.findElement(by);
	}
	
	public void sleep() throws InterruptedException {
		driver.wait(DEFAULT_SLEEP_TIME);
	}
	
	public void switchToIframe(WebElement element) throws InterruptedException {
		driver.switchTo().frame(element);
		sleep();
	}
	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	public void resetDriver(){
		if (driver != null) {
			driver.close();
		}
		driver = null;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public String getElementText(WebElement element) {
		return element.getText();
	}
	
	public List<WebElement> getSearchInputVisibleList() {
		List<WebElement> list = new ArrayList<>();
		List<WebElement> uls = driver.findElements(By.className("ui-autocomplete"));
		for (WebElement ul : uls) {
			if (ul.isDisplayed()) {
				list = ul.findElements(By.className("ui-menu-item")); 
			}
		}
		return list;
	}
	
	public List<WebElement> fillSearchField(WebElement element, String text) throws InterruptedException {
		element.sendKeys(text);
		sleep();
		return getSearchInputVisibleList();
	}
	
	public List<WebElement> getVisibleElementsById(String id) throws InterruptedException {
		List<WebElement> list = new ArrayList<>();
		try {
			List<WebElement> tmpList =  driver.findElements(By.id(id));
			for (WebElement element : tmpList) {
				if (element.isDisplayed()) {
					list.add(element);
				}
			}
		} catch (Exception e) {
			Assert.fail("Elementos não encontrados para o id: " + id);
		}
		return list;
	}
}
