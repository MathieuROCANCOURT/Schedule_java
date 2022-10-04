package JavaEncoder;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class CesarEncoder extends Encoder {
	
	int key;
	/*Builder*/
	public CesarEncoder (int key){
		this.key=key;
	}
	/*Getter*/
	public int getKey(){
		return this.key;
	}
	 
	public char encodeCharacter(char chr){
		int ascii = (int) chr;
		if (97<=ascii && ascii<=122){
			if (ascii+this.getKey()<=122){
				ascii=ascii+this.getKey();
			}
			else{
				ascii=ascii-26+this.getKey();
			
		}
	}
		if (65<=ascii && ascii<=90){
			if (ascii+this.getKey()<=90){
				ascii=ascii+this.getKey();
			}
			else{
				ascii=ascii-26+this.getKey();
			
		}
	}
		chr= (char) ascii;
		return chr;
	
}
}

/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
