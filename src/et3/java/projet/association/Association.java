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
	 * @throws Exception Si le membre est d�j� inscrit ou n'a pas pu �tre inscrit
	 */
	public void inscriptionMembre(Membre membre) throws Exception {
		if (this.membres.get(membre.getId()) != null) {
			throw new Exception("Le membre est d�j� inscrit");
		}
		this.membres.put(membre.getId(), membre);
		if (this.membres.get(membre.getId()) == null) {
			throw new Exception("Le membre n'a pas �t� inscrit");
		}
		membre.setAssociation(this);
	}
	
	
	/** Desinscription du membre dans l'association
	 * @param membre A desinscririre
	 * @throws Exception Si le membre n'est pas inscrit ou n'a pas pu �tre desinscrit 
	 */
	public void desinscriptionMembre(Membre membre) throws Exception {
		if (this.membres.get(membre.getId()) == null) {
			throw new Exception("Le membre n'est pas inscrit");
		}
		this.membres.remove(membre.getId());
		if (this.membres.get(membre.getId()) != null) {
			throw new Exception("Le membre n'a pas �t� desinscrit");
		}
		membre.setAssociation(null);
	}
	
// Externe :
	/** Inscription externe
	 * @param externe a inscrire
	 * @throws Exception Si l'externe est d�j� inscrit ou n'a pas pu �tre inscrit
	 */
	public void inscriptionExterne(Externe externe) throws Exception {
		if (this.membres.get(externe.getId()) == null) {
			throw new Exception("L'externe est d�j� inscrit");
		}
		this.externes.put(externe.getId(), externe);
		if (this.membres.get(externe.getId()) != null) {
			throw new Exception("L'externe n'a pas �t� inscrit");
		}
		externe.setAssociation(this);
	}
	
	/** Desinscription externe
	 * @param externe a desinscririre
	 * @throws Exception Si l'externe n'est pas inscrit ou n'a pas pu �tre desinscrit
	 */
	public void desinscriptionExterne(Externe externe) throws Exception {
		if (this.membres.get(externe.getId()) == null) {
			throw new Exception("L'externe n'est pas inscrit");
		}
		this.externes.remove(externe.getId());
		if (this.membres.get(externe.getId()) != null) {
			throw new Exception("L'externe n'a pas �t� desinscrit");
		}
		externe.setAssociation(null);
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
