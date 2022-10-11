package net.tfobz.groessen;

public class Auto implements Groesse {

	private int laenge;
	private int breite;
	private int hoehe;

	public Auto(int laenge, int breite, int hoehe) {
		this.laenge = laenge;
		this.breite = breite;
		this.hoehe = hoehe;
	}

	@Override
	public int getLaenge() {
		return this.laenge;
	}

	@Override
	public int getBreite() {
		return this.hoehe;
	}

	@Override
	public int getHoehe() {
		return this.breite;
	}

	public void setBreite(int breite) {
		this.breite = breite;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}

	public int getGrundfleache() {
		int ret = 0;
		ret = this.getBreite() * this.getLaenge();
		return ret;
	}

	public String toString() {
		String ret = "";
		ret = "Auto L = " + this.getLaenge() + " B = " + this.getBreite() + " H = " + this.getHoehe() + " G = "
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
