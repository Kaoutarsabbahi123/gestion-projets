package Persistance;
import Metier.Filiere;
import Metier.Projet;
import Metier.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_FILIERE {
    Connection con;
    public DAO_FILIERE(){
        con= connection.getconnection();
    }
    public ArrayList<Filiere> getAll() {
        ResultSet res;
        ArrayList<Filiere> liste = new ArrayList<Filiere>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM filiére");
            res = ps.executeQuery();
            while (res.next()) {
                liste.add(new Filiere(res.getInt("Num_fil"),res.getString("Nomfil"),
                        res.getInt("Num_depa")));
            }
            return liste;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public boolean ajouterfiliere(Filiere fil){
        try {
            PreparedStatement ps=con.prepareStatement("INSERT INTO filiére  values (?,?,?)");
            ps.setInt(1,fil.getNum_fil());
            ps.setString(2, fil.getNom_fil());
            ps.setInt(3,fil.getNum_departement());
            ps.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean supprimerFiliere(int id_fil){
        try {
            PreparedStatement ps=con.prepareStatement("DELETE FROM filiére WHERE Num_fil=?");
            ps.setInt(1, id_fil);
            ps.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean modifierFiliere(Filiere f){
        try {
            PreparedStatement ps=con.prepareStatement("UPDATE filiére SET Nomfil=?, Num_depa=? WHERE Num_fil = ?");
            ps.setString(1, f.getNom_fil());
            ps.setInt(2,f.getNum_departement());
            ps.setInt(3,f.getNum_fil());
            ps.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
     public int nbfiliere(){
         PreparedStatement ps;
         int nbr=0;
         try {
             ps = con.prepareStatement("SELECT COUNT(*) FROM filiére");
             ResultSet rs=ps.executeQuery();
             while(rs.next())
             {
                 nbr=rs.getInt("COUNT(*)");
             }
             return nbr;
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         return nbr;
     }
    public int existe(int num_fil){
        int t=0;
        try{
            PreparedStatement st=con.prepareStatement("SELECT COUNT(*) from filiére where Num_fil =?");
            st.setInt(1,num_fil);
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
     public int getFilBYName(String nomfil){
        int id=0;
         try{
             PreparedStatement st=con.prepareStatement("SELECT Num_fil from filiére where Nomfil =?");
             st.setString(1,nomfil);
             ResultSet rs= st.executeQuery();
             if(rs.next()){
                 id=rs.getInt("Num_fil");
             }
             return id;
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return id;
     }
}
