package trabalhomercantil;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author João
 */
public class Mercantil {
    private String nome;
    private String proprietario;
    private String cnpj;
    private ContaBancaria conta;
    private String dados;
    private String path;
    Init iniciar = new Init();

    /**
     *
     * @param nome
     * @param proprietario
     * @param cnpj
     * @param saldoConta
     */
    public Mercantil(String nome, String proprietario, String cnpj, float saldoConta, String path) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.cnpj = cnpj;
        this.conta = new ContaBancaria(saldoConta);
    }

   

    public boolean editSaldo(float s) {
        
        if (s != 0) {
            dados += "escreve";
            if (salvarSaldo("mercantil.txt")) {
                System.out.println("Saldo salvo no banco de dados");
                return true;
            } else {
                System.err.println("Erro ao inserir produto");
                return false;
            }
        } else {
            System.out.println("Mercantil s == 0");
            return false;
        }
    }

    public boolean salvarSaldo(String file) {
        System.out.println("path: " + iniciar.getPath());
        try {
            OutputStream os = new FileOutputStream(path + "mercantil.json"); // nome do arquivo que será escrito
            Writer wr = new OutputStreamWriter(os); // criação de um escritor
            BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer

            // br.write("Vamos escrever nesse novo arquivo em Java! que legal hahaha!!!");
            br.write("[\n    {\n        \"dono\": \"" + getProprietario() +
                    "\",\n        \"nome\": \"" + getNome() +
                    "\",\n        \"saldo\": \"" + getSaldoConta() +
                    "\",\n        \"cnpj\":\"" + getCnpj() + "\"}\n]");
            // br.newLine();
            // br.newLine();
            // br.write("Vamos escrever outra linha aqui embaixo hahaha!!!");
            br.close();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Mercantil erro: " + e);
            return false;
        }
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     *
     * @return
     */
    public String getProprietario() {
        return proprietario;
    }

    /**
     *
     * @return
     */
    public ContaBancaria getConta() {
        return conta;
    }

    /**
     *
     * @return
     */
    public Float getSaldoConta() {
        return conta.getSaldo();
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param proprietario
     */
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    /**
     *
     * @param cnpj
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     *
     * @param conta
     */
    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    /**
     *
     * @param conta
     */
    public void setSaldo(Float saldo) {
        this.conta.setSaldo(saldo);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" + "Proprietario: " + getProprietario() + "\n" + "CNPJ: " + getCnpj() + "\n"
                + "Saldo: " + getConta().getSaldo();
    }
}
