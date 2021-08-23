package fr.formation.bll;

import fr.formation.bo.Personne;
import fr.formation.dal.DalException;
import fr.formation.dal.FormulaireDao;

public class FormulaireManager {

	private FormulaireDao fDao;
	
	public FormulaireManager() {
		fDao = new FormulaireDao();
	}
	
	public void ajout(String nom, String prenom, String age) throws BllException {
		BllException exception = new BllException();
		
		if (nom == null || nom.trim().isEmpty()) {
			exception.ajoutMessage("Le nom est obligatoire");
		}
		
		if (prenom == null || prenom.trim().isEmpty()) {
			exception.ajoutMessage("Le prenom est obligatoire");
		}
		
		Integer a = null;
		try {
			a = Integer.parseInt(age);
			if (a <= 0)
				exception.ajoutMessage("L'age doit être un entier strictement positif");
		} catch (Exception e) {
			exception.ajoutMessage("L'age doit être un entier");
		}
		
		if (exception.estVide()) {
			Personne p = new Personne(nom, prenom, a);
			try {
				fDao.add(p);
			} catch (DalException e) {
				exception.ajoutMessage("Un problème d'accès à la base de données est apparu : " + e.getMessage());
			}
		}
		
		if (!exception.estVide()) {
			throw exception;
		}
	}
}
