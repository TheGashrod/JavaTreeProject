package et3.java.projet.association;

import java.util.ArrayList;
import java.util.HashMap;

import et3.java.projet.comptabilite.EcritureComptable;
import et3.java.projet.comptabilite.LivreComptable;
import et3.java.projet.municipalite.Arbre;
import et3.java.projet.outils.Date;

public class Association {
	
	private static final double MONTANT_COTISATION = 30;

	LivreComptable livreComptable;
	
//	HashMap<Integer,Membre membres> comme structure des membres
	private HashMap<Integer,Membre> membres = new  HashMap<Integer,Membre>();
	
// 	HashMap<Integer,Externe externs> comme structures des externes
	private HashMap<Integer,Externe> externes = new  HashMap<Integer,Externe>();

	
	
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
		this.membres = new HashMap<Integer,Membre>();
	}
	
	
// Inscription / Desinscription Membre/Externe :	
	
// Membre :	
	/** Inscription du membre dans l'association
	 * @param membre à inscrire
	 */
	public void inscriptionMembre(Membre membre) {
//		this.membres.add(membre);
		this.membres.put(membre.getId(), membre);
		membre.setAssociation(this);
	}
	
	
	/** Desinscription du membre dans l'association
	 * @param membre A desinscririre
	 */
	public void desinscriptionMembre(Membre membre) {
		this.membres.remove(membre.getId());
		membre.setAssociation(null);
	}
	
// Externe :
	/** Inscription externe
	 * @param externe a inscrire
	 */
	public void inscriptionExterne(Externe externe) {
		this.externes.put(externe.getId(), externe);
	}
	
	/** Desinscription externe
	 * @param externe a desinscririre
	 */
	public void desinscriptionExterne(Externe externe) {
		this.externes.remove(externe.getId());
	}
	
	
	/** Obtenir le/la liste des membres
	 * @return le/la liste des membres
	 */
	public HashMap<Integer,Membre> getMembres() {
		return membres;
	}
	
	
	/** Obtenir le/la livreComptable
	 * @return le/la livreComptable
	 */
	public LivreComptable getLivreComptable() {
		return livreComptable;
	}


	/** Enregistrer le paiement de la cotisation du membre pour l'annee demandée
	 * @param membre
	 * @param annee
	 */
	public void payerCotisation(Membre membre, int annee) {
		this.livreComptable.ajouterEcritureComptable(new EcritureComptable(new Cotisation(annee), membre, new Date(), MONTANT_COTISATION));
	}

}
