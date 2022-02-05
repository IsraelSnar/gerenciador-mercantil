package trabalhomercantil;

/**
 *
 * @author João
 * @param codigoBarras
 * @param nome
 * @param descricao
 * @param categoriaN
 * @param preco
 * @param estoqueAtual
 * @param estoqueCritico
 */
public class Produto {

    private String codigoBarras;
    private String nome;
    private String descricao;
    private Categorias categorias[];
    private int categoriaN;
    private String categoria;
    private float preco;
    private int estoqueAtual;
    private int estoqueCritico;

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
    public Produto(String codigoBarras, String nome, String descricao, int categoriaN, float preco, int estoqueAtual, int estoqueCritico) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.descricao = descricao;
        this.categoriaN = categoriaN;
        this.categorias = Categorias.values();
        this.categoria = categorias[categoriaN].name();
        this.preco = preco;
        this.estoqueAtual = estoqueAtual;
        this.estoqueCritico = estoqueCritico;
    }

    /**
     *
     * @param codigoBarras
     * @return
     */
    

    /**
     *
     * @return
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @return
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     *
     * @return
     */
    public Categorias[] getCategorias() {
        return categorias;
    }

    /**
     *
     * @return
     */
    public int getCategoriaN() {
        return categoriaN;
    }

    /**
     *
     * @return
     */
    public float getPreco() {
        return preco;
    }

    /**
     *
     * @return
     */
    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    /**
     *
     * @return
     */
    public int getEstoqueCritico() {
        return estoqueCritico;
    }

    /**
     *
     * @param codigoBarras
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @param categoriaN
     */
    public void setCategoriaN(int categoriaN) {
        this.categoriaN = categoriaN;
        this.categoria = categorias[categoriaN].name();
    }

    /**
     *
     * @param preco
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /**
     *
     * @param estoqueAtual
     */
    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    /**
     *
     * @param estoqueCritico
     */
    public void setEstoqueCritico(int estoqueCritico) {
        this.estoqueCritico = estoqueCritico;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {

        return "Cod: " + getCodigoBarras() + "; "
                + "Nome: " + getNome() + "; "
                + "Descrição: " + getDescricao() + "; "
                + "Categoria: " + getCategoria() + "\n\r"
                + " Preço: R$ " + getPreco() + "; "
                + "Estoque Atual: " + getEstoqueAtual() + "; "
                + "Estoque Critico: " + getEstoqueCritico() + "\n\r";
    }
}
