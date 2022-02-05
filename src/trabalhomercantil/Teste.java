/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

/**
 *
 * @author israe
 */
public class Teste {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String path = "D:/Faculdade/POO/TrabalhoMercantil/src/assets/";
        Init iniciar = new Init();
        Estoque a = new Estoque();
        Products products = new Products(path);
        iniciar.setPath(path);

        a = products.lerProducts();
        //a.listarProdutos();

        iniciar.login("israel", "123456");

        // Produto p = new Produto("5156165616", "Arroz", "1kg", 10, 5, 100, 20);
        // if (a.adcionarProduto(p)) {
        //     products.escreverProduct(p);
        // }

        // products.editProducts(a.editarProduto("5165165165", "Arroz branco", "5kg", 10, 2.5f), a);

        products.delete("1234567890123");
        /*
         * String str = "algo";
         * 
         * if (str.equals("algo")){
         * System.out.println("igual");
         * }
         */

    }
}
