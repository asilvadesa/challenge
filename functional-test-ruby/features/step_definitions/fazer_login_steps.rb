Dado('que desejo acessar a apliacação') do
  visit "https://financeiro.hostgator.com.br/"
  find('#cookie-cta').click
end

Dado('que informo o email {string}') do |email|
  find(".email-input").set email
end

Dado('que informo senha {string}') do |senha|
  find("#password").set senha
end

Quando('clico em entrar') do
  click_button "Entrar"
end

Então('a resposta e {string}') do |msg_resposta|

  elemenent = find(".email-input")
  log elemenent.valid

  message = find(".email-input").native.attribute("validationMessage")
  expect(message).to eq msg_resposta
end
