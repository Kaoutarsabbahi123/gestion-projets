package Metier.Gestionnaires;
import Metier.Etudiant;
import Persistance.DAO_ETUDIANT;
import Persistance.DAO_PROJET;

import java.util.ArrayList;

public class Gestionnaire_Etudiant {
    DAO_ETUDIANT et;
    public Gestionnaire_Etudiant(){
        et=new DAO_ETUDIANT();
    }
    public ArrayList<Etudiant> getAll(){
        return et.getAll();
    }
    public boolean ajouterEtudiant(Etudiant e)
    {
        return et.ajouterEtudiant(e);
    }
    public boolean supprimerEtudiant(String CNE)
    {
        return et.supprimerEtudiant(CNE);
    }
    public boolean modifier(Etudiant etd) {
        return et.modifier(etd);
    }
    public long countEtudiant() {
        return et.getNumberofEtudiant();
    }
    public int existe_etd(String id){return et.existe_Etd(id);}
}

