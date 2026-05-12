import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out =
                response.getWriter();

        String fullname =
                request.getParameter("fullname");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        try{

            Connection con =
                    DBConnection.getConnection();

            String query =
            "INSERT INTO users(fullname,email,password) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, password);

            int i = ps.executeUpdate();

            if(i > 0){

                out.println(
                "<h1 style='color:green;text-align:center;'>Registration Successful</h1>"
                );

            }else{

                out.println(
                "<h1 style='color:red;text-align:center;'>Registration Failed</h1>"
                );
            }

        }catch(Exception e){

            e.printStackTrace();
        }
    }
}