import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Sudokubeholder {

	public static ArrayList<int[][]> losningsbeholder = new ArrayList<int[][]>();
	
	static int antlosninger = 0;
	
	public static void settInn(Brett brett){
		
		if(antlosninger <= 500) {
			int[][] temp = new int[brett.dimensjon][brett.dimensjon];
			for(int x = 0; x < brett.dimensjon; x++){
				for(int y = 0; y < brett.dimensjon; y++) {
					temp[x][y] = brett.brett[x][y].verdi;
				}
			}
			losningsbeholder.add(temp);
		}
		antlosninger++;
		
	}
	
	public int [][] taUt(int los){
		return losningsbeholder.get(los);
		
	}
	
	public int hentAntLosninger(){
		return antlosninger;
	}
	
}

/*Programmet SKAL inneholde "class Sudokubeholder" som igjen inneholder de tre
offentlige metodene settInn (eventuelt insert hvis du foretrekker engelske navn på
identifikatorer) taUt (get), og hentAntallLosninger (getSolutionCount). Du kan gjerne
bruke ferdiglagde datastrukturer i Java-biblioteket når du programmerer denne klassen.*/
