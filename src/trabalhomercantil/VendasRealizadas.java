/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

import java.util.ArrayList;

/**
 *
 * @author João Alves
 */
public class VendasRealizadas {
    private ArrayList<Float> vendasRealizadas;

    public VendasRealizadas() {
        vendasRealizadas = new ArrayList<>();
    }
    
    public void listarVendasRealizadas(){
        
        System.out.println("VENDAS REALIZADAS" + "\n" + "Total: " + vendasRealizadas.size());
        
        for (int i = 0; i < vendasRealizadas.size(); i++) {
            System.out.println((i+1) + " - R$ " + vendasRealizadas.get(i));    
        }
        
    }

    public ArrayList<Float> getVendasRealizada() {
        return vendasRealizadas;
    }

    public void setVendasRealizada(ArrayList<Float> vendasRealizada) {
        this.vendasRealizadas = vendasRealizada;
    }
    
    
    
}
