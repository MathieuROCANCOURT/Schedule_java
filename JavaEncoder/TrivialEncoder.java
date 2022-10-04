package JavaEncoder;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class TrivialEncoder extends Encoder{
	
	char letter;
	
	
	/*Builder*/
	public TrivialEncoder (char letter){
		this.letter=letter;
		
		
	}
	/*Getter*/
	public char getLetter(){
		return this.letter;
	}
	
	public char encodeCharacter(char chr){
		chr=letter;
		return chr;
	}
	
	
	
}	
