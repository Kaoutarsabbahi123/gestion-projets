package Persistance;
import Metier.Professeur;
import Metier.*;
import Presentation.Accueil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO_PROFESSEUR {
    Connection con;
    public DAO_PROFESSEUR(){
        con=connection.getconnection();
    }
   public ArrayList<Professeur> getProf(){
        ArrayList<Professeur> liste=new ArrayList<>();
        try
        {
            PreparedStatement ps=con.prepareStatement("select Id_Prof,Nomprof,Prénom_prof,Email_prof,grade,etat," +
                    "Num_depa,Num_fil,Num_labo" +
                    ",libelle,rolep from Professeur ");
            ResultSet res=ps.executeQuery();
            while(res.next()){
                liste.add(new Professeur(res.getInt("Id_Prof"), res.getString("Nomprof"),
                        res.getString("Prénom_prof"),
                        res.getString("Email_prof"),res.getString("grade"),res.getString("etat"),
                        res.getString("libelle"),res.getString("rolep"),
                        res.getInt("Num_depa"),res.getInt("Num_fil"),
                        res.getInt("Num_labo")));
            }
            return liste;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean ajoutprof(Professeur p){
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO Professeur values (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,p.getId_Prof());
            ps.setString(2,p.getNom_Prof());
            ps.setString(3,p.getPrenom_Prof());
            ps.setString(4,p.getEmail_prof());
            ps.setString(5,p.getGrade());
            ps.setString(6,p.getLibele());
            ps.setInt(7,p.getNum_dep());
            ps.setInt(8,p.getNum_fil());
            ps.setInt(9,p.getNum_labo());
            ps.setString(10,p.getRole());
            ps.setString(11,p.getEtat());
            ps.setString(12,p.getMdp_prof());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean supprimer_prof(int id){
        try{
            PreparedStatement ps=con.prepareStatement("Delete from Professeur where Id_Prof=? and etat=?");
            ps.setInt(1,id);
            ps.setString(2,"Archive");
            ps.execute();
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean modif_prof(Professeur p){
        try{
            PreparedStatement ps=con.prepareStatement("UPDATE professeur set  Nomprof=?, Prénom_prof=?, " +
                    " Email_prof=? ,grade =?," +
                    " libelle =? , Num_depa = ? ,Num_fil = ?,Num_labo=?,rolep=?," +
                    "etat=? WHERE Id_Prof=?");
            ps.setString(1,p.getNom_Prof());
            ps.setString(2,p.getPrenom_Prof());
            ps.setString(3,p.getEmail_prof());
            ps.setString(4,p.getGrade());
            ps.setString(5,p.getLibele());
            ps.setInt(6,p.getNum_dep());
            ps.setInt(7,p.getNum_fil());
            ps.setInt(8,p.getNum_labo());
            ps.setString(9,p.getRole());
            ps.setString(10,p.getEtat());
            ps.setInt(11,p.getId_Prof());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int getNumberofProf()
    {
        PreparedStatement ps;
        int t=0;
        try {
            ps = con.prepareStatement("SELECT COUNT(*) FROM professeur");
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
    private ArrayList<Integer> encadrant() {
        ArrayList<Integer> encadrants = new ArrayList<>();
        {
            PreparedStatement ps;
            try {
                ps = con.prepareStatement("select Id_Prof from encadre ");
                ResultSet res = ps.executeQuery();
                while (res.next()) {
                    encadrants.add(res.getInt("Id_prof"));
                }
                return encadrants;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        }
    }
   public boolean archiver_Prof(int Id)
    {
        PreparedStatement ps;
        try {
            ArrayList<Integer> encadrants= encadrant();
            for ( int Idprof : encadrants){
                     if(Idprof ==Id){
                         return false;
                     }
            }
            ps = con.prepareStatement("UPDATE Professeur SET etat=? WHERE Id_Prof=?");
            ps.setString(1, "Archive");
            ps.setInt(2, Id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
    public boolean authentif_chefFil(String email,String mdp){
        try{
            PreparedStatement st=con.prepareStatement("SELECT Id_Prof FROM Professeur WHERE Email_prof=? AND Mdp_prof=? AND libelle=?");
            st.setString(1,email);
            st.setString(2,mdp);
            st.setString(3,"chef de filière");
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean authentif_respo(String email,String mdp){
        try{
            PreparedStatement st=con.prepareStatement("SELECT Id_Prof FROM Professeur WHERE Email_prof=? AND Mdp_prof=? AND rolep=?");
            st.setString(1,email);
            st.setString(2,mdp);
            st.setString(3,"responsable");
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean authentif_Chefdep(String email,String mdp){
        try{
            PreparedStatement st=con.prepareStatement("SELECT Id_Prof FROM Professeur WHERE Email_prof=? AND Mdp_prof=? AND libelle=?");
            st.setString(1,email);
            st.setString(2,mdp);
            st.setString(3,"Chef de département");
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean authentif_Encadrant(String email,String mdp){
        try{
            PreparedStatement st=con.prepareStatement("SELECT Id_Prof FROM Professeur , encadre WHERE " +
                    "Email_prof=? AND Mdp_prof=? AND Professeur.Id_Prof=encadre.Id_Prof");
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
    public int existe_prof(int id){
        int t=0;
        try{
            PreparedStatement st=con.prepareStatement("SELECT COUNT(*) from professeur where Id_Prof=?");
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
    public boolean getprof(int id){
        try{
            PreparedStatement st=con.prepareStatement("SELECT COUNT(*) from professeur where Id_Prof=? AND " +
                    "libelle=?");
            st.setInt(1,id);
            st.setString(2,"Professeur");
            ResultSet rs= st.executeQuery();
            int t=0;
            if(rs.next()) {
                t = rs.getInt("COUNT(*)");
            }
            if(t==1){
                PreparedStatement ps=con.prepareStatement("UPDATE Professeur SET  libelle=? where Id_Prof=?");
                ps.setString(1,"chef de filière");
                ps.setInt(2,id);
                ps.executeUpdate();
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

        private ArrayList<Integer> profbyfil(int id) {
            ArrayList<Integer> profs = new ArrayList<>();
            {
                PreparedStatement ps;
                try {
                    ps = con.prepareStatement("select Id_Prof from Professeur Where Num_fil=?  ");
                    ResultSet res = ps.executeQuery();
                    while (res.next()) {
                        profs.add(res.getInt("Id_prof"));
                    }
                    return profs;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
            }
    }
    public boolean verf(int id,int Idprof ){
        PreparedStatement ps;
        try {
            ArrayList<Integer> list= profbyfil(id);
            for ( int idp :list){
                if(idp==id){
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return false;
    }
}
