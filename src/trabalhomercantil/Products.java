package trabalhomercantil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Products {
    LerFile ler;
    Init iniciar = new Init();
    String dados;

    public Products(String path){
        ler = new LerFile(path);
    }

    public Estoque lerProducts() {
        iniciar.getPath();
        lerTudo();
        Estoque es = new Estoque();
        String str[] = new String[7];

        /**
         * str[0] = codigo
         * str[1] = nome
         * str[2] = descricao
         * str[3] = categoria
         * str[4] = preco
         * str[5] = estoque
         * str[6] = estoqueCritico
         */

        JSONParser parser = new JSONParser();

        Object objeto;

        try {
            objeto = parser.parse(new FileReader("D:/Faculdade/POO/TrabalhoMercantil/src/assets/" + "produtos.json"));
            JSONArray jsonarray = (JSONArray) objeto;
            // System.out.println("jsonarray size = " + jsonarray.size());
            for (int i = 0; i < jsonarray.size(); i++) {

                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                str[0] = (String) jsonObject.get("codigo");
                str[1] = (String) jsonObject.get("nome");
                str[2] = (String) jsonObject.get("descricao");
                str[3] = (String) jsonObject.get("categoria");
                str[4] = (String) jsonObject.get("preco");
                str[5] = (String) jsonObject.get("estoque");
                str[6] = (String) jsonObject.get("estoqueCritico");

                es.adcionarProduto(new Produto(str[0], str[1], str[2], Integer.parseInt(str[3]), Float.parseFloat(str[4]), 
                Integer.parseInt(str[5]), Integer.parseInt(str[6])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e);
        }

        return es;
    }

    public boolean escreverProduct(Produto p) {

        return false;
    }

    public void lerTudo(){
        
    }
}
