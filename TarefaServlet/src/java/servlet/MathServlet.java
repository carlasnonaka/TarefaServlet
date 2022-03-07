/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carla
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/MathServlet"})
public class MathServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String error = null;
            double n1=1, n2=1;
            String operacao = request.getParameter("op");
            try
            {
                String p1 = request.getParameter("n1");
                String p2 = request.getParameter("n2");
                n1 = Double.parseDouble(p1);
                n2 = Double.parseDouble(p2);
            } catch (Exception e)
            {
                error = e.getMessage();
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>TAREFA 02 - MathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3><a href='index.html'> Voltar </a></h3>");
            out.println("<h1> JAVA EE </h1>");
            out.println("<h1> OPERAÇÃO ARITMÉTICA </h1>");
            if (error != null)
            {
                out.println("<span style='color:red'> ERRO AO TENTAR LER PARÂMETRO! </span>");
            }else 
            {
               
                out.println("<br/>");
                out.println("<div>");
                if (operacao.equals("+"))
                {
                    out.println(n1+" + "+n2+" = "+(n1+n2));
                } else if (operacao.equals("-"))
                {
                   out.println(n1+" - "+n2+" = "+(n1-n2)); 
                } else if (operacao.equals("*"))
                {
                    out.println(n1+" * "+n2+" = "+(n1*n2));
                } else if (operacao.equals("/") && (n2 != 0))
                {
                    out.println(n1+" / "+n2+" = "+(n1/n2));
                } else
                {
                    out.println("Digite um valor válido!"); 
                }
                out.println("</div>");
                
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
