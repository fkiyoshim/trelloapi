#language:pt

Funcionalidade: Realizar login
  Eu como usuário desejo ter acesso ao sistema para que eu possa utiliza-lo

@001
  Cenário: Login API token recuperado com sucesso
  Dado que sejam passadas as credenciais 
  Quando o webserice login for executado
  Então deve obter a seguinte resposta: statusCode '200' e token gerado


@02
Cenário: criar um card
Dado que o usuário cria um Board
E o id do board é guardado 
E o usuario cria uma lista a partir do id do board
E o id da lista é guardado
E o usuário cria um card a partir do id da lista
Quando o card é criado
Então o usuário tem acessa as informações geradas para o card





#autorizar/pegar key do meu usuário
#https://trello.com/1/authorize?expiration=never&scope=read,write,account&response_type=token&name=Server%20Token&key=ad3cb8118c2688a49b8e4a1482c1c631