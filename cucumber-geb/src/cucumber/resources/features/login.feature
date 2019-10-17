#language:pt

Funcionalidade: Realizar login
  Eu como usuário desejo ter acesso ao sistema para que eu possa utiliza-lo

  
  Cenário: Login com sucesso
   Dado que o usuário esteja na tela de login
   Quando ele inserir o username 'vanessa'
   E ele inserir o password 'vanessam'
   E ele acessar o sistema 
   Então ele estará no dasboard
