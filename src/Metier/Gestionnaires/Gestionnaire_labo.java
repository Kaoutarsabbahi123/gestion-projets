package Metier.Gestionnaires;
import Metier.laboratoire;
import Persistance.DAO_LABORATOIRE;
import Metier.Etudiant;
import java.util.ArrayList;

public class Gestionnaire_labo {
    DAO_LABORATOIRE labo;
    public Gestionnaire_labo() {
        labo=new DAO_LABORATOIRE();
    }
    public boolean ajout_labo(laboratoire l){
        return labo.ajouter(l);
    }
    public boolean sup_labo(int Num_labo){
        return labo.delete_Lab(Num_labo);
    }
    public boolean modif_labo(laboratoire l){
        return labo.modify_Lab(l);
    }
    public int nb_labo(){
        return labo.countLabo();
    }
    public ArrayList<laboratoire> getAllLabo(){
        return labo.getAll();
    }
    public int existe_labo(int id){return labo.existe_labo(id);}
}
