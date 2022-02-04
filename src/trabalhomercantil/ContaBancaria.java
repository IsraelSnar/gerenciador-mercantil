package trabalhomercantil;

/**
 *
 * @author João
 */
public class ContaBancaria {
    private float saldo;
    
    /**
     *
     * @param saldo
     */
    public ContaBancaria(float saldo){
        this.saldo = saldo;
    }

    public ContaBancaria(){
        this.saldo = 0;
    }

    /**
     *
     * @return
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     *
     * @param saldo
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Saldo: " + getSaldo();
    }
}
