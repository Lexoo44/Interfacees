package net.tfobz.groessen;

public interface Groesse extends Comparable<Groesse> {
	int getLaenge();

	int getBreite();

	int getHoehe();

	String toString();
	
	int compareTo(Groesse o);
	
	int getGrundfleache();
}
