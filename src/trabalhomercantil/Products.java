package trabalhomercantil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Products {
    LerFile ler;
    Init iniciar = new Init();
    String dados;
    String data = "[";

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
            System.err.println("Products: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
        return es;
    }

    public boolean escreverProduct(Produto p) {
        lerTudo();
        if (p != null) {
            dados += ",\n    {\n        \"codigo\": \"" + p.getCodigoBarras() +
                    "\",\n        \"nome\": \"" + p.getNome() +
                    "\",\n        \"descricao\": \"" + p.getDescricao() +
                    "\",\n        \"categoria\":\"" + p.getCategoriaN() +
                    "\",\n        \"preco\": \"" + p.getPreco() +
                    "\",\n        \"estoque\": \"" + p.getEstoqueAtual() +
                    "\",\n        \"estoqueCritico\": \"" + p.getEstoqueCritico()
                    + "\"\n    }";
            if (writeProducts("produtos.json")) {
                System.out.println("Produto escrito no banco de dados");
                return true;
            } else {
                System.err.println("Erro ao inserir produto");
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean writeProducts(String file) {
        try (
                OutputStream os = new FileOutputStream("D:/Faculdade/POO/TrabalhoMercantil/src/assets/" + file, false);
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);) {

            bw.write(dados); // Escreve no arquivo
            bw.write("]"); // Escreve no arquivo
            // bw.newLine(); // adiciona caractere de quebra de linha
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.err.println("Tente novamente, caso o erro persista");
            System.err.println("entre em contato com o administrador ou programador");
            return false;
        }
    }

    public boolean editProducts(Produto p, Estoque e) {
        System.out.println(e);
        if (p != null) {
            for (int i = 0; i < e.getProdutos().size(); i++) {
                if (e.getProdutos().get(i).getCodigoBarras().equals(p.getCodigoBarras())) {
                    

                    data += "\n    {\n        \"codigo\": \"" + p.getCodigoBarras() +
                            "\",\n        \"nome\": \"" + p.getNome() +
                            "\",\n        \"descricao\": \"" + p.getDescricao() +
                            "\",\n        \"categoria\":\"" + p.getCategoriaN() +
                            "\",\n        \"preco\": \"" + p.getPreco() +
                            "\",\n        \"estoque\": \"" + p.getEstoqueAtual() +
                            "\",\n        \"estoqueCritico\": \"" + p.getEstoqueCritico()
                            + "\"\n    }";
                    if (i != e.getProdutos().size() - 1) {
                        data += ",";
                    }
                   
                } else {
                    data += "\n    {\n        \"codigo\": \"" + e.getProdutos().get(i).getCodigoBarras() +
                            "\",\n        \"nome\": \"" + e.getProdutos().get(i).getNome() +
                            "\",\n        \"descricao\": \"" + e.getProdutos().get(i).getDescricao() +
                            "\",\n        \"categoria\":\"" + e.getProdutos().get(i).getCategoriaN() +
                            "\",\n        \"preco\": \"" + e.getProdutos().get(i).getPreco() +
                            "\",\n        \"estoque\": \"" + e.getProdutos().get(i).getEstoqueAtual() +
                            "\",\n        \"estoqueCritico\": \"" + e.getProdutos().get(i).getEstoqueCritico()
                            + "\"\n    }";
                    if (i != e.getProdutos().size() - 1) {
                        data += ",";
                    }
                }
            }

            try (

                    OutputStream os = new FileOutputStream(iniciar.getPath() + "produtos.json", false);
                    OutputStreamWriter osw = new OutputStreamWriter(os);
                    BufferedWriter bw = new BufferedWriter(osw);) {

                bw.write(data); // Escreve no arquivo
                bw.write("]"); // Escreve no arquivo
                // bw.newLine(); // adiciona caractere de quebra de linha
                data = "[";
                return true;
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.err.println("Tente novamente, caso o erro persista");
                System.err.println("entre em contato com o administrador ou programador");
                return false;
            }
        } else {
            return false;
        }

    }

    public void delete(String id) {
        String str[] = new String[7];
        data = "[";

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
            objeto = parser.parse(new FileReader(iniciar.getPath() + "produtos.json"));
            JSONArray jsonarray = (JSONArray) objeto;
            System.out.println("Json Array: " + jsonarray);
            System.out.println("jsonarray size = " + jsonarray.size());

            for (int i = 0; i < jsonarray.size(); i++) {

                JSONObject jsonObject = (JSONObject) jsonarray.get(i);

                if (jsonObject.get("codigo").equals(id)) {

                } else {
                    str[0] = (String) jsonObject.get("codigo");
                    str[1] = (String) jsonObject.get("nome");
                    str[2] = (String) jsonObject.get("descricao");
                    str[3] = (String) jsonObject.get("categoria");
                    str[4] = (String) jsonObject.get("preco");
                    str[5] = (String) jsonObject.get("estoque");
                    str[6] = (String) jsonObject.get("estoqueCritico");
                    data += "\n    {\n        \"codigo\": \"" + str[0] +
                            "\",\n        \"nome\": \"" + str[1] +
                            "\",\n        \"descricao\": \"" + str[2] +
                            "\",\n        \"categoria\":\"" + str[3] +
                            "\",\n        \"preco\": \"" + str[4] +
                            "\",\n        \"estoque\": \"" + str[5] +
                            "\",\n        \"estoqueCritico\": \"" + str[6]
                            + "\"\n    }";
                    if (i != jsonarray.size() - 1) {
                        data += ",";
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println("Products: " + e);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }

        /**
         * Escrever
         */

        try (

                OutputStream os = new FileOutputStream(iniciar.getPath() + "produtos.json", false);
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);) {

            bw.write(data); // Escreve no arquivo
            bw.write("]"); // Escreve no arquivo
            // bw.newLine(); // adiciona caractere de quebra de linha
            data = "[";
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.err.println("Tente novamente, caso o erro persista");
            System.err.println("entre em contato com o administrador ou programador");
        }
    }

    public void lerTudo() {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(iniciar.getPath() + "produtos.json"),
                StandardCharsets.UTF_8)) {

            // usando o método getEncoding() da classe InputStreamReader
            // para pegar a codificação usada no arquivo
            
            dados = "";
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
