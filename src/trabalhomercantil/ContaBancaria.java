public class ContaBancaria {
    private float saldo;
    
    public ContaBancaria(float saldo){
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "Saldo: " + getSaldo();
    }
}
