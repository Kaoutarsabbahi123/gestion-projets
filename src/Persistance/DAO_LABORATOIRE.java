package Persistance;
import Metier.Etudiant;
import Metier.laboratoire;
import java.util.*;
import java.sql.*;
public class DAO_LABORATOIRE {
    Connection cn;

    public DAO_LABORATOIRE()
    {
        cn=connection.getconnection();
    }

    public ArrayList<laboratoire> getAll()
    {
        ArrayList <laboratoire> liste= new ArrayList<laboratoire>();
        try {
            PreparedStatement ps=cn.prepareStatement("SELECT * FROM Laboratoire");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                liste.add(new laboratoire (rs.getString("Nom_labo"),rs.getInt("Num_labo"),rs.getString("Email_labo")
                        ,rs.getString("Num_telel"),rs.getString("Adresse_labo")));
            }
            return liste;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public boolean ajouter(laboratoire l)
    {
        try {
            PreparedStatement ps= cn.prepareStatement("insert into Laboratoire  values(? ,?, ?,?,?)");
            ps.setInt(1, l.getNum());
            ps.setNString(2, l.getNom());
            ps.setNString(3, l.getEmail());
            ps.setNString(4, l.getTel());
            ps.setNString(5, l.getAdress());
            ps.execute();
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete_Lab(int id_labo) {
        try {
            PreparedStatement  ps = cn.prepareStatement("Delete from laboratoire where Num_labo = ?");
            ps.setInt(1,id_labo);
            ps.execute();
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean modify_Lab(laboratoire l) {
        try {
            PreparedStatement ps = cn.prepareStatement("update laboratoire set  Nom_labo = ? ,Email_labo = ? ,Num_telel = ?," +
                    " Adresse_labo= ?  where Num_labo=?");
            ps.setNString(1,l.getNom());
            ps.setNString(2,l.getEmail());
            ps.setNString(3,l.getTel());
            ps.setNString(4,l.getAdress());
            ps.setInt(5, l.getNum());
            ps.execute();
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public int countLabo()
    {
        PreparedStatement ps;
        int nbr=0;
        try {
            ps = cn.prepareStatement("SELECT COUNT(*) FROM Laboratoire");
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
    public int existe_labo(int num_labo){
        int t=0;
        try{
            PreparedStatement st=cn.prepareStatement("SELECT COUNT(*) from Laboratoire where Num_labo=?");
            st.setInt(1,num_labo);
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
