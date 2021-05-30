package et3.java.projet.comptabilite;

import et3.java.projet.outils.Date;

public class EcritureComptable {
	
	private Evenement evenement;
	private Compte compte;
	private Date date;
	private double somme;
	
	
	/** Crée une écriture comptable
	 * @param evenement
	 * @param compte
	 * @param date
	 * @param somme
	 */
	public EcritureComptable(Evenement evenement, Compte compte, Date date, double somme) {
		this.setEvenement(evenement);
		this.setCompte(compte);
		
		this.date=date;
		this.somme=somme;
	}

	/** Obtenir le/la evenement
	 * @return le/la evenement
	 */
	public Evenement getEvenement() {
		return evenement;
	}

	/** Définition de evenement
	 * @param evenement le/la evenement à définir
	 */
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
		this.evenement.setEcritureComptable(this);
	}

	/** Obtenir le/la compte
	 * @return le/la compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/** Définition de compte
	 * @param compte le/la compte à définir
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
		this.compte.setEcritureComptable(this);
	}

	/** Obtenir le/la date
	 * @return le/la date
	 */
	public Date getDate() {
		return date;
	}

	/** Définition de date
	 * @param date le/la date à définir
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/** Obtenir le/la somme
	 * @return le/la somme
	 */
	public double getSomme() {
		return somme;
	}

	/** Définition de somme
	 * @param somme le/la somme à définir
	 */
	public void setSomme(double somme) {
		this.somme = somme;
	}
	
	/**
	 * Retourne une chaine de caractères correspondant à l'écriture comptable
	 */
	@Override
	public String toString() {
		String ecritureComptableString="";
		try {
			ecritureComptableString = date + " | " + somme + " euros  | " + compte + " | "+ evenement.toStringComptabilite();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ecritureComptableString;
	}
	
	

}
