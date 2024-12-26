package Metier.Gestionnaires;
import Metier.Etape;
import Persistance.DAO_ETAPE;
public class Gestionnaire_etape {
    DAO_ETAPE etape;

    public Gestionnaire_etape() {
        etape = new DAO_ETAPE();
    }
    public boolean ajoutetape(Etape e){
        return etape.ajouteretape(e);
    }
    public boolean supp_etape(String N_etape){
        return etape.supprimeretape(N_etape);
    }
    public boolean modif_etape(Etape e){
        return etape.modifieretape(e);
    }
}
