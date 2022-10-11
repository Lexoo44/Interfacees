package net.tfobz.groessen;

public class Testprogramm {

	public static void main(String[] args) {
		Groesse[] g = new Groesse[10];
		System.out.println("Ausgabe unsortiert");

		g[0] = new Auto(1000, 50, 20);
		g[1] = new Auto(2000, 40, 20);
		g[2] = new Auto(3000, 30, 20);
		System.out.println(1 + "." + g[0].toString());
		System.out.println(2 + "." + g[1].toString());
		System.out.println(3 + "." + g[2].toString());

		g[3] = new Fussballfeld();
		g[4] = new Fussballfeld();
		System.out.println(4 + "." + g[3].toString());
		System.out.println(5 + "." + g[4].toString());

		for (int i = 5; i < 10; i++) {
			g[i] = new Papierbaltt(i - 5);
			System.out.println(i + "." + g[i].toString());
		}

		System.out.println("\nAusgabe sortiert");
		Groesse tmp;
		for (int i = 0; i < g.length; i++) {
			for (int j = 1; j < i; j++) {
				int ergebnis = g[i].compareTo(g[j]);
				if (ergebnis == -1) {
					tmp = g[i];
					g[i] = g[j];
					g[j] = tmp;
				}
				if (ergebnis == 0) {
					tmp = g[i];
					g[i] = g[j];
					g[j] = tmp;
				}
			}
		}
		for(int i = 0; i < g.length; i++) {
			System.out.println(i + ". " + g[i].toString());
		}
	}
}
