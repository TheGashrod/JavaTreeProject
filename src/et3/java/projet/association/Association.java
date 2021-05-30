package et3.java.projet.association;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import et3.java.projet.comptabilite.EcritureComptable;
import et3.java.projet.comptabilite.LivreComptable;
import et3.java.projet.municipalite.Arbre;
import et3.java.projet.outils.Date;


public class Association {
	
	private static final double MONTANT_COTISATION = 30;

	private static final int NB_VISITES_MAX_PAR_MEMBRE_PAR_AN = 5;

	private static final double MONTANT_DEFRAIEMENT_VISITE = 5;

	private static final String MESSAGE_DEMANDE_FINANCEMENT = "Bonjour, vous avez contribué au bon fonctionnement de notre association par le passé. \n Souhaitez vous renouveller votre donation cette année ?";

	private LivreComptable livreComptable;
	
	private HashMap<Integer,Membre> membres = new  HashMap<Integer,Membre>();
	
	private HashMap<Integer,Externe> externes = new  HashMap<Integer,Externe>();
	
	private HashMap<Visite, Membre> visites;
	
	static void finExerciceBudgetaire() {}
	
	/** Obtenir la liste des 5 arbres avec le plus de votes des membres
	 * @return liste des id des 5 arbres
	 */
	public ArrayList<Integer> getListePropositionClassificationRemarquable() {
		HashMap<Integer, Integer> votes = new HashMap<Integer, Integer>();
		
		// Compter les votes des membres
		for (Membre membre : this.getMembres().values()) {
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
		Iterator<Entry<Integer, Integer>> iterator = votesListe.iterator();
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
	
	/** Vérifier les cotisation de chaque membre pour l'annee demandée, si elle n'est pas payée, exclure le membre
	 * @param annee
	 */
	private void supprimerMembresSansCotisation(int annee) {
		for (Membre membre : this.getMembres().values()) {
			if(membre.isCotisationPayee(annee)) {
				try {
					this.desinscriptionMembre(membre);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/** Obtenir une liste de demandes de financement avec chaque donateur passé
	 * @return la liste des demandes de financement
	 */
	private HashMap<Externe, String> envoyerDemandesFinancement() {
		HashMap<Externe, String> demandesFinancement=new HashMap<Externe, String>();
		
		// Pour chaque Compte Externe ayant fait une donation à l'association
		for(EcritureComptable ecritureComptable : this.getLivreComptable().getHistoriqueEcritures()) {
			if(ecritureComptable.getCompte() instanceof Externe) {
				Externe donateur = (Externe) ecritureComptable.getCompte();
				// on ajoute une demande de financement (
				// comme on stocke les demandes dans une HashMap avec en clé le Compte Externe : une seule demande est conservée pour chaque Compte Externe
				demandesFinancement.put(donateur, donateur.getDesignation()+"\n" + MESSAGE_DEMANDE_FINANCEMENT);
			}
		}
		return demandesFinancement;
	}
	
	/**
	 * Crée une association
	 */
	public Association() {
		this.livreComptable = new LivreComptable();

		this.visites = new HashMap<Visite, Membre>();

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
		
		membre.anonymisationCompte();
		
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
		
		externe.anonymisationCompte();
		
		externe.setAssociation(null);
	}
	
	
	/** Obtenir le/la liste des membres
	 * @return le/la liste des membres
	 */
	public HashMap<Integer,Membre> getMembres() {
		return membres;
	}
	
	/** Obtenir le membre avec l'id demandé
	 * @param id
	 * @return
	 * @throws Exception si le membre n'est pas trouvé
	 */
	public Membre getMembre(int id) throws Exception {
		if(this.getMembres().get(id)==null) {
			throw new Exception("Membre non trouvé");
		}
		return this.getMembres().get(id);
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
	public void recetteCotisation(Membre membre, int annee) {
		try {
			this.livreComptable.ajouterEcritureComptable(new EcritureComptable(new Cotisation(annee), membre, new Date(), MONTANT_COTISATION), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		
		if(this.getVisitesByMembre(membre, true).size()>=NB_VISITES_MAX_PAR_MEMBRE_PAR_AN) {
			throw new Exception("Le membre a atteint le nombre de visite maximale par membre et par an.");
		}
		
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
	
	/** Obtenir la liste des visites de l'arbre demandé triée par ordre chronologique
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
				
		// Trier les visites par ordre chronologique
		sortVisites(visitesArbre, true);
		
		return visitesArbre;
	}
	
	/** Trier les visites par ordre chronologique ou inversement chronologique
	 * @param chronologique = true : chronologique, false : inversement chronologique
	 * @return
	 */
	public static ArrayList<Visite> sortVisites(ArrayList<Visite> visitesATrier, boolean chronologique){
		// Trier les visites par ordre chronologique
		Collections.sort(visitesATrier, new Comparator<Visite>() {
			@Override
			public int compare(Visite o1, Visite o2) {
				if (chronologique) {
					return o1.getDate().compareTo(o2.getDate());
				}
				else {
					return -(o1.getDate().compareTo(o2.getDate()));
				}
			}
		});
		
		return visitesATrier;
	}
	
	/**Obtenir la liste des visites du membre demandé triée par ordre chronologique
	 * @param arbre
	 * @param membre
	 * @param anneeCourante = true : uniquement les visites de l'année en cours
	 * @return la liste des visites
	 * @throws Exception si le membre n'est pas dans l'association
	 */
	public ArrayList<Visite> getVisitesByMembre(Membre membre, boolean anneeCourante) throws Exception{
		
		// Tester si le membre fait bien partie de l'association
		this.getMembre(membre.getId());
		
		ArrayList<Visite> visitesMembre = new ArrayList<Visite>();
		Date debutAnnee = new Date();
		debutAnnee.setJour(1);
		debutAnnee.setMois(1);
		
		// Récupérer les visites du membre
		for(Entry<Visite, Membre> mapentry : this.visites.entrySet()) {
			if(anneeCourante) {
				if(mapentry.getKey().getDate().compareTo(debutAnnee)>0) {
					visitesMembre.add(mapentry.getKey());
				}
			}
			else {
				visitesMembre.add(mapentry.getKey());
			}
		}
		
		// Trier les visites par ordre chronologique
		sortVisites(visitesMembre, true);
		
		return visitesMembre;
	}
	
	/** Retourne vrai si la visite demandée est déjà defrayée
	 * @param visite
	 * @return vrai si la visite est déjà defrayée
	 */
	public boolean isDefrayee(Visite visite){
		return !(this.getLivreComptable().getLivreByEvenement(visite).getHistoriqueEcritures().isEmpty());
	}
	
	/** Défrayer le membre ayant programmé la visite
	 * @param visite
	 * @throws Exception si la visite a déjà été défrayée, ou si le solde est insuffisant
	 */
	public void defrayerMembrePourVisite(Visite visite) throws Exception {
		
		if( this.isDefrayee(visite) ) {
			throw new Exception("Cette visite a déjà été defrayée.");
		}
		
		Membre membreVisite = this.visites.get(visite);
		this.getLivreComptable().ajouterEcritureComptable(new EcritureComptable(visite, membreVisite, new Date(), -MONTANT_DEFRAIEMENT_VISITE), true);
	}

}
