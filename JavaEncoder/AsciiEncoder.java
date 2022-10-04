package JavaEncoder;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class AsciiEncoder {
	
	public String encode (String chaine){
	
		StringBuilder result= new StringBuilder();
		
		char[] tmp=chaine.toCharArray();
		for (char chr: tmp){
			
			String str = encodeCharacter(chr);
			
			result.append(str);
		}
	return result.toString();
	}
	
	public String encodeCharacter (char chr){
		
		String tmp2= Integer.toString(chr);
		return tmp2 + " ";
	}
}


/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
