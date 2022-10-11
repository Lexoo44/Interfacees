package net.tfobz.groessen;

public class TestprogrammGrundflaeche {

	public static void main(String[] args) {
		Groesse[] g = new Groesse[8];
		g[1] = new Auto(100, 50, 20);
		System.out.println(g[1].toString());
		g[2] = new Fussballfeld();
		System.out.println(g[2].toString());
		for (int i = 1; i < 5; i++) {
			g[i] = new Papierbaltt(i);
			System.out.println(g[i].toString());
		}

	}
}
