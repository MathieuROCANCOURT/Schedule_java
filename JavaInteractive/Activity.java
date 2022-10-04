package JavaInteractive;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;
public class Activity {
	public String description;
	public int duree;
	
	/*Builder*/
	public Activity(String description, int duree){
		this.description=description;
		this.duree=duree;
	}
	/*Getter*/
	public String getDescription () {
		return this.description;
	}
	public int getDuree () {
		return this.duree;
	}
	public String toString(){
		return this.description;
	}	
}



/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
