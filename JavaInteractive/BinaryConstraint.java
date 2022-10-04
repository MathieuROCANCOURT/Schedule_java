package JavaInteractive;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public abstract class BinaryConstraint implements Constraint {
	
	
	public Activity first;
	public Activity second;
	
	public BinaryConstraint (Activity first, Activity second) {
		this.first=first;
		this.second=second;
	}
	public Activity getSecond(){
		return this.second;
		}
	public Activity getFirst(){
		return this.first;
		}
	
	
	public abstract String toString();
	public abstract boolean isSatisfied(int date1, int date2);
	
	
}	

/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
