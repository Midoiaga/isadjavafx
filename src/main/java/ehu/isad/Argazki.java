package ehu.isad;

import java.sql.Struct;

public class Argazki {
    private String izena;
    private String fitx;

    @Override
    public String toString() {
        return izena;
    }

    public Argazki(String pIzena, String pFitx){
        this.izena=pIzena;
        this.fitx=pFitx;

    }
    public String getFitx(){
        return this.fitx;
    }
}
