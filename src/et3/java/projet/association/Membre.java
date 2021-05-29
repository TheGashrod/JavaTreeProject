package et3.java.projet.association;

import java.util.LinkedList;

import et3.java.projet.comptabilite.Compte;
import et3.java.projet.comptabilite.EcritureComptable;
import et3.java.projet.comptabilite.LivreComptable;
import et3.java.projet.municipalite.Arbre;
import et3.java.projet.outils.Date;

public class Membre extends Compte {
	
	private static int count=0;
	
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private boolean estPresident;
	private Date dateDeNaissance;
	
	private Association association;
	private LinkedList<Arbre> listeNominations;
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param estPresident
	 * @param dateDeNaissance
	 * @param association
	 */
	public Membre(String nom, String prenom, String adresse, boolean estPresident, Date dateDeNaissance) {
		super();
		
		count++;
		this.id = count;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.estPresident = estPresident;
		this.dateDeNaissance = dateDeNaissance;
		
		this.listeNominations = new LinkedList<Arbre>();
	}
	
	
	
	@Override
	public String toString() {
		return "Membre [id=" + id + ", nom=" + nom + ", prenom=" + prenom+ ", adresse=" + adresse + ", dateDeNaissance=" + dateDeNaissance + "]";
	}


	/** Obtenir le/la association
	 * @return le/la association
	 */
	public Association getAssociation() {
		return association;
	}

	/** Définition de association
	 * @param association le/la association à définir
	 */
	public void setAssociation(Association association) {
		this.association = association;
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
	
	public LivreComptable getHistorique() {
		return this.getAssociation().getLivreComptable().getLivreByCompte(this);
	}

	public void payerCotisation(int annee) {
		if(!this.isCotisationPayee(annee)) {
			association.payerCotisation(this, annee);
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
	 */
	public void nominerArbre(Arbre arbre) {
		this.getListeNominations().addFirst(arbre);
		if(this.getListeNominations().size() > 5) {
			this.getListeNominations().removeLast();
		}
	}
	
	

}
