package Persistance;
import java.util.*;
import java.sql.*;
import Metier.Etudiant;
public class DAO_ETUDIANT {
    Connection con;
    public DAO_ETUDIANT() {
       con=connection.getconnection();
    }
    public ArrayList<Etudiant> getAll() {
        ResultSet res;
        ArrayList<Etudiant> liste = new ArrayList<Etudiant>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Etudiant;");
            res = ps.executeQuery();
            while (res.next()) {
                liste.add(new Etudiant(res.getNString("N_CNE"), res.getNString("Nometd"), res.getNString("Prenom"),
                        res.getNString("Niveau"), res.getInt("Num_fil"), res.getNString("Email"),
                        res.getInt("Num_labo")));
            }
            return liste;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public boolean ajouterEtudiant(Etudiant e)
    {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Etudiant values(?,?,?,?,?,?,?,?)");
            ps.setString(1, e.getCNE());
            ps.setString(2, e.getNom());
            ps.setString(3, e.getPrenom());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getNiveau());
            ps.setInt(6, e.getFiliere());
            ps.setInt(7,e.getLabo());
            ps.setString(8,e.getMdp_etudiant());
            ps.execute();
            return true;
        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }
        return false;
    }
    public boolean supprimerEtudiant(String CNE)
    {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Etudiant WHERE N_CNE=?");
            ps.setString(1,CNE);
            ps.execute();
            return true;
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return false;
    }
    public boolean modifier(Etudiant E)
    {
        try {
            PreparedStatement ps =con.prepareStatement("UPDATE Etudiant set Nometd=?,Prenom=?," +
                    "Email=?,niveau=?,Num_fil=?,Num_labo=? where N_CNE=?");
            ps.setString(1,E.getNom());
            ps.setString(2,E.getPrenom());
            ps.setString(3,E.getEmail());
            ps.setString(4,E.getNiveau());
            ps.setInt(5,E.getFiliere());
            ps.setInt(6,E.getLabo());
            ps.setString(7,E.getCNE());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }
    public int getNumberofEtudiant()
    {
        PreparedStatement ps;
        int t=0;
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM Etudiant");
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
    public boolean authentif_Etudiant(String email,String mdp){
        try{
            PreparedStatement st=con.prepareStatement("SELECT N_CNE FROM Etudiant where Email_prof=? AND Mdp_prof=?");
            st.setString(1,email);
            st.setString(2,mdp);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int existe_Etd(String Cne){
        int t=0;
        try{
            PreparedStatement st=con.prepareStatement("SELECT COUNT(*) from Etudiant where N_CNE=?");
            st.setString(1,Cne);
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
