package et3.java.projet.association;

import et3.java.projet.comptabilite.Evenement;
import et3.java.projet.municipalite.Arbre;
import et3.java.projet.outils.Date;

public class Visite extends Evenement {
	
	private Date date;
	private String compteRendu;
	private Arbre arbre;
	private Association association;
	
	/**
	 * @param date
	 * @param arbre
	 */
	public Visite(Date date, Arbre arbre) {
		super();
		this.date = date;
		this.arbre = arbre;
	}

	/** Obtenir le/la compteRendu
	 * @return le/la compteRendu
	 */
	public String getCompteRendu() {
		return compteRendu;
	}

	/** Définition de compteRendu
	 * @param compteRendu le/la compteRendu à définir
	 */
	public void setCompteRendu(String compteRendu) {
		this.compteRendu = compteRendu;
	}

	/** Obtenir le/la date
	 * @return le/la date
	 */
	public Date getDate() {
		return date;
	}

	/** Obtenir le/la arbre
	 * @return le/la arbre
	 */
	public Arbre getArbre() {
		return arbre;
	}
	
	/** Définition de association
	 * @param association le/la association à définir
	 */
	public void setAssociation(Association association) {
		this.association = association;
	}
	
	/** Obtenir le/la association
	 * @return le/la association
	 */
	public Association getAssociation() {
		return association;
	}
	
	/**
	 * Retourne une chaine de caractère décrivant la visite
	 */
	@Override
	public String toString() {
		return "Visite [date=" + date + ", compteRendu=" + compteRendu + ", arbre=" + arbre + ", association="
				+ association + "]";
	}
	
	
	
}
