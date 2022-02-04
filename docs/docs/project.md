# Gerenciador de Mercantil

## CMS em Java

[![Build Status](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://github.com/IsraelSnar/gerenciador-mercantil)

### Configuração
Para configurar o sistema, você deve abrir o arquivo ```Aplicaçao.java``` localizado dentro de `src/trabalhomercantil/` e na linha _23_ modificar a String que está antes de ```"TrabalhoMercantil/src/assets/"```, só deve ser trocado o nome "TrabalhoMercantil" assim como os seguintes caso aja mudança no nome do diretório (e nós não recomendamos isso), caso contrário mantenha como está. 
**Obs:** não coloque caminho relativo, mas coloque o caminho completo, desde `home/` ou `C:/` até o diretório _assets/_ e não esqueça de adicionar a barra ao final 😉.

### Bibliotecas
O projeto utiliza uma biblioteca, a json-simple, que está no diretório `src/assets/`, mas você pode baixa-lá clicando [aqui](https://code.google.com/archive/p/json-simple/downloads).

### Compilação
Recomendamos o uso da IDE netbeans ou Eclipse ou outra que suporte a programação java e consiga conectar-se as bibliotecas e outros arquivos.

## Sistema
### Comandos
 * Help: mostra comandos do sistema
 * Show: mostra informações do usuário logado
 * Reset: apaga todas as informações do arquivo *mercantil.json* reiniciando o sistema, mantem ainda dados de login
 * Cash: entra no caixa, possui comandos especificos [veja aqui](#cash)
 * Product: entra nos produtos, possui comandos especificos [veja aqui](#product)
 <!-- * Stock: 
 * Balance: 
 * Sales: -->
 
**Obs:** esses comandos aqui listados tratam apenas de comandos do sistema em geral, dentro do sistema alguns comandos requerem informações a mais, e esses possuem sua própria lista de comandos e ajuda.

### Funções
 * **Login**: para acessar o sistema, todo funcionário deve realizar

## Comandos especificos

#### Cash
 * **↵**: basta digitar `cash` e dar enter para entrar no loop
<br>Dentro do loop tem:

 * **0**: sair do loop caixa
 * **↵**: basta dar mostrar enter para mostrar help dos comandos do caixa, vamos tratar deles aqui também
 * **new**: criar nova compra, é um loop que para sair deve ser digitado "0".
 * **remove** ou **-** {ID}: remover produto, informe o código de barras junto ao comando.
 * **finish**: finalizar compra, realiza ação de informar método de pagamento.
 * **sangria**: realizar sangria, remove dinheiro do caixa e adiciona ao saldo da empresa
 * **show**: listar itens da compra atual

#### Product
 * **↵**: basta digitar `product` e dar enter para entrar no loop
<br>Dentro do loop temos:

 * **0**: sair do loop produto.
 * **↵**: basta dar enter para mostrar help dos comandos do produto.
 * **new**: novo produto
     * **código**: código de barras do produto, esse é um codigo único.
     * **nome**: nome do produto. ex: Arroz, Feijão Pai João...
     * **descrição**: recomenda-se adicionar o peso. ex: 1kg, 500g, 1l...
     * **categoria**: Informe o ID da categoria em questão, para ver as categorias [veja aqui](#categorias).
     * **preço**: preço do produto, troque a vírgula por `.`(ponto final). Ex: 5.50, 6.00, 1...
     * **estoque**: quantidade atual de produtos disponíveis.
     * **estoque crítico**: quantidade mínima que deve ter no estoque.
 * **list**: listar todos os produtos cadastrados
 * **show** {ID}: lista o produto específico, informe o código de barras junto ao comando e será retornado o produto ou uma mensagem informando a inexistência dele.
 * **delete** {ID}: apaga o produto específico, informe o código de barras junto ao comando, caso exista o produto ele será apagado, caso não retornará uma mensagem de inexistência.
 * **edit** {ID} {NOME} {DESCRIÇÃO} {CATEGORIA} {PRECO}: editar o produto específico, informe todas as informações pedidas para editar o produto, caso o produto exista será impresso uma mensagem de sucesso, caso contrário uma mensagem de erro informando que o produto não existe. <br> **Obs:** informe cuidadosamente o codigo de barras (ID) pois será essa informação usada para encontrar o produto no banco de dados.
 * **Obs:** todas as informações devem ser separadas por `;`(ponto e vírgula).


#### Categorias
 01. **LIMPEZA**
 02. **CONGELADOS_E_FRIOS**
 03. **HORTIFRUTI**
 04. **HIGIENE_PESSOAL**
 05. **BEBIDAS**
 06. **PAPELARIA**
 07. **PADARIA**
 08. **MERCEARIA_EM_GERAL**
 09. **CARNES**
 10. **UTILIDADES**
 11. **PERECIVEL**
 12. **OUTROS**