package JavaScheduler;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class PrecedenceConstraint {
	Activity first;
	Activity second;
	
	/*Builder*/
	public PrecedenceConstraint (Activity first, Activity second) {
		this.first=first;
		this.second=second;
	}
	public Activity getSecond(){
		return this.second;
		}
	public Activity getFirst(){
		return this.first;
		}
	
	public boolean isSatisfied (int date1, int date2){
		return (date1 + (first.getDuree()) <= date2 );
		}
	
	public String toString(){
		return this.first+" doit avoir lieu avant "+ this.second;
	}
	
	public boolean isSatisfiedBySchedule( HashMap<Activity, Integer> edt){
		return this.isSatisfied(edt.get(first),edt.get(second));
	}
	}



/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
