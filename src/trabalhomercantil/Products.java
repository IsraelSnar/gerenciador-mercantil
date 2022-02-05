package trabalhomercantil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Products {
    LerFile ler;
    Init iniciar = new Init();
    String dados = "";
    String data;

    public Products(String path) {
        ler = new LerFile(path);
        iniciar.setPath(path);
    }

    public Estoque lerProducts() {

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

        System.out.println(iniciar.getPath());

        try {
            objeto = parser.parse(new FileReader(iniciar.getPath() + "produtos.json"));
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

                es.adcionarProduto(
                        new Produto(str[0], str[1], str[2], Integer.parseInt(str[3]), Float.parseFloat(str[4]),
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
        data = ",{\"codigo\": \"" + p.getCodigoBarras() +
                "\",\"nome\": \"" + p.getNome() +
                "\",\"descricao\": \"" + p.getDescricao() +
                "\",\"categoria\":\"" + p.getCategoria() +
                "\",\"preco\": \"" + p.getPreco() +
                "\",\"estoque\": \"" + p.getEstoqueAtual() +
                "\",\"estoqueCritico\": \"" + p.getEstoqueCritico() + "\"}";

        /**
         * pegar var dados juntar com variavel data escrever file "produtos.json"
         */
        return false;
    }

    public void lerTudo() {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(iniciar.getPath() + "produtos.json"),
                StandardCharsets.UTF_8)) {

            // usando o método getEncoding() da classe InputStreamReader
            // para pegar a codificação usada no arquivo
            // System.out.println("Codificação do arquivo: " + isr.getEncoding());

            int intValue;
            // lê o arquivo caractere a caractere e imprime na tela
            while ((intValue = isr.read()) != -1) {
                char ch = (char) intValue;
                // System.out.print(ch);
                if (ch == ']') {
                } else {
                    dados += ch;
                }
            }
            // System.out.println();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    public String getDados() {
        return dados;
    }
}
