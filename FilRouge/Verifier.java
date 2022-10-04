package FilRouge;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Verifier {
	ArrayList<Constraint> arrayConstraint;
	
	/*Builder*/
	public Verifier () {
		this.arrayConstraint=new ArrayList<Constraint>();
	}
	/*Getter*/
	public ArrayList<Constraint> getArrayConstraint (){
		return this.arrayConstraint;
	}
	public void add (Constraint c) {
		this.getArrayConstraint().add(c);
	}
	public boolean verify (HashMap<Activity,Integer> edt){
		for (Constraint c: this.getArrayConstraint()){
			if (!c.isSatisfiedBySchedule(edt)){
				return false;
			}
		}
		return true;
	}
}

/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
