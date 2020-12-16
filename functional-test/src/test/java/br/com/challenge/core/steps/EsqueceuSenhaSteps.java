package br.com.challenge.core.steps;

import br.com.challenge.core.pageobjects.LoginPageObject;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EsqueceuSenhaSteps {

    private WebDriver driver;
    private LoginPageObject loginPageObject;

    @Dado("que desejo acessar a apliacação na url {string}")
    public void queDesejoAcessarAApliacaçãoNaUrl(String url) {
        driver = new ChromeDriver();
        loginPageObject = new LoginPageObject(driver);
        loginPageObject.open(url);
    }

    @Dado("clico em esqueceu a senha")
    public void clicoEmEsqueceuASenha() {
        loginPageObject.cliqueEsqueceuSenha();
    }

    @Então("sou redirecionado para pagina de esqueceu a senha que possui titulo {string}")
    public void souRedirecionadoParaPaginaDeEsqueceuASenhaQuePossuiTitulo(String titulo) {
        String logoTitulo = driver.findElement(By.className("logo-title")).getText();
        try{
            Assert.assertEquals(titulo, logoTitulo);
        }finally {
            driver.close();
        }
    }
}
