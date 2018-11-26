package sklad;

public class Stoka extends Contact {
	private int nalichnost;
	private int cena;
	
	
	public Stoka(String name, int nalichnost, int cena) {
		super(name);
		this.nalichnost = nalichnost;
		this.cena = cena;
	}

	public int getNalichnost() {
		return nalichnost;
	}

	public int getCena() {
		return cena;
	}
	
	@Override
	public String toString() {
		return "Stoka [name " + getName() + ", nalichnost=" + nalichnost + ", cena=" + cena + "]";
	}

	public void setNalichnost(int nalichnost) {
		this.nalichnost = nalichnost;
	}

//	@Override
//	public int hashCode() {
//		return this.getName().hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if ((obj != null) && (obj instanceof Stoka)) {
//			Stoka stoka = (Stoka) obj;
//			return this.getName().equals(stoka.getName());
//		}
//		return false;
//	}
}
