geditimport java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Boks extends SuperBoksKolRad {

	Rute [] thisBox = new Rute [Brett.dimensjon];
	int index = 0;
	int loddRett;


	public void addRutes(Rute rute){
		thisBox[index++] = rute;
	}

	int hentVerdi(){
		return loddRett;
	}

	public static boolean boksLovlig(int boks, Brett b, int tall) { // Sjekker om verdien passer

		int x;
		int y;

		for (x = 0; x < b.dimensjon; x++) {
			for (y = 0; y < b.dimensjon; y++) {	
				if ((b.brett[x][y].boksnr == boks) && (b.brett[x][y].verdi == tall)) {
					return false;	
				}	
			}	
		}
		return true;
	}
}
