import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rad extends SuperBoksKolRad{

	Rute [] denneRaden = new Rute [Brett.dimensjon];
	int index = 0;
	int vannRett;

	public void addRutes(Rute rute){
		denneRaden[index++] = rute;

	}

	int hentVerdi(){
		return vannRett;
	}

	public static boolean radLovlig(int kolonne, Brett b, int tall){
		int x;
		for (x = 0 ; x < b.dimensjon; x++) {
			if (b.brett[kolonne][x].verdi == tall) {
				return false ;
			}
		}
		return true;
	}
}
