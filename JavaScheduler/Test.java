package JavaScheduler;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;
public class Test{


public static void main (String [] args) {
	// Definition of activities
	Activity cafe = new Activity ("Boire un café", 10);
	Activity cours = new Activity ("Cours de POO", 75);
	Activity campus = new Activity ("Aller au campus", 30);
	Activity lireMail = new Activity ("Lire mon courrier électronique", 5);

	// Definition of constraints
	PrecedenceConstraint c1 = new PrecedenceConstraint (cafe, campus);
	PrecedenceConstraint c2 = new PrecedenceConstraint (campus, cours);
	PrecedenceConstraint c3 = new PrecedenceConstraint (lireMail, cours);
	List<PrecedenceConstraint> allConstraints = new ArrayList();
	allConstraints.add(c1);
	allConstraints.add(c2);
	allConstraints.add(c3);

	// Computation of schedule
	Scheduler s = new Scheduler ();
	HashMap<Activity, Integer> schedule = s.computeShedule(allConstraints);
	if (schedule == null) {
		System.out.println("Pas de plan cohérent avec toutes les contraintes");
	} else {
		System.out.println("Un plan trouvé : " + schedule);
	}
	// affiche par exemple "{cafe = 0, lireMail = 10, campus = 15, cours = 45}" (en minutes)
	
	
	
}
}
