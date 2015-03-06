import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Brett {

	public Rute [][] brett; //mhm
	public Rute[][] verdier;
	public static int dimensjon;
	public static int antLoddrett;
	public static int antVannrett;
	public Sudokubeholder beholder;
	public String tilfil;
	public String utfil;
	Rute forsteRute;


	Brett (int dimensjon, int antVannrett, int antLoddrett, Sudokubeholder beholder, String utfil) {

		this.dimensjon = dimensjon;
		this.antVannrett = antVannrett;
		this.antLoddrett = antLoddrett;
		this.beholder = beholder;
		brett = new Rute [dimensjon][dimensjon];
		this.utfil = utfil;

	}

	
/************************************************************************
 * Metodene under hadde jeg tenkt til å bruke for å linke sammen rad,
 * kolonne og boks. Men fant en annen metode for å lose dette.
 * Planen var å kalle på link(); i konstruktøren til brett. Får
 * nullPointerEx.	
 ***********************************************************************/
	
	public void link (){
		Rute [][] verdier = new Rute[dimensjon][dimensjon];
		Kolonne [] kolz = new Kolonne [dimensjon];
		Rad [] radz = new Rad [dimensjon];
		Boks [][] bokz = new Boks [antVannrett][antLoddrett];

		for(int i = 0; i < dimensjon; i++) {
			for(int j = 0; j < dimensjon; j++) {
				kolz[j].addRutes(verdier[i][j]);
				verdier[i][j].settKolz(kolz[j]);
			}
		}


		for(int i = 0; i < dimensjon; i++) {
			for(int j = 0; j < dimensjon; j++) {

				radz[i].addRutes(verdier[i][j]);
				verdier[i][j].settRadz(radz[i]);
			}
		}


		for(int i = 0; i <dimensjon; i++) {
			for(int j = 0; j <dimensjon; j++) {
				bokz[i/antVannrett][j/antLoddrett].addRutes(verdier[i][j]);
				verdier[i][j].settBokz(bokz[i/antVannrett][j/antLoddrett]);

			}
		}
		visLosninger();
	}

	void losningerDone(){
		Integer [][] kopi = new Integer[dimensjon][dimensjon];
		for(int i = 0; i < dimensjon; i++) {
			for(int j = 0; j < dimensjon; j++) {

				kopi[i][j] = brett[i][j].hentVerdi();
			}
		}
		new SudokuGUI(dimensjon, antVannrett, antLoddrett, null, beholder);
	}

	void visLosninger(){
		forsteRute.fyllUtRestenAvBrettet();
	}
}
