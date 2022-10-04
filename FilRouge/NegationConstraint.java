package FilRouge;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class NegationConstraint implements Constraint{
	Constraint negConstraint;
	
	/*Builder*/
	public NegationConstraint(Constraint negConstraint){
		this.negConstraint=negConstraint;
	}
	/*Getter*/
	public Constraint getNegConstraint(){
		return this.negConstraint;
	}
	public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> edt){
		return (! this.negConstraint.isSatisfiedBySchedule(edt));
	}
	
	public String toString(){
		return ("Ne dois pas être satisfait"+this.negConstraint.toString());
	}
	
}
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
