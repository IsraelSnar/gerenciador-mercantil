public class Produto {
    private String codigoBarras;
    private String nome;
    private String descricao;
    private CategoriasEnum categorias [];
    private int categoriaN;
    private String categoria;
    private float preco;
    private int estoqueAtual;
    private int estoqueCritico;

    public Produto(String codigoBarras, String nome, String descricao, int categoriaN, float preco, int estoqueAtual, int estoqueCritico){
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.descricao = descricao;
        this.categoriaN = categoriaN;
        this.categorias  = CategoriasEnum.values(); 
        this.categoria = categorias[categoriaN].name();
        this.preco = preco;
        this.estoqueAtual = estoqueAtual;
        this.estoqueCritico = estoqueCritico;

   
        
    }

    public boolean validaCodigo(String codigoBarras){
        return true;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public CategoriasEnum[] getCategorias() {
        return categorias;
    }

    public int getCategoriaN() {
        return categoriaN;
    }

    public float getPreco() {
        return preco;
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public int getEstoqueCritico() {
        return estoqueCritico;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoriaN(int categoriaN) {
        this.categoriaN = categoriaN;
        this.categoria = categorias[categoriaN].name();
    }


    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public void setEstoqueCritico(int estoqueCritico) {
        this.estoqueCritico = estoqueCritico;
    }

    
    public String toString() {
       
        return "Cod: "+getCodigoBarras() + " - " + 
               "Nome: "+ getNome() + " - " +
               "Descrição: "+ getDescricao() + " - " +
               "Categoria: "+ getCategoria() + " - " +
               "Preço: R$ "+ getPreco() + " - " +
               "Estoque Atual: "+ getEstoqueAtual() + " - " +
               "Estoque Critico: "+ getEstoqueCritico() + "\n";
    }
}
