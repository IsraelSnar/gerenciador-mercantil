/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Israel
 * @author Joao
 */
public class Aplicacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LerFile ler = new LerFile("D:/Faculdade/POO/TrabalhoMercantil/src/trabalhomercantil/");
        
        System.out.println(ler.view("funcionarios"));
//
//        EscreverFile write = new EscreverFile();
//        System.out.println(write);
        /*
        //Locale.setDefault(Locale.US);
//        LerFile ler = new LerFile();
//        System.out.println(ler);
        File file = new File("D:/Faculdade/POO/TrabalhoMercantil/src/trabalhomercantil/estoque.json");

        JSONParser parser = new JSONParser();

        Object objeto;

        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            //jsonObject = (JSONObject) parser.parse(new FileReader("D:/Faculdade/POO/TrabalhoMercantil/src/trabalhomercantil/estoque.json"));
            objeto = parser.parse(new FileReader("D:/Faculdade/POO/TrabalhoMercantil/src/trabalhomercantil/estoque.json"));
            JSONArray jsonarray = (JSONArray) objeto;
            System.out.println("jsonarray size = " + jsonarray.size());
            for (int i = 0; i < jsonarray.size(); i++) {
                System.out.println("i: " + i);
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                System.out.println((String) jsonObject.get("nome"));

            }

            //Salva nas variaveis os dados retirados do arquivo
//            nome = (String) jsonObject.get("nome");
//            sobrenome = (String) jsonObject.get("sobrenome");
//            estado = (String) jsonObject.get("estado");
//            pais = (String) jsonObject.get("pais");
//            System.out.printf(
//                    "Nome: %s\nSobrenome: %s\nEstado: %s\nPais: %s\n",
//                    nome, sobrenome, estado, pais);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        catch (Exception e){
//            System.err.println(e);
//        }

//        //Salva no objeto JSONObject o que o parse tratou do arquivo
//        jsonObject = (JSONObject) parser.parse(new FileReader("saida.json"));
//        //Salva nas variaveis os dados retirados do arquivo
//        System.out.println((String) jsonObject.get("nome"));
//            sobrenome = (String) jsonObject.get("sobrenome");
//            estado = (String) jsonObject.get("estado");
//            pais = (String) jsonObject.get("pais");
//            System.out.printf(
//                    "Nome: %s\nSobrenome: %s\nEstado: %s\nPais: %s\n",
//                    nome, sobrenome, estado, pais);
//        InputStream input = null;
//        try {
//            input = new FileInputStream(file);
//
//            int intValue;
//            // lê o arquivo byte-a-byte e converte cada byte para um char
//            while ((intValue = input.read()) != -1) {
//                char ch = (char) intValue;
//                System.out.print(ch);
//            }
//
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        finally{
//            input.close();
//        }
        /**
         * essa classe funciona
         */
//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
//
//            // usando o método getEncoding() da classe InputStreamReader
//            // para pegar a codificação usada no arquivo
//            System.out.println("Codificação do arquivo: " + isr.getEncoding());
//
//            int intValue;
//            // lê o arquivo caractere a caractere e imprime na tela
//            while ((intValue = isr.read()) != -1) {
//                char ch = (char) intValue;
//                System.out.print(ch);
//            }
//
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println("ERRO: " + e.getMessage());
//        }
        /**
         *
         */
//        try (BufferedReader br
//                = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
//
//            String line;
//
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
//
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println("ERRO: " + e.getMessage());
//        }
//        try (Scanner inputFile = new Scanner(file)) {
//            while (inputFile.hasNext()) {
//                String firstName = inputFile.next();
//                String lastName = inputFile.next();
//                byte age = inputFile.nextByte();
//                double salary = inputFile.nextDouble();
//
//                System.out.printf("Name: %s, Last name: %s, Age: %d, Salary: %.2f%n",
//                        firstName, lastName, age, salary);
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("Invalid input");
//        } catch (FileNotFoundException e) {
//            System.err.println("File not found");
//        } catch (IOException e) {
//            System.err.println("I/O Exception");
//        } catch (Exception e) {
//            System.err.println(e);
//        }

    }

}
