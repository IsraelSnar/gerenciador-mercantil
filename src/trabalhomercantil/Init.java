/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author israe
 */
public class Init {

    File file;
    LerFile ler;
    private String path;
    Scanner leitor = new Scanner(System.in);
    private boolean adm;
    private String token;
    private String nome;
    private String cargo;
    private float salario;
    private float saldo;
    private String dono;
    private String empresa;
    private String cnpj;


    /**
     * Iniciar o programa com informações
     *
     */
    public Init(String path) {
        setPath(path);
    }

    public Init() {
    }

    /**
     *
     * @param cargo
     */
    public void initRead(boolean cargo) {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {

            // usando o método getEncoding() da classe InputStreamReader
            // para pegar a codificação usada no arquivo
            // System.out.println("Codificação do arquivo: " + isr.getEncoding());
            int intValue;
            // lê o arquivo caractere a caractere e imprime na tela
            while ((intValue = isr.read()) != -1) {
                char ch = (char) intValue;
                /*
                 * char ch = (char) intValue;
                 * System.out.println(ch + " - " + intValue);
                 * if (ch == 0) {
                 * System.out.println("tem");
                 * initWrite();
                 * } else {
                 * System.out.println("nao tem");
                 * }
                 */
                if (intValue == 48) {
                    // System.out.println("tem sim");
                    if (cargo) {
                        // System.out.println("valor arquivo: " + intValue);
                        initWrite();
                    } else {
                        // System.out.println("valor arquivo: " + intValue);
                        System.err.println("Sistema não tem informações sobre o estabelecimento");
                        System.err.println("O sistema será encerrado e precisa que o propietario faça primeiro acesso");
                        System.err.println("Entre em contato com o administrador");
                        System.exit(0);
                    }
                } else {
                    // System.out.println("valor arquivo: " + intValue);

                    break;
                }
            }

            // System.out.println("Sistema inicializado");
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private void initWrite() {
        // System.out.println("Escrever arquivo");
        try (
                OutputStream os = new FileOutputStream(file, false);
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);) {
            System.out.println("Informe: DONO NOME_DA_EMPRESA SALDO CNPJ");
            System.out.println("Use ';' para separar cada informação");
            String line = leitor.nextLine();
            // System.out.println("$" + line);
            String ui[] = line.split(";");

            while (!(ui.length > 3)) {
                System.out.println("vazio insira \"DONO NOME_DA_EMPRESA SALDO CNPJ\" separados por ;");
                line = leitor.nextLine();
                // System.out.println("$" + line);
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
     */
    public void login(String user, String pass) {

        // ler.view("funcionarios");
        boolean get = ler.viewLogin(getPath() + "funcionarios", user, pass);
        // System.out.println(get);
        if (get) {
            System.out.println(Cor.getANSI_GREEN() + "logado" + Cor.getANSI_RESET());
            setAdm(ler.isAdm());
            setToken(ler.getToken());
            setNome(ler.viewVal(getPath() + "funcionarios", "nome", getToken()));
            setCargo(ler.viewVal(getPath() + "funcionarios", "cargo", getToken()));
            setSalario(Float.parseFloat(ler.viewVal(getPath() + "funcionarios", "salario", getToken())));
            // return ler.getToken();
        } else {
            System.err.println("Erro: usuário ou senha incorretos");
            System.err.println("Tente novamente, caso o erro persista entre em contato com o admin");
            // return null;
        }
    }

    public void inforMercantil() {
        JSONParser parser = new JSONParser();

        Object objeto;

        try {
            objeto = parser.parse(new FileReader(getPath() + "mercantil.json"));
            JSONArray jsonarray = (JSONArray) objeto;
            //System.out.println("jsonarray size = " + jsonarray.size());
            for (int i = 0; i < jsonarray.size(); i++) {
                //System.out.println("i: " + i);
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
//                System.out.println((String) jsonObject.get("nome"));
                this.saldo = Float.parseFloat( (String) jsonObject.get("saldo"));
                this.empresa = (String) jsonObject.get("nome");
                this.dono = (String) jsonObject.get("dono");
                this.cnpj = (String) jsonObject.get("cnpj");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
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
        if (!a.toUpperCase().equals("Y") || a.equals("")) {
            System.out.println("programa encerrado com sucesso");
            System.exit(0);
        }
    }
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

    /**
     *
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
        file = new File(path + "mercantil.json");
        ler = new LerFile(path);
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nome: " + getNome()
                + "\n\rAdm: " + isAdm()
                + "\n\rCargo: " + getCargo()
                + "\r\nSalário: " + getSalario();
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the salario
     */
    public float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @return the dono
     */
    public String getDono() {
        return dono;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @return the saldo
     */
    public Float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
