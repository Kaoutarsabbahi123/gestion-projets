package Metier.Gestionnaires;
import Metier.Departement;
import Persistance.DAO_DEPARTEMENT;
import Persistance.DAO_ENTREPRISE;

import java.util.ArrayList;

public class Gestionnaire_dep {
    DAO_DEPARTEMENT dep;
    public Gestionnaire_dep(){
        dep = new DAO_DEPARTEMENT();
    }
    public boolean ajout_dep(Departement d){
        return dep.ajouter(d);
    }
    public boolean sup_dep(int Num_dep){
        return dep.delete_dep(Num_dep);
    }
    public boolean modif_dep(Departement d){
        return dep.modify_dep(d);
    }
    public int nbr_dep(){
        return dep.nbdepartement();
    }
    public ArrayList<Departement> getAllDep(){
        return dep.getAll();
    }
    public int existe_dep(int id){return dep.existe_dep(id);}
}
