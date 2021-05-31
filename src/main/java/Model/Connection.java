package Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connection {

    java.sql.Connection con = null;

    //DB QUERIES


    public java.sql.Connection RetriveConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Evidencia3_Web");
            Statement statement = con.createStatement();

        } catch (Exception e){
            System.out.println("RETRIEVE ERROR");
            e.printStackTrace();
        }
        return con;
    }


}
