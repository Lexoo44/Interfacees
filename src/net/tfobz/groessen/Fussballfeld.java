package net.tfobz.groessen;

public class Fussballfeld implements Groesse{
	private int laenge = 105000;
	private int breite = 7000;
	private int hoehe = 0;

	@Override
	public int getLaenge() {
		return this.laenge;
	}

	@Override
	public int getBreite() {
		return this.breite ;
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
		ret = "Fussballfeld L = " + this.getLaenge() + " B = " + this.getBreite() + " H = " + this.getHoehe() + " G = " + this.getGrundfleache();
		return ret;
	}

	@Override
	public int compareTo(Groesse o) {
		int ret = -2;
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
