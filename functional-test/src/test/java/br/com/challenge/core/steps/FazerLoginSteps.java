package br.com.challenge.core.steps;

import br.com.challenge.core.pageobjects.LoginPageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FazerLoginSteps {

    WebDriver driver;

    LoginPageObject loginPageObject;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Dado("que desejo acessar a apliacação")
    public void queDesejoAcessarAApliacação() {
        loginPageObject = new LoginPageObject(driver);
    }

    @Quando("acessar o endereço {string}")
    public void acessarOEndereço(String url) {
        loginPageObject.open(url);

    }
    @Dado("que informo a conta {string}")
    public void queInformoAConta(String email) {
        loginPageObject.setCampoEmail(email);
    }
    @Dado("que informo senha {string}")
    public void queInformoSenha(String password) {
        loginPageObject.setCampoSenha(password);
    }
    @Quando("clico em salvar")
    public void clicloEmSalvar() {
       loginPageObject.salvar();
    }
    @Então("a resposta e {string}")
    public void aRespostaE(String mensagem) {
        Assert.assertEquals(mensagem, loginPageObject.pegaMensagem());
    }

    @After
    public void fecharBrowser(){
        driver.close();
    }
}
