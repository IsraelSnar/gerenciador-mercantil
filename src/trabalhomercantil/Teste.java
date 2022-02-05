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
        Venda pontoDeVenda = new Venda();
        Estoque estoque = new Estoque();
        Caixa caixa = new Caixa(0);
        VendasRealizadas vendasRealizadas = new VendasRealizadas();

        iniciar.setPath(path);

        iniciar.login("israel", "123456");

        Produto p = new Produto("1234567890123", "Arroz - Pai João", "1kg", 10, 5, 100, 20);

        a.adcionarProduto(p);
        p = new Produto("1234567890123", "Arroz - Pai João", "1kg", 10, 5, 100, 20);

        a.adcionarProduto(p);
        p = new Produto("123", "Feijão - Pai João", "1kg", 10, 5, 100, 20);

        a.adcionarProduto(p);
        p = new Produto("1234", "Feijão preto", "1kg", 10, 5, 100, 20);

        a.adcionarProduto(p);

        a.editarProduto("1234567890123", "Arroz branco", "5kg", 10, 2.5f);

        pontoDeVenda.adcionarItem(estoque, "123", 5);
        pontoDeVenda.adcionarItem(estoque, "1234567890123", 5);
        pontoDeVenda.adcionarItem(estoque, "1234", 5);

        pontoDeVenda.totalCompra();

        caixa.setSaldoCaixa(caixa.getSaldoCaixa() + pontoDeVenda.totalCompra());
        vendasRealizadas.getVendasRealizada().add(pontoDeVenda.totalCompra());
        pontoDeVenda.clear();
        System.out.println("VENDA REALIZADA COM SUCESSO!");

        /*
         * p = new Produto("9876543210987", "Feijão", "1kg", 10, 5, 100, 20);
         * a.adcionarProduto(p);
         * 
         * a.listarProduto();
         * 
         * p = new Produto("4567891230456", "Arroz - Da Terra", "1kg", 1, 5, 100, 20);
         * a.adcionarProduto(p);
         * 
         * a.excluirProduto("1234567890123");
         * 
         * a.listarProduto();
         * 
         * a.excluirProduto("5515154545454");
         */
    }
}
