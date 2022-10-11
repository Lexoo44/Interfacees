package net.tfobz.ausdrueckeerw;

public class Argument extends Konstante {
	private double ergebnis = 0.0;

	public Argument() {
		super();
	}
	
	public Argument(double ergebnis) {
		this.setErgebnis(ergebnis);
	}


	@Override
	public void setErgebnis(double ergebnis) {
		this.ergebnis = (int) Math.abs(ergebnis);
	}

	@Override
	public double getErgebnis() {
		return ergebnis;
	}

	public String toString() {
		return ("(" + String.valueOf(this.getErgebnis()) + ")");
	}

}
