package Metier.Gestionnaires;
import Metier.Departement;
import Metier.Professeur;
import Persistance.DAO_DEPARTEMENT;
import Persistance.DAO_PROFESSEUR;

import java.util.ArrayList;

public class Gestionnaire_prof {
    DAO_PROFESSEUR prof;

    public Gestionnaire_prof() {
        prof=new DAO_PROFESSEUR();
    }
    public boolean ajout_prof(Professeur p){
        return prof.ajoutprof(p);
    }
    public boolean sup_prof(int Id_prof){
        return prof.supprimer_prof(Id_prof);
    }
    public boolean modif_prof(Professeur p){
        return prof.modif_prof(p);
    }
    public int nbr_prof(){
        return prof.getNumberofProf();
    }
    public boolean archive(int id){return prof.archiver_Prof(id);}
    public ArrayList<Professeur> get_prof(){return prof.getProf();}
    public int existe_prof(int id){return prof.existe_prof(id);}
    public boolean getprof(int id){return prof.getprof(id);}
    public boolean authentif_Chefdep(String email,String mdp){return prof.authentif_Chefdep(email,mdp);}
    public boolean authentif_chefFil(String email,String mdp){return prof.authentif_chefFil(email,mdp);}
    public boolean authentif_respo(String email,String mdp){return prof.authentif_respo(email,mdp);}
    public boolean verf(int id,int Idprof ){return prof.verf(id,Idprof);}
}
