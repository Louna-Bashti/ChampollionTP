package champollion;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;

	Intervention inter1;

	Salle salle1;

	ServicePrevu service;
		
	@BeforeEach
	public void setUp() {
		service = new ServicePrevu(40,50,30);
		untel = new Enseignant("untel", "untel@gmail.com", service);
		uml = new UE("UML");
		java = new UE("Programmation en java");
		salle1 = new Salle("Salle B009",35);
		inter1 = new Intervention(LocalDate.of(2022,10,26),2,false,10,TypeIntervention.CM,uml,salle1);
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeuresTD() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);
		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");
                // 20h TD pour UML
		untel.ajouteEnseignement(uml, 0, 20, 0);
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}

	@Test
	public void testAjoutHeuresCM() {
		// 10h CM pour UML
		untel.ajouteEnseignement(uml, 10, 0, 0);

		assertEquals(15, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 15 heures prévues pour l'UE 'uml'");

		// 10h CM pour UML

		untel.ajouteEnseignement(uml, 10, 0, 0);

		assertEquals(15 + 15, untel.heuresPrevuesPourUE(uml),
				"L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");

	}
	@Test
	public void testAjoutHeuresTP() {
		//10h TP pour UML
		untel.ajouteEnseignement(uml, 0,0,10);
		assertEquals(8, untel.heuresPrevuesPourUE(uml),"Il devrait y avoir 8 heures en équivalent TD pour UML");
		untel.ajouteEnseignement(uml, 0,0,10);
		assertEquals(15, untel.heuresPrevuesPourUE(uml),"Il devrait y avoir 15 heures en équivalent TD pour UML");
	}

	@Test
	public void ajoutHeures(){
		untel.ajouteEnseignement(uml, 10,10,0);
		assertEquals(25, untel.heuresPrevuesPourUE(uml),"Il devrait y avoir 25 heures de prévues pour l'UE UML");
		untel.ajouteEnseignement(uml,0,10,10);
		assertEquals(25+18,untel.heuresPrevuesPourUE(uml), "Il devrait y avoir 37 heures de prévues pour l'UE UML");
	}

	@Test
	public void ajoutHeuresUE(){
		untel.ajouteEnseignement(uml,0,10,0);
		untel.ajouteEnseignement(java,0,10,0);
		assertEquals(10, untel.heuresPrevuesPourUE(uml), "Il devrait y avoir dix heures prévues pour UML");
		assertEquals(10,untel.heuresPrevuesPourUE(java), "Il devrait y avoir 10 heures prévues pour Java");

	}

	@Test
	public void testSousService() {
		untel.ajouteEnseignement(uml, 0,10,0);
		untel.ajouteEnseignement(uml,0,10,0);
		assertEquals(true, untel.enSousService(), "L'enseignant doit être en sous-service");
		untel.ajouteEnseignement(uml, 0,192,0);
		assertEquals(false, untel.enSousService(), "L'enseignant ne doit pas être en sous-service");

	}

	@Test
	public void testAjoutIntervention() {
		untel.ajouteIntervention(inter1);
		assertEquals(1, untel.getListeInterventions().size(), "Il devrait y avoir une intervention dans la liste");
	}
	@Test
	public void testHeuresPlanifiees(){
		untel.ajouteIntervention(inter1);
		untel.ajouteEnseignement(uml, 10,0,0);
		assertEquals(12, untel.resteAPlanifier(), "Il devrait rester 12 heures à planifier en équivalent TD");
	}
	
}
