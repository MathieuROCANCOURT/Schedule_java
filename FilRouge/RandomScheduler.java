package FilRouge;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class RandomScheduler{
	Set<Activity> activities;
	List<Constraint> constraints;
	Random randomGenerator;
	
	/*Builder*/
	public RandomScheduler(){
		this.randomGenerator= new Random();
		this.activities=new HashSet<Activity>();
		this.constraints=new ArrayList<Constraint>();
	}
	public void add(Activity activity){
		this.activities.add(activity);
	}
	public void add(Constraint constraint){
		this.constraints.add(constraint);
	}
	
	/*OK*/
	public Map<Activity, Integer> randomEdt(){
		Map<Activity, Integer> map = new HashMap<>();
		for (Activity act:this.activities){
			map.put(act, randomGenerator.nextInt(18*60));
		}
		return map;
	}
	
	/*Pas OK*/
	public int nbConstraintesSatisfied(Map<Activity, Integer> map){
		HashMap<Activity, Integer> map2 = new HashMap<>(map);
		int ContraintSatisfied = 0;
		for (Constraint c: this.constraints){
			if (c.isSatisfiedBySchedule(map2)){
				ContraintSatisfied += 1;
			}
		}
		return ContraintSatisfied;
	}
	
	
	public Map<Activity, Integer> bestMap(int n){
		int max = 0;
		Map<Activity, Integer> edtFinal = new HashMap<Activity, Integer>();
		for(int i=1;i<=n;i++){
			Map<Activity, Integer> tmp = this.randomEdt();
			int nbCons = nbConstraintesSatisfied(tmp);
			if (nbCons > max){
				edtFinal = tmp;
				max = nbCons;
			}
		}
		return edtFinal;
	}
}
