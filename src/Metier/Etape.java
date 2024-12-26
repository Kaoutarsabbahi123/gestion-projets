package Metier;

import java.util.Locale;

public class Etape {
    private String N_Etape;
    private String Durre;
    private String Date_depart;
    private String Doc;
    private String Liv;
    private int N_proj;
    public Etape(){}
    public Etape(String doc,String Liv,String N_Etape,String Durre,int N_proj, String Date_depart ) {
        this.Doc=doc;
        this.Liv=Liv;
        this.N_Etape=N_Etape;
        this.Durre=Durre;
        this.N_proj=N_proj;
        this.Date_depart=Date_depart;
    }

    public String getDoc() {
        return Doc;
    }

    public int getN_proj() {
        return N_proj;
    }

    public String getN_Etape() {
        return N_Etape;
    }

    public String getLiv() {
        return Liv;
    }

    public String getDurre() {
        return Durre;
    }

    public void setN_Etape(String n_Etape) {
        N_Etape = n_Etape;
    }

    public void setDoc(String doc) {
        Doc = doc;
    }

    public void setDurre(String durre) {
        Durre = durre;
    }

    public void setLiv(String liv) {
        Liv = liv;
    }

    public void setN_proj(int n_proj) {
        N_proj = n_proj;
    }

    public String getDate_depart() {
        return Date_depart;
    }

    public void setDate_depart(String date_depart) {
        Date_depart = date_depart;
    }

    @Override
    public String toString() {
        return "Etape{" +
                "N_Etape=" + N_Etape +
                ", Durre='" + Durre + '\'' +
                ", Date_depart='" + Date_depart + '\'' +
                ", Doc='" + Doc + '\'' +
                ", Liv='" + Liv + '\'' +
                ", N_proj=" + N_proj +
                '}';
    }
}

