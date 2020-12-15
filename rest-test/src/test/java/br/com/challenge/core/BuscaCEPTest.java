package br.com.challenge.core;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class BuscaCEPTest {

    @Test
    public void naoDeve_RetornarEnderecoComCEPVazio(){

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/")
        .then()
                .statusCode(405)
                .body("message", is("Method not allowed. Must be one of: OPTIONS"))
        ;
    }

    @Test
    public void naoDeve_RetornarEnderecoComCEPInvalido(){
        given()
        .when()
                .get("https://financeiro.hostgator.com.br/api/v3/checkout/cep/1")
        .then()
            .log().all()
            .statusCode(400)

        ;
    }


    public String buscaRegiaoCep(Integer num){

        switch (num){
            case 0:
            case 1:
                return "SP";
            case 2:
                return "RJ, ES";
            case 3:
                return "MG";
            case 4:
                return "BA, SE";
            case 5:
                return "PB, AL, PB, RN";
            case 6:
                return "CE, PI, MA, PA, AM, AC, AP, RR";
            case 7:
                return "DF, GO, TO, MS, RO";
            case 8:
                return "PR, SC";
            case 9:
                return "RS";
            default:
                throw new IllegalArgumentException("CEP Invalido");
        }

    }

}
