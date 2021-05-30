package et3.java.projet.comptabilite;

import et3.java.projet.association.Association;
import et3.java.projet.association.Externe;
import et3.java.projet.association.Membre;
import et3.java.projet.association.TypeCompteExterne;
import et3.java.projet.outils.Date;

public abstract class Compte {
	
	private static int count=0;
	private int id;
	private EcritureComptable ecritureComptable;
	private Association association;
	/**
	 * @param ecritureComptable
	 */
	public Compte() {
		count++;
		this.id = count;
		this.ecritureComptable = null;
	}

	/** Obtenir le/la id
	 * @return le/la id
	 */
	public int getId() {
		return id;
	}

	/** Obtenir le/la ecritureComptable
	 * @return le/la ecritureComptable
	 */
	public EcritureComptable getEcritureComptable() {
		return ecritureComptable;
	}

	/** Définition de ecritureComptable
	 * @param ecritureComptable le/la ecritureComptable à définir
	 */
	public void setEcritureComptable(EcritureComptable ecritureComptable) {
		this.ecritureComptable = ecritureComptable;
	}
	
	/** Obtenir le/la association
	 * @return le/la association
	 */
	public Association getAssociation() {
		return association;
	}

	/** Définition de association
	 * @param association le/la association à définir
	 */
	public void setAssociation(Association association) {
		this.association = association;
	}
	
	/** Remplacement du Compte dans les écritures comptables par un compte anonyme
	 * @throws Exception si le compte est toujours présent dans au moins une écriture comptable
	 */
	public void anonymisationCompte() throws Exception {
		// Anonymisation des Ecritures Comptables liées au compte
		Compte compteAnonyme = new Externe("Compte supprimé : id original="+this.getId(), "", new TypeCompteExterne("", false));
		
		LivreComptable historiqueMembre  = this.getAssociation().getLivreComptable().getLivreByCompte(this);
		
		for (EcritureComptable ecritureComptable : historiqueMembre.getHistoriqueEcritures()) {
			ecritureComptable.setCompte(compteAnonyme);
		}
		
		if(!this.getAssociation().getLivreComptable().getLivreByCompte(this).getHistoriqueEcritures().isEmpty()) {
			throw new Exception("Le compte n'as pas pu être anonymisé");
		}
		
	}
}
