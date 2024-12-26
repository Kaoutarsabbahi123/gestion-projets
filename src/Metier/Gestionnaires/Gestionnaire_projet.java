package Metier.Gestionnaires;
import Metier.Projet;
import Persistance.DAO_PROJET;

import java.util.ArrayList;

public class Gestionnaire_projet {
    DAO_PROJET proj;

    public Gestionnaire_projet() {
        proj =new DAO_PROJET();
    }
    public boolean ajout_proj(Projet p){
        return proj.ajouterprojet(p);
    }
    public boolean sup_proj(int N_proj){
        return proj.supprimerprojet(N_proj);
    }
    public boolean modif_proj(Projet p){
        return proj.modifierprojet(p);
    }
    public  int nombre_proj(){
        return proj.nbProjet();
    }
    public ArrayList<Projet> getAllProj(){
        return proj.getAll();
    }
    public Projet getprojet(String Titre){ return proj.getprojet(Titre);}
    public int existe_projet(int id){
         return proj.existe_projet(id);
    }
}
