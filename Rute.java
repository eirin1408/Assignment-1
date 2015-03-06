import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rute {


	boolean futfylt;
	int boksnr;
	Brett brett;
	Rute nesteRute;
	public int verdi;
	static boolean gjort = false;
	int antall = 1;
	int kolonne;
	int rad;
	int boks;


	public Rute(int v, int kolonnenr, int radnr, boolean utfylt, Brett b) {
		verdi = v;
		rad = radnr;
		kolonne = kolonnenr;
		futfylt = utfylt;
		brett = b;
	}
	


	int hentVerdi(){
		return verdi;
	}

	void settBokz(Boks b){
	}

	void settRadz(Rad r){
	}

	void settKolz(Kolonne k){
	}

	public void fyllUtRestenAvBrettet(){

		Test t = new Test(); //Peker på klassen Test som tar for seg å lese til og fra fil

	  	for (int i = 1; i <= brett.dimensjon; i++)
			if (passer(i)) {
				verdi = i;
				if (nesteRute != null) {
					nesteRute.fyllUtRestenAvBrettet();
				} 
				else {
					Sudokubeholder.settInn(brett);
					if (brett.utfil != null) {
						t.skrivTilFil(brett, brett.utfil, antall);
					}
					antall++;
					System.out.println();
				}
			}
		verdi = 0;
		
	} 

	boolean passer(int i){
		if(Boks.boksLovlig(boksnr, brett, i)){
			if(Kolonne.kolonneLovlig(rad, brett, i)){
				if(Rad.radLovlig(kolonne, brett, i)){
					return true;
				}
			}
		}
		return false;
	}
}
