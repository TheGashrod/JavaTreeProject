package et3.java.projet.association;

import java.util.ArrayList;
import java.util.LinkedList;

import et3.java.projet.comptabilite.Compte;
import et3.java.projet.comptabilite.EcritureComptable;
import et3.java.projet.comptabilite.LivreComptable;
import et3.java.projet.municipalite.Arbre;
import et3.java.projet.outils.Date;

public class Membre extends Compte {
	
	private String nom;
	private String prenom;
	private String adresse;
	private boolean estPresident;
	private Date dateDeNaissance;
	
	private LinkedList<Arbre> listeNominations;
	
	/**

	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param estPresident
	 * @param dateDeNaissance
	 * @param association
	 */
	public Membre(String nom, String prenom, String adresse, boolean estPresident, Date dateDeNaissance) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.estPresident = estPresident;
		this.dateDeNaissance = dateDeNaissance;
		
		this.listeNominations = new LinkedList<Arbre>();
	}
	
	/**
	 * Retourne une chaine de caractère décrivant le membre
	 */
	@Override
	public String toString() {
		return "Membre [id=" + this.getId() + ", nom=" + nom + ", prenom=" + prenom+ ", adresse=" + adresse + ", dateDeNaissance=" + dateDeNaissance + "]";
	}


		
	/** Est-ce que la cotisation du membre est payée pour l'annee demandée
	 * @param annee
	 * @return true si la cotisation est payée, false sinon
	 */
	public boolean isCotisationPayee(int annee) {
		
		LivreComptable livreMembre = this.getHistorique();
		
		for (EcritureComptable ecritureComptable : livreMembre.getHistoriqueEcritures()) {
			if (ecritureComptable.getEvenement() instanceof Cotisation) {
				Cotisation cotisationCourante = (Cotisation) ecritureComptable.getEvenement();
				if (cotisationCourante.getAnnee() == annee) {
					return true;
				}
			}
		}

		return false;
	}

	/** Obtenir l'historique des transactions liées à ce membre
	 * @return LivreComptable contenant les EcrituresComptable correspondantes
	 */
	public LivreComptable getHistorique() {
		return this.getAssociation().getLivreComptable().getLivreByCompte(this);
	}

	/** Payer sa cotisation pour l'annee demandée
	 * @param annee
	 */
	public void payerCotisation(int annee) {
		if(!this.isCotisationPayee(annee)) {
			this.getAssociation().recetteCotisation(this, annee);
		}
	}
	
	/** Obtenir le/la listeNominations
	 * @return le/la listeNominations
	 */
	public LinkedList<Arbre> getListeNominations() {
		return listeNominations;
	}

	/** Ajouter un arbre à la liste des nominations, si la liste contient déjà 5 arbres le plus ancien choix est retiré 
	 * @param arbre
	 * @throws Exception si l'arbre est déjà remarquable
	 */
	public void nominerArbre(Arbre arbre) throws Exception {
		
		if(arbre.isRemarquable()) {
			throw new Exception("L'arbre est déjà remarquable");
		}
		
		this.getListeNominations().addFirst(arbre);
		
		// si la liste contient déjà 5 arbres le plus ancien choix est retiré 
		if(this.getListeNominations().size() > 5) {
			this.getListeNominations().removeLast();
		}
		
	}
	
	/**
	 * @return Les donnees personelles du membre
	 */
	public String getDonneesPersonnelles() {
		ArrayList<EcritureComptable> hisoriqueMembre = this.getAssociation().getLivreComptable().getLivreByCompte(this).getHistoriqueEcritures();
		String donnesPersonnelles = "Nom;Prenom;Date de naissance;Adress;Date de derni�re inscription; Liste des cotisations \n";
		donnesPersonnelles += this.nom +";"+ this.prenom +";"+ this.dateDeNaissance +";"+ this.adresse +";"+ hisoriqueMembre.get(hisoriqueMembre.size()-1).getDate()
				+";"+ hisoriqueMembre;
		return donnesPersonnelles;
		}


	

}
