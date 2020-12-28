#language: pt
Funcionalidade: Fazer Login
        Como um usuario
        Gostaria de fazer o login na aplicação

    @sem_email
    Cenario: Fazer Login sem email e sem senha
      Dado que acesso a pagina da aplicação
      Quando eu clico no botão entrar
      Então a mensagem de retorno: Please fill out this field.

    @email_incorreto
    Cenario: Fazer Login com email com uma letra e senha vazia
      Dado que acesso a pagina da aplicação
      E preencho o campo email com a letra A
      Quando eu clico no botão entrar
      Então a mensagem de retorno: Please include an @ in the email address. a is missing an @.

    @email_letraEarroba
    Cenario: Fazer Login com email com uma letra e @ e campo senha vazio
      Dado que acesso a pagina da aplicação
      E preencho o campo email com a letra a@
      Quando eu clico no botão entrar
      Então a mensagem de retorno: Please enter a part following @. a@ is incomplete.