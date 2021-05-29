package et3.java.projet.outils;


public class Date implements Comparable<Date> {
	
	private int jour;
	private int mois;
	private int annee;
	
	
	public Date(int annee, int mois, int jour) {
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;

	}
	
	
	/**
	 * Met la date d'aujourd'hui :)
	 */
	public Date() {
		//Solution temporaire
		this(2021, 05, 29);
	}
	
	
	@Override
	public int compareTo(Date date) {
		if (this.annee > date.annee) {return 1;}
		else if(this.annee < date.annee) {return -1;}
		else {
			
			if (this.mois > date.mois) {return 1;}
			else if(this.mois < date.mois) {return -1;}
			else {
				
				if(this.jour > date.jour) {return 1;}
				else if(this.jour < date.jour) {return -1;}
				else return 0;
			}
		}
	}

	/**
	 * Retourne une chaine de caractères correspondant à la date
	 */
	@Override
	public String toString() {
		return jour + "/" + mois + "/" + annee;
	}
	
	

}
