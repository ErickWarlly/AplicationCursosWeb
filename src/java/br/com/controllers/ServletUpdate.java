/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controllers;

import br.com.dao.PageDAO;
import br.com.model.Disciplinas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author android
 */
public class ServletUpdate extends HttpServlet {

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
        Disciplinas disci = new Disciplinas();

        disci.setIddisciplinas(Integer.parseInt(request.getParameter("selectDisc")));
        disci.setIdcursos(Integer.parseInt(request.getParameter("seletor")));
        disci.setCargahoraria(Integer.parseInt(request.getParameter("cargahora")));

        PageDAO pageDAO = new PageDAO();

        if (disci.getCargahoraria() > 200) {
            request.setAttribute("mensagem", "Carga Horária Inválida, o limite e de 200 horas!");
            request.getRequestDispatcher("alterardisci.do").forward(request, response);
        } else if (disci.getCargahoraria() == 0) {
            boolean confirmad = pageDAO.updateDisciplinaCurso(disci);
            if (confirmad == true) {
                request.setAttribute("mensagem", "ALTERAÇÃO FEITA!");
                request.getRequestDispatcher("alterardisci.do").forward(request, response);
            } else {
                request.setAttribute("mensagem", "OCORREU ALGUM ERRO!");
                request.getRequestDispatcher("alterardisci.do").forward(request, response);
            }
        } else {
            boolean confirmad = pageDAO.updateDisciplina(disci);
            if (confirmad == true) {
                request.setAttribute("mensagem", "ALTERAÇÃO FEITA!");
                request.getRequestDispatcher("alterardisci.do").forward(request, response);
            } else {
                request.setAttribute("mensagem", "OCORREU ALGUM ERRO!");
                request.getRequestDispatcher("alterardisci.do").forward(request, response);
            }
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
