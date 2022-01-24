/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author israe
 */
public class EscreverFile {

    String file = "D:/Faculdade/POO/TrabalhoMercantil/src/trabalhomercantil/data.txt";
    Scanner sc = new Scanner(System.in);

    /**
     * alguma coisa
     */
    public EscreverFile() {
        String line;
        try (
                OutputStream os = new FileOutputStream(file, true);
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);) {
            do {
                line = sc.nextLine(); // lê uma linha do terminal
                if (line.equals("exit")) break;
                bw.write(line); // Escreve no arquivo
                bw.newLine(); // adiciona caractere de quebra de linha
            } while (true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
