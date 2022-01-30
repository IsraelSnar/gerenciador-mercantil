package trabalhomercantil;

/**
 *
 * @author João
 */
public class Mercantil {
    private String nome;
    private String proprietario;
    private String cnpj;
    private ContaBancaria conta;

    /**
     *
     * @param nome
     * @param proprietario
     * @param cnpj
     * @param saldoConta
     */
    public Mercantil(String nome, String proprietario, String cnpj, float saldoConta) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.cnpj = cnpj;
        this.conta = new ContaBancaria(saldoConta);
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
     * @return
     */
    @Override
    public String toString() {
        return "Nome: " + getNome() + "\n" + "Proprietario: " + getProprietario() + "\n" + "CNPJ: " + getCnpj() + "\n"
                + "Saldo: " + getConta().getSaldo();
    }
}
