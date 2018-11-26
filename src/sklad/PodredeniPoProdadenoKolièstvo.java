package sklad;
import java.util.Comparator;

public class PodredeniPoProdadenoKolièstvo implements Comparator<Stoka>{

	@Override
	public int compare(Stoka stoka1, Stoka stoka2) {
		return stoka2.getNalichnost() - stoka1.getNalichnost();
	}

}
