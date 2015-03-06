import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;


public class Test {

	int teller = 0;
	int antVannrett = 0;
	int antLoddrett = 0;
	int dimensjon = 0;
	public String tilfil;
	public String utfil;
	Brett brett;

	Rute forsteRute = null;

	void lesFil(File input){
		tilfil = input.toString();
		System.out.println(tilfil);
		Sudokubeholder beholder = new Sudokubeholder();


		try {
			Scanner filinn = new Scanner(new File(tilfil));

			dimensjon = filinn.nextInt();
			antVannrett = filinn.nextInt();
			antLoddrett = filinn.nextInt();	
			String linje;
			filinn.nextLine();
			int[][] rute = new int[dimensjon][dimensjon];
			brett = new Brett(dimensjon, antVannrett, antLoddrett, beholder, utfil);

			int kteller; //kolonneteller
			int rteller; //radteller

			for(kteller = 0; kteller < dimensjon; kteller++){
				linje = filinn.nextLine();
				for(rteller = 0; rteller < dimensjon; rteller++){

					char verdi = linje.charAt(rteller);

					if(verdi == '.'){
						IkkeUtFylt ruteTom = new IkkeUtFylt(0, kteller, rteller, false, brett);
						rute[kteller][rteller] = 0;
						brett.brett[kteller][rteller] = ruteTom;

						if (forsteRute == null) {
							forsteRute = ruteTom;
							forsteRute.nesteRute = null;
						}
						else {
							Rute denne = forsteRute;
							forsteRute = ruteTom;
							forsteRute.nesteRute = denne;
						}
					}
					else if (verdi >= 'A' && verdi <= 'Z') {
						int nyverdi =  verdi - 55;
						rute[kteller][rteller]= nyverdi;
						FerdigUtfylt nyFU = new FerdigUtfylt(nyverdi, kteller, rteller, true, brett);
						brett.brett[kteller][rteller] = nyFU;

					} else {
						int nyverdi = verdi -48;
						rute[kteller][rteller]= nyverdi;
						FerdigUtfylt nyutfyltrute = new FerdigUtfylt(nyverdi, kteller, rteller, true, brett);
						brett.brett[kteller][rteller] = nyutfyltrute;
					}	
				}
			}	
			for (int i = 0; i < dimensjon; i++) {
				for (int j = 0; j < dimensjon; j++) {
					brett.brett[i][j].boksnr = ((i/antLoddrett) * (antLoddrett) + (j/antVannrett)); 
				}
			}
		}

		catch (Exception e) {
			System.out.println("Ville ikke lose din Sudoku " + e.getMessage());
			e.printStackTrace();

		}
		new SudokuGUI(dimensjon, antVannrett, antLoddrett, brett, beholder);
	}

	void skrivTilFil(Brett brett, String utfil, int ant) {

		PrintWriter printUt = null;
		try {
			printUt = new PrintWriter(new FileWriter (utfil, true));
			printUt.print(ant + ": ");
			for (int i = 0; i < brett.dimensjon; i ++) {
				for (int j = 0; j < brett.dimensjon; j++) {
					printUt.print(brett.brett[i][j].verdi);
				}
				printUt.print(" // ");
			}
			printUt.print("\n");
			printUt.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}

