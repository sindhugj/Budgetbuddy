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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sindhusha
 */
@WebServlet(name = "AllottoDistrict", urlPatterns = {"/AllottoDistrict"})
public class AllottoDistrict extends HttpServlet {

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
         String don;
          don=request.getParameter("don");
          int amount=Integer.parseInt(request.getParameter("amount"));
          HttpSession session=request.getSession();
          String dname=session.getAttribute("dname").toString();
           String sstate=session.getAttribute("sstatename").toString();
           java.sql.Connection con=DB.MyDBBean.getDBConnection();
           String village="Hyderabad";
          
           String purpose="Hyderabad";
           int amountused=0;
           
           String q="insert into budjectamountdata values('0','"+amount+"','"+village+"','"+dname+"','"+sstate+"','"+don+"','"+purpose+"','"+amountused+"')";
           java.sql.Statement st=con.createStatement();
          int i=st.executeUpdate(q);
          if(i>0)
          {
               RequestDispatcher rd=request.getRequestDispatcher("allotbudgettoDistrict.jsp");
                   request.setAttribute("msg", "Successfully Budget Alloted of <font color='green'>"+amount+"</font>");
                   rd.forward(request, response);
          }else
          {
               RequestDispatcher rd=request.getRequestDispatcher("allotbudgettoDistrict.jsp");
                   request.setAttribute("msg", "District Not Registered");
                   rd.forward(request, response);
          }
          
          
        }
        catch(Exception e)
        {
            out.println(e);
        } finally {            
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
