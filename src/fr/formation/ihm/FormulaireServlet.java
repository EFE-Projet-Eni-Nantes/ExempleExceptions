package fr.formation.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.formation.bll.BllException;
import fr.formation.bll.FormulaireManager;
import fr.formation.bo.Personne;

@WebServlet("/formulaire")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/formulaire.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String age = request.getParameter("age");
		
		FormulaireManager fm = new FormulaireManager();
		String output = "/WEB-INF/jsp/succes.jsp";
		try {
			Personne p = fm.ajout(nom, prenom, age);
			request.setAttribute("personne", p);
			
		} catch (BllException e) {
			request.setAttribute("erreurs", e.getMessages());
			output = "/WEB-INF/jsp/formulaire.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(output);
		rd.forward(request, response);
		
	}

}
