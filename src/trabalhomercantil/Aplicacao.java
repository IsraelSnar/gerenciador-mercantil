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
        Estoque a = new Estoque();
        Helps help = new Helps();
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
                    //|| ui[0].equals("")
                }
            } else {
                System.out.println("$ " + ui[0] + ":" + ui[1]);
                iniciar.login(ui[0], ui[1]);
            }
            token = iniciar.getToken();

            SUPER:
            while (true) {
                while (token == null) {
                    System.out.println("Informe usuário e senha separados por espaço");
                    System.out.println("Ou digite 'exit' para finalizar o programa");
                    System.out.print("~ ");
                    line = leitor.nextLine();
                    ui = line.split(" ");

                    //System.out.println("tamanho do array[ui]: " + ui.length);
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

                OUTER:
                while (token != null) {
                    iniciar.initRead(iniciar.isAdm());
                    System.out.print("~ ");
                    //System.out.println("adm: " + adm + "token: " + token);
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
//                            System.out.println("mostrar dados");
//                            System.out.println("Não implementado");
                            System.out.println(iniciar.toString());
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
                                            break;
                                        case "add":
                                            break;
                                        case "+":
                                            break;
                                        case "finish":
                                            break;
                                        case "remove":
                                            break;
                                        case "-":
                                            break;
                                        case "sangria":
                                            System.out.println("fazer sangria");
                                            /**
                                             * tirar diheiro do caixa e colocar
                                             * no saldo da empresa
                                             */
                                            break;
                                        default:
                                            System.out.println("Comando invalido; Informe 0 para sair ou '↵' (ENTER) para ajuda");
                                            break;
                                    }
                                }
                                System.out.print("~: ");
                                line = leitor.nextLine();
                                ui = line.split(" ");
                            }
                            break;
                        case "help":
                            System.out.println("Para mais informações digite apenas o comando e veja mais informações no help do comando");
                            if (iniciar.isAdm()) {
                                System.err.println("# reset: apagar todos os dados do sistema (exceto logins)");
                                System.out.println("# stock: apagar todos os dados do sistema (exceto logins)");
                                System.out.println("# sales: vendas realizadas");
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

                                DOWN:
                                while (true) {
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
                                            System.out.println("Digite '↵' (ENTER) para mostrar ajuda em cada parametro");
                                            System.out.println("Para informar numeros reais (com virgula) use o '.'");
                                            while (true) {
                                            System.out.println("Informe CODIGO; NOME; DESCRICAO; CATEGORIA; PRECO; ESTOQUE; ESTOQUE_CRITICO");
                                                System.out.print(": ");
                                                line = leitor.nextLine();
                                                ui = line.split(";");
                                                if (ui[0].equals("")) {
                                                    help.getHelpProductNew();
                                                } else if (ui[0].equals("0")) {
                                                    break;
                                                } else if (ui.length < 6) {
                                                    System.err.println("Erro: todas as informações não foram inseridas, o produto não foi cadastrado");
                                                } else {
                                                    ui[4] = ui[4].replace(',', '.');
                                                    Produto p = new Produto(ui[0], ui[1], ui[2], Integer.parseInt(ui[3]), Float.parseFloat(ui[4]), Integer.parseInt(ui[5]), Integer.parseInt(ui[6]));
                                                    a.adcionarProduto(p);
                                                }
                                            }
                                            break;
                                        case "list":
                                            a.listarProdutos();
                                            break;
                                        case "show":
                                            System.out.println("Informe codigo de barras para encontrar produto ou informe 0 para cancelar");
                                            System.out.print(": ");
                                            line = leitor.nextLine();
                                            ui = line.split(" ");
                                            if (ui.length < 2) {
                                                System.err.println("Erro: informe código de barras junto ao comando");
                                            } else {
                                                System.out.println(a.encontrarProduto(ui[1]));
                                            }
                                            break;
                                        case "delete":
//                                            System.out.println("Informe codigo de barras para excluir produto ou informe 0 para cancelar");
//                                            line = leitor.nextLine();
//                                            System.out.print(": ");
//                                            ui = line.split(" ");
                                            if (ui.length < 20) {
                                                System.err.println("Erro: informe código de barras junto ao comando");
                                            } else {
                                                a.excluirProduto(ui[1]);
                                            }
                                            break;
                                        case "edit":
//                                            System.out.println("Informe CODIGO_DE_BARRAS NOME DESCRICAO CATEGORIA PRECO");
//                                            System.out.println("O codigo de barras é usado para identificar o produto informe com cuidado");
//                                            System.out.println("Para ver categorias digite '↵' (ENTER)");
//                                            System.out.print(": ");
//                                            line = leitor.nextLine();
//                                            ui = line.split(" ");
                                            help.getHelpProductEdit();

                                            if (ui.length < 2) {
                                                System.err.println("Erro: informe tudo que é pedido junto ao comando");
                                            } else {
                                                a.editarProduto(ui[1], ui[2], ui[3], Integer.parseInt(ui[4]), Integer.parseInt(ui[5]));
                                            }

//                                            System.out.print(": ");
//                                            line = leitor.nextLine();
//                                            ui = line.split(" ");
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
