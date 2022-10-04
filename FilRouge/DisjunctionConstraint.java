package FilRouge;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class DisjunctionConstraint implements Constraint{
	Constraint constraint1;
	Constraint constraint2;
	/*Builder*/
	public DisjunctionConstraint(Constraint constraint1, Constraint constraint2){
		this.constraint1=constraint1;
		this.constraint2=constraint2;
	}
	/*Getter*/
	public Constraint getConstraint1(){
		return this.constraint1;
	}
	public Constraint getConstraint2(){
		return this.constraint2;
	}
	
	public boolean isSatisfiedBySchedule(HashMap<Activity, Integer> edt){
		return ((this.constraint1.isSatisfiedBySchedule(edt)) || (this.constraint2.isSatisfiedBySchedule(edt)));
	}
	public String toString (){
		return("L'une des 2 conditions doit être satisfaite: "+ this.constraint1.toString()+" ; "+this.constraint2.toString());
	}
	
}
