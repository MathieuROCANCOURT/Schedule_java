package JavaInteractive;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class InteractiveScheduling {
	public static void main (String [] args) {
	
	/*Créer les Activités*/
	/* ************************************************************** */
	ArrayList<String> activities=new ArrayList<String>();
	
	ArrayList<Activity> activitiesWithLength=new ArrayList<Activity>();
	
	String test=" ";
	
	System.out.println("\nEntrez les noms de vos activités. \nTapez stop pour sortir");
	Scanner scanner = new Scanner(System.in);
	while ((!test.contentEquals("stop"))){
		if (scanner.hasNextLine()){
		test=scanner.nextLine();
		activities.add(test);}
	}
	
	activities.remove("stop");
	System.out.println("\nLes activités que vous avez rentrées sont:  ");
	for(String str: activities){
		System.out.println("	"+str);
	}
	for (String str: activities){
		System.out.println("Quelle est la durée de "+str+" (en minutes)");
		activitiesWithLength.add(new Activity(str,scanner.nextInt()));
	}
	/* ************************************************************** */
	
	/* Créer les contraintes */
	/* ************************************************************** */
	ArrayList<Constraint> constraints= new ArrayList<Constraint>();
	test=" ";
	ArrayList<Activity> temporary =new ArrayList<Activity>();
	
	System.out.println("\nEntrez les contraintes sur vos activités.\n");
	
	
	while ((!test.contentEquals("non"))){
		System.out.println("\nAjouter une contrainte de précedence? oui/non");
		if (scanner.hasNext()){
			test=scanner.nextLine();
			if (test.contentEquals("oui")){
				System.out.println("\nAjouter les activités dans l'ordre dans lequel vous voulez\nqu'elles apparaissent dans l'edt.\n");
				
				System.out.println("\nActivité 1?");
				String nom1 = scanner.nextLine();
				
				for (Activity a1 : activitiesWithLength){
					if (a1.getDescription().equals(nom1)){
						temporary.add(a1);
					}
				}
				System.out.println("\nActivité 2?");
				String nom2 = scanner.nextLine();
				
				for (Activity a2 : activitiesWithLength){
					if (a2.getDescription().equals(nom2)){
						temporary.add(a2);
					}
				}
				System.out.println("\nQuel type de precedence?\n	S'enchaine sans écart: Taper 1\n	S'enchaine avec écart: Taper 2\n	Peu Importe: Taper3\n");
				String choix=scanner.nextLine();
				if (choix.contentEquals("1")){
					constraints.add(new MeetConstraint(temporary.get(0),temporary.get(1)));
				}
				if (choix.contentEquals("2")){
					System.out.println("\nCombien d'écart minimum? (en minute)");
					int gap = scanner.nextInt(); 
					constraints.add(new PrecedenceConstraintWithGap(temporary.get(0),temporary.get(1),gap));
				}
				if (choix.contentEquals("3")){
					constraints.add(new PrecedenceConstraint(temporary.get(0),temporary.get(1)));
				}
				temporary.clear();
				
			}
		}
	}
	test=" ";
	
	int dureeMax;
	
	System.out.println("\nAjouter une contrainte de durée max? oui/non");
	if (scanner.hasNext()){
			test=scanner.nextLine();
			if (test.contentEquals("oui")){
					System.out.println("\nQuelle est la durée max?(en minute)");
					dureeMax=scanner.nextInt();
					constraints.add(new MaxSpanConstraint(activitiesWithLength,dureeMax));
			}
		}
	/* ************************************************************** */
	
	/*Ajouter les durées */
	/* ************************************************************** */
	HashMap<Activity, Integer> edt= new HashMap<Activity, Integer>();
	
	int duree;
	
	for (Activity a: activitiesWithLength){
		System.out.println("\nA quelle heure "+a.getDescription()+ " a lieu? (en minute)");
		duree=scanner.nextInt();
		edt.put(a,duree);
	
	}
	scanner.close();
	/* ************************************************************** */
	
	/* Test des contraintes*/
	for (Constraint c : constraints){
		if (c.isSatisfiedBySchedule(edt)){
			System.out.println("\nLa contrainte "+c.toString()+ " est OK");
		}else{
			System.out.println("\nLa contrainte "+c.toString()+ " n'est pas OK");
		}
	}
	
}
}
	


/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
