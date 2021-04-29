# SR-Challenge

Alejandro Augusto Espejo Gonzalez
alejandro_espejo_g@hotmail.com
u201815565@upc.edu.pe
+51997329195

Herramientas utilizadas para el desarrollo del ejercicio:
- Freamework Selenium
- JUnit 
- ChromeDriver

Se creó la función sendText(), la cual cuenta con 7 líneas de código 
    
    public void sendText(String label, String selectorType, String selector, String value) {
		if (selectorType == "name") {
			driver.findElement(By.name(selector)).sendKeys(value);
		} else if (selectorType == "css") {
			driver.findElement(By.cssSelector("input[name ='" + selector + "']")).sendKeys(value);
		} else {
			driver.findElement(By.xpath("//input[@name='" + selector + "']")).sendKeys(value);
		}
	}
	
	
Se creó testApprater() para ejecutar el test con los parámetros establecidos

	@Test
	public void testApprater() {
		sendText("myName", "name", "user-submitted-name", "Alejandro Espejo");
		sendText("EmailAddress", "css", "user-submitted-email", "alejandro_espejo_g@hotmail.com");
		sendText("ProductTitle", "xpath", "user-submitted-title", "Postulación");
		sendText("ProductUrl", "css", "user-submitted-url[]", "https://www.linkedin.com/alejandroesgo/");
		sendText(" ", "name", "user-submitted-content", "Estudiante de Ingeniería de Sistemas de la Información de 7mo ciclo en la UPC");
	}
