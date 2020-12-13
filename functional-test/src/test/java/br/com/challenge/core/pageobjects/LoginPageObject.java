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

    private Integer tamanhoDaSenha;

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
    }

    public void setCampoEmail(String email) {
        campoEmail.sendKeys(email);
    }

    public void setCampoSenha(String senha) {
        campoSenha.sendKeys(senha);
        tamanhoDaSenha = senha.length();
    }

    public void salvar() {
        botaoSalvar.click();
    }

    public String pegaMensagem(){
        buscaElementos();
        if (!emailEhValido()){
           return (String)js.executeScript("return arguments[0].validationMessage;", campoEmail);

        }else if(!senhaEhValido()){
           return (String)js.executeScript("return arguments[0].validationMessage;", campoSenha);
        }
        return driver.findElement(By.tagName("span")).getText();
    }

    private Boolean emailEhValido() {
        return  (Boolean) js.executeScript("return arguments[0].checkValidity();", campoEmail);
    }
    private Boolean senhaEhValido() {
        return  (Boolean) js.executeScript("return arguments[0].checkValidity();", campoSenha);
    }

}
