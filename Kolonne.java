

public class Kolonne extends SuperBoksKolRad {

	private Rute [] denneKolonnen = new Rute [Brett.dimensjon];
	int index = 0;
	int loddRett;


	public void addRutes(Rute rute){
		denneKolonnen[index++] = rute;
	}
	int hentVerdi(){
		return loddRett;
	}

	public static boolean kolonneLovlig(int rad, Brett b, int tall){
		int x;
		for (x = 0 ; x < b.dimensjon; x++) {
			if (b.brett[x][rad].verdi == tall) {
				return false ;
			}
		}
		return true;
	}
}
