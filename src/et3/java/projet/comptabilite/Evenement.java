package et3.java.projet.comptabilite;

public abstract class Evenement {
	
	private EcritureComptable ecritureComptable;

	/**
	 * @param ecritureComptable
	 */
	public Evenement() {
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
