package sklad;
import java.util.HashSet;
import java.util.Set;

public class KachestvenDostavchik extends Dostavchik {

//	private static final double COEF_ZA_KACHESTVO = 0.5;

	public KachestvenDostavchik(String name) {
		super(name);
	}

	@Override
	public Set<Stoka> zakupiStoki(Set<Stoka> stoki) {
		Set<Stoka> spisak = new HashSet<Stoka>(stoki);
		for (Stoka stoka : spisak) {
			spisak.add(stoka);
			this.setPari((int) (this.getPari() - stoka.getCena()));
		}
		return spisak;
	}

	
}
