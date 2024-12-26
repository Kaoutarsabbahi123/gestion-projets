package Persistance;
import Metier.entreprise;
import java.util.*;
import java.sql.*;
public class DAO_ENTREPRISE {
        Connection cn;

        public DAO_ENTREPRISE() {
            super();
            cn =  connection.getconnection();
        }

        public ArrayList <entreprise> getAll()
        {
            ArrayList <entreprise> et=new ArrayList<entreprise>();
            PreparedStatement ps;
            try {
                ps = cn.prepareStatement("SELECT * FROM Entreprise");
                ResultSet rs=ps.executeQuery();
                while(rs.next()) {
                    et.add(new entreprise(rs.getInt("Num_entrp"),
                            rs.getString("Num_teleE"),rs.getString("Email_entrp"),
                            rs.getString("Adresse_entrp"),rs.getString("responsable"),rs.getString("Raison_social")));
                }
                return et;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;

        }
        public boolean supprimerEnt(int id_entrp)
        {

            try {
                PreparedStatement ps=cn.prepareStatement("DELETE FROM Entreprise WHERE Num_entrp=?");
                ps.setInt(1, id_entrp);
                ps.execute();
                return true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }

        public boolean modifierEnt(entreprise et)
        {
            try {
                PreparedStatement ps=cn.prepareStatement("UPDATE entreprise SET  Num_teleE=?, Email_entrp=?," +
                        "Adresse_entrp=?, responsable=?, Raison_social=? WHERE Num_entrp=?");
                ps.setString(1, et.getNumtele());
                ps.setString(2, et.getEmail());
                ps.setString(3, et.getAdresse());
                ps.setString(4,et.getResponsable() );
                ps.setString(5, et.getRaison_social());
                ps.setInt(6,et.getNumentrp());
                ps.execute();
                return true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }


        public boolean ajouterEnt(entreprise et) {

            try {
                PreparedStatement ps=cn.prepareStatement("INSERT INTO entreprise  values (?,?,?,?,?,?)");
                ps.setInt(1,et.getNumentrp());
                ps.setString(2, et.getNumtele());
                ps.setString(3, et.getEmail());
                ps.setString(4, et.getAdresse());
                ps.setString(5,et.getResponsable() );
                ps.setString(6, et.getRaison_social());
                ps.execute();
                return true;
            }catch(SQLException e) {
                e.printStackTrace();
            }

            return false;
        }
        public int countEtreprise()
        {
            PreparedStatement ps;
            int nbr=0;
            try {
                ps = cn.prepareStatement("SELECT COUNT(*) FROM entreprise");
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
    public int existe_Entrp(int id){
        int t=0;
        try{
            PreparedStatement st=cn.prepareStatement("SELECT COUNT(*) from Entreprise where Num_entrp=?");
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
