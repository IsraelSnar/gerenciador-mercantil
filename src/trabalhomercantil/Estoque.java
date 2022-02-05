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

    // Adicionar Produto ao Estoque
    /**
     *
     * @param produto
     */
    public boolean adcionarProduto(Produto produto) {

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigoBarras().equals(produto.getCodigoBarras())) {
                System.out.println("FALHA AO ADICIONAR PRODUTO! PRODUTO INSERIDO JÁ ESTÁ NO ESTOQUE");
                System.out.println();
                return false;
            }
        }
        produtos.add(produto);
        return true;

    }

    // Ver Produtos do Estoque
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

    /**
     * Lista produtos com uma interface grafica
     * 
     * @return
     */
    public String listProductView() {
        // System.out.println("LISTA DE PRODUTOS NO ESTOQUE");
        String lista = "";
        for (int i = 0; i < produtos.size(); i++) {
            lista += (i + 1) + " - " + produtos.get(i).toString();
        }
        return lista;
    }

    // Editar um Produto do Estoque
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
                System.out.println("Estoque: Produto editado com sucesso");
                return;
            }

        }
        System.err.println("Estoque: Produto não está no Estoque");
    }

    // Adicionar Produto ao Estoque
    /**
     *
     * @param codigoBarras
     */
    public void excluirProduto(String codigoBarras) {

        if (produtos.remove(encontrarProduto(codigoBarras))) {
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
                System.out.println("Estoque: Produto Encontrado ");
                return produtos.get(i);
            }
        }
        System.err.println("Estoque: Produto não está no Estoque");
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
