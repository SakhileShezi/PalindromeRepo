/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.entity.beans.WordFacadeLocal;
import za.ac.tut.entity.word.Word;

/**
 *
 * @author Thato Keith Kujwane
 */
public class WordProcessorServlet extends HttpServlet {
    @EJB
    WordFacadeLocal wordPersistanceEJB;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String word = request.getParameter("word");
        boolean isPalindrome = determineIfPalindrome(word);
        
        Word userWord = new Word(word, isPalindrome);
        
        wordPersistanceEJB.create(userWord);
        
        request.setAttribute("word", word);
        request.setAttribute("outcome", isPalindrome);
        
        request.getRequestDispatcher("outcoume.jsp").forward(request, response);
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

    private boolean determineIfPalindrome(String word) {
        boolean isPalindrome = false;
        
        String newWord = "";
        
        for (int i = word.length() - 1; i >= 0; i--){
            newWord += word.charAt(i);
        }
        
        isPalindrome = word.equalsIgnoreCase(newWord);
        
        return isPalindrome;
    }

}
