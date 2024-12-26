package Persistance;
import Presentation.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connection {
    final static String driverClassName="com.mysql.cj.jdbc.Driver";
    final static String connectionUrl="jdbc:mysql://localhost:3306/gestion_Projets";
    final static String dbUser="root";
    final static String dbPwd="Kawtar123_@*";
    public connection(){
    }

    public static Connection getconnection(){
        try{
            Class.forName(driverClassName); // pilote
            Connection cn = DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
            return cn;
        }catch(ClassNotFoundException | SQLException e ){

            return null ;
        }
    }
}
