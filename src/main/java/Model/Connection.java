package Model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {

    java.sql.Connection con = null;

    //DB QUERIES
    private static final String SELECT_ADMIN = "SELECT * FROM Admin WHERE user = ?";
    private static final String SELECT_ALL_CLIENTS = "SELECT * FROM Cliente";
    private static final String INSERT_CLIENTE = "INSERT INTO Cliente(idCliente,nombre,calle,colonia,ciudad,telefono,tamano,cantidad) VALUES (?,?,?,?,?,?,?,?)";
    private static final String INSERT_PLATILLO = "INSERT INTO Platillo(idPlatillo,nombre,ingredientes,tamano,precio) VALUES (?,?,?,?,?)";
    private static final String SELECT_ORDERS = "SELECT * FROM Orden";
    private static final String SELECT_SALES = "SELECT * FROM Venta";
    private static final String SELECT_MENU = "SELECT * FROM Platillo";

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

    public Admin getAdminFromDB(String user){

        Admin admin = null;

        try(java.sql.Connection con = RetriveConnection();
                PreparedStatement preparedState = con.prepareStatement(SELECT_ALL_CLIENTS);) {

            preparedState.setString(1, user);
            System.out.println(preparedState);

            ResultSet result = preparedState.executeQuery();
            while (result.next()){
                int id = Integer.parseInt(result.getString("idAdmin"));
                String username = result.getString("user");
                String pass = result.getString("pass");

                admin = new Admin(id, username, pass);
            }

        }catch(SQLException e){

            System.out.println("SELECT ADMIN ERROR");
            e.printStackTrace();
        }
        return admin;
    }

    public Cliente insertCliente(Cliente cliente){

        try(java.sql.Connection con = RetriveConnection(); PreparedStatement preparedState = con.prepareStatement(INSERT_CLIENTE, Statement.RETURN_GENERATED_KEYS);){

            preparedState.setString(1, cliente.getNombre());
            preparedState.setString(2,cliente.getCalle());
            preparedState.setString(3,cliente.getColonia());
            preparedState.setString(4,cliente.getTelefono());
            preparedState.setString(5,cliente.getTamano());
            preparedState.setString(6,cliente.getCiudad());
            preparedState.setString(7,cliente.getCantidad());

            System.out.println(preparedState);

            int result = preparedState.executeUpdate();

            try (ResultSet generatedKeys = preparedState.getGeneratedKeys()) {
                if (generatedKeys.next()) {

                    int generatedId = (int) generatedKeys.getLong(1);

                    cliente.setIdCliente(generatedId);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained");
                }
            }

        } catch (SQLException e){
            System.out.println("INSERT INTO USER ERROR");
            e.printStackTrace();

        }
        return cliente;
    }


}
