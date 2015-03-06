import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Oblig5 {

	/***************************************************************
	 * eirinsve		Oblig5		INF1010	V13
	 * 
	 * Det ser ut som hele obligen fungerer som den skal :D
	 * Har tatt meg friheten til å leke litt med fargene i Guiet.
	 * 
	 ***************************************************************/
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

			goFileChooser();
		}

	public static void goFileChooser(){

		Test t = new Test();
		t.utfil = null;


		JFileChooser f = new JFileChooser();


		int retval = f.showOpenDialog(null);

		if (retval == f.APPROVE_OPTION) {
			File input = f.getSelectedFile();
			String navn = input.getName();
			t.tilfil = navn;
			t.lesFil(input);
			t.forsteRute.fyllUtRestenAvBrettet();
		}	
	}
}
