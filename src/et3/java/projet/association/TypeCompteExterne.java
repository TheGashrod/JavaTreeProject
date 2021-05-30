package et3.java.projet.association;

public class TypeCompteExterne {

	private String nature;
	private boolean servicePublic;
	
	
	/** Crée un type de donateur
	 * @param nature
	 * @param servicePublic
	 */
	public TypeCompteExterne(String nature, boolean servicePublic) {
		super();
		this.nature = nature;
		this.servicePublic = servicePublic;
	}

	/**
	 * Retourne une chaine de caractères correspondant au type de donateur
	 */
	@Override
	public String toString() {
		return "TypeCompteExterne [nature=" + nature + ", servicePublic=" + servicePublic + "]";
	}
	
	
}
