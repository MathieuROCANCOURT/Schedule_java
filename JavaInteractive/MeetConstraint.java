package JavaInteractive;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class MeetConstraint extends BinaryConstraint{

	/*Builder*/
	public MeetConstraint (Activity first, Activity second) {
		super(first, second);
	}
	
	public boolean isSatisfied (int date1, int date2){
		return (date1 + (first.getDuree()) == date2 );
		}
	
	public String toString(){
		return this.first+" doit se terminer exactement quand "+ this.second+ " commence";
	}
	public boolean isSatisfiedBySchedule( HashMap<Activity, Integer> edt){
		return this.isSatisfied(edt.get(first),edt.get(second));
	}
}



/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
