public class Item extends Produto {

    private int quantidadeNaCompra;
    private float subTotal;

    public Item(String codigoBarras, String nome, String descricao, int categoriaN, float preco, int estoqueAtual,
            int estoqueCritico) {
        super(codigoBarras, nome, descricao, categoriaN, preco, estoqueAtual, estoqueCritico);
       
    }

    public int getQuantidadeNaCompra() {
        return quantidadeNaCompra;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setQuantidadeNaCompra(int quantidadeNaCompra) {
        this.quantidadeNaCompra = quantidadeNaCompra;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        
        return 
        getCodigoBarras() + " | " + 
        getNome() + " " + getDescricao() + " | " +
        getPreco() + " | " +
        getSubTotal() + "\n";
    }

}
