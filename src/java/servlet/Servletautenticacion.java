package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controller.conectadb;
import java.sql.Connection;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santiago
 */
@WebServlet(name = "Servletautenticacion", urlPatterns = {"/Servletautenticacion"})
public class Servletautenticacion extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servletautenticacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servletautenticacion at " + request.getContextPath() + "</h1>");
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

        PrintWriter out = response.getWriter();

        try {
            boolean buscar = false;

            String id = request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String telefono = "";
            String direccion = "";
            String sexo = "";
            String estado = "";
            
            conectadb sqlite = new conectadb();
            java.sql.Connection cn = sqlite.Conectar();
            Statement st = cn.createStatement();
            ResultSet rs;

            String consulta = "Select * from clientes where id='" + id + "' or nombre='" + nombre + "' ;";
            
            rs = st.executeQuery(consulta);
            System.out.print(consulta);
            while (rs.next()) {
                id = rs.getString(1);
                nombre = rs.getString(2);
                buscar = true;
            }

            if (buscar) {

                //Creamos la sesion 
                HttpSession session = request.getSession(true);
                session.setAttribute("id", id);
                session.setAttribute("nombre", nombre);
                

                //Mandamos estos atributos a la página bienvenida.jsp
                request.getRequestDispatcher("/busqueda.jsp").forward(request, response);
            } else {
                //De lo contrario vamos a la página errorLogin.jsp
                request.getRequestDispatcher("/noencontro.jsp").forward(request, response);
            }
            out.close();
        } catch (SQLException ex) {
            out.println(ex.toString());
        }
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
