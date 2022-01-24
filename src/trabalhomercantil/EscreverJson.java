/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author israe
 */
public class EscreverJson {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();

        FileWriter writeFile = null;
//        jsonObject.put("nome", jsonObject.put("_id", 16156));
//        jsonObject.put("sobrenome", "Romanato");
//        jsonObject.put("pais", "Brasil");
//        jsonObject.put("estado", "SP");
        try {
            writeFile = new FileWriter("D:/Faculdade/POO/TrabalhoMercantil/src/trabalhomercantil/saida.json");
            //Escreve no arquivo conteudo do Objeto JSON
            writeFile.write(jsonObject.toJSONString());
            writeFile.close();
            System.out.println("deu certo");
            System.out.println(jsonObject.keySet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
