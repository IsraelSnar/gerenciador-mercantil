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
        boolean adm;
        String token;

        /**
         * Ler arquivo 'mercantil.json' e verifica se possui 0 Caso possua então
         * apaga e inicializa a função para preencher dados da empresa Se não
         * então apenas pega os dados e continua a proseguir a execução do
         * programa
         */
        Init iniciar = new Init();
        Estoque a = new Estoque();
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
                if (ui[0].equals("0")) {
                    System.exit(0);
                }
            } else {
                System.out.println("Usuário: " + ui[0] + "\n\r Senha: " + ui[1]);
                iniciar.login(ui[0], ui[1]);
            }
            token = iniciar.getToken();
            adm = iniciar.isAdm();

            SUPER:
            while (true) {
                while (token == null) {
                    System.out.println("Informe usuário e senha separados por espaço");
                    System.out.println("Ou digite 0 para finalizar o programa");
                    System.out.print("~ ");
                    line = leitor.nextLine();
                    ui = line.split(" ");

                    //System.out.println("tamanho do array[ui]: " + ui.length);
                    if ((ui.length < 2)) {
                        if (ui[0].equals("0")) {
                            System.exit(0);
                        }
                        System.err.println("Erro! Informe usuário e senha");
                    } else {
                        System.out.println("$ Usuário: " + ui[0] + "\r\n Senha: " + ui[1]);
                        iniciar.login(ui[0], ui[1]);
                        token = iniciar.getToken();
            adm = iniciar.isAdm();
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
                            adm = false;
                            iniciar.logout();
                            break OUTER;
                        case "show":
                            System.out.println("mostrar dados");
                            System.out.println("Não implementado");
                            System.out.println("User:" + iniciar.toString());
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
                        case "product":
                            /**
                             * precisa de permissão
                             */
                            if (iniciar.isAdm()) {
                                System.out.println("Produtos:");
                                if (ui.length < 2) {
                                    System.out.println("help produtos: ");
                                    System.out.println(".. new: novo produto\r\n"
                                            + ".. list: listar produtos\r\n"
                                            + ".. show: mostrar produto especifico\r\n"
                                            + ".. delete: apagar produto especifico\r\n"
                                            + ".. edit: editar produto especifico");
                                    break;
                                }
                                switch (ui[1]) {
                                    case "new":
                                        Produto p = new Produto("1234567890123", "Arroz", "1kg", 1, 5, 100, 20);
                                        a.adcionarProduto(p);
                                        p = new Produto("0123456789012", "Arroz", "1kg", 1, 5, 100, 20);
                                        a.adcionarProduto(p);
                                        p = new Produto("9876543210987", "Arroz", "1kg", 1, 5, 100, 20);
                                        a.adcionarProduto(p);
                                        break;
                                    case "list":
                                        a.listarProduto();
                                        break;
                                    case "show":
                                        System.out.println("Informe codigo de barras para encontrar produto ou informe 0 para cancelar");
                                        line = leitor.nextLine();
                                        ui = line.split(" ");
                                        if (ui[0].equals("0")) {
                                            break;
                                        } else {
                                            System.out.println(a.encontrarProduto(ui[0]));
                                        }
                                        break;
                                    case "delete":
                                        System.out.println("Informe codigo de barras para excluir produto ou informe 0 para cancelar");
                                        line = leitor.nextLine();
                                        ui = line.split(" ");
                                        if (ui[0].equals("0")) {
                                            break;
                                        } else {
                                            a.excluirProduto(ui[0]);
                                        }
                                        break;
                                    case "edit":
                                        System.out.println("Informe CODIGO_DE_BARRAS NOME DESCRICAO CATEGORIA PRECO");
                                        System.out.println("O codigo de barras é usado para identificar o produto informe com cuidado");
                                        line = leitor.nextLine();
                                        ui = line.split(" ");
                                        a.editarProduto(ui[0], ui[1], ui[2], Integer.parseInt(ui[3]), Integer.parseInt(ui[4]));
                                        break;
                                    default:
                                        break;
                                }
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
                        case "sale":
                            System.out.println("venda:");
                            System.out.println("Não implementado");
                            break;
                        case "cash":
                            System.out.println("Caixa:");
                            System.out.println("Para sair digite '0'");
                            System.out.println("Digite 'help' para mostrar comandos");
                            line = leitor.nextLine();
                            ui = line.split(" ");
                            while (true) {
                                if (ui[0].equals("0")) {
                                    break;
                                } else {
                                    switch (ui[0]) {
                                        case "help":
                                            break;
                                        case "new":
                                            break;
                                        case "sangria":
                                            System.out.println("fazer sangria");
                                            /**
                                             * tirar diheiro do caixa e colocar
                                             * no saldo da empresa
                                             */
                                            break;
                                        default:
                                            break;
                                    }
                                }
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
                        case "help":
                            if (iniciar.isAdm()) {
                                System.out.println(Cor.getANSI_WHITE_BACKGROUND() + Cor.getANSI_RED() + "$ reset: apagar todos os dados do sistema (exceto logins)" + Cor.getANSI_RESET());
                            }
                            System.out.println("$ exit: fechar programa");
                            //System.out.println("$ show: mostrar informações do usuário");
                            System.out.println("$ logout: sair da conta");
                            System.out.println("$ help: mostrar comandos");
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
