package sklad;
import java.util.Set;

public abstract class Dostavchik extends Contact {
	
	
	private static final int PARI_PREDI_PECHALBATA = 2000;
	private int pari;
	
	public Dostavchik(String name) {
		super(name);
		this.pari = PARI_PREDI_PECHALBATA;
	}
	
	public abstract Set<Stoka> zakupiStoki(Set<Stoka> stoki);

	public int getPari() {
		return pari;
	}

	public void setPari(int pari) {
		this.pari = pari;
	}

	public static int getPariPrediPechalbata() {
		return PARI_PREDI_PECHALBATA;
	}
}
