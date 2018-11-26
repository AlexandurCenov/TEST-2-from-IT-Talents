package sklad;
import java.util.HashSet;
import java.util.Set;

public class BurzDostavchik extends Dostavchik {
	
//	private static final double COEF_ZA_BURZA_DOSTAVKA = 0.2;
	
	public BurzDostavchik(String name) {
		super(name);
	}

	@Override
	public Set<Stoka> zakupiStoki(Set<Stoka> stoki) {
		Set<Stoka> spisak = new HashSet<Stoka>(stoki);
		for (Stoka stoka : spisak) {
			if (Math.random() > 0.1) {
				spisak.add(stoka);
				this.setPari((int) (this.getPari() - stoka.getCena()));
			}
		}
		return spisak;
	}

	

}
