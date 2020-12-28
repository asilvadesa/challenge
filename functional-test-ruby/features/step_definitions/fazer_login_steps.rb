Dado('que acesso a pagina da aplicação') do
  visit "https://financeiro.hostgator.com.br/"
  find('#cookie-cta').click
end

Quando('eu clico no botão entrar') do
  click_button "Entrar"
end

Então('a mensagem de retorno: Please fill out this field.') do
  message = find(".email-input").native.attribute("validationMessage")
  expect(message).to eq "Please fill out this field."
end

Dado('preencho o campo email com a letra A') do
  find(".email-input").set "a"
end

Então("a mensagem de retorno: Please include an @ in the email address. a is missing an @.") do
  message = find(".email-input").native.attribute("validationMessage")
  expect(message).to eq "Please include an '@' in the email address. 'a' is missing an '@'."
end

Dado('preencho o campo email com a letra a@') do
  find(".email-input").set "a@"
end

Então('a mensagem de retorno: Please enter a part following @. a@ is incomplete.') do
  message = find(".email-input").native.attribute("validationMessage")
  expect(message).to eq "Please enter a part following '@'. 'a@' is incomplete."
end
