package sklad;
import java.util.Set;

public class RabotnikIzrqden extends Rabotnik {

	public RabotnikIzrqden(String name) {
		super(name);
		
	}

	@Override
	public void podrediStoki(Set<Stoka> stoki) {
		if (stoki != null) {
			for (Stoka stoka : stoki) {
				addPrietiStoki(stoka);
				this.setPodredeniIOtpisani(this.getPodredeniIOtpisani() + stoka.getNalichnost());
			}
			System.out.println(this.getName() + " podredi vsichkata prieta stoka!");
		}	
	}
}
