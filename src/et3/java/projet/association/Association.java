package et3.java.projet.association;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import et3.java.projet.comptabilite.EcritureComptable;
import et3.java.projet.comptabilite.LivreComptable;
import et3.java.projet.municipalite.Arbre;
import et3.java.projet.outils.Date;


public class Association {
	
	private static final double MONTANT_COTISATION = 30;

	LivreComptable livreComptable;
	
	ArrayList<Membre> membres;
	
	HashMap<Visite, Membre> visites;
	
	static void finExerciceBudgetaire() {}
	
	/** Obtenir la liste des 5 arbres avec le plus de votes des membres
	 * @return liste des id des 5 arbres
	 */
	public ArrayList<Integer> getListePropositionClassificationRemarquable() {
		HashMap<Integer, Integer> votes = new HashMap<Integer, Integer>();
		
		// Compter les votes des membres
		for (Membre membre : this.getMembres()) {
			for (Arbre arbre : membre.getListeNominations()) {
				if( votes.get(arbre.getIdBase()) == null ) {
					votes.put(arbre.getIdBase(), 1);
				}
				else {
					int score = votes.get(arbre.getIdBase()) + 1;
					votes.replace(arbre.getIdBase(), score);
				}
			}
		}
		
		// Trier les arbres en fonction du nombre de votes
		List<Entry<Integer, Integer>> votesListe = new LinkedList<Entry<Integer, Integer>>(votes.entrySet());
		
		Collections.sort(votesListe,
			new Comparator<Entry<Integer, Integer>>()   
			{  
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)   
				{  
					// Dans l'ordre décroissant
					return o2.getValue().compareTo(o1.getValue());  
				}  
			}
		); 
		
		// Garder uniquement les 5 arbres avec le plus de votes
		Iterator iterator = votesListe.iterator();
		ArrayList<Integer> listeIdPropositionArbres= new ArrayList<>();
		for (int i=0; i<5 & iterator.hasNext(); i++) {
			
			Entry<Integer, Integer> entry = (Entry<Integer, Integer>) iterator.next();
			listeIdPropositionArbres.add(entry.getKey());
		}
		
		return listeIdPropositionArbres;
	}
	
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
		
		this.visites = new HashMap<Visite, Membre>();
	}
	
	/** Inscription du membre dans l'association
	 * @param membre à inscrire
	 */
	public void inscriptionMembre(Membre membre) {
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

	/** Enregistrer le paiement de la cotisation du membre pour l'annee demandée
	 * @param membre
	 * @param annee
	 */
	public void payerCotisation(Membre membre, int annee) {
		this.livreComptable.ajouterEcritureComptable(new EcritureComptable(new Cotisation(annee), membre, new Date(), MONTANT_COTISATION));
	}
	
	/** Obtenir le solde de l'association 
	 * @return le solde
	 */
	public double getSolde() {
		return this.livreComptable.getSolde();
	}
	
	/** Programmer une visite
	 * @param visite à programmer
	 * @param membre effectuant la visite
	 * @throws Exception si une visite est déjà programmée dans une date future
	 */
	public void programmerVisite(Visite visite, Membre membre) throws Exception {
		
		ArrayList<Visite> visitesArbre = this.getVisitesByArbre(visite.getArbre());
		Date aujourdhui = new Date();
		
		for (Visite visite2 : visitesArbre) {
			// Si une visite est déjà programmée pour une date future
			if (visite2.getDate().compareTo(aujourdhui)>=0) {
				throw new Exception("Une visite est déjà programmée");
			}
		}
		
		this.visites.put(visite, membre);
		visite.setAssociation(this);
	}
	
	/** Obtenir la liste des visites de l'arbre demandé
	 * @param arbre
	 * @return la liste des visites
	 */
	public ArrayList<Visite> getVisitesByArbre(Arbre arbre) {
		ArrayList<Visite> visitesArbre=new ArrayList<Visite>();
		for ( Visite visite : visites.keySet()) {
			if ( visite.getArbre() == arbre ) {
				visitesArbre.add(visite);
			}
		}
		return visitesArbre;
	}

}
