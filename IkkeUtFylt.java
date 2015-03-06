import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class IkkeUtFylt extends Rute {	
	IkkeUtFylt(int v, int kolonnenr, int radnr, boolean utfylt, Brett b) {
		super(v, kolonnenr, radnr, utfylt, b);
		utfylt = false;
	}
}
