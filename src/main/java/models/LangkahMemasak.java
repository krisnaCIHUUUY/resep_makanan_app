/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author LENOVO
 */
public class LangkahMemasak {
    private String idLangkah;
    private String idResep;
    private int nomorUrutan;
    private String intsruksi;
    private String fotoLangkahUrl;
    
    public LangkahMemasak(){}
    
    public LangkahMemasak(String idLangkah, String idResep, int nomorUrutan, String intsruksi, String fotoLangkahUrl) {
        this.idLangkah = idLangkah;
        this.idResep = idResep;
        this.nomorUrutan = nomorUrutan;
        this.intsruksi = intsruksi;
        this.fotoLangkahUrl = fotoLangkahUrl;
    }
        
    public LangkahMemasak( String idResep, int nomorUrutan, String intsruksi, String fotoLangkahUrl) {
        this.idResep = idResep;
        this.nomorUrutan = nomorUrutan;
        this.intsruksi = intsruksi;
        this.fotoLangkahUrl = fotoLangkahUrl;
    }
    
    // Getter // 
    public String getIdLangkah(){
        return idLangkah;
    }
    public void setIdLangkah(String idLangkah){
        this.idLangkah = idLangkah;
    }
    
    public String getIdResep(){
        return idResep;
    }
    public void setIdResep(String idResep){
        this.idResep = idResep;
    }
    
    public int getNomorUrutan() {
        return nomorUrutan;
    }
    public void setNomorUrutan(int nomorUrutan) {
        this.nomorUrutan = nomorUrutan;
    }
    
    public String getIntruksi() {
        return intsruksi;
    }
    public void setIntruksi(String intsruksi) {
        this.intsruksi = intsruksi;
    }
    
    public String getFotoLangkahUrl() {
        return fotoLangkahUrl;
    }
    public void setFotoLangkahUrl(String fotoLangkahUrl) {
        this.fotoLangkahUrl = fotoLangkahUrl;
    }

    @Override
    public String toString() {
        return "Langkah " + nomorUrutan + ": " + intsruksi;
    }
    }
    
    

