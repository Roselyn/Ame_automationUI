package steps;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.LoginPage;

public class Steps {
	
	private WebDriver driver;
	private LoginPage login;
		
	@Dado("que esteja na tela inicial da loja")
	public void que_esteja_na_tela_inicial_da_loja() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        
	}

	@Quando("eu clicar em Sign in")
	public void eu_clicar_em_Sign_in() {
		
		login = new LoginPage(driver);
		
		login.clickSingIn();
		
	}

	@E("informar um {string} válido")
	public void informar_um_usuário_válido(String usuario) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email")));
		
		login.escreverEmail(usuario);
		
	}

	@E("inserir uma {string} válida")
	public void inserir_uma_senha_válida(String passwd) {
		
		login.escreverSenha(passwd);
		
	}
	
	@E("clicar em Sign in")
	public void clicar_em_Sign_in() {
		
		login.clickSingOn();
		
	}

	@Então("a tela de My Store será exibida")
	public void a_tela_de_My_Store_será_exibida() {
			
		String rightLogin = driver.findElement(By.cssSelector(".page-heading")).getText();
		Assert.assertEquals(rightLogin, "MY ACCOUNT");

	}
	
	@E("informar um {string} inválido")
	public void informar_um_inválido(String usuario1) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email")));
		
		login.escreverEmail(usuario1);

	}

	@E("inserir uma {string} inválida")
	public void inserir_uma_inválida(String passwd1) {
		
		login.escreverSenha(passwd1);

	}

	@Então("a mensagem Invalid email address será exibida")
	public void a_mensagem_Invalid_email_address_será_exibida() {
		
		String erroLogin = driver.findElement(By.cssSelector("ol > li")).getText();
		Assert.assertEquals(erroLogin, "Invalid password.");
		
	}

	@E("informar um {string} em branco")
	public void informar_um_em_branco(String usuario2) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#email")));
		
		login.escreverEmail(usuario2);
	
	}

	@E("inserir uma {string} em branco")
	public void inserir_uma_em_branco(String passwd2) {
		
		login.escreverSenha(passwd2);
		  
	}

	@Então("a mensagem An email address required será exibida")
	public void a_mensagem_An_email_address_required_será_exibida() {
		
		String erroLogin = driver.findElement(By.cssSelector("ol > li")).getText();
		Assert.assertEquals(erroLogin, "An email address required.");
		
	}
	
	@After(order = 1)
	public void screenshot(Scenario cenario) {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@After(order = 0)
	public void fecharBrowser(){
		
		driver.quit();
	
	}
}
