package sklad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sklad extends Contact{
	
	private static final double COEF_ZA_NADCENKA = 0.2;
	private static final double COEF_ZA_KACHESTVO = 0.3;
	private static final int STARTOVA_NALICHNOST = 10000;
	
	private String address;
	private List<Dostavchik> dostavchici;
	private List<Rabotnik> rabotnici;
	private List<Distributor> distributori;
	private Set<Stoka> stoki;
	private int oborot;
	private int razhodi;
	private int pechalba;
	
	public Sklad(String name, String address) {
		super(name);
		this.address = address;
		this.oborot = STARTOVA_NALICHNOST;
		this.dostavchici = new ArrayList<Dostavchik>();
		this.rabotnici = new ArrayList<Rabotnik>();
		this.distributori = new ArrayList<Distributor>();
		this.stoki = new HashSet<Stoka>();
		this.razhodi = 0;
		this.pechalba = 0;
	}
	
	public void addIzrqdenRabotnik(String name) {
		rabotnici.add(new RabotnikIzrqden(name));
	}

	public void addNeIzrqdenRabotnik(String name) {
		rabotnici.add(new RabotnikNeIzrqden(name));
	}
	
	public void addDistributor(Distributor d) {
		this.distributori.add(new Distributor(d.getName()));
	}

	public void addBurzDostavchik(String name) {
		this.dostavchici.add(new BurzDostavchik(name));
	}
	
	public void addKachestvenDostavchik(String name) {
		this.dostavchici.add(new KachestvenDostavchik(name));
	}
	
	
	
	public Set<Stoka> deficitniStoki() {
		Set<Stoka> spisak = new HashSet<Stoka>();
		for (Stoka stoka : this.stoki) {
			if (stoka.getNalichnost() < 10) {
				spisak.add(stoka);
			}
		}
		for (Stoka stoka : spisak) {
			System.out.println(stoka);
		}
		return spisak;
	}
	
	public void zaredi(Set<Stoka> stoki) {
		int obshtRazhod = 0;
		
		Dostavchik dostavchik = this.dostavchici.get((int) (Math.random() * this.dostavchici.size()));
		this.stoki.addAll(dostavchik.zakupiStoki(stoki));
		
		Rabotnik rabotnik = this.rabotnici.get((int) (Math.random() * this.rabotnici.size()));
		if (rabotnik instanceof RabotnikIzrqden) {
			RabotnikIzrqden rab = (RabotnikIzrqden) rabotnik;
			rab.podrediStoki(stoki);
		}else {
			RabotnikNeIzrqden rab = (RabotnikNeIzrqden) rabotnik;
			rab.podrediStoki(stoki);
		}
		
		for (Stoka stoka : stoki) {
			obshtRazhod += stoka.getCena();
		}
		
		if (dostavchik instanceof KachestvenDostavchik) {
			dostavchik.setPari((int) (dostavchik.getPari() + obshtRazhod + (obshtRazhod * (COEF_ZA_KACHESTVO + COEF_ZA_NADCENKA))));
			this.oborot -= obshtRazhod + (obshtRazhod * (COEF_ZA_NADCENKA + COEF_ZA_KACHESTVO));
			this.razhodi += obshtRazhod + (obshtRazhod * (COEF_ZA_NADCENKA + COEF_ZA_KACHESTVO));
		}else {
			dostavchik.setPari((int) (dostavchik.getPari() + obshtRazhod + (obshtRazhod * COEF_ZA_NADCENKA)));
			this.oborot -= obshtRazhod + (obshtRazhod * COEF_ZA_NADCENKA);
			this.razhodi += obshtRazhod + obshtRazhod * COEF_ZA_NADCENKA;
		}
		System.out.println("Sklad " + this.getName() + " e zareden sys stoka!");
	}
	
	public void dostavi(Set<Stoka> stoki, Magazin magazin) {
		int obshtPrihod = 0;
		
		Distributor distributor = this.distributori.get((int) (Math.random() * this.distributori.size()));
		distributor.dostavi(magazin, stoki);
		
		
		Rabotnik rabotnik = this.rabotnici.get((int) (Math.random() * this.rabotnici.size()));
		rabotnik.otpishiStokata(stoki, magazin);

		for (Stoka stoka : stoki) {
			obshtPrihod += stoka.getCena();
		}
		this.oborot += obshtPrihod - (obshtPrihod * COEF_ZA_NADCENKA);
		this.pechalba += obshtPrihod - (obshtPrihod * COEF_ZA_NADCENKA);
		distributor.setMoney((int)(distributor.getMoney() + (obshtPrihod * COEF_ZA_NADCENKA)));
	}
	
	public void allprodajbi() {
		System.out.println("Oborot na Distributorite : ");
		for (Distributor distributor : this.distributori) {
			int money = (int) (distributor.getMoney() - Distributor.getNalichniPari());
			System.out.println(distributor.getName() + " e izkaral " + money + "leva, pechalba dnes.");
		}
	}
	
	public void allpokupki() {
		System.out.println("Oborot na Dostavchicite : ");
		for (Dostavchik dostavchik : this.dostavchici) {
			int money = dostavchik.getPari() - Dostavchik.getPariPrediPechalbata();
			System.out.println(dostavchik.getName() + " e izkaral " + money + "leva, pechalba dnes.");
		}
	}
	
	public void totalOborot() {
		System.out.println("Razhodite sa: " + this.razhodi);
		System.out.println("Pechalbata e: " + this.pechalba);
	}
	
	public List<Rabotnik> naiMurzelivSlujitel() {
//		SortedSet<Rabotnik> rabotnici = new TreeSet<Rabotnik>(new PodredeniPoRabotaComparator());
		List<Rabotnik> rabotnici = new ArrayList<Rabotnik>();
		rabotnici.addAll(this.rabotnici);
		Collections.sort(rabotnici, new PodredeniPoRabotaComparator());
		for (int i = 0; i < rabotnici.size(); i++) {
			System.out.println(rabotnici.get(i));
		}
		return rabotnici;
	}
	
	public void naiTursenaStoka() {
		List<Stoka> stoki = new ArrayList<Stoka>();
		List<Stoka> stokite = new ArrayList<Stoka>();
		List<Rabotnik> rabotnici = this.rabotnici;
		for (Rabotnik rabotnik : rabotnici) {
			for (Stoka stoka : rabotnik.getNaiProdavani()) {
				if (rabotnik.getNaiProdavani().contains(stoka)) {
					stoki.add(stoka);
				}
			}
		}
		
		Collections.sort(stoki, new PodredeniPoImeComparator());
		int count = 0;
		for (int i = 0; i < stoki.size(); i++) {
			stokite.add(stoki.get(i));
			
			if (i > 0) {
				if (stoki.get(i).getName().equals(stoki.get(i-1).getName())) {
					stokite.get(count).setNalichnost(stokite.get(count).getNalichnost() + stokite.get(count+1).getNalichnost());
					stokite.remove(count+1);
				}else {
					count++;
				}
			}
		}
		Collections.sort(stokite, new PodredeniPoProdadenoKolièstvo());
		for (Stoka stoka : stokite) {
			System.out.println("Ot " + stoka.getName() + " e prodadeno takowa kolichestvo : " + stoka.getNalichnost());
		}
		
	}
}
