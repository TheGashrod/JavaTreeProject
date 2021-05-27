package et3.java.projet.association;

public class TypeDonateur {

	private String nature;
	private boolean servicePublic;
	
	
	/** Crée un type de donateur
	 * @param nature
	 * @param servicePublic
	 */
	public TypeDonateur(String nature, boolean servicePublic) {
		super();
		this.nature = nature;
		this.servicePublic = servicePublic;
	}

	/**
	 * Retourne une chaine de caractères correspondant au type de donateur
	 */
	@Override
	public String toString() {
		return "TypeDonateur [nature=" + nature + ", servicePublic=" + servicePublic + "]";
	}
	
	
}
