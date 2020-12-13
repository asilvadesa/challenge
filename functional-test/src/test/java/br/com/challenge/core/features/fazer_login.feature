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
    Quando selecio a opção salvar
    Então a resposta é "<mensagem>"

    Exemplos:
      | email                | senha  | mensagem                                                                    |
      |                      |        | Please fill out this field.                                                 |
