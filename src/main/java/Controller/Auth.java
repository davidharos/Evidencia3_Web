package Controller;
import Model.Admin;
import Model.Cliente;
import Model.Connection;
import com.azul.crs.client.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Auth/*")
public class Auth extends HttpServlet{
    private Connection connection = new Connection();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getPathInfo().substring(1);

        switch (action) {
            case "login": {
                try {
                    getAdmin(request,response);
                } catch (SQLException e) {
                    System.out.println("LOGIN ERROR");
                    e.printStackTrace();
                }
            }
            break;

            case "register":{
                try {
                    createAdmin(request,response);
                } catch (SQLException e) {
                    System.out.println("REGISTER ERROR");
                    e.printStackTrace();
                }
            }
            break;

        }

    }

    private void getAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {

        //Se traen los datos del JSP
        String user = request.getParameter("user");
        String pass = (String) request.getParameter("pass");

        //Conexion a DB
        Admin admin = connection.getAdminFromDB(user);
        HttpSession session = request.getSession();

        //Validacion de contrasena
        if(pass.equals(admin.getPass())){
            request.setAttribute("idAdmin",admin.getIdAdmin());
            session.setAttribute("idAdmin",admin.getIdAdmin());
            response.sendRedirect(request.getContextPath()+"/inicio.jsp");
        } else {
            System.out.println("NO SON IGUALES");
            response.sendRedirect(request.getContextPath());
        }

    }

    private void createAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {


    }

    }
