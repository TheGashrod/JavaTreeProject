package et3.java.projet.comptabilite;

import et3.java.projet.association.Association;

//import static et3.java.projet.comptabilite.Compte.count;

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
}
