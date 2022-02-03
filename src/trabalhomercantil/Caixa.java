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

    public Caixa(float saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }
    
    public void sangria(float valor){
        setSaldoCaixa(saldoCaixa - valor);
    }

    public float getSaldoCaixa() {
        return saldoCaixa;
    }
    
    public void setSaldoCaixa(float saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }
    
    
    
}
