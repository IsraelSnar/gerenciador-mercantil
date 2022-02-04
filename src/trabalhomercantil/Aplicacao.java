/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

import java.util.Scanner;

/**
 *
 * @author Israel
 * @author Joao
 */
public class Aplicacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String path = "D:/Faculdade/POO/TrabalhoMercantil/src/assets/";
        String token;

        /**
         * Ler arquivo 'mercantil.json' e verifica se possui 0 Caso possua então
         * apaga e inicializa a função para preencher dados da empresa Se não
         * então apenas pega os dados e continua a proseguir a execução do
         * programa
         */
        Init iniciar = new Init();
        Estoque estoque = new Estoque();
        Helps help = new Helps();
        Caixa caixa = new Caixa(0);
        Produto p = new Produto("", "", "", 0, 0, 0, 0);
        ContaBancaria cb = new ContaBancaria();
        // ContaBancaria conta = new ContaBancaria(0);
        Venda pontoDeVenda = new Venda();
        VendasRealizadas vendasRealizadas = new VendasRealizadas();
        /**
         * enviar true or false caso o login seja o administrador ou nao
         */
        /**
         * Função de login De acordo com o acesso ele poderá fazer determinadas
         * funções
         */

        iniciar.setPath(path);

        System.out.println("Login");
        System.out.println("Informe usuário e senha separados por espaço");
        System.out.print("~ ");

        try (Scanner leitor = new Scanner(System.in)) {
            String line = leitor.nextLine();
            String ui[] = line.split(" ");

            if ((ui.length < 2)) {
                if (ui[0].equals("exit")) {
                    System.exit(0);
                    // || ui[0].equals("")
                }
            } else {
                System.out.println("$ " + ui[0] + ":" + ui[1]);
                iniciar.login(ui[0], ui[1]);
            }
            token = iniciar.getToken();

            SUPER: while (true) {
                while (token == null) {
                    System.out.println("Informe usuário e senha separados por espaço");
                    System.out.println("Ou digite 'exit' para finalizar o programa");
                    System.out.print("~ ");
                    line = leitor.nextLine();
                    ui = line.split(" ");

                    // System.out.println("tamanho do array[ui]: " + ui.length);
                    if ((ui.length < 2)) {
                        if (ui[0].equals("exit")) {
                            System.exit(0);
                        }
                        System.err.println("Erro! Informe usuário e senha");
                    } else {
                        System.out.println("$ " + ui[0] + ":" + ui[1]);
                        iniciar.login(ui[0], ui[1]);
                        token = iniciar.getToken();
                    }
                }

                System.out.println("Escreva 'help' para ver comandos");

                OUTER: while (token != null) {
                    iniciar.initRead(iniciar.isAdm());
                    System.out.print("~ ");
                    // System.out.println("adm: " + adm + "token: " + token);
                    line = leitor.nextLine();
                    ui = line.split(" ");
                    switch (ui[0].toLowerCase()) {
                        case "exit":
                            break SUPER;
                        case "logout":
                            token = null;
                            iniciar.logout();
                            break OUTER;
                        case "show":
                            // System.out.println("mostrar dados");
                            // System.out.println("Não implementado");
                            System.out.println(iniciar.toString());
                            if (iniciar.isAdm()){
                                System.out.println(cb.toString());
                            }
                            break;
                        case "reset":
                            if (iniciar.isAdm()) {
                                System.out.println("Não totalmente implementado");
                                iniciar.reset(iniciar.isAdm());
                            } else {
                                System.out.println("Não tem permissão");
                            }
                            break;
                        case "stock":
                            /**
                             * precisa de permissão
                             */
                            if (iniciar.isAdm()) {
                                System.out.println("estoque:");
                                System.out.println("Não implementado");
                                estoque.listarProdutos();
                            } else {
                                System.out.println("Não tem permissão");
                            }
                            break;
                        case "balance":
                            /**
                             * precisa de permissão
                             */
                            if (iniciar.isAdm()) {
                                System.out.println("saldo:");
                                System.out.println("Não implementado");
                            } else {
                                System.out.println("Não tem permissão");
                            }
                            break;
                        case "sales":
                            System.out.println("vendas:");
                            System.out.println("Não implementado");
                            vendasRealizadas.listarVendasRealizadas();
                            break;
                        case "cash":
                            System.out.println("Caixa: ");
                            System.out.println("Para sair digite '0'");
                            System.out.println("Digite '↵' (ENTER) para mostrar comandos");
                            System.out.print("~: ");
                            line = leitor.nextLine();
                            ui = line.split(" ");

                            while (true) {
                                if (ui[0].equals("0")) {
                                    break;
                                } else {
                                    switch (ui[0]) {
                                        case "":
                                            help.getHelpCash();
                                            break;
                                        case "new":
                                            while (true) {
                                                System.out.println("Informe: ID QUANTIDADE");
                                                System.out.print(": ");
                                                line = leitor.nextLine();
                                                ui = line.split(" ");
                                                if (ui[0].equals("0")) {
                                                    break;
                                                } else if (ui.length < 2){
                                                    System.err.println("Erro, informe código de barras e quantidade");
                                                } else {
                                                    pontoDeVenda.adcionarItem(estoque, ui[0], Integer.parseInt(ui[1]));
                                                }
                                            }
                                            break;
                                        case "finish":
                                            float troco = 0;
                                            boolean validaFormaPagamento = true;
                                            System.out.println("VALOR TOTAL DA COMPRA: R$"
                                                    + pontoDeVenda.finalizarCompra() + "\n\r"
                                                    + "ESCOLHA A FORMA DE PAGAMENTO:" + "\n\r"
                                                    + "1 - DINHEIRO" + "\n\r"
                                                    + "2 - CARTÃO" + "\n\r"
                                                    + "3 - PIX");
                                            line = leitor.nextLine();
                                            ui = line.split(" ");
                                            while (validaFormaPagamento) {
                                                if (Integer.parseInt(ui[0]) <= 0 || Integer.parseInt(ui[0]) >= 4) {
                                                    System.out.println("OPÇÃO NÃO ENCONTRADA!" + "\n"
                                                            + "ESCOLHA A FORMA DE PAGAMENTO:" + "\n"
                                                            + "1 - DINHEIRO" + "\n"
                                                            + "2 - CARTÃO" + "\n"
                                                            + "3 - PIX");
                                                    line = leitor.next();
                                                    ui = line.split(" ");
                                                } else {
                                                    validaFormaPagamento = false;
                                                }
                                            }
                                            if (ui[0].equals("1")) {
                                                System.out.println("Digite valor recebido do cliente:");
                                                line = leitor.next();
                                                ui = line.split(" ");

                                                while (Float.parseFloat(ui[0]) < pontoDeVenda.finalizarCompra()) {
                                                    System.out
                                                            .println("Valor invalido receba um valor maior ou igual a: "
                                                                    + pontoDeVenda.finalizarCompra());
                                                    line = leitor.next();
                                                    ui = line.split(" ");
                                                }
                                                caixa.setSaldoCaixa(caixa.getSaldoCaixa() + Float.parseFloat(ui[0]));
                                                // System.out.println("SALDO DO CAIXA COM DINHEIRO RECEBIDO DO CLIENTE:
                                                // " + caixa.getSaldoCaixa());

                                                troco = Float.parseFloat(ui[0]) - pontoDeVenda.finalizarCompra();
                                                System.out.println("TROCO: R$ " + troco);

                                                caixa.setSaldoCaixa(caixa.getSaldoCaixa() - troco);
                                                // System.out.println("SALDO DO CAIXA DPS DO TROCO : " +
                                                // caixa.getSaldoCaixa());
                                                System.out.println("VENDA REALIZADA COM SUCESSO!");
                                                vendasRealizadas.getVendasRealizada().add(pontoDeVenda.finalizarCompra());

                                            } else {
                                                System.out.println("Nao implementado");
                                                caixa.setSaldoCaixa(
                                                        caixa.getSaldoCaixa() + pontoDeVenda.finalizarCompra());
                                                System.out.println("VENDA REALIZADA COM SUCESSO!");
                                                vendasRealizadas.getVendasRealizada().add(pontoDeVenda.finalizarCompra());
                                            }
                                            break;
                                        case "remove":
                                            if (ui.length < 2) {
                                                System.err.println(
                                                        "Erro, informe \"REMOVE {ID}\" sendo ID o código de barras");
                                            } else {
                                                pontoDeVenda.removerItem(Integer.parseInt(ui[1]));
                                            }
                                            break;
                                        case "-":
                                            break;
                                        case "show":
                                            pontoDeVenda.mostrarListaDeItens();
                                            break;
                                        case "saldo":
                                            System.out.println(caixa.getSaldoCaixa());
                                            break;
                                        case "sangria":
                                            caixa.sangria(caixa.getSaldoCaixa());
                                            System.out.println("fazer sangria");
                                            /**
                                             * tirar diheiro do caixa e colocar
                                             * no saldo da empresa
                                             */
                                            break;
                                        default:
                                            System.out.println(
                                                    "Comando invalido; Informe 0 para sair ou '↵' (ENTER) para ajuda");
                                            break;
                                    }
                                }
                                System.out.print("~: ");
                                line = leitor.nextLine();
                                ui = line.split(" ");
                            }
                            break;
                        case "help":
                            System.out.println(
                                    "Para mais informações digite apenas o comando e veja mais informações no help do comando");
                            if (iniciar.isAdm()) {
                                System.out.println("# stock: lista todos os produtos do estoque");
                            }
                            System.out.println("$ exit: fechar programa");
                            System.out.println("$ show: mostrar informações do usuário");
                            System.out.println("$ logout: sair da conta");
                            System.out.println("$ help: mostrar comandos");
                            System.out.println("$ cash: entrar no caixa");
                            System.out.println("$ product: produtos; informe '↵' (ENTER) para mostrar comandos");
                            break;
                        case "product":
                            /**
                             * precisa de permissão
                             */
                            if (iniciar.isAdm()) {
                                System.out.println("Produtos:");

                                DOWN: while (true) {
                                    System.out.print("~: ");
                                    line = leitor.nextLine();
                                    ui = line.split(" ");
                                    switch (ui[0]) {
                                        case "":
                                            help.getHelpProduct();
                                            break;
                                        case "0":
                                            System.out.println("Saiu do loop");
                                            break DOWN;
                                        case "new":
                                            System.out
                                                    .println("Digite '↵' (ENTER) para mostrar ajuda em cada parametro");
                                            System.out.println("Para informar numeros reais (com virgula) use o '.'");
                                            while (true) {
                                                System.out.println(
                                                        "Informe CODIGO; NOME; DESCRICAO; CATEGORIA; PRECO; ESTOQUE; ESTOQUE_CRITICO");
                                                System.out.print(": ");
                                                line = leitor.nextLine();
                                                line = line.replace("; ", ";");
                                                line = line.replace(" ;", ";");
                                                
                                                ui = line.split(";");
                                                if (ui[0].equals("")) {
                                                    help.getHelpProductNew();
                                                } else if (ui[0].equals("0")) {
                                                    break;
                                                } else if (ui.length < 7) {
                                                    System.err.println(
                                                            "Erro: todas as informações não foram inseridas, o produto não foi cadastrado");
                                                } else {
                                                    ui[4] = ui[4].replace(',', '.');
                                                    try {
                                                        p = new Produto(ui[0], ui[1], ui[2],
                                                                Integer.parseInt(ui[3]), Float.parseFloat(ui[4]),
                                                                Integer.parseInt(ui[5]), Integer.parseInt(ui[6]));
                                                        estoque.adcionarProduto(p);
                                                    } catch (NumberFormatException e) {
                                                        // TODO: handle exception
                                                        System.err.println(
                                                                "Informe apenas números nas informações: categoria, preço, e estoques");
                                                    }

                                                }
                                            }
                                            break;
                                        case "show":
                                            System.out.println(
                                                    "Informe codigo de barras para encontrar produto ou informe 0 para cancelar");
                                            System.out.print(": ");
                                            line = leitor.nextLine();
                                            ui = line.split(" ");
                                            if (ui.length < 2) {
                                                System.err.println("Erro: informe código de barras junto ao comando");
                                            } else {
                                                System.out.println(estoque.encontrarProduto(ui[1]));
                                            }
                                            break;
                                        case "delete":
                                            // System.out.println("Informe codigo de barras para excluir produto ou
                                            // informe 0 para cancelar");
                                            // line = leitor.nextLine();
                                            // System.out.print(": ");
                                            // ui = line.split(" ");
                                            if (ui.length < 2) {
                                                System.err.println("Erro: informe código de barras junto ao comando");
                                            } else {
                                                estoque.excluirProduto(ui[1]);
                                            }
                                            break;
                                        case "edit":
                                            System.out.println(
                                                    "Informe CODIGO_DE_BARRAS | NOME | DESCRICAO | CATEGORIA | PRECO");
                                            System.out.println(
                                                    "O codigo de barras é usado para identificar o produto informe com cuidado");
                                            System.out.println("Para ver categorias digite '↵' (ENTER)");
                                            System.out.print(": ");
                                            line = leitor.nextLine();
                                            line = line.replace("; ", ";");
                                            line = line.replace(" ;", ";");
                                            ui = line.split(";");

                                            if (ui.equals("")) {
                                                help.getHelpProductEdit();
                                            } else if (ui.length < 5) {
                                                System.err.println("Erro: informe tudo que é pedido junto ao comando");
                                            } else {
                                                try {
                                                    ui[4] = ui[4].replace(",", ".");
                                                    estoque.editarProduto(ui[0], ui[1], ui[2], Integer.parseInt(ui[3]),
                                                            Float.parseFloat(ui[4]));
                                                } catch (NumberFormatException e) {
                                                    // TODO: handle exception
                                                    System.out.println(
                                                            "Informe apenas números nas informações: categoria e preço");
                                                }

                                            }

                                            // System.out.print(": ");
                                            // line = leitor.nextLine();
                                            // ui = line.split(" ");
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("Não tem permissão");
                            }
                            break;
                        default:
                            System.out.println("Comando invalido, digite 'help' para ver comandos");
                            break;
                    }
                }
            }
        }
    }
}
