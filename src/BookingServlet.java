import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/booking")

public class BookingServlet extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out =
                response.getWriter();

        String fullname =
                request.getParameter("fullname");

        int age =
                Integer.parseInt(
                request.getParameter("age"));

        String vaccine =
                request.getParameter("vaccine");

        String hospital =
                request.getParameter("hospital");

        String booking_date =
                request.getParameter("booking_date");

        try{

            Connection con =
                    DBConnection.getConnection();

            String query =
            "INSERT INTO vaccination(fullname,age,vaccine,hospital,booking_date) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, fullname);

            ps.setInt(2, age);

            ps.setString(3, vaccine);

            ps.setString(4, hospital);

            ps.setString(5, booking_date);

            int i = ps.executeUpdate();

            if(i > 0){

                response.sendRedirect("viewbooking.jsp");

            }else{

                out.println("Booking Failed");
            }

        }catch(Exception e){

            out.println(e);
        }
    }
}