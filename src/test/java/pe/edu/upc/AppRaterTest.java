package pe.edu.upc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppRaterTest {

	private WebDriver driver;

	public void sendText(String label, String selectorType, String selector, String value) {
		if (selectorType == "name") {
			driver.findElement(By.name(selector)).sendKeys(value);
		} else if (selectorType == "css") {
			driver.findElement(By.cssSelector("input[name ='" + selector + "']")).sendKeys(value);
		} else {
			driver.findElement(By.xpath("//input[@name='" + selector + "']")).sendKeys(value);
		}
	}

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://apprater.net/add/");
	}

	@Test
	public void testApprater() {
		sendText("myName", "name", "user-submitted-name", "Alejandro Espejo");
		sendText("EmailAddress", "css", "user-submitted-email", "alejandro_espejo_g@hotmail.com");
		sendText("ProductTitle", "xpath", "user-submitted-title", "Postulación");
		sendText("ProductUrl", "css", "user-submitted-url[]", "https://www.linkedin.com/alejandroesgo/");
		sendText(" ", "name", "user-submitted-content",
				"Estudiante de Ingeniería de Sistemas de la Información de 7mo ciclo en la UPC");
	}

	@After
	public void tearDown() throws Exception {
		driver.wait();
	}
}
