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

}
