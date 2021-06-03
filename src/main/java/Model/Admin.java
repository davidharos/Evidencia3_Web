package Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Admin {

    private Connection DBConnection = new Connection();

    //variables
    private int idAdmin = 0;
    private String user = "";
    private String pass = "";

    public Admin (int idAdmin, String user, String pass){

        setUser(user);
        setPass(pass);
        setIdAdmin(idAdmin);
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}

