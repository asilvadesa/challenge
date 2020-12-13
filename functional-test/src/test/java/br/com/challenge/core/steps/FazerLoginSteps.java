package br.com.challenge.core.steps;

import io.cucumber.java.pt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FazerLoginSteps {

    WebDriver driver;
    JavascriptExecutor js;

    @Dado("que desejo acessar a apliacação")
    public void queDesejoAcessarAApliacação() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @Quando("acessar o endereço {string}")
    public void acessarOEndereço(String url) {
        driver.get(url);
        driver.findElement(By.id("cookie-cta")).click();
    }
    @Dado("que informo a conta {string}")
    public void queInformoAConta(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }
    @Dado("que informo senha {string}")
    public void queInformoSenha(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }
    @Quando("clico em salvar")
    public void clicloEmSalvar() {
       driver.findElement(By.tagName("button")).click();
    }
    @Então("a resposta e {string}")
    public void aRespostaE(String string) {
//        WebElement email = driver.findElement(By.name("email"));
//        //Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", email);
        String message = (String)js.executeScript("return arguments[0].validationMessage;", driver.findElement(By.name("email")));
        System.out.println(message);
    }
}
