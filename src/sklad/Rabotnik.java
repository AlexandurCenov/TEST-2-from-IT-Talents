package sklad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class Rabotnik extends Contact{
	private static final int SALARY = 500;
	private int zaplata; 
	private Set<Stoka> prietiStoki;	
	private Set<Stoka> otpisaniStoki;
	private List<Stoka> naiProdavani;
//	private int podredeni = 0;
//	private int otpisani = 0;
	private int podredeniIOtpisani = 0;
	
	
	public Rabotnik(String name) {
		super(name);
		this.zaplata = SALARY;
		this.otpisaniStoki = new HashSet<Stoka>();
		this.prietiStoki = new HashSet<Stoka>();
		this.naiProdavani = new ArrayList<Stoka>();
		}
	

	void addPrietiStoki(Stoka s) {
		this.prietiStoki.add(new Stoka(s.getName(), s.getNalichnost(), s.getCena()));
	}
	
	void addOtpisaniStoki(Stoka s) {
		this.otpisaniStoki.add(new Stoka(s.getName(), s.getNalichnost(), s.getCena()));
	}
	
	public abstract void podrediStoki(Set<Stoka> stoki);
	
	public void otpishiStokata(Set<Stoka> stoki, Magazin magazin) {
		if ((stoki != null) && (magazin != null)) {
			System.out.println("Magazin " + magazin.getName() + " shte poluchi : ");
			for (Stoka stoka : stoki) {
				if (stoki.contains(stoka)) {
					System.out.println("Stoka [name " + stoka.getName() + ", broi=" + stoka.getNalichnost() + ", cena=" + stoka.getCena() + "]");
					this.naiProdavani.add(stoka);
//					stoka.setNalichnost(stoka.getNalichnost() - stoka.getNalichnost());
				}
			}
		}
	}	

	public Set<Stoka> getPrietiStoki() {
		return Collections.unmodifiableSet(this.prietiStoki);
	}

	public Set<Stoka> getOtpisaniStoki() {
		return Collections.unmodifiableSet(this.otpisaniStoki);
	}



	public int getPodredeniIOtpisani() {
		return this.podredeniIOtpisani;
	}



	public void setPodredeniIOtpisani(int podredeniIOtpisani) {
		this.podredeniIOtpisani = podredeniIOtpisani;
	}


	@Override
	public String toString() {
		return "Rabotnik [name=" + getName() + " podredeniIOtpisani=" + podredeniIOtpisani + "]";
	}


	public List<Stoka> getNaiProdavani() {
		return Collections.unmodifiableList(this.naiProdavani);
	}

	
	
	
	
}


