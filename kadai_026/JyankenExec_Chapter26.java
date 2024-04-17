package kadai_026;

import java.io.FileNotFoundException;

public class JyankenExec_Chapter26 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Jyanken_Chapter26 game1 = new Jyanken_Chapter26();
		
		game1.playGame( game1.getMyChoice(), game1.getRandom() );
		
	}

}
