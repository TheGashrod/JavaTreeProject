package et3.java.projet.association;

import java.util.ArrayList;

import et3.java.projet.comptabilite.EcritureComptable;
import et3.java.projet.comptabilite.LivreComptable;
import et3.java.projet.outils.Date;

public class Association {
	
	private static final double MONTANT_COTISATION = 30;

	LivreComptable livreComptable;
	
	ArrayList<Membre> membres;
	
	static void finExerciceBudgetaire() {}
	
	private static void constituerListeArbresRemarquables() {}
	public String genererRapportActivite() {
		return this.livreComptable.toString();
	}
	private static void envoyerDemandesFinancement() {}

	/**
	 * Crée une association
	 */
	public Association() {
		this.livreComptable = new LivreComptable();
		this.membres = new ArrayList<Membre>();
	}
	
	
	public void insciptionMembre(Membre membre) {
		this.membres.add(membre);
		membre.setAssociation(this);
	}
	
	
	
	/** Obtenir le/la livreComptable
	 * @return le/la livreComptable
	 */
	public LivreComptable getLivreComptable() {
		return livreComptable;
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
		this.livreComptable.ajouterEcritureComptable(new EcritureComptable(new Cotisation(annee), membre, new Date(), MONTANT_COTISATION));
	}

}
