package net.tfobz.groessen;

public class Papierbaltt implements Groesse {
	private int laenge;
	private int breite;
	private int hoehe;
	private int format;

	public Papierbaltt(int format) {
		if (format < 5) {
			this.format = format;
			if (format == 0) {
				this.laenge = 1189;
				this.breite = 841;
			} else if (format == 1) {
				this.laenge = 841;
				this.breite = 595;
			} else if (format == 2) {
				this.laenge = 595;
				this.breite = 420;
			} else if (format == 3) {
				this.laenge = 420;
				this.breite = 297;
			} else if (format == 4) {
				this.laenge = 297;
				this.breite = 210;
			}
		} else {
			System.out.println("Fehler! Fromat muss zwischen 0 und 4 sein.");
		}
	}

	@Override
	public int getLaenge() {
		return this.laenge;
	}

	@Override
	public int getBreite() {
		return this.breite;
	}

	@Override
	public int getHoehe() {
		return this.hoehe;
	}

	public int getGrundfleache() {
		int ret = 0;
		ret = this.getBreite() * this.getLaenge();
		return ret;
	}

	public String toString() {
		String ret = "";
		ret = "Papierbaltt L = " + this.getLaenge() + " B = " + this.getBreite() + " H = " + this.getHoehe() + " G = "
				+ this.getGrundfleache();
		return ret;
	}

	@Override
	public int compareTo(Groesse o) {
		int ret = 0;
		if (this.getGrundfleache() < o.getGrundfleache()) {
			ret = -1;
		} else if (this.getGrundfleache() > o.getGrundfleache()) {
			ret = 1;
		} else if (this.getGrundfleache() == o.getGrundfleache()) {
			ret = 0;
		}
		return ret;
	}
}
