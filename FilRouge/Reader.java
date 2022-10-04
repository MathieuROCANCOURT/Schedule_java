package FilRouge;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.io.*;

public class Reader{
	String activitiesFile;
	String constraintsFile;
	public Map<String,scheduleio.ActivityDescription> activities=new HashMap<>();
	public List<scheduleio.ConstraintDescription> constraints=new ArrayList<>();
	public List<Activity> finalActivities=new ArrayList<>();
	
	/*Builder*/
	public Reader (String activitiesFile, String constraintsFile) throws FileNotFoundException, IOException{
		scheduleio.ActivityReader acReader= new scheduleio.ActivityReader(activitiesFile);
		activities= acReader.readAll();
		
		scheduleio.ConstraintReader coReader= new scheduleio.ConstraintReader(constraintsFile);
		constraints=coReader.readAll();
		this.finalActivities=finalActivities;
	}
	
	/*Getters pour les activités et différentes contraintes*/
	
	
	/*Activités*/
	public Activity getActivity (String str){
		return new Activity (activities.get(str).getName(),activities.get(str).getDuration());
	}
	public List<Activity> getFinalActivities(){
		return this.finalActivities;
	}
	
	/*Contraintes*/
	public PrecedenceConstraint getPrecedenceConstraint (String[] actArray){
		if (actArray.length==2){
		
		for (scheduleio.ConstraintDescription conDes : this.constraints){
			if (conDes.getKeyword().equals("PRECEDENCE")){
				if ((actArray[0].equals(conDes.getArguments()[0]))&&(actArray[1].equals(conDes.getArguments()[1]))){
					Activity a1= this.getActivity(actArray[0]);
					Activity a2= this.getActivity(actArray[1]);
					if (!finalActivities.contains(a1)){
					finalActivities.add(a1);}
					if (!finalActivities.contains(a2)){
					finalActivities.add(a2);}
					return new PrecedenceConstraint(a1,a2);
				}
			}
		}System.err.println("Error: An Activity name is wrong, or doesn't exist");
		
		}else{
			System.err.println("Error: Too many Activities for a PrecedenceConstraints");
		}
		return null;
	}
	
	
	
	public PrecedenceConstraintWithGap getPrecedenceConstraintWithGap (String[] actArray){
		if (actArray.length==3){
		
		for (scheduleio.ConstraintDescription conDes : this.constraints){
			if (conDes.getKeyword().equals("PRECEDENCE_GAP")){
				if ((actArray[1].equals(conDes.getArguments()[1]))&&(actArray[2].equals(conDes.getArguments()[2]))){
					Activity a1= this.getActivity(actArray[1]);
					Activity a2= this.getActivity(actArray[2]);
					if (!finalActivities.contains(a1)){
					finalActivities.add(a1);}
					if (!finalActivities.contains(a2)){
					finalActivities.add(a2);}
					return new PrecedenceConstraintWithGap(a1,a2, Integer.parseInt(actArray[0]));
				}
			}
		}System.err.println("Error: An Activity name or gap is wrong, or doesn't exist");
		
		}else{
			System.err.println("Error: Too many Activities for a PrecedenceConstraints");
		}
		return null;
	}
	
	
	
	public MeetConstraint getMeetConstraint (String[] actArray){
		if (actArray.length==2){
		
		for (scheduleio.ConstraintDescription conDes : this.constraints){
			if (conDes.getKeyword().equals("MEET")){
				if ((actArray[0].equals(conDes.getArguments()[0]))&&(actArray[1].equals(conDes.getArguments()[1]))){
					Activity a1= this.getActivity(actArray[0]);
					Activity a2= this.getActivity(actArray[1]);
					if (!finalActivities.contains(a1)){
					finalActivities.add(a1);}
					if (!finalActivities.contains(a2)){
					finalActivities.add(a2);}
					return new MeetConstraint(a1,a2);
				}
			}
		}System.err.println("Error: An Activity name is wrong, or doesn't exist");
		
		}else{
			System.err.println("Error: Too many Activities for a PrecedenceConstraints");
		}
		return null;
	}
	
	
	
	public MaxSpanConstraint getMaxSpanConstraint (String[] actArray){
		ArrayList<Activity> arrayListAct= new ArrayList<Activity>();
		
		for (scheduleio.ConstraintDescription conDes : this.constraints){
			if (conDes.getKeyword().equals("MAX_SPAN")){
				for (int i=1; i<actArray.length ;i++){
				if (actArray[i].equals(conDes.getArguments()[i])){
					Activity a1= this.getActivity(actArray[i]);
					if(!finalActivities.contains(a1)){
						finalActivities.add(a1);}
					arrayListAct.add(a1);
				}
			}
				if (arrayListAct.size()==actArray.length-1){
					return new MaxSpanConstraint(arrayListAct, Integer.parseInt(actArray[0]));
				}
			}
			
		}System.err.println("Error: An Activity name or total length is wrong, or doesn't exist");
		return null;
		}	
		
		/*Fonctions retournant les SET/LIST des activités et contraintes*/
	
	public List<Constraint> readConstraints(){
		List<Constraint> allConstraints = new ArrayList<>();
		for (scheduleio.ConstraintDescription consDesc : this.constraints){
			if (consDesc.getKeyword().equals("PRECEDENCE")){
				allConstraints.add(getPrecedenceConstraint(consDesc.getArguments()));	
			}
			if (consDesc.getKeyword().equals("PRECEDENCE_GAP")){
				allConstraints.add(getPrecedenceConstraintWithGap(consDesc.getArguments()));	
			}
			if (consDesc.getKeyword().equals("MEET")){
				allConstraints.add(getMeetConstraint(consDesc.getArguments()));	
			}
			if (consDesc.getKeyword().equals("MAX_SPAN")){
				allConstraints.add(getMaxSpanConstraint(consDesc.getArguments()));	
			}
		}
		return allConstraints;
	}
}
