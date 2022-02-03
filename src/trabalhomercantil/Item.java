package trabalhomercantil;

/**
 *
 * @author João
 */
public class Item extends Produto {

    private int quantidadeNaCompra;
    private float subTotal;

    /**
     *
     * @param codigoBarras
     * @param nome
     * @param descricao
     * @param categoriaN
     * @param preco
     * @param estoqueAtual
     * @param estoqueCritico
     */
    public Item(String codigoBarras, String nome, String descricao, int categoriaN, float preco, int estoqueAtual,
            int estoqueCritico) {
        super(codigoBarras, nome, descricao, categoriaN, preco, estoqueAtual, estoqueCritico);
        
       
    }

    /**
     *
     * @return
     */
    public int getQuantidadeNaCompra() {
        return quantidadeNaCompra;
    }

    /**
     *
     * @return
     */
    public float getSubTotal() {
        return subTotal;
    }

    /**
     *
     * @param quantidadeNaCompra
     */
    public void setQuantidadeNaCompra(int quantidadeNaCompra) {
        this.quantidadeNaCompra = quantidadeNaCompra;
    }

    /**
     *
     * @param subTotal
     */
    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        
        return 
        getCodigoBarras() + " | " + 
        getNome() + " " + getDescricao() + " | " +
        getPreco() + " | " +
        getSubTotal();
    }

}
