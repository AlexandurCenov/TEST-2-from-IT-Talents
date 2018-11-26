package sklad;
import java.util.Set;

public class RabotnikNeIzrqden extends Rabotnik{

	public RabotnikNeIzrqden(String name) {
		super(name);
	}

	@Override
	public void podrediStoki(Set<Stoka> stoki) {
		if (stoki != null) {
			for (Stoka stoka : stoki) {
				addPrietiStoki(stoka);
					int random = (int) Math.random();
					if (random > 0.5) {
						this.setPodredeniIOtpisani(this.getPodredeniIOtpisani() + stoka.getNalichnost());
					}
				}
			System.out.println(this.getName() + " podredi samo polovinata prieta stoka!");	
		}
	}
}
