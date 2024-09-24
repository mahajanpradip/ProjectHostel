package Okk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pk")
public class Pradip extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 try {
 			Class.forName("com.mysql.cj.jdbc.Driver");
 			String user="root";
 			String password="root";
 			String url="jdbc:mysql://localhost:3306/advjavae2?";
 			Connection connection=DriverManager.getConnection(url,user,password);
 			
 			String query="INSERT INTO ok (id) values (?)";
 			  String st=req.getParameter("id");
 			  int i=Integer.parseInt(st);
 			PreparedStatement pstmt=connection.prepareStatement(query);
 			 
 			Data d=new Data();
 			pstmt.setInt(1, i);
 			
 			pstmt.executeUpdate();
 			
 			pstmt.close();
 			connection.close();
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}

    }
}
