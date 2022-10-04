package FilRouge;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class MaxSpanConstraint implements Constraint {
	ArrayList<Activity> arrayActivity;
	int dureeMax;
	
	/*Builder*/
	public MaxSpanConstraint (ArrayList<Activity> arrayActivity, int dureeMax){
		this.arrayActivity=arrayActivity;
		this.dureeMax=dureeMax;
	}
	/*Getter*/
	public ArrayList<Activity> getArrayActivity(){
		return this.arrayActivity;
	}
	public int getDureeMax(){
		return this.dureeMax;
	}
	
	public boolean isSatisfiedBySchedule (HashMap<Activity, Integer> edt){
		int hMin = 10000;
		int hFin =0;
		for (Activity a: edt.keySet()){
			if (this.arrayActivity.contains(a)){
				if (edt.get(a)<=hMin){
					hMin=edt.get(a);
				}
				if (edt.get(a)+a.getDuree()>=hFin){
					hFin=edt.get(a)+a.getDuree();
				}
			}
		}
		int dureeTotale= hFin-hMin ;
		return (dureeTotale <= this.dureeMax);
	}
	
	public String toString(){
		return "Les activités doivent tenir sur "+getDureeMax()+ "minutes";
	}
}


/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
