# language:pt

Funcionalidade: Login
  Para acessar a loja
  Sendo um cliente cadastrado
  Quero fazer o login com sucesso
  
Contexto: Login

Dado que esteja na tela inicial da loja
Quando eu clicar em Sign in

Esquema do Cenário: Login Sucesso

E informar um <usuario> válido
E inserir uma <passwd> válida
E clicar em Sign in
Então a tela de My Store será exibida

Exemplos:

|passwd  |usuario                       |
|"TestUI"|"vsdenybcgozvdngeaw@awdrt.com"|

Esquema do Cenário: Login Inválido

E informar um <usuario1> inválido
E inserir uma <passwd1> inválida
E clicar em Sign in
Então a mensagem Invalid email address será exibida

Exemplos:

|passwd1|usuario1            |
|"Test" |"vsdenyb@awdrt.com" |


Esquema do Cenário: Login em Branco

E informar um <usuario2> em branco
E inserir uma <passwd2> em branco
E clicar em Sign in
Então a mensagem An email address required será exibida

Exemplos:

|passwd2|usuario2|
|""     |   ""   |



