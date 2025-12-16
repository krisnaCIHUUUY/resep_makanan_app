/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
public class LangkahMemasak {
    private int nomorUrutan;
    private String intruksi;
    private String fotoLangkahUrl;
    
    public LangkahMemasak(int nomorUrutan, String intruksi) {
        this.nomorUrutan = nomorUrutan;
        this.intruksi    = intruksi;
        this.fotoLangkahUrl = fotoLangkahUrl;
    }
        
    public LangkahMemasak(int nomorUrutan, String intruksi, String fotoLangkahUrl) {
        this.nomorUrutan = nomorUrutan;
        this.intruksi = intruksi;
        this.fotoLangkahUrl = fotoLangkahUrl;
    }
    
    // Getter // 
    public int getNomorUrutan() {
        return nomorUrutan;
    }
    
    public String getIntruksi() {
        return intruksi;
    }
    
    public String getFotoLangkahUrl() {
        return fotoLangkahUrl;
    }

    Object[] getInstruksi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
        
        
    }
    
    

