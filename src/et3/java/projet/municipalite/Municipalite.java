package et3.java.projet.municipalite;

import java.util.ArrayList;

//import et3.java.projet.data.Afficher;

public class Municipalite {
	
    private ArrayList<Arbre> listeArbre = new ArrayList<Arbre>();
	private ArrayList<Notification> listeNotification = new ArrayList<Notification>();
	
	
	
	public String listeArbretoString() {
		String s = "";
		for(Arbre a : listeArbre) {
        	s += a.toString() + "\n";
        }
		return s;
	}
	
	public void ajouterArbre(Arbre a) {
		this.listeArbre.add(a);
		
	}
	
	public void ajouterNouvelArbre(Arbre a) {
		this.listeArbre.add(a);
		Notification notification = new Notification();
		notification.setNotificationNouvelArbre(notification.getNotificationNouvelArbre()+a.toString());
		this.listeNotification.add(notification);
	}
	
	
	
    /** Obtenir le/la listeArbre
	 * @return le/la listeArbre
	 */
	public ArrayList<Arbre> getListeArbre() {
		return listeArbre;
	}
	/** Définition de listeArbre
	 * @param listeArbre le/la listeArbre à définir
	 */
	public void setListeArbre(ArrayList<Arbre> listeArbre) {
		this.listeArbre = listeArbre;
	}
	/** Obtenir le/la listeNotification
	 * @return le/la listeNotification
	 */
	public ArrayList<Notification> getListeNotification() {
		return listeNotification;
	}
	/** Définition de listeNotification
	 * @param listeNotification le/la listeNotification à définir
	 */
	public void setListeNotification(ArrayList<Notification> listeNotification) {
		this.listeNotification = listeNotification;
	}



}
