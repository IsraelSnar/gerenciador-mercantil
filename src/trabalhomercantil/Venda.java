package trabalhomercantil;

import java.util.ArrayList;

//MUDAR O NOME DA CLASSE PARA VENDA
/**
 *
 * @author israe
 */
public class Venda {

    private ArrayList<Item> itens;
    private Item itemLista;
    private int quantidade;
    private float valorTotal;

    /**
     * venda
     */
    public Venda() {
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
     * @param itemEstoque
     * @param codigoBarras
     * @param quantidade
     */
    public void adcionarItem(Estoque itemEstoque, String codigoBarras, int quantidade) {

        for (int i = 0; i < itemEstoque.getProdutos().size(); i++) {

            if (itemEstoque.getProdutos().get(i).getCodigoBarras().equals(codigoBarras)) {

                System.out.println("Produto disponivel no estoque");

                if (quantidade > itemEstoque.getProdutos().get(i).getEstoqueAtual() || quantidade == 0) {
                    System.out.println("Quantidade invalida, Escolha a quantidade entre 0 e " + itemEstoque.getProdutos().get(i).getEstoqueAtual() + ";");
                } else {
                    //DIMINUI A QUANTIDADE DE ITENS NO ESTOQUE
                    itemEstoque.getProdutos().get(i).setEstoqueAtual(itemEstoque.getProdutos().get(i).getEstoqueAtual() - quantidade);

                    //CRIA UM ITEM OU COPIA DO PRODUTO  
                    itemLista = new Item(
                            itemEstoque.getProdutos().get(i).getCodigoBarras(),
                            itemEstoque.getProdutos().get(i).getNome(),
                            itemEstoque.getProdutos().get(i).getDescricao(),
                            itemEstoque.getProdutos().get(i).getCategoriaN(),
                            itemEstoque.getProdutos().get(i).getPreco(),
                            itemEstoque.getProdutos().get(i).getEstoqueAtual(),
                            itemEstoque.getProdutos().get(i).getEstoqueCritico()
                    );

                    itemLista.setQuantidadeNaCompra(quantidade);
                    itemLista.setSubTotal(quantidade * itemLista.getPreco());

                    itens.add(itemLista);

                }
            } else {
                System.out.println("Produto não esta no estoque");
            }
        }
    }

    /**
     * mostrar lista de itens
     */
    public void mostrarListaDeItens() {

        float calculoCompra = 0;
        System.out.println("LISTA DE ITENS" + "\n"
                + "ITEM | Cod. | PRODUTO | Qtd | PREÇO Uni. | SUB TOTAL");

        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + itens.get(i).toString());
        }

        for (int i = 0; i < itens.size(); i++) {
            calculoCompra += itens.get(i).getSubTotal();
        }

        System.out.println("TOTAL DE ITENS: " + itens.size() + "\n" + "VALOR TOTAL : R$" + calculoCompra);
    }

    /**
     *
     * @param NumeroItem
     */
    public void removerItem(int NumeroItem) {

        //FALTA VALIDAR A REMOÇÃO
        itens.remove(NumeroItem);
    }

    /**
     * finalizar compra
     */
    public void finalizarCompra() {
        float calculo = 0;
        for (int i = 0; i < itens.size(); i++) {
            calculo += itens.get(i).getPreco() * quantidade;
        }
    }
}
