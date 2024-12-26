package Metier.Gestionnaires;
import Metier.Filiere;
import Persistance.DAO_FILIERE;

import java.util.ArrayList;

public class Gestionnaire_fil {
    DAO_FILIERE fil;
    public Gestionnaire_fil(){
        fil =new DAO_FILIERE();
    }
    public ArrayList<Filiere> getAll_fil(){
        return fil.getAll();
    }
    public boolean ajout_fil(Filiere f){
        return fil.ajouterfiliere(f);
    }
    public boolean sup_fil(int num_fil){
        return fil.supprimerFiliere(num_fil);
    }
    public boolean modif_fil(Filiere f){
        return fil.modifierFiliere(f);
    }
    public int nbr_fil(){
        return fil.nbfiliere();
    }
    public int  existe(int id){return fil.existe(id);}
    public int getFilBYName(String nomfil){return fil.getFilBYName(nomfil);}
}
