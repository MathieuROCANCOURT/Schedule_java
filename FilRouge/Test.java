package FilRouge;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;
public class Test{


public static void main (String [] args) {
	
	/*PARTIE NUMERO 1*/
	/* Objets*/
	Activity options = new Activity ("Choisir mes options", 70);
	Activity ip = new Activity ("Inscription pédagogique", 30);
	PrecedenceConstraint contrainte = new PrecedenceConstraint (options, ip);
	int neufHeures = 540;
	int dixHeures = 600;
	int onzeHeures = 640;

	// Test avec une programmation censée satisfaire la contrainte
	if (  !contrainte.isSatisfied(neufHeures, onzeHeures) ) {
		System.out.println("Mon programme ne marche pas.");
		System.out.println("Il aurait dû trouver que la contrainte est satisfaite.");
	} else {
		System.out.println("Mon programme passe le premier test avec succès.");
	}

	// Test avec une programmation censée ne pas satisfaire la contrainte
	if ( contrainte.isSatisfied(dixHeures, neufHeures) ) {
		System.out.println("Mon programme ne marche pas.");
		System.out.println("Il aurait dû trouver que la contrainte n'est pas satisfaite.");
	} else {
		System.out.println("Mon programme passe le deuxième test avec succès.");
	}

	// Test avec une programmation censée ne pas satisfaire la contrainte (car la première
	// activité finirait après le début de la seconde)
	if ( contrainte.isSatisfied(neufHeures, dixHeures) ) {
		System.out.println("Mon programme ne marche pas.");
		System.out.println("Il aurait dû trouver que la contrainte n'est pas satisfaite.");
	} else {
		System.out.println("Mon programme passe le troisième test avec succès.");
	}

	// Definition of activities
	Activity cafe = new Activity ("Boire un café", 10);
	Activity cours = new Activity ("Cours de POO", 75);
	Activity campus = new Activity ("Aller au campus", 30);
	Activity lireMail = new Activity ("Lire mon courrier électronique", 5);
	
	PrecedenceConstraint c1 = new PrecedenceConstraint (cafe, campus);
	PrecedenceConstraint c2 = new PrecedenceConstraint (campus, cours);
	PrecedenceConstraint c3 = new PrecedenceConstraint (lireMail, cours);
	
	/*PARTIE NUMERO 2 DOSSIER SCHEDULER (POUR ALLER PLUS LOIN)*/

	
	/*PARTIE NUMERO 3*/
		
	HashMap<Activity, Integer> edt = new HashMap<> ();
	Activity judoAvecMathieu = new Activity ("faire du judo avec Mathieu le BRO", 200);
	PrecedenceConstraint c5 = new PrecedenceConstraintWithGap(cours, judoAvecMathieu, 500);
	edt.put(cafe, 540);
	edt.put(cours, 550);
	edt.put(campus, 530);
	edt.put(lireMail, 300);
	edt.put(judoAvecMathieu,1140);
	System.out.println("L'emploi du temps satisfait-il c1 ? " + c1.isSatisfiedBySchedule(edt));
	System.out.println("L'emploi du temps satisfait-il c2 ? " + c2.isSatisfiedBySchedule(edt));
	System.out.println("L'emploi du temps satisfait-il c3 ? " + c3.isSatisfiedBySchedule(edt));
	System.out.println("Mathieu doit faire du Judo? " + c5.isSatisfiedBySchedule(edt));


	/*Partie NUMERO 4: DOSSIER ENCODER(POUR ALLER PLUS LOIN)*/

	
	
	/*PARTIE NUMERO 5*/
	Verifier verifieur = new Verifier();

	// Contrainte : activité1 doit être planifiée avant activité2
	verifieur.add(new PrecedenceConstraint(cafe, cours));

	// Contrainte : activité4 doit commencer précisément quand activité3 se termine
	verifieur.add(new MeetConstraint(campus, lireMail));

	// Contrainte : activité1, activité2 et activité3 doivent toutes
	// être exécutées en au plus 90 minutes
	ArrayList<Activity> ensemble = new ArrayList<> ();
	ensemble.add(cafe);
	ensemble.add(cours);
	ensemble.add(campus);
	MaxSpanConstraint contrainteEnsemble = new MaxSpanConstraint(ensemble, 90);
	verifieur.add(contrainteEnsemble);

	HashMap<Activity, Integer> emploiDuTemps = new HashMap<Activity, Integer> ();
	emploiDuTemps.put(cafe, 0);
	emploiDuTemps.put(lireMail, 50);
	emploiDuTemps.put(cours, 40);
	emploiDuTemps.put(campus, 20);
	System.out.println("L'emploi du temps satisfait-il toutes les contraintes ? ");
	if (verifieur.verify(emploiDuTemps)) {
		System.out.println("Oui");
	} else {
		System.out.println("Non");
	}
	
	
	/*PARTIE NUMERO 6*/
		Verifier verifieurNegation = new Verifier();

	// Contrainte : activité1 doit être planifiée avant activité2
	verifieurNegation.add(new NegationConstraint(new PrecedenceConstraint(cafe, cours)));

	// Contrainte : activité4 doit commencer précisément quand activité3 se termine
	verifieurNegation.add(new NegationConstraint(new MeetConstraint(campus, lireMail)));

	// Contrainte : activité1, activité2 et activité3 doivent toutes
	// être exécutées en au plus 90 minutes
	ArrayList<Activity> ensembleNegation = new ArrayList<> ();
	ensembleNegation.add(cafe);
	ensembleNegation.add(cours);
	ensembleNegation.add(campus);
	NegationConstraint contrainteEnsembleNegation = new NegationConstraint(new MaxSpanConstraint(ensemble, 90));
	verifieurNegation.add(contrainteEnsembleNegation);

	System.out.println("L'emploi du temps ne satisfait-il aucune contraintes ? ");
	if (verifieurNegation.verify(emploiDuTemps)) {
		System.out.println("Oui");
	} else {
		System.out.println("Non");
	}
	
	Verifier verifieurDisjunction = new Verifier();
	verifieurDisjunction.add(new DisjunctionConstraint(new MeetConstraint(campus, lireMail),new PrecedenceConstraint(cafe, cours)));
	
	System.out.println("L'emploi du temps ne satisfait-il une des 2 contraintes ? ");
	if (verifieurDisjunction.verify(emploiDuTemps)) {
		System.out.println("Oui");
	} else {
		System.out.println("Non");
	}
	
	/*Partie numero 7*/
	RandomScheduler ranScheduler = new RandomScheduler();
	
	
	ranScheduler.add(cafe);
	ranScheduler.add(cours);
	ranScheduler.add(campus);
	ranScheduler.add(lireMail);
	
	ranScheduler.add(new PrecedenceConstraint(cafe, cours));
	ranScheduler.add(new PrecedenceConstraintWithGap(campus,lireMail,15 ));
	ranScheduler.add(new MaxSpanConstraint(ensemble, 300));
	Map<Activity, Integer> edtRandom= ranScheduler.bestMap(20);
	System.out.println("Nombre contraintes ok: "+ranScheduler.nbConstraintesSatisfied(edtRandom));
	System.out.println(edtRandom);
	
}
}
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
