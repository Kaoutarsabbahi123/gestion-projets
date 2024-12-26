package Metier;

public class Professeur {
    private int Id_Prof;
    private int Num_dep;
    private int Num_labo;
    private int Num_fil;
    private String Mdp_prof;
    private String Nom_Prof;
    private String Prenom_Prof;
    private String Email_prof;
    private String Grade;
    private String Etat;
    private String libele;
    private String role;

    public Professeur() {
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Professeur(int id_Prof, int num_dep, int num_labo, int num_fil, String mdp_prof,
                      String nom_Prof, String prenom_Prof, String email_prof, String grade, String etat, String libele, String role) {
        Id_Prof = id_Prof;
        Num_dep = num_dep;
        Num_labo = num_labo;
        Num_fil = num_fil;
        Mdp_prof = mdp_prof;
        Nom_Prof = nom_Prof;
        Prenom_Prof = prenom_Prof;
        Email_prof = email_prof;
        Grade = grade;
        Etat = etat;
        this.libele=libele;
        this.role=role;
    }
    public Professeur(int id_Prof, String nom_Prof, String prenom_Prof, String email_prof,
                      String grade, String etat, String libele, String role,int num_dep, int num_labo, int num_fil) {
        Id_Prof = id_Prof;
        Nom_Prof = nom_Prof;
        Prenom_Prof = prenom_Prof;
        Email_prof = email_prof;
        Grade = grade;
        Etat = etat;
        Num_dep = num_dep;
        Num_labo = num_labo;
        Num_fil = num_fil;
        this.libele=libele;
        this.role=role;
    }

    public int getId_Prof() {
        return Id_Prof;
    }

    public void setId_Prof(int id_Prof) {
        Id_Prof = id_Prof;
    }

    public int getNum_dep() {
        return Num_dep;
    }

    public void setNum_dep(int num_dep) {
        Num_dep = num_dep;
    }

    public int getNum_labo() {
        return Num_labo;
    }

    public void setNum_labo(int num_labo) {
        Num_labo = num_labo;
    }

    public int getNum_fil() {
        return Num_fil;
    }

    public void setNum_fil(int num_fil) {
        Num_fil = num_fil;
    }

    public String getMdp_prof() {
        return Mdp_prof;
    }

    public void setMdp_prof(String mdp_prof) {
        Mdp_prof = mdp_prof;
    }

    public String getNom_Prof() {
        return Nom_Prof;
    }

    public void setNom_Prof(String nom_Prof) {
        Nom_Prof = nom_Prof;
    }

    public String getPrenom_Prof() {
        return Prenom_Prof;
    }

    public void setPrenom_Prof(String prenom_Prof) {
        Prenom_Prof = prenom_Prof;
    }

    public String getEmail_prof() {
        return Email_prof;
    }

    public void setEmail_prof(String email_prof) {
        Email_prof = email_prof;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }
    public static  String[] getAttribut(){
        String[] res={"Id_Prof","Nom_Prof","Prenom_Prof","Email_prof","Grade",
                "Etat","libele","role","Num_filiére" ,
                "Num_département","Num_laboratoire"};
        return res;
    }
    public Object get(int i){
        switch (i){
            case 0 : return this.getId_Prof();
            case 1 : return this.getNom_Prof();
            case 2 : return this.getPrenom_Prof();
            case 3 : return this.getEmail_prof();
            case 4 :return this.getGrade();
            case 5: return this.getEtat();
            case 6: return this.getLibele();
            case 7:return this.getRole();
            case 8: return this.getNum_fil();
            case 9: return this.getNum_dep();
            case 10:return this.getNum_labo();
        }
        return null;
    }
}
