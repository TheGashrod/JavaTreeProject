package et3.java.projet.association;

import java.util.ArrayList;
import java.util.Date;

public class Association {
	
	private static final double MONTANT_COTISATION = 30;

	/**
	 * Historique des écritures comptables
	 */
	ArrayList<EcritureComptable> livreComptable;
	
	ArrayList<Membre> membres;
	
	static void finExerciceBudgetaire() {}
	
	private static void constituerListeArbresRemarquables() {}
	private static void genererRapportActivite() {}
	private static void envoyerDemandesFinancement() {}

	/**
	 * Crée une association
	 */
	public Association() {
		this.livreComptable = new ArrayList<EcritureComptable>();
		this.membres = new ArrayList<Membre>();
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
			livreComptableString+=ecritureComptable+"\n";
		}
		return livreComptableString;
	}
	
	public void insciptionMembre(Membre membre) {
		this.membres.add(membre);
		membre.setAssociation(this);
	}
	
	
	
	/** Obtenir le/la membres
	 * @return le/la membres
	 */
	public ArrayList<Membre> getMembres() {
		return membres;
	}

	/**
	 * @param membre
	 * @param annee
	 */
	public void payerCotisation(Membre membre, int annee) {
		this.ajouterEcritureComptable(new EcritureComptable(new Cotisation(annee), membre, new Date(), MONTANT_COTISATION));
	}

}
