package FilRouge;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.io.*;

public class Executable {
	
	
	public static void main (String [] args) throws FileNotFoundException, IOException {
		String activitiesFile;
		String constraintsFile;
		activitiesFile=args[0];
		constraintsFile=args[1];
		
		Reader reader= new Reader(activitiesFile, constraintsFile);
		List<Activity> activities= new ArrayList<>();
		List<Constraint> constraints= new ArrayList<>();
		constraints= reader.readConstraints();
		activities=reader.getFinalActivities();
		
		RandomScheduler ranScheduler = new RandomScheduler();
		
		for (Activity a: activities){
			System.out.println(a);
			ranScheduler.add(a);
		}
		for (Constraint c: constraints){
			System.out.println(c);
			ranScheduler.add(c);
		}
		
		Map<Activity, Integer> edtRandom= ranScheduler.bestMap(20);	
		System.out.println("Nombre contraintes ok: "+ranScheduler.nbConstraintesSatisfied(edtRandom));
		System.out.println(edtRandom);
		
	}
	
}
