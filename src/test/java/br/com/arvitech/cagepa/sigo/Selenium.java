package br.com.arvitech.cagepa.sigo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Classe Utils para o Selenium
 * Identifica qual o browser escolhido no config.properties e inicializa o webdriver correspondente
 */
public class Selenium {
	
	private static WebDriver driver = null;
	private static final long DEFAULT_SLEEP_TIME = 1000;

	/**
	 * Verifica qual o browser escolhido no arquivo de propriedades
	 * inicializa o driver apropriado e o retorna
	 * @return retorna instância do WebDriver
	 */
	public static WebDriver getDriver() {
		String browser = "chrome";
		if (driver == null) {
			if (Browser.CHROME.equals(browser)) {
				File file = new File(new File("").getAbsolutePath() + "/src/test/resources/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
				driver = new ChromeDriver();
			} else if (Browser.IE.equals(browser)) {
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				File file = new File(new File("").getAbsolutePath() + "\\src\\test\\resources\\IEDriverServer.exe");
				
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver(capabilities);
				
			}else  if (Browser.FIREFOX.equals(browser)){
				//System.setProperty("webdriver.gecko.driver", new File("").getAbsolutePath() + "\\home\\user\\bin");
				driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	
	public static void resetDriver(){
		if (driver != null) {
			driver.close();
		}
		driver = null;
	}
	
	public static void sleep() throws InterruptedException {
		driver.wait(DEFAULT_SLEEP_TIME);
	}
}
