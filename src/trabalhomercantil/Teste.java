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
        Helps help = new Helps();

        iniciar.setPath(path);

        iniciar.login("israel", "123456");
        
        help.getHelpProduct();
        
        help.getHelpProductNew();

        //mostrar dados do usuário logado
        //
        Produto p = new Produto("1234567890123", "Arroz - Pai João", "1kg", 10, 5, 100, 20);
        a.adcionarProduto(p);

        /*p = new Produto("9876543210987", "Feijão", "1kg", 10, 5, 100, 20);
        a.adcionarProduto(p);

        a.listarProduto();

        p = new Produto("4567891230456", "Arroz - Da Terra", "1kg", 1, 5, 100, 20);
        a.adcionarProduto(p);

        a.excluirProduto("1234567890123");
        
        a.listarProduto();
        
        a.excluirProduto("5515154545454");*/
    }
}
