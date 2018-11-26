package sklad;
import java.util.Comparator;

public class PodredeniPoImeComparator implements Comparator<Stoka>{
	
	@Override
	public int compare(Stoka stoka1, Stoka stoka2) {
		return stoka1.getName().compareTo(stoka2.getName());
	}

}
