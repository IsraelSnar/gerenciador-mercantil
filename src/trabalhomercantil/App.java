package trabalhomercantil;

/**
 *
 * @author israe
 */
public class App {
    
    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        //variaveis que vão ser utilizada futuramente

        //Mercantil
        String nomeMercantil;
        String nomeProprietarioMercantil;
        String cnpjMercantil;
        float saldoContaMercantil;

        //Produto
        String codigoBarrasProduto;
        String nomeProduto;
        String descricaoProduto;
        int categoriaProduto;
        float precoProduto;
        int estoqueAtualProduto;
        int estoqueCriticoProduto;

        



        //Mercantil m = new Mercantil("EXTRA", "Jose", "1111000823", 0);
        //System.out.println(m);

        float preco = 2;

        Produto p = new Produto("1234567890123", "Arroz", "1kg", 1, preco , 100 , 20);
        //Produto p1 = new Produto("1234567890000", "FEijap", "1kg", "Alimentos", preco , 100 , 20);

        //System.out.println(p);

       //ESTOQUE DO MERCANTIL
       Estoque estoque = new Estoque();
       estoque.adcionarProduto(p);

       Venda pontoDeVenda = new Venda();

       pontoDeVenda.adcionarItem(estoque, "1234567890123", 80);

       pontoDeVenda.mostrarListaDeItens();

       estoque.listarProduto();
      
        

       // System.out.println(a);
        //String ex = "1234567890123";
        //float novoPreco = 10;

        //a.editarProduto(ex, "FEIJAO PRETO", "2KG", 0, novoPreco);

        //System.out.println(a);

        //a.listarProduto();

        
      

    }
}
