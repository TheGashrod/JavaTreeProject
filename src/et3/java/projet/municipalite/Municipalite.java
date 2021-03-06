package et3.java.projet.municipalite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import et3.java.projet.association.Association;
import et3.java.projet.association.Visite;
import et3.java.projet.outils.Date;

public class Municipalite {
	
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
		
	/** Cette fonction est utilis�e pour constituer la base de donn�es des arbres de la municipalit� � partir du fichier csv,
	 * ensuite on utilisera PlanterNouvelAbrbre  pour ajouter un arbre et envoyer une notification 
	 * @param arbre
	 */
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
		this.listeNotification.add(new PlantationNotification(arbre));
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
		this.listeNotification.add(new AbattageNotification(arbre));
	}
	
	/** Classifie l'arbre remarquable et envoie une notiication de classification remarquable
	 * @param arbre classifie remarquable
	 */
	public void classifierRemarquable(Arbre arbre) {                          
		this.mapArbre.get(arbre.getIdBase()).setRemarquable(true);
		this.listeNotification.add(new ClassificationRemarquableNotification(arbre));
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
	
	
	/** Obtenir l'arbre correspondant à l'id demandé
	 * @param id
	 * @return Arbre correspondant à l'id demandé
	 * @throws Exception si aucun arbre n'est trouvé pour cet id
	 */
	public Arbre getArbre(int id) throws Exception {
		if(!this.getMapArbre().containsKey(id)) {
			throw new Exception("Il n'y a pas d'arbre avec cet id");
		}
		
		return this.getMapArbre().get(id);
	}
	
	/** Obtenir la liste des arbres remarquables
	 * @return la liste des arbres
	 */
	public ArrayList<Arbre> getArbresRemarquables(){
		ArrayList<Arbre> arbresRemarquables = new ArrayList<Arbre>();
		
		for (Arbre arbre : this.getMapArbre().values()) {
			if(arbre.isRemarquable()) {
				arbresRemarquables.add(arbre);
			}
		}
		
		return arbresRemarquables;
	}
	
	/** Obtenir la liste des arbres remarquables triée par ancienneté de leur dernière visite.
	 * @return la liste des arbres
	 */
	public ArrayList<Arbre> getArbresRemarquablesOrderByVisite(Association association){
		ArrayList<Arbre> arbresRemarquables = this.getArbresRemarquables();
		
		HashMap<Arbre, Date> dateDerniereVisiteParArbre = new HashMap<Arbre, Date>();
		
		for (Arbre arbre : arbresRemarquables) {
			
			ArrayList<Visite> visites = association.getVisitesByArbre(arbre);
			
			Date derniereVisite;
			
			if (!visites.isEmpty()) {
				derniereVisite = visites.get(visites.size()-1).getDate();
			}
			else {
				derniereVisite = new Date(1970,1,1);
			}
			
			dateDerniereVisiteParArbre.put(arbre, derniereVisite);
		}
		
		List<Entry<Arbre,Date>> listeDateDerniereVisiteParArbre = new LinkedList<Entry<Arbre,Date>>(dateDerniereVisiteParArbre.entrySet());
		
		// Trier les arbre par visites par ordre chronologique
		Collections.sort(listeDateDerniereVisiteParArbre, new Comparator<Entry<Arbre,Date>>() {
			@Override
			public int compare(Entry<Arbre, Date> o1, Entry<Arbre, Date> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		HashMap<Arbre, Date> dateDerniereVisiteParArbreTriee = new LinkedHashMap<Arbre, Date>();  
		for (Iterator<Entry<Arbre,Date>> it = listeDateDerniereVisiteParArbre.iterator(); it.hasNext();)   
		{  
			Map.Entry<Arbre, Date> entry = (Map.Entry<Arbre, Date>) it.next();  
			dateDerniereVisiteParArbreTriee.put(entry.getKey(), entry.getValue());  
		}   
		return arbresRemarquables;
	}

}
