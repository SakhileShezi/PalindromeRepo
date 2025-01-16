/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web.servlet;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.entity.beans.WordFacadeLocal;
import za.ac.tut.entity.word.Word;

/**
 *
 * @author Thato Keith Kujwane
 */
public class GetProcessedWordsServlet extends HttpServlet {
    @EJB
    WordFacadeLocal wordsPersistanceEJB;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Word> wordsList = this.wordsPersistanceEJB.findAll();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("wordsList", wordsList);
        
        response.sendRedirect("words_list.jsp");
    }
}
