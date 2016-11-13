/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sindhusha
 */
@WebServlet(name = "statereg", urlPatterns = {"/statereg"})
public class statereg extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
          String son,email,psw,phno,state;
          son=request.getParameter("son");
          email=request.getParameter("email");
          psw=request.getParameter("psw");
          phno=request.getParameter("phno");
          state=request.getParameter("state");
           java.sql.Connection con=DB.MyDBBean.getDBConnection();
           String q="insert into stateofficer values('0','"+son+"','"+email+"','"+phno+"','"+psw+"','"+state+"')";
           java.sql.Statement st=con.createStatement();
          int i=st.executeUpdate(q);
          if(i>0)
          {
               RequestDispatcher rd=request.getRequestDispatcher("statereg.jsp");
                   request.setAttribute("msg", "State Officer Registered Successfully");
                   rd.forward(request, response);
          }else
          {
               RequestDispatcher rd=request.getRequestDispatcher("statereg.jsp");
                   request.setAttribute("msg", "State Not Registered");
                   rd.forward(request, response);
          }
          
          
        }
        catch(Exception e)
        {
            out.println(e);
        }
        
        finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
