# Gerenciador de Mercantil

## Sistema em Java

[![Build Status](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://github.com/IsraelSnar/gerenciador-mercantil)

[![Build Status](https://img.shields.io/badge/Version-1.0-brightgreen)](https://github.com/IsraelSnar/gerenciador-mercantil)

### Configuração
Para configurar o sistema, você deve abrir o arquivo ```Aplicacao.java``` localizado dentro de `src/trabalhomercantil/` e na linha _23_ modificar a String ```PATH/TrabalhoMercantil/src/assets/```, substituindo a palavra ``PATH`` pelo seu caminho completo até o diretório. 
**Obs:** não coloque caminho relativo, coloque o caminho completo, desde `/` ou `C:/` até o diretório raiz do projeto que já está inserida na String.

### Bibliotecas
O projeto utiliza uma biblioteca, a json-simple, que está no diretório `src/packages/`, mas você pode baixa-lá clicando [aqui](https://code.google.com/archive/p/json-simple/downloads). Essa biblioteca é usada nesse projeto para ler Json armazenado nos arquivos, carregando algumas informações.

### Compilação
Recomendamos o uso da IDE netbeans ou Eclipse ou outra que suporte a programação java e consiga conectar-se as bibliotecas e outros arquivos. A construção desse projeto foi realizado no netbeans, e já foi configurado para o caminho relativo e puxar a biblioteca json-simple da pasta assets, caso o projeto seja compilado em outro editor como VS code ou terminal não remova a biblioteca desse diretório pois será lá que o Java irá atrás. Também foi definido o diretório `src/packages/` como local para puxar qualquer outras bibliotecas, portanto, caso queira modificar o projeto e adicionar bibliotecas externas lá será o local.

## Sistema
### Comandos
 * Help: mostra comandos do sistema
 * Show: mostra informações do usuário logado
 * Reset: apaga todas as informações do arquivo *mercantil.json* reiniciando o sistema, mantem ainda dados de login
 * Cash: entra no caixa, possui comandos especificos [veja aqui](#cash)
 * Product: entra nos produtos, possui comandos especificos [veja aqui](#product)
 * Stock: lista todos os produtos salvos no banco de dados
 <!-- * Balance:  -->
 * Sales: lista todas as vendas realizadas mostrando o valor de cada compra.
 
**Obs:** esses comandos aqui listados tratam apenas de comandos do sistema em geral, dentro do sistema alguns comandos requerem informações a mais, e esses possuem sua própria lista de comandos e ajuda.

### Funções
 * **Login**: para acessar o sistema, todo funcionário deve realizar

### Usuários
De início o sistema possui apenas dois tipos principais, sendo: administrador e funcionário caixa. Pode configurar um funcionário com outro tipo de cargo, entretanto não haverá grande diferença pois tem apenas 2 tipos de configurações, para adiministrador ou funcionário. O cargo deve ser configurado com todas as letras em maiúsculo e sem caracteres especiais, letras acentuada ou qualquer outro símbolo, apenas letras.

## Comandos especificos

#### Cash
 * **↵**: basta digitar `cash` e dar enter para entrar no loop
<br>Dentro do loop tem:

 * **0**: sair do loop caixa
 * **↵**: basta dar mostrar enter para mostrar help dos comandos do caixa, vamos tratar deles aqui também
 * **new**: criar nova compra, é um loop que para sair deve ser digitado "0".
     * **ID**: código de barras 
     * **QUANTIDADE**: quantidade de produtos
     * **0**: sair do loop de compra
 * **remove** ou **-** {ID}: remover produto, informe o código de barras junto ao comando.
 * **finish**: finalizar compra, realiza ação de informar método de pagamento.
 * **sangria**: realizar sangria, remove dinheiro do caixa e adiciona ao saldo da empresa
 * **show**: listar itens da compra atual

#### Product
 * **↵**: basta digitar `product` e dar enter para entrar no loop
<br>Dentro do loop temos:

 * **0**: sair do loop produto.
 * **↵**: basta dar enter para mostrar help dos comandos do produto.
 * **new**: novo produto, insira o comando e dê enter, após será pedido as informações para cadastrar o produto
     * **código**: código de barras do produto, esse é um codigo único.
     * **nome**: nome do produto. ex: Arroz, Feijão Pai João...
     * **descrição**: recomenda-se adicionar o peso. ex: 1kg, 500g, 1l...
     * **categoria**: Informe o ID da categoria em questão, para ver as categorias [veja aqui](#categorias).
     * **preço**: preço do produto, troque a vírgula por `.`(ponto final). Ex: 5.50, 6.00, 1...
     * **estoque**: quantidade atual de produtos disponíveis.
     * **estoque crítico**: quantidade mínima que deve ter no estoque.
     * **Obs:** todas as informações devem ser separadas por `;`(ponto e vírgula).
 * **list**: listar todos os produtos cadastrados, o comando [stock](#comandos) também faz a mesma coisa
 * **show** {ID}: lista o produto específico, informe o código de barras junto ao comando e será retornado o produto ou uma mensagem informando a inexistência dele.
 * **delete** {ID}: apaga o produto específico, informe o código de barras junto ao comando, caso exista o produto ele será apagado, caso não retornará uma mensagem de inexistência.
 * **edit**: editar o produto específico, informe todas as informações pedidas para editar o produto, caso o produto exista será impresso uma mensagem de sucesso, caso contrário uma mensagem de erro informando que o produto não existe. 
     * **ID**: código de barras do produto, usado para verificar se o mesmo existe no banco de dados
     * **NOME**: novo nome do produto
     * **DESCRIÇÃO**: nova descrição/peso do produto
     * **CATEGORIA**: categoria
     * **PRECO**: preço do produto


#### Categorias
 * [0] **LIMPEZA**
 * [1] **CONGELADOS_E_FRIOS**
 * [2] **HORTIFRUTI**
 * [3] **HIGIENE_PESSOAL**
 * [4] **BEBIDAS**
 * [5] **PAPELARIA**
 * [6] **PADARIA**
 * [7] **MERCEARIA_EM_GERAL**
 * [8] **CARNES**
 * [9]  **UTILIDADES**
 * [10] **PERECIVEL**
 * [11] **OUTROS**