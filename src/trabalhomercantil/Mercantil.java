public class Mercantil {
    private String nome;
    private String proprietario;
    private String cnpj;
    private ContaBancaria conta;

    public Mercantil(String nome, String proprietario, String cnpj, float saldoConta) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.cnpj = cnpj;
        this.conta = new ContaBancaria(saldoConta);
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getProprietario() {
        return proprietario;
    }

    public ContaBancaria getConta() {
        return conta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setConta(ContaBancaria conta) {
        this.conta = conta;
    }

    public String toString() {
        return "Nome: " + getNome() + "\n" + "Proprietario: " + getProprietario() + "\n" + "CNPJ: " + getCnpj() + "\n"
                + "Saldo: " + getConta().getSaldo();
    }
}
