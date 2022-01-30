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

        String token;
        String path = null;
        boolean adm;

        /**
         * Ler arquivo 'mercantil.json' e verifica se possui 0 Caso possua então
         * apaga e inicializa a função para preencher dados da empresa Se não
         * então apenas pega os dados e continua a proseguir a execução do
         * programa
         */
        Init iniciar = new Init();
        /**
         * enviar true or false caso o login seja o administrador ou nao
         */
        /**
         * Função de login De acordo com o acesso ele poderá fazer determinadas
         * funções
         */
        Scanner leitor = new Scanner(System.in);

        if (path == null) {
            System.out.println("Informe caminho completo ate arquivos, coloque a barra no final");
            System.out.println(Cor.getANSI_WHITE_BACKGROUND() + Cor.getANSI_RED() + "Informe caminho até pasta 'assets' com a '/' no fim" + Cor.getANSI_RESET());
            path = leitor.nextLine();
            iniciar.setPath(path);
            System.out.println(Cor.getANSI_WHITE_BACKGROUND() + Cor.getANSI_BLUE() + "Obs: essa ação é temporária, existe intenção de remoção caso encontremos solução melhor" + Cor.getANSI_RESET());
        }

        System.out.println("Login");
        System.out.println("Informe usuário e senha separados por espaço");
        System.out.print("~ ");

        String line = leitor.nextLine();
        String ui[] = line.split(" ");

        if ((ui.length < 2)) {
            if (ui[0].equals("0")) {
                System.exit(0);
            }
            token = null;
        } else {
            System.out.println("Usuário: " + ui[0] + "\n\rSenha: " + ui[1]);
            token = iniciar.login(ui[0], ui[1]);
        }

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
                    System.out.println("$ Usuário: " + ui[0] + "\n\rSenha: " + ui[1]);
                    token = iniciar.login(ui[0], ui[1]);
                }
            }

            System.out.println("Escreva 'help' para ver comandos");

            OUTER:
            while (token != null) {
                adm = iniciar.isAdm();
                iniciar.initRead(adm);
                System.out.print("~ ");
                //System.out.println("adm: " + adm + "token: " + token);
                line = leitor.nextLine();
                ui = line.split(" ");
                switch (ui[0].toLowerCase()) {
                    case "exit":
                        break SUPER;
                    /*case "show":
                        System.out.println("mostrar dados");
                        System.out.println("Não implementado");
                        break;*/
                    /**
                     * case "write": iniciar.initRead(adm); break;
                     */
                    /*case "stock":
                        /**
                         * precisa de permissão
                         */
                        /*if (adm) {
                            System.out.println("estoque:");
                            System.out.println("Não implementado");
                        } else {
                            System.out.println("Não tem permissão");
                        }
                        break;*/
                    /*case "product":
                        /**
                         * precisa de permissão
                         */
                        /*if (adm) {
                            System.out.println("Produtos:");
                            Produto p = new Produto();
                            Estoque a = new Estoque();
                            if (ui[1].equals("new")) {
                                p = new Produto("1234567890123", "Arroz", "1kg", 1, 5, 100, 20);
                                a.adcionarProduto(p);
                            } else if (ui[1].equals("show")) {
                                a.listarProduto();
                            }
                        } else {
                            System.out.println("Não tem permissão");
                        }
                        break;*/
                    /*case "balance":
                        /**
                         * precisa de permissão
                         */
                        /*if (adm) {
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
                        System.out.println("caixa:");
                        System.out.println("Não implementado");
                        break;
                    case "reset":
                        if (adm) {
                            iniciar.reset(adm);
                            System.out.println("Não totalmente implementado");
                        } else {
                            System.out.println("Não tem permissão");
                        }
                        break;*/
                    /*case "path":
                        if (adm) {
                            line = leitor.nextLine();
                            iniciar.setPath(line);
                        } else {
                            System.out.println("Não tem permissão");
                        }
                        break;*/
                    case "help":
                        if (adm) {
                            //System.out.println(Cor.getANSI_WHITE_BACKGROUND() + Cor.getANSI_RED() + "$ reset: apagar todos os dados do sistema (exceto logins)" + Cor.getANSI_RESET());
                            //System.out.println(Cor.getANSI_RED() + "$ path: configurar path dos arquivos" + Cor.getANSI_RESET());
                        }
                        System.out.println("$ exit: fechar programa");
                        //System.out.println("$ show: mostrar informações do usuário");
                        System.out.println("$ logout: sair da conta");
                        System.out.println("$ help: mostrar comandos");
                        break;
                    case "logout":
                        token = null;
                        adm = false;
                        iniciar.logout();
                        break OUTER;
                    default:
                        System.out.println("Comando invalido, digite 'help' para ver comandos");
                        break;
                }
            }
        }
    }
}
