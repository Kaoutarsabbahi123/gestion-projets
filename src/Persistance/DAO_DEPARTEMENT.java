package Persistance;
import Metier.Departement;
import java.util.*;
import java.sql.*;
public class DAO_DEPARTEMENT {
    Connection cn;

    public DAO_DEPARTEMENT()
    {
        cn= connection.getconnection();
    }

    public ArrayList<Departement> getAll()
    {
        ArrayList <Departement> liste= new ArrayList<Departement>();
        try {
            PreparedStatement ps=cn.prepareStatement("SELECT * FROM Département");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                liste.add(new Departement(rs.getInt("Num_depa"),rs.getString("Nom_depa"),
                        rs.getString("Email_depa")));
            }
            return liste;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public boolean ajouter(Departement d)
    {
        try {
            PreparedStatement ps= cn.prepareStatement("insert into Département values(?,?,?)");
            ps.setInt(1,d.getNum_depa());
            ps.setString(2, d.getEmail());
            ps.setString(3, d.getNom());
            ps.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }
    public boolean delete_dep(int Id) {
        try {
            PreparedStatement ps = cn.prepareStatement("Delete from Département where Num_depa=?");
            ps.setInt(1, Id);
            ps.execute();
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean modify_dep(Departement d) {
        try {
            PreparedStatement ps = cn.prepareStatement("update Département set Nom_depa=?,Email_depa = ? where" +
                    " Num_depa=? ");
            ps.setString(1, d.getNom());
            ps.setString(2, d.getEmail());
            ps.setInt(3,d.getNum_depa());
            ps.execute();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public int nbdepartement(){
        PreparedStatement ps;
        int nbr=0;
        try {
            ps = cn.prepareStatement("SELECT COUNT(*) FROM Département");
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
    public int existe_dep(int id){
        int t=0;
        try{
            PreparedStatement st=cn.prepareStatement("SELECT COUNT(*) from Département where Num_depa=?");
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
