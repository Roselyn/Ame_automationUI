package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By txt_username = By.cssSelector("#email");
	
	By txt_password = By.cssSelector("#passwd");
	
	By btn_sign_on = By.linkText("Sign in");
	
	By btn_sign_in = By.cssSelector("#SubmitLogin");
	
	
	//Constructor
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	public void escreverEmail(String username) {
		
		driver.findElement(txt_username).sendKeys(username);
		
	}
	
	public void escreverSenha(String passwd) {
		
		driver.findElement(txt_password).sendKeys(passwd);
		
	}
	
	public void clickSingOn() {
		
		driver.findElement(btn_sign_in).click();
		
	}
	
	public void clickSingIn() {
		
		driver.findElement(btn_sign_on).click();
		
	}

}
