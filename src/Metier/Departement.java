package Metier;

import Presentation.Departement_admi;

public class Departement {
    private int Num_depa;
    private String Nom;
    private String Email;
    public Departement(){
        super();
    }
    public Departement(int Num_depa,String nom, String email) {
        super();
        this.Num_depa=Num_depa;
        Nom = nom;
        Email = email;
    }

    public int getNum_depa() {
        return Num_depa;
    }

    public void setNum_depa(int num_depa) {
        Num_depa = num_depa;
    }

    public String getNom() {
        return Nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public static String[] getAttribut(){
        String[] res={"Num_depa","Nom","Email"};
        return res;
    }
    public Object get(int i){
        switch (i){
            case 0 : return this.getNum_depa();
            case 1 : return this.getNom();
            case 2 : return this.getEmail();

        }
        return null;
    }
}
