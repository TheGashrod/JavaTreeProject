package et3.java.projet.municipalite;

public class Notification {
	
	private static  String messageNouvelArbre = "Un nouvel arbre a été ajouté : "+ "\n";
	
	

	/** Obtenir le/la notificationNouvelArbre
	 * @return le/la notificationNouvelArbre
	 */
	public String getNotificationNouvelArbre() {
		return this.messageNouvelArbre;
	}

	/** Définition de notificationNouvelArbre
	 * @param notificationNouvelArbre le/la notificationNouvelArbre à définir
	 */
	public void setNotificationNouvelArbre(String notificationNouvelArbre) {
		this.messageNouvelArbre = notificationNouvelArbre;
	}

	
//	public Notification() {
//		// TODO Auto-generated constructor stub
//	}

	
	
}
