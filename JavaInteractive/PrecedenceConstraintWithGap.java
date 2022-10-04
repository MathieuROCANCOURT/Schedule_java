package JavaInteractive;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint {
	
	int gap;
	
	/*Builder*/
	public PrecedenceConstraintWithGap (Activity first, Activity second, int gap){
		super(first,second);
		this.gap=gap;
	}
	/*Getter*/
	public int getGap (){
		return this.gap;
	}
	
	public boolean isSatisfied (int date1, int date2){
		return (date1 + (first.getDuree())+ this.getGap() <= date2 );
		} 
	public String toString(){
		return this.first+" doit se terminer "+ this.getGap() +" minutes avant "+ this.second;
	}
	public boolean isSatisfiedBySchedule( HashMap<Activity, Integer> edt){
		return this.isSatisfied(edt.get(first),edt.get(second));
	}
}


/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
