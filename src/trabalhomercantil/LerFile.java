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
    private String token;
    private boolean adm;

    /**
     *
     * @param path
     */
    public LerFile(String path) {
        setPath(path);
    }

    /**
     * ler file
     */
    public LerFile() {
        if (path.isEmpty()) {
            System.out.println("Vazio");
        }
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
     * @param file
     * @param user
     * @param pass
     * @return
     */
    public boolean viewLogin(String file, String user, String pass) {
        JSONParser parser = new JSONParser();

        Object objeto;

        try {
            objeto = parser.parse(new FileReader(file + ".json"));
            JSONArray jsonarray = (JSONArray) objeto;
            //System.out.println("jsonarray size = " + jsonarray.size());
            for (int i = 0; i < jsonarray.size(); i++) {
                //System.out.println("i: " + i);
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
//                System.out.println((String) jsonObject.get("nome"));
                if (jsonObject.get("user").equals(user) && jsonObject.get("senha").equals(pass)) {
                    //System.out.println((String) jsonObject.get("token"));
                    setToken((String) jsonObject.get("token"));
                    String cargo = (String) jsonObject.get("cargo");
                    if (cargo.equals("Admin")) {
                        setAdm(true);
                    } else {
                        setAdm(false);
                    }
                    return true;
                }
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
        return false;
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

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    private void setToken(String token) {
        this.token = token;
    }

    /**
     * Set token ""
     */
    public void setToken() {
        this.token = null;
    }

    /**
     * @return the adm
     */
    public boolean isAdm() {
        return adm;
    }

    /**
     * @param adm the adm to set
     */
    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    /**
     *
     * @param file
     * @param valor
     * @param token
     * @return
     */
    public String viewVal(String file, String valor, String token) {
        JSONParser parser = new JSONParser();

        Object objeto;

        try {
            objeto = parser.parse(new FileReader(file + ".json"));
            JSONArray jsonarray = (JSONArray) objeto;
            //System.out.println("jsonarray size = " + jsonarray.size());
            for (int i = 0; i < jsonarray.size(); i++) {
                //System.out.println("i: " + i);
                JSONObject jsonObject = (JSONObject) jsonarray.get(i);
//                System.out.println((String) jsonObject.get("nome"));
                if (jsonObject.get("token").equals(token)) {
                    //System.out.println((String) jsonObject.get("token"));
                    System.out.println("Valor: " + valor);
                    return ((String) jsonObject.get(valor));
                }
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
        return null;
    }
}
