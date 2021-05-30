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
	 * @return la liste des arbres stoqu�s dans la HashMap "mapArbre" sous forme de String
	 */
	public String listeArbretoString() {
		String s = "";

		for(Map.Entry<Integer, Arbre> mapentry : mapArbre.entrySet()) {
        	s += mapentry.getValue().toString() + "\n" ;
        }
		return s;
	}
	
	
// Cette fonction est utilis�e pour constituer la base de donn�es des arbres de la municipalit� � partir du fichier csv,
//	ensuite on utilisera PlanterNouvelAbrbre  pour ajouter un arbre et envoyer une notification 
	public void ajouterArbre(Arbre arbre) {
		this.mapArbre.put(arbre.getIdBase(),arbre);
		
	}
	
	/**Plante l'arbre et envoye une notification de plantation
	 * @param arbre plant�
	 * @throws Exception si l'arbre existe d�j� ou n'a pas �t� ajout�
	 */
	public void planterNouvelArbre(Arbre arbre) throws Exception {
		if (this.mapArbre.get(arbre.getIdBase()) != null) {
			throw new Exception("L'arbre exite d�j�");
		}
		this.mapArbre.put(arbre.getIdBase(),arbre);
		if (this.mapArbre.get(arbre.getIdBase())== null) {
			throw new Exception("Arbre non ajout�");
		}
		this.listeNotification.add(new Plantation(arbre));
	}
	
	/** Abbat l'arbre et envoye une notification d'abattage
	 * @param arbre abattu
	 * @throws Exception L'arbre n'a pas �t� retir�
	 */
	public void abattreArbre(Arbre arbre) throws Exception {
		this.mapArbre.remove(arbre.getIdBase());
		if (this.mapArbre.get(arbre.getIdBase()) != null) {
			throw new Exception("Arbre non retir�");
		}
		this.listeNotification.add(new Abattage(arbre));
	}
	
	/** Classifie l'arbre remarquable et envoie une notiication de classification remarquable
	 * @param arbre classifie remarquable
	 */
	public void classifierRemarquable(Arbre arbre) {                          
		this.mapArbre.get(arbre.getIdBase()).setRemarquable(true);
		this.listeNotification.add(new ClassificationRemarquable(arbre));
	}
	
	

	/** Obtenir le/la mapArbre
	 * @return le/la mapArbre
	 */
	public HashMap<Integer, Arbre> getMapArbre() {
		return mapArbre;
	}

	/** D�finition de mapArbre
	 * @param mapArbre le/la mapArbre � d�finir
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
	/** D�finition de listeNotification
	 * @param listeNotification le/la listeNotification � d�finir
	 */
	public void setListeNotification(ArrayList<Notification> listeNotification) {
		this.listeNotification = listeNotification;
	}
	

}
