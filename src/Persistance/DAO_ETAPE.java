package Persistance;
import Metier.Etape;
import java.sql.*;
public class DAO_ETAPE {
    private Connection con;
    public DAO_ETAPE(){
        super();
        this.con=new connection().getconnection();
    }
    public boolean ajouteretape(Etape etape){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO étape  values (?,?,?,?,?,?)");
            ps.setString(1, etape.getN_Etape());
            ps.setString(2,etape.getDurre());
            ps.setString(3, etape.getDate_depart());
            ps.setString(4, etape.getDoc());
            ps.setString(5, etape.getLiv());
            ps.setInt(6,etape.getN_proj());
            return ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean supprimeretape(String N_etape)
    {
        try {
            PreparedStatement ps=con.prepareStatement("DELETE FROM étape WHERE N_étape=?");
            ps.setString(1, N_etape);
            return ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean modifieretape(Etape etape){
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE étape SET Durée=?,Date_départ=?,Doc=?,liv=?,N_proj=? WHERE N_étape=?");
            ps.setString(1,etape.getDurre());
            ps.setString(2, etape.getDate_depart());
            ps.setString(3, etape.getDoc());
            ps.setString(4, etape.getLiv());
            ps.setInt(5,etape.getN_proj());
            ps.setString(6, etape.getN_Etape());
            return ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
}
