package et3.java.projet.municipalite;

public class Notification {
	
	/** Obtenir le/la messageNouvelArbre
	 * @return le/la messageNouvelArbre
	 */
	public String getMessageNouvelArbre() {
		return messageNouvelArbre;
	}
	/** D�finition de messageNouvelArbre
	 * @param messageNouvelArbre le/la messageNouvelArbre � d�finir
	 */
	public void setMessageNouvelArbre(String messageNouvelArbre) {
		this.messageNouvelArbre = messageNouvelArbre;
	}
	/** Obtenir le/la messageArbreSupprime
	 * @return le/la messageArbreSupprime
	 */
	public String getMessageArbreSupprime() {
		return messageArbreSupprime;
	}
	/** D�finition de messageArbreSupprime
	 * @param messageArbreSupprime le/la messageArbreSupprime � d�finir
	 */
	public void setMessageArbreSupprime(String messageArbreSupprime) {
		this.messageArbreSupprime = messageArbreSupprime;
	}
	private String messageNouvelArbre = "Un nouvel arbre a �t� ajout� : "+ "\n";
	private String messageArbreSupprime = "Un arbre a �t� Supprim� : "+ "\n";
	
	
	
}
