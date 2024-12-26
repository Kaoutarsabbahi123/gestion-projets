package Metier.Gestionnaires;
import Metier.entreprise;
import Persistance.DAO_ENTREPRISE;

import java.util.ArrayList;

public class Gestionnaire_Ent {
    DAO_ENTREPRISE entrp;

    public Gestionnaire_Ent() {
        entrp=new DAO_ENTREPRISE();
    }
    public boolean ajout_entrp(entreprise ent){
        return entrp.ajouterEnt(ent);
    }
    public boolean sup_entrp(int Num_entrp){
        return entrp.supprimerEnt(Num_entrp);
    }
    public boolean modif_entrp(entreprise ent){
        return entrp.modifierEnt(ent);
    }
    public ArrayList<entreprise> getAllEnt(){
        return entrp.getAll();
    }
    public int nb_entrp(){
        return entrp.countEtreprise();
    }
    public int existe_ent(int id){return entrp.existe_Entrp(id);}
}
