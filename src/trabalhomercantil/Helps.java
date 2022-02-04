/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

/**
 *
 * @author israe
 */
public class Helps {

    /**
     * Mostra comandos sobre produtos
     */
    public void getHelpProduct(){
        System.out.println("new: novo produto\r\n"
                                            + "list: listar produtos\r\n"
                                            + "show: mostrar produto especifico\r\n"
                                            + "delete: apagar produto especifico\r\n"
                                            + "edit: editar produto especifico\n\r"
                + "0: sair do loop");
    }
    
    /**
     * Mostra o que cada informação requerida pede explicitamente
     */
    public void getHelpProductNew(){
        System.out.println("$ CODIGO: codigo de barras do produto, essa informação é unica no sistema (STRING)"
                + "\r\n$ NOME: nome do produto, pode-se adicionar marca separado por um '-' (STRING)"
                + "\r\n$ DESCRICAO: peso do produto (STRING)"
                + "\r\n$ CATEGORIA: categoria na qual se encaixa o produto (INT)"
                + "\r\n$ PRECO: preço do produto (FLOAT)"
                + "\r\n$ ESTOQUE: quantidade de produtos no momento"
                + "\r\n$ ESTOQUE_CRITICO: quantidade mínima de produtos que deve ter no estoque");
        getHelpProductEdit();
    }
    
    /**
     * Mostrar categorias
     */
    public void getHelpProductEdit(){
        int i = 0;
        for (Categorias object : Categorias.values()) {
            System.out.println("$ [" + i + "] - " + object);
            i += 1;
        }
        System.out.println("$ Na criação/edição do produto informe o ID da categoria não o nome");
    }
    
    /**
     * Mostrar comandos do caixa
     */
    public void getHelpCash(){
        System.out.println("$ new: nova compra"
                + "\n\r$ add | +: adicionar produto"
                + "\n\r$ finish: finalizar compra"
                + "\n\r$ sangria: realizar sangria - remover dinheiro do caixa"
                + "\n\r$ remove {id} | - {id}: remover produto, passando o codigo de barras"
                + "\n\r$ 0: sair do caixa"
                + "\n\r$ show: listar itens da compra atual");
    }
    
}
