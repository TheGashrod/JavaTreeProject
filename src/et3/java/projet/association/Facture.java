package et3.java.projet.association;

import et3.java.projet.comptabilite.Evenement;

public class Facture extends Evenement {

	private int numero;

	/** Crée une facture avec le numéro correspondant
	 * @param numero
	 */
	public Facture(int numero) {
		super();
		this.numero = numero;
	}
	
	/**
	 * Retourne une chaine de caractères correspondant à la facture
	 */
	@Override
	public String toString() {
		return "Facture [numero=" + numero + "]";
	}
	
	/**
	 * Retourne une chaine de caractères correspondant à la facture
	 */
	@Override
	public String toStringComptabilite() {
		return "Facture [numero=" + numero + "]";
	}
	

}
