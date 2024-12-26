package Metier;

public class Etudiant {
    private String CNE;
    private String nom;
    private String prenom;
    private String niveau;
    private int filiere;
    private String email;
    private int labo;
    private String mdp_etudiant;

    public String getMdp_etudiant() {
        return mdp_etudiant;
    }

    public void setMdp_etudiant(String mdp_etudiant) {
        this.mdp_etudiant = mdp_etudiant;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getFiliere() {
        return filiere;
    }

    public void setFiliere(int filiere) {
        this.filiere = filiere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLabo() {
        return labo;
    }

    public void setLabo(int labo) {
        this.labo = labo;
    }

    public Etudiant(String CNE, String nom, String prenom, String niveau, int filiere, String email, int labo,String mdp ) {
        this.CNE = CNE;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.filiere = filiere;
        this.email = email;
        this.labo = labo;
        mdp_etudiant=mdp;
    }
    public Etudiant(){
    }
    public Etudiant(String CNE, String nom, String prenom, String niveau, int filiere, String email, int labo ) {
        this.CNE = CNE;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.filiere = filiere;
        this.email = email;
        this.labo = labo;

    }
    public static String[] getAttribut(){
        String[] res={"CNE","nom","prenom","niveau","filiere","email","labo"};
        return res;
    }
    public Object get(int i){
        switch (i){
            case 0 : return this.getCNE();
            case 1 : return this.getNom();
            case 2 : return this.getPrenom();
            case 3 : return this.getNiveau();
            case 4 :return this.getFiliere();
            case 5: return this.getEmail();
            case 6: return this.getLabo();
        }
        return null;
    }

}
