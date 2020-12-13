#language: pt
Funcionalidade: Fazer Login
  Como um usuario
  Gostaria de fazer o login no aplicação

  Contexto:
    Dado que desejo acessar a apliacação
    Quando acessar o endereço "https://financeiro.hostgator.com.br/"

  Esquema do Cenario: Devo validar regras de login
    Dado que informo a conta "<email>"
    E que informo senha "<senha>"
    Quando clico em entrar
    Então a resposta e "<mensagem>"

    Exemplos:
      |   email   |      senha      | mensagem                                                                                  |
      |           |                 | Please fill out this field.                                                               |
      |    a      |                 | Please include an '@' in the email address. 'a' is missing an '@'.                        |
      |    a@     |                 | Please enter a part following '@'. 'a@' is incomplete.                                    |
      |    a@@    |                 | A part following '@' should not contain the symbol '@'.                                   |
      |    a@A    |                 | Please fill out this field.                                                               |
      |    a@A    |      1          | Please lengthen this text to 5 characters or more (you are currently using 1 character).  |
      |    a@A    |      1234       | Please lengthen this text to 5 characters or more (you are currently using 4 characters). |
      |    a@A    |      12345      | Confirme que você não é um robô clicando no reCaptcha abaixo                              |