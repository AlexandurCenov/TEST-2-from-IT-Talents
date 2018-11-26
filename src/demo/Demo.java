package demo;

import java.util.HashSet;
import java.util.Set;

import sklad.Distributor;
import sklad.Magazin;
import sklad.Sklad;
import sklad.Stoka;


public class Demo {

	public static void main(String[] args) {
		String[] imena = {"Kiro", "Poli", "Jecho", "Pesho", "Lada", "Natasha", "Kali", "Stoil", "Gero", "Fikret", "Toni", "Boni", 
				"Gosho", "Misho", "Siso", "Francis", "Kansis", "Marko", "Polo", "Strahil",
				"Nikola", "Spiro", "Firo", "Miro", "Pansa", "Sancho", "InQn", "Kor", "Boril"};
		String[] magazinNames = {"Denonoshten", "Poli", "Pri Tosho", "Nadejda", "Na Ugula", "Kitaiski", "Kasheto"};
		String[] artikuli = {"Kafe", "Bezalkoholno", "Rakiq", "Wiski"};
		
		Sklad bezmiten = new Sklad("Bezmiten", "ul. Tutrakan 7");
		// rabotnici
		bezmiten.addIzrqdenRabotnik(imena[(int)(Math.random() * imena.length)]);
		bezmiten.addIzrqdenRabotnik(imena[(int)(Math.random() * imena.length)]);
		bezmiten.addNeIzrqdenRabotnik(imena[(int)(Math.random() * imena.length)]);
		bezmiten.addNeIzrqdenRabotnik(imena[(int)(Math.random() * imena.length)]);
		bezmiten.addNeIzrqdenRabotnik(imena[(int)(Math.random() * imena.length)]);

		//distributori
		Distributor distributor1 = new Distributor(imena[(int)(Math.random() * imena.length)]);
		Distributor distributor2 = new Distributor(imena[(int)(Math.random() * imena.length)]);
		Distributor distributor3 = new Distributor(imena[(int)(Math.random() * imena.length)]);
		Distributor distributor4 = new Distributor(imena[(int)(Math.random() * imena.length)]);
		Distributor distributor5 = new Distributor(imena[(int)(Math.random() * imena.length)]);
		
		bezmiten.addDistributor(distributor1);
		bezmiten.addDistributor(distributor2);
		bezmiten.addDistributor(distributor3);
		bezmiten.addDistributor(distributor4);
		bezmiten.addDistributor(distributor5);
		//dostavchici
		bezmiten.addKachestvenDostavchik(imena[(int)(Math.random() * imena.length)]);
		bezmiten.addKachestvenDostavchik(imena[(int)(Math.random() * imena.length)]);
		bezmiten.addKachestvenDostavchik(imena[(int)(Math.random() * imena.length)]);
		bezmiten.addBurzDostavchik(imena[(int)(Math.random() * imena.length)]);
		bezmiten.addBurzDostavchik(imena[(int)(Math.random() * imena.length)]);
		
		Set<Stoka> stoki = new HashSet<Stoka>();
		stoki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 9) + 4), (int) ((Math.random() * 19) + 1)));
		stoki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 9) + 4), (int) ((Math.random() * 19) + 1)));
		stoki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 9) + 4), (int) ((Math.random() * 19) + 1)));
		stoki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 9) + 4), (int) ((Math.random() * 19) + 1)));		
		stoki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 9) + 4), (int) ((Math.random() * 19) + 1)));		
		
		bezmiten.zaredi(stoki);
		bezmiten.zaredi(stoki);
		bezmiten.zaredi(stoki);
		bezmiten.zaredi(stoki);
		bezmiten.zaredi(stoki);
		bezmiten.zaredi(stoki);
		System.out.println();
		
		Set<Stoka> dostavki = new HashSet<Stoka>();
		dostavki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 2) + 1), (int) ((Math.random() * 19) + 1)));
		dostavki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 2) + 1), (int) ((Math.random() * 19) + 1)));
		dostavki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 2) + 1), (int) ((Math.random() * 19) + 1)));
		dostavki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 2) + 1), (int) ((Math.random() * 19) + 1)));
		dostavki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 2) + 1), (int) ((Math.random() * 19) + 1)));
		dostavki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 2) + 1), (int) ((Math.random() * 19) + 1)));
		dostavki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 2) + 1), (int) ((Math.random() * 19) + 1)));
		dostavki.add(new Stoka(artikuli[(int)(Math.random() * artikuli.length)], (int) ((Math.random() * 2) + 1), (int) ((Math.random() * 19) + 1)));

		
		Magazin m = new Magazin(magazinNames[(int)(Math.random() * magazinNames.length)]);
		
		
		bezmiten.dostavi(dostavki, m);
		System.out.println();
		System.out.println("Vsichki pokupki");
		bezmiten.allpokupki();
		System.out.println();
		System.out.println("Vsichki prodajbi ");
		bezmiten.allprodajbi();
		System.out.println();
		System.out.println("Total Oborot : ");
		bezmiten.totalOborot();
		
		System.out.println();
		System.out.println("Naj-deficitni stoki : ");
		bezmiten.deficitniStoki();
		
		System.out.println();
		bezmiten.naiMurzelivSlujitel();
		
		System.out.println();
		System.out.println("Nai-turseni stoki :");
		bezmiten.naiTursenaStoka();
		
	}

}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		

