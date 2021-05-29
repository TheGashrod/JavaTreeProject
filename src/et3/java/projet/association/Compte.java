package et3.java.projet.association;

public abstract class Compte {
	
	private EcritureComptable ecritureComptable;

	/**
	 * @param ecritureComptable
	 */
	public Compte() {
		this.ecritureComptable = null;
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
}
