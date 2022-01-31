package trabalhomercantil;

import java.util.ArrayList;

/**
 *
 * @author israe
 */
public class ListaDeCompra  {
    private ArrayList<Produto> itens;

    /**
     * Lista de compra
     */
    public ListaDeCompra(){
        itens = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Produto> getItens() {
        return itens;
    }

    /**
     *
     * @param itens
     */
    public void setItens(ArrayList<Produto> itens) {
        this.itens = itens;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "";
    }

    /**
     *
     * @param produto
     */
    public void add(Produto produto) {
    }
    
}
