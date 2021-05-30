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
	
	/** Obtenir l'historique des EcritureComptable liées au compte demandé
	 * @param compte
	 * @return LivreComptable contenant les EcritureComptable correspondantes
	 */
	public LivreComptable getLivreByCompte(Compte compte) {
		LivreComptable livre = new LivreComptable();
		for (EcritureComptable ecritureComptable : historiqueEcritures) {
			if(ecritureComptable.getCompte()==compte) {
				livre.ajouterEcritureComptable(ecritureComptable);
			}
		}
		return livre;
	}

	/** Obtenir le/la historiqueEcritures
	 * @return le/la historiqueEcritures
	 */
	public ArrayList<EcritureComptable> getHistoriqueEcritures() {
		return historiqueEcritures;
	}
	
	/** Obtenir le solde du LivreComptable (somme des montants des EcritureComptable)
	 * @return le solde du LivreComptable
	 */
	public double getSolde() {
		double solde = 0;
		
		for (EcritureComptable ecritureComptable : this.getHistoriqueEcritures()) {
			solde+=ecritureComptable.getSomme();
		}
		
		return solde;
	}
	
	
	
}
