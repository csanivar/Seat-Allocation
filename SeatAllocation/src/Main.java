import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;


public class Main {
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException{
		runGaleShapley();
		runMeritOrder();
		
	}
	
	public static void runGaleShapley() throws FileNotFoundException, UnsupportedEncodingException{
		GaleShapleyAdmission galeShapleyAlgo = new GaleShapleyAdmission();
		galeShapleyAlgo.runAlgorithm();
		galeShapleyAlgo.printAllotedSeats();
	}
	public static void runMeritOrder() throws FileNotFoundException, UnsupportedEncodingException{
		MeritOrderAdmission meritOrderAlgo = new MeritOrderAdmission();
		meritOrderAlgo.runAlgorithm();
		meritOrderAlgo.printAllotedSeats();
	}
}
