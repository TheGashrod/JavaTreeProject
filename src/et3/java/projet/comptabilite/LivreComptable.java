package et3.java.projet.comptabilite;

import java.util.ArrayList;

public class LivreComptable {
	
	/**
	 * Historique des écritures comptables
	 */
	ArrayList<EcritureComptable> historiqueEcritures;
	
	public LivreComptable() {
		this.historiqueEcritures = new ArrayList<EcritureComptable>();
	}
	
	/** Ajoute une écriture comptable à l'historique des écritures comptables
	 * @param ecritureComptable
	 */
	public void ajouterEcritureComptable(EcritureComptable ecritureComptable){
		this.historiqueEcritures.add(ecritureComptable);
	}
	
	/**
	 * Retourne une chaine de caractères correspondant à l'historique des écritures comptables
	 */
	@Override
	public String toString() {
		String livreComptableString="";
		for (EcritureComptable ecritureComptable : historiqueEcritures) {
			livreComptableString+=ecritureComptable+"\n";
		}
		return livreComptableString;
	}	
	
	
}
