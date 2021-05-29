package et3.java.projet.municipalite;

public abstract class Notification {
	
	private String message;
	private Arbre arbre;
	
	
	
	public Notification(String message, Arbre arbre) {
		this.message = message;
		this.arbre = arbre;
	}
	
	
	
	@Override
	public String toString() {
		return "Notification [message=" + message + ", arbre=" + arbre + "]";
	}



	
}
	
	
	
	
	
	
	
	
	
	
	
	
//	/** Obtenir le/la messageNouvelArbre
//	 * @return le/la messageNouvelArbre
//	 */
//	public String getMessageNouvelArbre() {
//		return messageNouvelArbre;
//	}
//	/** Définition de messageNouvelArbre
//	 * @param messageNouvelArbre le/la messageNouvelArbre à définir
//	 */
//	public void setMessageNouvelArbre(String messageNouvelArbre) {
//		this.messageNouvelArbre = messageNouvelArbre;
//	}
//	/** Obtenir le/la messageArbreSupprime
//	 * @return le/la messageArbreSupprime
//	 */
//	public String getMessageArbreSupprime() {
//		return messageArbreSupprime;
//	}
//	/** Définition de messageArbreSupprime
//	 * @param messageArbreSupprime le/la messageArbreSupprime à définir
//	 */
//	public void setMessageArbreSupprime(String messageArbreSupprime) {
//		this.messageArbreSupprime = messageArbreSupprime;
//	}
//	private String messageNouvelArbre = "Un nouvel arbre a été ajouté : "+ "\n";
//	private String messageArbreSupprime = "Un arbre a été Supprimé : "+ "\n";
//	
	
	

