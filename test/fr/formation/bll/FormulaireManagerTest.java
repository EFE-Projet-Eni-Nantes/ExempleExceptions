package fr.formation.bll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.formation.bo.Personne;

class FormulaireManagerTest {

	@Test
	void testAjoutQuiPasse() {
		
		FormulaireManager fm = new FormulaireManager();
		
		try {
			Personne p = fm.ajout("Legrand", "Luc", "40");
			
			assertNotEquals(p, null);
			assertFalse(p == null);
			System.out.println("Coucou");
		} catch (BllException e) {
			fail("La personne n'est pas correcte");
		} 
	}

	@Test
	protected void  testAjoutQuiEnvoieUneExceptionSiNomEstNul() {
		FormulaireManager fm = new FormulaireManager();
		BllException e = assertThrows(BllException.class, () -> fm.ajout(null, "Luc", "40"));
		
		assertTrue(e.getMessages().size() == 1);
		assertTrue(e.getMessages().get(0).contains("nom"));
		
		
	}
	

	@Test
	protected void  testAjoutQuiEnvoieUneExceptionSiPrenomEstNul() {
		FormulaireManager fm = new FormulaireManager();
		BllException e = assertThrows(BllException.class, () -> fm.ajout("Legrand" , null, "40"));
		
		assertTrue(e.getMessages().size() == 1);
		assertTrue(e.getMessages().get(0).contains("prenom"));
		
		
	}
	
	

	@Test
	protected void  testAjoutQuiEnvoieUneExceptionSiAgePasEntier() {

		FormulaireManager fm = new FormulaireManager();
		BllException e = assertThrows(BllException.class, () -> fm.ajout("Legrand" , "Luc", "Coucou"));
		assertTrue(e.getMessages().size() == 1);
		assertTrue(e.getMessages().get(0).contains("entier"));
	}
	

	@Test
	protected void  testAjoutQuiEnvoieUneExceptionSiAgeEstNegatif() {

		FormulaireManager fm = new FormulaireManager();
		BllException e = assertThrows(BllException.class, () -> fm.ajout("Legrand" , "Luc", "-45"));
		assertTrue(e.getMessages().size() == 1);
		assertTrue(e.getMessages().get(0).contains("strictement"));
	}
	
}
