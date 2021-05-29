package et3.java.projet.association;

import et3.java.projet.comptabilite.Compte;

public class Externe extends Compte {
	
	private String designation;
	private String adresse;
	
	private TypeDonateur typeDonateur;

	/** Crée un compte externe
	 * @param designation
	 * @param adresse
	 * @param typeDonateur
	 */
	public Externe(String designation, String adresse, TypeDonateur typeDonateur) {
		super();
		this.designation = designation;
		this.adresse = adresse;
		this.typeDonateur = typeDonateur;
	}
	
	/**
	 * Retourne une chaine de caractères correspondant à l'état de l'objet
	 */
	@Override
	public String toString() {
		return "Externe [designation=" + designation + ", adresse=" + adresse + ", typeDonateur=" + typeDonateur + "]";
	}
	
	

}
