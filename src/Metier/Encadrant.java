package Metier;

public class Encadrant extends Professeur{
    public Encadrant(int id_Prof, int num_dep, int num_labo, int num_fil, String mdp_prof, String nom_Prof,
                     String prenom_Prof, String email_prof, String grade, String etat, String libele, String role) {
        super(id_Prof, num_dep, num_labo, num_fil, mdp_prof, nom_Prof, prenom_Prof, email_prof, grade, etat,libele,role);
    }
}
