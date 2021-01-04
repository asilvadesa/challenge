package br.com.challenge.core;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BuscaCEPTest {

    @Test
    public void naoDeve_RetornarEnderecoCEPVazio(){

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/" + "    9")
        .then()
                .statusCode(405)
                .body("message", is("Method not allowed. Must be one of: OPTIONS"))
        ;
    }

    @Test
    public void naoDeve_RetornarEnderecoCEPComApenasUmDigito(){
        given()
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/1")
        .then()
            .statusCode(400)
            .body("notifications.field", hasItem("CEP"))
            .body("notifications.level", hasItem("VALIDATION_ERROR"))
        ;
    }

    @Test
    public void naoDeve_RetornaEnderecoCEPComMaisDeOitoDigitosNumericos(){
        given()
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/690741005")
        .then()
                .statusCode(400)
                .body("notifications.field", hasItem("CEP"))
                .body("notifications.level", hasItem("VALIDATION_ERROR"));
    }

    @Test
    public void naoDeve_RetornarEnderecoCEPContendoDigitosAlfaNumericos(){
        given()
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/A69074100")
        .then()
                .body("data", nullValue());
    }

    @Test
    public void naoDeve_RetornarEnderecoCEPContendoDigitosCaracteresEspeciais(){
        given()
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/13165-000(*")
        .then()
                .body("data", nullValue());
    }

    @Test
    public void deve_RetornarCodigoStatus404ComCEPValidoMasNaoExistente(){
        given()
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/69070109")
        .then()
                .statusCode(404)
                .body("data", nullValue());
    }

    @Test
    public void deve_RetornarMensagemNotAllowParaMetodoPostCEPValido(){
        given()
                .accept(ContentType.JSON)
        .when()
                .post("https://financeiro.hostgator.com.br/api/v3/checkout/cep/69074100")
        .then()
                .body("message", is("Method not allowed. Must be one of: OPTIONS, GET"));
    }

    @Test
    public void deve_RetornarMensagemNotAllowParaMetodoPostCEPInvalido(){
        given()
                .accept(ContentType.JSON)
        .when()
                .post("https://financeiro.hostgator.com.br/api/v3/checkout/cep/74100")
        .then()
                .body("message", is("Method not allowed. Must be one of: OPTIONS, GET"));
    }

    @Test
    public void deve_RetornarEnderecoParaCEPValidoExistente(){
        given()
                .accept(ContentType.JSON)
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/20751060")
        .then()
                .body("data", notNullValue())
                .statusCode(200);
    }

}
