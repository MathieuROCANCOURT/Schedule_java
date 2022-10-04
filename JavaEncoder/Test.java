package JavaEncoder;
/*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*//*DAB*/
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Test{

public static void main (String [] args) {

/*PARTIE NUMERO 4*/
	// Handling strings
	TrivialEncoder encoder = new TrivialEncoder('a');
	String string = "Une chaîne pour l'exemple.";
	String encoded = encoder.encode(string);
	if (encoded.equals("aaa aaaîaa aaaa a'aaaaaaa.")) {
    System.out.println("OK " + encoded);
	} else {
    System.out.println("KO, found " + encoded);
	}
	UpperCaseEncoder encoder2 = new UpperCaseEncoder();
	String encoded2 = encoder2.encode(string);
	System.out.println("Tout en Maj: " +encoded2);
	AsciiEncoder encoder3 = new AsciiEncoder();
	String encoded3= encoder3.encode (string);
	System.out.println("Tout En Ascii: "+encoded3);
	
	CesarEncoder encoder4 = new CesarEncoder(16);
	String encoded4 = encoder4.encode(string);
	System.out.println("Cesar: Cle ="+encoder4.getKey()+ " " + encoded4);
}
}
