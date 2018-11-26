package sklad;
import java.util.HashSet;
import java.util.Set;

public class Distributor extends Contact {
	
	private static final double COMISIONNA = 0.2;
	private static final int NALICHNI_PARI = 500;
	private int money;
	
	public Distributor(String name) {
		super(name);
		this.money = NALICHNI_PARI;
	}
	
	void dostavi(Magazin magazin, Set<Stoka> stoki) {
		if ((stoki != null) && (magazin != null)) {
			Set<Stoka> poruchki = new HashSet<Stoka>(stoki);
			System.out.println("Magazin " + magazin.getName() + " porychal : ");
			for (Stoka stoka : poruchki) {
				System.out.println("Stoka [name " + stoka.getName() + ", broi=" + stoka.getNalichnost() + ", cena=" + stoka.getCena() + "]");
				this.money += stoka.getCena() * COMISIONNA;
			}
		}
		
	}

	public int getMoney() {
		return money;
	}

	public static int getNalichniPari() {
		return NALICHNI_PARI;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
