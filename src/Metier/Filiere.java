package Metier;

public class Filiere {
    private int Num_fil;
    private String Nom_fil;
    private int Num_departement;
    public Filiere() {
    }

    public Filiere(int Num_fil,String nom_fil, int num_depart) {
        this.Num_fil=Num_fil;
        Nom_fil = nom_fil;
        Num_departement = num_depart;
    }

    public String getNom_fil() {
        return Nom_fil;
    }

    public void setNom_fil(String nom_fil) {
        Nom_fil = nom_fil;
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "Num_fil=" + Num_fil +
                ", Nom_fil='" + Nom_fil + '\'' +
                ", Num_departement='" + Num_departement + '\'' +
                '}';
    }

    public int getNum_fil() {
        return Num_fil;
    }

    public void setNum_fil(int num_fil) {
        Num_fil = num_fil;
    }

    public int getNum_departement() {
        return Num_departement;
    }

    public void setNum_departement(int num_departement) {
        Num_departement = num_departement;
    }
    public static String[] getAttribut(){
        String[] res={"Num_fil","Nom_fil","Num_departement"};
        return res;
    }
    public Object get(int i){
        switch (i){
            case 0 : return this.getNum_fil();
            case 1 : return this.getNom_fil();
            case 2 : return this.getNum_departement();

        }
        return null;
    }
}
