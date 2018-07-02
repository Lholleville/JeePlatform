/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DeviceModel;
import model.DevicetypeModel;
import model.UserModel;

/**
 *
 * @author Loic
 */
@WebServlet(name = "addDeviceServlet", urlPatterns = {"/addDeviceServlet"})
public class addDeviceServlet extends HttpServlet {

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
            out.println("<title>Servlet addDeviceServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addDeviceServlet at " + request.getContextPath() + "</h1>");
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
      
        
      try {
            UserModel user = new UserModel();
            DevicetypeModel dtm = new DevicetypeModel();
            List<UserModel> LUm = user.findAll();
            List<DevicetypeModel> Ldtm = dtm.findAll();
            request.setAttribute("ListUser", LUm);
            request.setAttribute("ListDeviceType", Ldtm);
            System.out.println(request.getAttribute("ListUser"));
            this.getServletContext().getRequestDispatcher("/addDevice.jsp").forward(request, response);
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addDeviceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addDeviceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        
        try {
            UserModel user = new UserModel();
            DevicetypeModel dtm = new DevicetypeModel();
            List<UserModel> LUm = user.findAll();
            List<DevicetypeModel> Ldtm = dtm.findAll();
            request.setAttribute("ListUser", LUm);
            request.setAttribute("ListDeviceType", Ldtm);
            Integer status = Integer.parseInt(request.getParameter("status"));
            Integer user_id = Integer.parseInt(request.getParameter("user_id"));
            Integer devicetype = Integer.parseInt(request.getParameter("devicetype"));
            DeviceModel device = new DeviceModel();
            device.createDevice(request.getParameter("name"),
                    request.getParameter("unit"),
                    status,
                    user_id, 
                    devicetype
            );
            
            
            this.getServletContext().getRequestDispatcher("/addDevice.jsp").forward(request, response);
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addDeviceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addDeviceServlet.class.getName()).log(Level.SEVERE, null, ex);
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
