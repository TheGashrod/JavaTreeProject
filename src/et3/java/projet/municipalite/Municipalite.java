package et3.java.projet.municipalite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import et3.java.projet.data.Afficher;

public class Municipalite {
	
//    private ArrayList<Arbre> listeArbre = new ArrayList<Arbre>();
	private HashMap<Integer,Arbre> mapArbre = new  HashMap<Integer,Arbre>();
	private ArrayList<Notification> listeNotification = new ArrayList<Notification>();
	
	
	
	/**
	 * @return la liste des arbres stoqués dans la HashMap "mapArbre" sous forme de String
	 */
	public String listeArbretoString() {
		String s = "";

		for(Map.Entry mapentry : mapArbre.entrySet()) {
        	s += mapentry.getValue().toString() + "\n" ;
        }
		return s;
	}
	
	
	public void ajouterArbre(Arbre arbre) {
		this.mapArbre.put(arbre.getIdBase(),arbre);
		
	}
	
	public void ajouterNouvelArbre(Arbre arbre) {
		this.mapArbre.put(arbre.getIdBase(),arbre);
		this.listeNotification.add(new PlantationArbreNotification(arbre));
	}
	
	public void supprimerArbre(Arbre arbre) {
		this.mapArbre.remove(arbre.getIdBase());
		this.listeNotification.add(new AbattageArbreNotification(arbre));
	}
	
	public void rendreRemarquable(Arbre arbre) {
		this.mapArbre.get(arbre.getIdBase()).setRemarquable(true);
		this.listeNotification.add(new EstRemarquableNotification(arbre));
	}
	
	

	/** Obtenir le/la mapArbre
	 * @return le/la mapArbre
	 */
	public HashMap<Integer, Arbre> getMapArbre() {
		return mapArbre;
	}

	/** Définition de mapArbre
	 * @param mapArbre le/la mapArbre à définir
	 */
	public void setMapArbre(HashMap<Integer, Arbre> mapArbre) {
		this.mapArbre = mapArbre;
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
