/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author israe
 */
public class Init {

    File file = new File("D:/Faculdade/POO/TrabalhoMercantil/src/assets/mercantil.json");
    LerFile ler = new LerFile("D:/Faculdade/POO/TrabalhoMercantil/src/assets/");
    Scanner leitor = new Scanner(System.in);
    private boolean adm;
    private String token;

    /**
     * Iniciar o programa com informações
     *
     */
    public Init() {
//        LerFile ler = new LerFile("");
//        String var = "";
//        initRead();
    }

    /**
     *
     * @param cargo
     */
    public void initRead(boolean cargo) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {

            // usando o método getEncoding() da classe InputStreamReader
            // para pegar a codificação usada no arquivo
            //System.out.println("Codificação do arquivo: " + isr.getEncoding());
            int intValue;
            // lê o arquivo caractere a caractere e imprime na tela
            while ((intValue = isr.read()) != -1) {
                char ch = (char) intValue;
                /*char ch = (char) intValue;
                System.out.println(ch + " - " + intValue);
                if (ch == 0) {
                    System.out.println("tem");
                    initWrite();
                } else {
                    System.out.println("nao tem");
                }*/
                if (intValue == 48) {
                    //System.out.println("tem sim");
                    if (cargo) {
                        //System.out.println("valor arquivo: " + intValue);
                        initWrite();
                    } else {
                        //System.out.println("valor arquivo: " + intValue);
                        System.err.println("Sistema não tem informações sobre o estabelecimento");
                        System.err.println("O sistema será encerrado e precisa que o propietario faça primeiro acesso");
                        System.err.println("Entre em contato com o administrador");
                        System.exit(0);
                    }
                } else {
                    //System.out.println("valor arquivo: " + intValue);
                    break;
                }
            }

            //System.out.println("Sistema inicializado");
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private void initWrite() {
        //System.out.println("Escrever arquivo");
        try (
                OutputStream os = new FileOutputStream(file, false);
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);) {
            System.out.println("Informe: DONO NOME_DA_EMPRESA SALDO CNPJ");
            System.out.println("Use ';' para separar cada informação");
            String line = leitor.nextLine();
            //System.out.println("$" + line);
            String ui[] = line.split(";");

            while (!(ui.length > 3)) {
                System.out.println("vazio insira \"DONO NOME_DA_EMPRESA SALDO CNPJ\" separados por ;");
                line = leitor.nextLine();
                //System.out.println("$" + line);
                ui = line.split(";");
            }

            bw.write("{\"dono\": \"" + ui[0] + "\",\n "
                    + "\"nome\": \"" + ui[1] + "\",\n "
                    + "\"saldo\": " + ui[2] + ",\r "
                    + "\"cnpj\": \"" + ui[3] + "\""
                    + "\r}");
            bw.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * @param user
     * @param pass
     * @return se logou ou nao
     */
    public String login(String user, String pass) {

        //ler.view("funcionarios");
        boolean get = ler.viewLogin("D:/Faculdade/POO/TrabalhoMercantil/src/assets/funcionarios", user, pass);
        //System.out.println(get);
        if (get) {
            System.out.println(Cor.getANSI_GREEN() + "logado" + Cor.getANSI_RESET());
            setAdm(ler.isAdm());
            return ler.getToken();
        } else {
            System.err.println("Erro: usuário ou senha incorretos");
            System.err.println("Tente novamente, caso o erro persista entre em contato com o admin");
            return null;
        }
    }

    /**
     * retira o login do usuário
     */
    public void logout() {
        setAdm(false);
        ler.setAdm(false);
        ler.setToken();
        System.out.println("Deseja realizar login em outra conta? [y/N]");
        String a = leitor.nextLine().toUpperCase();
        if (a.toUpperCase().equals("Y") || !(a.equals(""))) {
        } else {
            System.out.println("programa encerrado com sucesso");
            System.exit(0);
        }
    }

    /**
     *
     * menu do sistema
     */
    /*public void menu() {
        System.out.println("Informe usuário e senha separados por espaço");

        String line = leitor.nextLine();
        String ui[] = line.split(" ");

        token = login(ui[0], ui[1]);

        while (true) {
            while (token == null) {
                System.out.println("Informe usuário e senha separados por espaço");
                System.out.println("Ou digite '0' para finalizar o programa");

                line = leitor.nextLine();
                ui = line.split(" ");

                if (ui[0].equals(0)) {
                    System.exit(0);
                }

                System.out.println("Usuário: " + ui[0] + "\n\rSenha: " + ui[1]);
                token = login(ui[0], ui[1]);
            }

            OUTER:
            while (token != null) {
                adm = isAdm();
                initRead(adm);
                System.out.println("Informe opção");
                System.out.println("Escreva 'help' para ver comandos");
                line = leitor.nextLine();
                ui = line.split(" ");
                switch (ui[0]) {
                    case "exit":
                        break OUTER;
                    case "help":
                        if (adm) {
                            System.out.println("reset: fechar programa");
                        } else {
                            System.out.println("nao é adm");
                        }
                        System.out.println("exit: fechar programa");
                        System.out.println("sair: sair da conta");
                        System.out.println("sair: sair da conta");
                        break;
                    case "sair":
                        token = null;
                        logout();
                        break;
                    default:
                        break;
                }
            }
        }
    }*/
    /**
     *
     * @return adm
     */
    public boolean isAdm() {
        return adm;
    }

    /**
     *
     * @return
     */
    public String ler() {
        return "";
    }

    /**
     * @param adm the adm to set
     */
    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    void reset(boolean adm) {

    }

}
