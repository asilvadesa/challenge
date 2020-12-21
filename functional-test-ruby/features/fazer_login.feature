#language: pt
Funcionalidade: Fazer Login
  Como um usuario
  Gostaria de fazer o login na aplicação


    Cenario: Fazer Login sem email e sem senha
        Dado que acesso a pagina da aplicação
        Quando eu digito no campo amail ""
        E eu digito no campo senha ""
        Então a mensagem de retorno "Please fill out this field."