/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

/**
 *
 * @author João
 * 
 */
public class Test {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        //Mercantil m = new Mercantil("EXTRA", "Jose", "1111000823", 0);
        //System.out.println(m);

        float preco = 2;

        Produto p = new Produto("1234567890123", "Arroz", "1kg", 1, preco , 100 , 20);
//        Produto p1 = new Produto("1234567890000", "FEijap", "1kg", "Alimentos", preco , 100 , 20);

        //System.out.println(p);

       Estoque a = new Estoque();
        a.adcionarProduto(p);

       // System.out.println(a);
        String ex = "1234567890123";
        float novoPreco = 10;

        a.editarProduto(ex, "FEIJAO PRETO", "2KG", 0, novoPreco);

        //System.out.println(a);

        a.listarProduto();

        
      

    }
}