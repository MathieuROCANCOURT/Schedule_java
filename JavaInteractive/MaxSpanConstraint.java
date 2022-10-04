package JavaInteractive;
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
		int dureeTotale=0	;
		for (Activity a: edt.keySet()){
			if (this.arrayActivity.contains(a)){
				dureeTotale= dureeTotale + edt.get(a);
			}
		}
		return (dureeTotale <= this.dureeMax);
	}
	public String toString(){
		return " Les activités tiennent sur la durée maximum";
	}
}


/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
