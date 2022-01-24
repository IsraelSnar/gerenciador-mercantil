public class Mercantil {
    private String nome;
    private String proprietario;
    private String cnpj;
    private float saldoConta;

    public Mercantil(String nome, String proprietario, String cnpj, float saldoConta) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.cnpj = cnpj;
        this.saldoConta = saldoConta;
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

    public float getSaldoConta() {
        return saldoConta;
    }

    public String toString() {
        return "Nome: " + getNome() + "\n" + "Proprietario: " + getProprietario() + "\n" + "CNPJ: " + getCnpj() + "\n"
                + " Saldo: " + getSaldoConta();
    }
}
