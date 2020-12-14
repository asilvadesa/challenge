package br.com.challenge.core.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

    private WebDriver driver;
    private JavascriptExecutor js;

    private WebElement campoEmail;
    private WebElement campoSenha;
    private WebElement botaoSalvar;
    private WebElement linkEsqueceuSenha;


    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public void open(String url) {
        driver.get(url);
        driver.findElement(By.id("cookie-cta")).click();
        buscaElementos();
    }

    private void buscaElementos(){
        campoEmail = driver.findElement(By.name("email"));
        campoSenha = driver.findElement(By.name("password"));
        botaoSalvar =  driver.findElement(By.tagName("button"));
        linkEsqueceuSenha = driver.findElement(By.className("forgot-link"));
    }

    public void setCampoEmail(String email) {
        campoEmail.sendKeys(email);
    }

    public void setCampoSenha(String senha) {
        campoSenha.sendKeys(senha);
    }

    public void salvar() {
        botaoSalvar.click();
    }

    public String pegaMensagem(){
        buscaElementos();
        if (!ehValido(campoEmail)){
           return (String)js.executeScript("return arguments[0].validationMessage;", campoEmail);

        }else if(!ehValido(campoSenha)){
           return (String)js.executeScript("return arguments[0].validationMessage;", campoSenha);
        }
        return driver.findElement(By.tagName("span")).getText();
    }

    private Boolean ehValido(WebElement element){
        return  (Boolean) js.executeScript("return arguments[0].checkValidity();", element);
    }


    public void cliqueEsqueceuSenha() {
        linkEsqueceuSenha.click();
    }
}
