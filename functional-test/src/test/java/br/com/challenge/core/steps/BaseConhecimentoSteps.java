package br.com.challenge.core.steps;

import br.com.challenge.core.pageobjects.LoginPageObject;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseConhecimentoSteps {
    private WebDriver driver;
    private LoginPageObject loginPageObject;

    @Dado("que desejoa cessar a url {string}")
    public void queDesejoaCessarAUrl(String url) {
        driver =  new ChromeDriver();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.open(url);
    }

    @Dado("clico em acessar agora")
    public void clicoEmAcessarAgora() {
        loginPageObject.cliqueBaseConhecimento();
    }
    @Então("abre outra aba do navegador com o titulo {string}")
    public void abreOutraAbaDoNavegadorComOTitulo(String tituloEsperado) {
        List<String> abas = new ArrayList<>(driver.getWindowHandles());
        String tituloBrowser = driver.switchTo().window(abas.get(1)).getTitle();
        try{
            Assert.assertEquals(tituloEsperado, tituloBrowser );
        }finally {
            driver.quit();
        }
    }
}
