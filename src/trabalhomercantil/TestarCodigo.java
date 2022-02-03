package trabalhomercantil;

import java.util.Scanner;

public class TestarCodigo {
    
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
        
        Scanner ler = new Scanner(System.in);

        



        //Mercantil m = new Mercantil("EXTRA", "Jose", "1111000823", 0);
        //System.out.println(m);

        float preco = 2;

        Produto p = new Produto("1234567890123", "Arroz", "1kg", 1, preco , 100 , 20);
        Produto p1 = new Produto("1234567890000", "FEijap", "1kg", 2, preco , 100 , 20);
        Produto p2 = new Produto("1234567890111", "MACARRÃO", "250G", 6, preco*2 , 100 , 20);

        //System.out.println(p);

       //ESTOQUE DO MERCANTIL
       Estoque estoque = new Estoque();
       estoque.adcionarProduto(p);
       estoque.adcionarProduto(p1);
       estoque.adcionarProduto(p2);
       
       Caixa caixa = new Caixa(200);

       Venda pontoDeVenda = new Venda();

       pontoDeVenda.adcionarItem(estoque, "1234567890123", 10);
       pontoDeVenda.adcionarItem(estoque, "1234567890000", 2);
       pontoDeVenda.adcionarItem(estoque, "1234567890111", 10);

       pontoDeVenda.mostrarListaDeItens();
       
       int formaPagamento = 0;
       float dinheiroRecebido = 0;
       float troco = 0;
       boolean validaFormaPagamento = true;
       
        System.out.println("VALOR TOTAL DA COMPRA: R$" + pontoDeVenda.finalizarCompra() + "\n" + 
                "ESCOLHA A FORMA DE PAGAMENTO:" + "\n" + 
                "1 - DINHEIRO" + "\n" +
                "2 - CARTÃO" + "\n" + 
                "3 - PIX");
        
        while (validaFormaPagamento) {            
           formaPagamento = ler.nextInt();
           if(formaPagamento <=0 || formaPagamento>=4){
               System.out.println("OPÇÃO NÃO ENCONTRADA!" + "\n" + 
                       "ESCOLHA A FORMA DE PAGAMENTO:" + "\n" + 
                "1 - DINHEIRO" + "\n" +
                "2 - CARTÃO" + "\n" + 
                "3 - PIX" );
           }
           
           else {
               validaFormaPagamento = false;
           }
           
        }
        
        
        if(formaPagamento == 1){
            System.out.println("Digite valor recebido do cliente:");
            dinheiroRecebido = ler.nextFloat();
           
            
            if(dinheiroRecebido == 0 || dinheiroRecebido < 0 || dinheiroRecebido < pontoDeVenda.finalizarCompra()){
                System.out.println("Valor invalido receba um valor >=" + pontoDeVenda.finalizarCompra());
            }
            
            else {
                caixa.setSaldoCaixa(caixa.getSaldoCaixa() + dinheiroRecebido);
                //System.out.println("SALDO DO CAIXA COM DINHEIRO RECEBIDO DO CLIENTE: " + caixa.getSaldoCaixa());
                
                troco = dinheiroRecebido - pontoDeVenda.finalizarCompra();
                System.out.println("TROCO: R$" + troco);
                
                caixa.setSaldoCaixa(caixa.getSaldoCaixa() - troco);
                //System.out.println("SALDO DO CAIXA DPS DO TROCO : " + caixa.getSaldoCaixa());
                System.out.println("VENDA REALIZADA COM SUCESSO!");
            }
        }
        
        else {
           caixa.setSaldoCaixa(caixa.getSaldoCaixa() + pontoDeVenda.finalizarCompra());
           System.out.println("VENDA REALIZADA COM SUCESSO!"); 
        }
        
        VendasRealizadas vendasRealizadas = new VendasRealizadas();
        
        vendasRealizadas.getVendasRealizada().add(pontoDeVenda.finalizarCompra());
        
        vendasRealizadas.listarVendasRealizadas();
       
       
       
        System.out.println(caixa.getSaldoCaixa());

       //estoque.listarProduto();
      
        

       // System.out.println(a);
        //String ex = "1234567890123";
        //float novoPreco = 10;

        //a.editarProduto(ex, "FEIJAO PRETO", "2KG", 0, novoPreco);

        //System.out.println(a);

        //a.listarProduto();

        
      

    }
}
