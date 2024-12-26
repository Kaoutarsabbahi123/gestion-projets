package Persistance;
import Metier.Projet;
import java.sql.Connection;
import java.util.*;
import java.sql.*;
public class DAO_PROJET {
    Connection con;
    public DAO_PROJET() {
        super();
        this.con = new connection().getconnection();
    }
    public ArrayList<Projet> getAll() {
        ResultSet res;
        ArrayList<Projet> liste = new ArrayList<Projet>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT *from Projet");
            res = ps.executeQuery();
            while (res.next()) {
                liste.add(new Projet(res.getInt("N_proj"),res.getString("Durée"),res.getString("Date_départ"),
                        res.getString("Titre"), res.getString("Type"),
                        res.getInt("Num_entrp"), res.getString("N_CNE")));
            }
            return liste;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public boolean ajouterprojet(Projet proj){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO Projet values (?,?,?,?,?,?,?)");
            ps.setInt(1, proj.getN_Projet());
            ps.setString(2,proj.getTitre());
            ps.setString(3, proj.getDure());
            ps.setString(4, proj.getDate_depart());
            ps.setString(5, proj.getType());
            ps.setString(6,proj.getN_CNE());
            ps.setInt(7,proj.getNum_entrp());
            ps.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean modifierprojet(Projet p){
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE Projet SET Titre=?, Durée=?, Date_départ=?,"+
                    "Type=?, N_CNE=?,Num_entrp=?"+
                    " WHERE N_Proj = ? ");
            ps.setString(1, p.getTitre());
            ps.setString(2,p.getDure());
            ps.setString(3, p.getDate_depart());
            ps.setString(4, p.getType());
            ps.setString(5, p.getN_CNE());
            ps.setInt(6,p.getNum_entrp());
            ps.setInt(7,p.getN_Projet());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean supprimerprojet(int Id_projet){
        try {
            PreparedStatement ps=con.prepareStatement("DELETE FROM Projet WHERE N_proj=?");
            ps.setInt(1, Id_projet);
            ps.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public Projet getprojet(String Titre){
        Projet pj;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Projet WHERE Titre =?");
            ps.setString(1, Titre);
            ResultSet res = ps.executeQuery();
            pj= new Projet(res.getInt("N_proj"),res.getString("Durée"),res.getString("Date_départ"),
                    res.getString("Titre"),res.getString("Type"),res.getInt("Num_entrp"),res.getString("N_CNE") );
            return pj;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public int nbProjet()
    {
        PreparedStatement ps;
        int t=0;
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM projet");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                t=rs.getInt("COUNT(*)");
            }
            return t;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }
    public int existe_projet(int id){
        int t=0;
        try{
            PreparedStatement st=con.prepareStatement("SELECT COUNT(*) from Projet where N_proj=?");
            st.setInt(1,id);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                t=rs.getInt("COUNT(*)");
            }
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
}
