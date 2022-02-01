package trabalhomercantil;

import java.util.ArrayList;

/**
 *
 * @author israe
 */
public class Estoque {

    private ArrayList<Produto> produtos = new ArrayList<>();

    /**
     * Estoque
     */
    public Estoque() {

    }

    //Adicionar Produto ao Estoque
    /**
     *
     * @param produto
     */
    public void adcionarProduto(Produto produto) {
        produtos.add(produto);
    }

    //Ver Produtos do Estoque
    /**
     * Lista produto
     */
    public void listarProdutos() {
        System.out.println("LISTA DE PRODUTOS NO ESTOQUE");
        String lista = "";
        for (int i = 0; i < produtos.size(); i++) {
            lista += (i + 1) + " - " + produtos.get(i).toString();
        }
        System.out.println(lista);
    }

    //Editar um Produto do Estoque
    /**
     *
     * @param codigoBarras
     * @param nome
     * @param descricao
     * @param categoriaN
     * @param preco
     */
    public void editarProduto(String codigoBarras, String nome, String descricao, int categoriaN, float preco) {
        for (int i = 0; i < produtos.size(); i++) {
            if (codigoBarras.equals(produtos.get(i).getCodigoBarras())) {
                produtos.get(i).setNome(nome);
                produtos.get(i).setDescricao(descricao);
                produtos.get(i).setCategoriaN(categoriaN);
                produtos.get(i).setPreco(preco);
            } else {
                System.out.println("Produto não está no Estoque");
            }
        }
    }

    //Adicionar Produto ao Estoque
    /**
     *
     * @param codigoBarras
     */
    public void excluirProduto(String codigoBarras) {
//        for (int i = 0; i < produtos.size(); i++) {
//            if (codigoBarras.equals(produtos.get(i).getCodigoBarras())) {
//                produtos.remove(produtos.get(i));
//                System.out.println("Produto Encontrado e Removido");
//                return;
//            }
//        }
//        System.out.println("Produto não está no Estoque");
        if (produtos.remove(encontrarProduto(codigoBarras))){
            System.out.println("Removido com sucesso");
        }
        
    }

    /**
     *
     * @param codigoBarras
     * @return
     */
    public Produto encontrarProduto(String codigoBarras) {
        for (int i = 0; i < produtos.size(); i++) {
            if (codigoBarras.equals(produtos.get(i).getCodigoBarras())) {
                System.out.println("Produto Encontrado ");
                return produtos.get(i);
            }
        }
        System.err.println("Produto não está no Estoque");
        return null;
    }

    /**
     *
     * @return
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    /**
     *
     * @param produtos
     */
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < produtos.size(); i++) {
            resultado += produtos.get(i).toString();
        }
        return resultado;
    }
}
