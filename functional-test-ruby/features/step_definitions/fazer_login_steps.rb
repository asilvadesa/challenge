tamanho_senha = 0

Dado('que desejo acessar a apliacação') do
  visit "https://financeiro.hostgator.com.br/"
  find('#cookie-cta').click
end

Dado('que informo o email {string}') do |email|
  find(".email-input").set email
end

Dado('que informo senha {string}') do |senha|
  tamanho_senha = senha.size
  find("#password").set senha
end

Quando('clico em entrar') do
  click_button "Entrar"
end

Então('a resposta e {string}') do |msg_resposta|

  emailValido = execute_script("return arguments[0].checkValidity();", find(".email-input"))
  senhaValido = execute_script("return arguments[0].checkValidity();", find("#password"))

  if emailValido == false
    message = find(".email-input").native.attribute("validationMessage")
    expect(message).to eq msg_resposta
  elsif senhaValido == false && tamanho_senha < 5
    message = find("#password").native.attribute("validationMessage")
    expect(message).to eq msg_resposta
  else
    message = find(".text-danger").text
    expect(message).to eq msg_resposta
  end

end
