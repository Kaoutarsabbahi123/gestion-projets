package Metier;

public class entreprise {
    private int numentrp;
    private String numtele;
    private String Email;
    private String Adresse;
    private String responsable;
    private String raison_social;
    public entreprise(int numentrp, String numtele, String email, String adresse,
                      String responsable, String raison_social) {
        this.numentrp = numentrp;
        this.numtele = numtele;
        Email = email;
        Adresse = adresse;
        this.responsable = responsable;
        this.raison_social = raison_social;
    }

    public entreprise() {
    }

    public int getNumentrp() {
        return numentrp;
    }

    public void setNumentrp(int numentrp) {
        this.numentrp = numentrp;
    }

    public String getNumtele() {
        return numtele;
    }

    public void setNumtele(String numtele) {
        this.numtele = numtele;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getRaison_social() {
        return raison_social;
    }

    public void setRaison_social(String raison_social) {
        this.raison_social = raison_social;
    }
    public static String[] getAttribut(){
        String[] res={"Num_entrp","Num_teleE","Email_entrp","Adresse_entrp","responsable","Raison_social"};
        return res;
    }
    public Object get(int i){
        switch (i){
            case 0 : return this.getNumentrp();
            case 1 : return this.getNumtele();
            case 2:return this.getEmail();
            case 3 : return this.getAdresse();
            case 4 : return this.getResponsable();
            case 5: return this.getRaison_social();

        }
        return null;
    }
}
