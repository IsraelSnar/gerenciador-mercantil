/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

/**
 *
 * @author João Alves
 */
public class Caixa {
    private float saldoCaixa;

    /**
     *
     * @param saldoCaixa
     */
    public Caixa(float saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }
    
    /**
     *
     * @param valor
     */
    public Float sangria(float valor){
        float i = saldoCaixa;
        setSaldoCaixa(saldoCaixa - valor);
        return i;
    }

    /**
     *
     * @return
     */
    public float getSaldoCaixa() {
        return saldoCaixa;
    }
    
    /**
     *
     * @param saldoCaixa
     */
    public void setSaldoCaixa(float saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }
    
    
    
}
