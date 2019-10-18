#language:pt

Funcionalidade: Realizar a Criação de Quadro
  Eu como usuário desejo ter acesso ao sistema para que eu possa utiliza-lo

@cenarioProvaPratica
Esquema do Cenário: Realizar o cadastro de um Quadro, Lista, Cartão e editar o mesmo e em seguida remover todos os registros
Dado que o usuário cria um '<Quadro>'
E o Quadro é criado com sucesso 
E o usuario cria uma '<Lista>' utilizando o Quadro
E a Lista é criada com sucesso
E o usuário cria um Cartão, informando o '<Nome>' e uma 'Descricao'
Quando o Cartão é criado com sucesso
Então o usuário edita o Cartão criado, alterando o '<NomeAlterado>' e a '<DescricaoAlterada>'
E por fim o Cartão e todos os registros são excluído

Exemplos:
|Quadro         |      Lista          |   Nome        | Descricao    |  NomeAlterado    | DescricaoAlterada|
|kanban Trello  |Aguardando Contratado|Ticket-16102019| Em andamento |  Ticket-18102019 | Aprovado         |

@cenario
Cenário: Executar requisição de Autorização informando Key inválida
Dado que o usuário possuir um TokenName (MyPersonalToken)
Quando ele enviar uma requisição de autorização para Api informando um key inválida
Então a requisão nao deve ser executada com sucesso

@cenario
Cenário: Tentar criar um registro sem permissão para criação
Dado que o usuário cria um login com apenas permissão de leitura 
Quando o usuário utilizar a Api de criação de Grupo, Lista ou Cartão
Então o sistema deve informar que o usuário não tem permissão para realizar a operação

@cenario
Cenário: Executar requisição de Criação de Quadro informando Key inválida
Dado que o usuário possui acesso a criação de Quadro
Quando ele enviar uma requisição de criação para Api informando uma key inválida
Então não deve ser criado o Quadro

@cenario
Cenário: Executar requisição de Criação de Quadro informando Token inválida
Dado que o usuário possui acesso a criação de Quadro
Quando ele enviar uma requisição de criação para Api informando um Token inválido
Então não deve ser criado o Quadro

@cenario
Cenário: Executar requisição de Criação de Listas informando Key inválida
Dado que o usuário possui acesso a criação de Listas
Quando ele enviar uma requisição de criação para Api informando uma key inválida
Então não deve ser criado a Lista

@cenario
Cenário: Executar requisição de Criação de Listas informando Token inválida
Dado que o usuário possui acesso a criação de Listas
Quando ele enviar uma requisição de criação para Api informando um Token inválido
Então não deve ser criado a Lista

@cenario
Cenário: Executar requisição de Cartão informando Key inválida
Dado que o usuário possui acesso a criação de Cartão
Quando ele enviar uma requisição de criação para Api informando uma key inválida
Então não deve ser criado o Cartão

@cenario
Cenário: Executar requisição de Cartão informando Token inválida
Dado que o usuário possui acesso a criação de Cartão
Quando ele enviar uma requisição de criação para Api informando um Token inválido
Então não deve ser criado o Cartão

@cenario
Cenário: Remover registro utilizando Id's inválidos
Dado que Dado que o usuário possui acesso a criação de Quadro
Quando ele enviar uma resquição para remover um Quadro, Lista ou Cartão informando um id inválido
Então a operação não deve ser executada e informar ao usuário o motivo

