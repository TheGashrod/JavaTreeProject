package et3.java.projet.comptabilite;

public abstract class Evenement {
	
	private static int count=0;
	private int id;
	private EcritureComptable ecritureComptable;

	public Evenement() {
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
	
	/** Retourne une chaine de l'évenement pour la comptabilité
	 * @return 
	 * @throws Exception si le méthode n'est pas implémentée dans les classes filles
	 */
	public String toStringComptabilite() throws Exception {
		throw new Exception("méthode toStringComptabilite() non implémentée pour la classe : "+this.getClass());
	}
	
	
}
