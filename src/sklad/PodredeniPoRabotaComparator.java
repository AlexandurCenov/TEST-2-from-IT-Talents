package sklad;
import java.util.Comparator;

public class PodredeniPoRabotaComparator implements Comparator<Rabotnik> {

	@Override
	public int compare(Rabotnik rab1, Rabotnik rab2) {
		return rab1.getPodredeniIOtpisani() - rab2.getPodredeniIOtpisani();
	}

}
