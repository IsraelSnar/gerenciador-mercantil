package trabalhomercantil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author israe
 */
public class Venda {
    private ArrayList<Item> itens;
    private Item itemLista;
    private int quantidade;
    private float valorTotal;
    
    Scanner ler = new Scanner(System.in);

    /**
     * Venda
     */
    public Venda(){
        itens = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public Item getItemLista() {
        return itemLista;
    }

    /**
     *
     * @return
     */
    public float getValorTotal() {
        return valorTotal;
    }

    /**
     *
     * @param valorTotal
     */
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     *
     * @param itemLista
     */
    public void setItemLista(Item itemLista) {
        this.itemLista = itemLista;
    }

    /**
     *
     * @return
     */
    public ArrayList<Item> getItens() {
        return itens;
    }

    /**
     *
     * @param itens
     */
    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    /**
     *
     * @return
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    

    //ADICIONA ITEM AO ARRAY LIST DE ITENS

    /**
     *
     * @param itemEstoque
     * @param codigoBarras
     * @param quantidade
     */
    public void adcionarItem(Estoque itemEstoque, String codigoBarras, int quantidade){
        setQuantidade(getQuantidade()+ quantidade);

        for (int i = 0; i < itemEstoque.getProdutos().size(); i++) {
            
            //VERIFICA SE TEM O PRODUTO NO ESTOQUE
            if(itemEstoque.getProdutos().get(i).getCodigoBarras().equals(codigoBarras)){

                System.out.println("Produto disponivel no estoque");
                
                //VERIFICA SE A QUANTIDADE DE PRODUTO É MAIOR QUE A DISPONÍVEL OU SE É IGUAL A 0
                if(quantidade > itemEstoque.getProdutos().get(i).getEstoqueAtual() || quantidade == 0){
                    System.out.println("Quantidade invalida, Escolha a quantidade entre 1 e " + itemEstoque.getProdutos().get(i).getEstoqueAtual() + ";");
                }
                else {
                    //DIMINUI A QUANTIDADE DO PRODUTO NO ESTOQUE
                    itemEstoque.getProdutos().get(i).setEstoqueAtual(itemEstoque.getProdutos().get(i).getEstoqueAtual() - quantidade);
                    
                    //CRIA UM ITEM 
                    itemLista = new Item
                    (
                    itemEstoque.getProdutos().get(i).getCodigoBarras(),
                    itemEstoque.getProdutos().get(i).getNome(),
                    itemEstoque.getProdutos().get(i).getDescricao(),
                    itemEstoque.getProdutos().get(i).getCategoriaN(),
                    itemEstoque.getProdutos().get(i).getPreco(),
                    itemEstoque.getProdutos().get(i).getEstoqueAtual(),
                    itemEstoque.getProdutos().get(i).getEstoqueCritico()
                    );
                    
                    //DEFINE A QUANTIDADE DE ITENS
                    itemLista.setQuantidadeNaCompra(quantidade);
                    //E SEU SUBTOTAL
                    itemLista.setSubTotal(quantidade*itemLista.getPreco());
                    
                    //ADICIONA O ITEM NO ARRAYLIST
                    itens.add(itemLista);
                    
                }
            }
            
            //CASO O PRODUTO NÃO ESTEJA NO ESTOQUE
            else {
                System.out.println("Produto não esta no estoque");
            }
        }}

    /**
     * mostra lista de itens
     */
    public void mostrarListaDeItens(){

        float calculoCompra = 0;
        
        System.out.println("LISTA DE ITENS" + "\n" + "\n" +
        "ITEM | Cod. | PRODUTO | Qtd | PREÇO Uni. | SUB TOTAL" + "\n");

        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i+1) + " | " + itens.get(i).toString());
        }
        
        System.out.println("\n");
        
        for (int i = 0; i < itens.size(); i++) {
            calculoCompra += itens.get(i).getSubTotal();
        }

        System.out.println("TOTAL DE ITENS: " + itens.size() + "\n" + "VALOR TOTAL : R$" + calculoCompra);

    }
        

    //REMOVE O ITEM

    /**
     *
     * @param NumeroItem
     */
    public void removerItem(int NumeroItem){

        //FALTA VALIDAR A REMOÇÃO
        itens.remove(NumeroItem);
    }

    /**
     *
     * @return
     */
    public float finalizarCompra(){
        
        
        float calculoCompra = 0;
        
        
        for (int i = 0; i < itens.size(); i++) {
            calculoCompra += itens.get(i).getSubTotal();
        }
        
      
       
        return calculoCompra;
        
        
    }
}
