package Metier;
enum genre{
    PFA,PFE,Doctorat;
}
public class Projet {
    private int N_Projet;
    private String Dure;
    private String date_depart;
    private String titre;
    private genre type;
    private int Num_entrp;
    private String N_CNE;

    public Projet(int n_Projet, String dure, String date_depart, String titre,
                  String type,int num_entrp,String N_CNE) {
        N_Projet = n_Projet;
        Dure = dure;
        this.date_depart = date_depart;
        this.titre = titre;
        if(type.equals("PFE"))			this.type=genre.PFE;
        else if(type.equals("PFA"))	this.type=genre.PFA;
        else if(type.equals("Doctorat"))	this.type=genre.Doctorat;
        else						this.type=null;
        Num_entrp = num_entrp;
        this.N_CNE=N_CNE;
    }
    public Projet() {
    }

    public int getN_Projet() {
        return N_Projet;
    }

    public String getDure() {
        return Dure;
    }

    public String getDate_depart() {
        return date_depart;
    }

    public String getTitre() {
        return titre;
    }

    public String getType() {
        return this.type.toString();
    }
    public int getNum_entrp() {
        return Num_entrp;
    }

    public void setN_Projet(int n_Projet) {
        N_Projet = n_Projet;
    }

    public void setDure(String dure) {
        Dure = dure;
    }

    public void setDate_depart(String date_depart) {
        this.date_depart = date_depart;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setType(String type) {
        if(type.equals("PFE"))			this.type=genre.PFE;
        else if(type.equals("PFA"))	this.type=genre.PFA;
        else if(type.equals("Doctorat"))	this.type=genre.Doctorat;
        else						this.type=null;
    }


    public void setNum_entrp(int num_entrp) {
        Num_entrp = num_entrp;
    }

    public void setType(genre type) {
        this.type = type;
    }

    public String getN_CNE() {
        return N_CNE;
    }

    public void setN_CNE(String n_CNE) {
        N_CNE = n_CNE;
    }
      public static String[] getAttribut(){
    String[] res={"N_Projet","duree","date_depart","titre","type","Num_entrp","N_CNE"};
    return res;
}
    public Object get(int i){
        switch (i){
            case 0 : return this.getN_Projet();
            case 1 : return this.getDure();
            case 2 : return this.getDate_depart();
            case 3 : return this.getTitre();
            case 4 :return this.getType();
            case 5: return this.getNum_entrp();
            case 6: return this.getN_CNE();
        }
        return null;
    }

}
