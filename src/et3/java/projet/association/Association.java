package et3.java.projet.association;

import java.util.ArrayList;

public class Association {
	
	/**
	 * Historique des écritures comptables
	 */
	ArrayList<EcritureComptable> livreComptable;
	
	static void finExerciceBudgetaire() {}
	
	private static void constituerListeArbresRemarquables() {}
	private static void genererRapportActivite() {}
	private static void envoyerDemandesFinancement() {}

	/**
	 * Crée une association
	 */
	public Association() {
		this.livreComptable = new ArrayList<EcritureComptable>();
	}
	
	
	/** Ajoute une écriture comptable à l'historique des écritures comptables
	 * @param ecritureComptable
	 */
	public void ajouterEcritureComptable(EcritureComptable ecritureComptable){
		this.livreComptable.add(ecritureComptable);
	}
	
	/**
	 * Retourne une chaine de caractères correspondant à l'historique des écritures comptables
	 */
	public String livreComptableToString() {
		String livreComptableString="";
		for (EcritureComptable ecritureComptable : livreComptable) {
			livreComptableString+=""+ecritureComptable;
		}
		return livreComptableString;
	}

}
