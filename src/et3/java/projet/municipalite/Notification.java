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
	

