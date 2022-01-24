/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhomercantil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author israe
 */
public class LerFile {

    private String path;

    /**
     *
     * @param path
     */
    public LerFile(String path) {
        setPath(path);
    }

    /**
     *
     * @param file
     * @return dados do arquivo passado no parametro
     */
    public String view(String file) {
        JSONParser parser = new JSONParser();

        Object objeto;

        try {
            objeto = parser.parse(new FileReader(getPath() + file + ".json"));
            JSONArray jsonarray = (JSONArray) objeto;
            System.out.println("jsonarray size = " + jsonarray.size());
            for (int i = 0; i < jsonarray.size(); i++) {
                //System.out.println("i: " + i);
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
                System.out.println((String) jsonObject.get("nome"));
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
        return "";
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return ""; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

}
