import java.util.ArrayList;

public class Estoque {
    private ArrayList<Produto> produtos;
    
    public Estoque(){
        produtos = new ArrayList<Produto>();
    }

    //Adicionar Produto ao Estoque
    public void adcionarProduto(Produto produto){
        produtos.add(produto);
    }

    //Ver Produtos do Estoque
    public void listarProduto(){
        System.out.println("LISTA DE PRODUTOS NO ESTOQUE");
        String lista = "";
        for (int i = 0; i < produtos.size(); i++) {
            lista+=(i+1)+ " - " + produtos.get(i).toString();
        }
        System.out.println(lista);
    }

    //Editar um Produto do Estoque
    public void editarProduto(String codigoBarras, String nome, String descricao, int categoriaN, float preco){
        for (int i = 0; i < produtos.size(); i++) {
            if(codigoBarras.equals(produtos.get(i).getCodigoBarras())){
                produtos.get(i).setNome(nome);
                produtos.get(i).setDescricao(descricao);
                produtos.get(i).setCategoriaN(categoriaN);
                produtos.get(i).setPreco(preco);
            }

            else{
                System.out.println("Produto não está no Estoque");
            }
        }
    }

    //Adicionar Produto ao Estoque
    public void excluirProduto(String codigoBarras){
        for (int i = 0; i < produtos.size(); i++) {
            if(codigoBarras.equals(produtos.get(i).getCodigoBarras())){
                
                produtos.remove(produtos.get(i));
                System.out.println("Produto Encontrado e Removido");

            }

            else{
                System.out.println("Produto não está no Estoque");
            }
        }
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    
    public String toString() {
        String resultado ="";
        

        for (int i = 0; i < produtos.size(); i++) {
            resultado+=produtos.get(i).toString();
        }
        return resultado;
    }
}
