package JavaEncoder;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public abstract class Encoder{
	
	public abstract char encodeCharacter(char chr);
	
	public String encode (String chaine){
		
		StringBuilder result= new StringBuilder();
		
		char[] tmp=chaine.toCharArray();
		
		for (char chr: tmp){
			if (('a'<= chr && chr <='z') || ('A'<=chr && chr <='Z')){
				chr=encodeCharacter(chr);
			}
			result.append(chr);
		}
	return result.toString();
	}
	
	
}
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
