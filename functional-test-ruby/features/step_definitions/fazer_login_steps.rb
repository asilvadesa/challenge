Dado('que acesso a pagina da aplicação') do
  visit "https://financeiro.hostgator.com.br/"
  find('#cookie-cta').click
end

Quando('eu clico no botão entrar') do
  click_button "Entrar"
end

Então('a mensagem de retorno') do
  message = find(".email-input").native.attribute("validationMessage")
  expect(message).to eq "Please fill out this field."
end
