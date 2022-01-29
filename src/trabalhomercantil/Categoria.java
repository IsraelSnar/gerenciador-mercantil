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
public enum Categoria {
    PERECIVEL("Perecível"), 
    LIMPEZA("Limpeza"), 
    HIGIENE("Higiene");

    private String cate;

    Categoria(String cate) {
        this.cate = cate;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return cate;
    }
}
