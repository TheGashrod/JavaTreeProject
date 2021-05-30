package et3.java.projet.association;

import et3.java.projet.comptabilite.Evenement;

public class Cotisation extends Evenement {
	
	int annee;

	/**
	 * @param annee
	 */
	public Cotisation(int annee) {
		super();
		this.annee = annee;
	}
	
	/**
	 * Retourne une chaine de caractères correspondant à l'état de l'objet
	 */
	@Override
	public String toString() {
		return "Cotisation [annee=" + annee + "]";
	}
	
	/**
	 * Retourne une chaine de caractères correspondant à l'état de l'objet
	 */
	@Override
	public String toStringComptabilite() {
		return "Cotisation [annee=" + annee + "]";
	}

	/** Obtenir le/la annee
	 * @return le/la annee
	 */
	public int getAnnee() {
		return annee;
	}
	
	

}
