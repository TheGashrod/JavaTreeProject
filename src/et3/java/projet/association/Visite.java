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
	 * @throws Exception si l'arbre n'est pas remarquable
	 */
	public Visite(Date date, Arbre arbre) throws Exception {
		super();
		
		if(!arbre.isRemarquable()) {
			throw new Exception("L'arbre n'est pas remarquable.");
		}
		
		this.date = date;
		this.arbre = arbre;
	}

	/** Obtenir le/la compteRendu
	 * @return le/la compteRendu
	 */
	public String getCompteRendu() {
		return compteRendu;
	}

	/** Définition du compteRendu de la visite et défrayer le membre si la visite n'a pas déjà été défrayée
	 * @param compteRendu le compteRendu à définir
	 */
	public void setCompteRendu(String compteRendu) {
		this.compteRendu=compteRendu;
		
		if(!(this.getAssociation().isDefrayee(this))) {
			try {
				this.getAssociation().defrayerMembrePourVisite(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		return "Visite [date=" + date + ", compteRendu=" + compteRendu + ", arbre=" + arbre + "]";
	}
	
	public String toStringComptabilite() {
		return "Visite [id="+this.getId()+", date=" + date + ", arbre=" + arbre.getIdBase() + "]";
	}
	
	
}
