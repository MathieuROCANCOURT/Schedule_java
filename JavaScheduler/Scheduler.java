package JavaScheduler;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;
public class Scheduler {
	
	public HashMap<Activity,Integer> initNbPreds (List<PrecedenceConstraint> allConstraints){
		HashMap<Activity, Integer> tablePred = new HashMap<Activity, Integer>();
		for (PrecedenceConstraint c: allConstraints){
			if (! tablePred.containsKey(c.getSecond())){
				tablePred.put(c.getSecond(),1);
			}
			else{
				tablePred.put(c.getSecond(),tablePred.get(c.getSecond())+1);
			}
			if (! tablePred.containsKey(c.getFirst())){
				tablePred.put(c.getFirst(),0);
			}
		}
	return tablePred;
}
	public void sheduleActivity (List<PrecedenceConstraint> allConstraints, Activity activity, int heure, HashMap<Activity, Integer> planPart, HashMap<Activity, Integer> tablePred){
		
		planPart.put(activity,heure);
		for (PrecedenceConstraint c: allConstraints){
			if (c.getFirst()==activity){
				 tablePred.put(c.getSecond(),tablePred.get(c.getSecond())-1);
				 }
		}
	}
	
	public HashMap<Activity,Integer> computeShedule (List<PrecedenceConstraint> allConstraints){
		
		HashMap<Activity,Integer> tablePred =initNbPreds(allConstraints);
		HashMap<Activity,Integer> planPart= new HashMap<Activity,Integer>();
		int heure=0;
		
		
		while (planPart.size() != tablePred.size()){
			int res =1;
			for (Activity a: tablePred.keySet()){
				
				if (! planPart.containsKey(a)){
					res=Math.min(res, tablePred.get(a));
					if (tablePred.get(a)==0){
						sheduleActivity(allConstraints,a,heure,planPart,tablePred);
						heure=heure+a.getDuree();
						
					}
				}
			}
			if (res!=0){
					return null;
				}
		}
		return planPart;
	}
}




/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
