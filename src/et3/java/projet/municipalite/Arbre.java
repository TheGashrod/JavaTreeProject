package et3.java.projet.municipalite;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class Arbre {
	
	 private Integer idBase;
	 private String typeEmplacement;
	 private String domanialite;
	 private String arrondissement;
	 private String complementAdresse;
	 private String adresse;
	 private Integer idEmplacement;
	 private String libelleFrancais;
	 private String genre;
	 private String espece;
	 private String varieteOuCultivar;
	 private Integer circonferenceEnCm;
	 private Integer hauteurEnM;
	 private String stadeDeveloppement;
	 private Boolean remarquable;
	 private Float[] geographicalPoint2D = new Float[2];
	 
// Arbre constructor


	public Arbre(Integer idBase, String typeEmplacement, String domanialite, String arrondissement, String complementAdresse, String adresse,
			Integer idEmplacement, String libelleFrancais, String genre, String espece, String varieteOuCultivar, Integer circonferenceEnCm,
			Integer hauteurEnM, String stadeDeveloppement, Boolean remarquable, Float[] geographicalPoint2D ) {
			
		setIdBase(idBase);
		setTypeEmplacement(typeEmplacement);
		setDomanialite(domanialite);
		setArrondissement(arrondissement);
		setComplementAdresse(complementAdresse);
		setAdresse(adresse);
		setIdEmplacement(idEmplacement);
		setLibelleFrancais(libelleFrancais);
		setGenre(genre);
		setEspece(espece);
		setVarieteOuCultivar(varieteOuCultivar);
		setCirconferenceEnCm(circonferenceEnCm);
		setHauteurEnM(hauteurEnM);
		setStadeDeveloppement(stadeDeveloppement);
		setRemarquable(remarquable);
		setGeographicalPoint2D(geographicalPoint2D);
	}
	 
	


	@Override
	public String toString() {
		String s =
        		"[ Id :" + idBase + ";" +
        		typeEmplacement + ";" +
        		domanialite + "; \n" +
        		"\t(Adresse : " +
        		arrondissement + ";" +
        		complementAdresse + ";" +
        		adresse + ";" +
        		idEmplacement + ";" +
        		") \n" +
        		"\t(Caractéristiques : " +
        		libelleFrancais + ";" +
        		genre + ";" +
        		espece + ";" +
        		varieteOuCultivar + ";" +
        		" Circonference en cm :" +
        		circonferenceEnCm + ";" +
        		" Hauteur en m :" +
        		hauteurEnM + ";" +
        		stadeDeveloppement + ";" +
        		"( Remarquable :" +
        		remarquable + ")" + ";" +
        		" Géolocalisation 2d :" +
        		"(" + geographicalPoint2D[0] + "," + geographicalPoint2D[1] + " ) ]\n";
		return s;
	}


	/** Obtenir le/la idBase
	 * @return le/la idBase
	 */
	public Integer getIdBase() {
		return idBase;
	}


	/** Définition de idBase
	 * @param idBase le/la idBase à définir
	 */
	public void setIdBase(Integer idBase) {
		this.idBase = idBase;
	}


	/** Obtenir le/la typeEmplacement
	 * @return le/la typeEmplacement
	 */
	public String getTypeEmplacement() {
		return typeEmplacement;
	}


	/** Définition de typeEmplacement
	 * @param typeEmplacement le/la typeEmplacement à définir
	 */
	public void setTypeEmplacement(String typeEmplacement) {
		this.typeEmplacement = typeEmplacement;
	}


	/** Obtenir le/la domanialite
	 * @return le/la domanialite
	 */
	public String getDomanialite() {
		return domanialite;
	}


	/** Définition de domanialite
	 * @param domanialite le/la domanialite à définir
	 */
	public void setDomanialite(String domanialite) {
		this.domanialite = domanialite;
	}


	/** Obtenir le/la arrondissement
	 * @return le/la arrondissement
	 */
	public String getArrondissement() {
		return arrondissement;
	}


	/** Définition de arrondissement
	 * @param arrondissement le/la arrondissement à définir
	 */
	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}


	/** Obtenir le/la complementAdresse
	 * @return le/la complementAdresse
	 */
	public String getComplementAdresse() {
		return complementAdresse;
	}


	/** Définition de complementAdresse
	 * @param complementAdresse le/la complementAdresse à définir
	 */
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}


	/** Obtenir le/la adresse
	 * @return le/la adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/** Définition de adresse
	 * @param adresse le/la adresse à définir
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/** Obtenir le/la idEmplacement
	 * @return le/la idEmplacement
	 */
	public Integer getIdEmplacement() {
		return idEmplacement;
	}


	/** Définition de idEmplacement
	 * @param idEmplacement le/la idEmplacement à définir
	 */
	public void setIdEmplacement(Integer idEmplacement) {
		this.idEmplacement = idEmplacement;
	}


	/** Obtenir le/la libelleFrancais
	 * @return le/la libelleFrancais
	 */
	public String getLibelleFrancais() {
		return libelleFrancais;
	}


	/** Définition de libelleFrancais
	 * @param libelleFrancais le/la libelleFrancais à définir
	 */
	public void setLibelleFrancais(String libelleFrancais) {
		this.libelleFrancais = libelleFrancais;
	}


	/** Obtenir le/la genre
	 * @return le/la genre
	 */
	public String getGenre() {
		return genre;
	}


	/** Définition de genre
	 * @param genre le/la genre à définir
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}


	/** Obtenir le/la espece
	 * @return le/la espece
	 */
	public String getEspece() {
		return espece;
	}


	/** Définition de espece
	 * @param espece le/la espece à définir
	 */
	public void setEspece(String espece) {
		this.espece = espece;
	}


	/** Obtenir le/la varieteOuCultivar
	 * @return le/la varieteOuCultivar
	 */
	public String getVarieteOuCultivar() {
		return varieteOuCultivar;
	}


	/** Définition de varieteOuCultivar
	 * @param varieteOuCultivar le/la varieteOuCultivar à définir
	 */
	public void setVarieteOuCultivar(String varieteOuCultivar) {
		this.varieteOuCultivar = varieteOuCultivar;
	}


	/** Obtenir le/la circonferenceEnCm
	 * @return le/la circonferenceEnCm
	 */
	public Integer getCirconferenceEnCm() {
		return circonferenceEnCm;
	}


	/** Définition de circonferenceEnCm
	 * @param circonferenceEnCm le/la circonferenceEnCm à définir
	 */
	public void setCirconferenceEnCm(Integer circonferenceEnCm) {
		this.circonferenceEnCm = circonferenceEnCm;
	}


	/** Obtenir le/la hauteurEnM
	 * @return le/la hauteurEnM
	 */
	public Integer getHauteurEnM() {
		return hauteurEnM;
	}


	/** Définition de hauteurEnM
	 * @param hauteurEnM le/la hauteurEnM à définir
	 */
	public void setHauteurEnM(Integer hauteurEnM) {
		this.hauteurEnM = hauteurEnM;
	}


	/** Obtenir le/la stadeDeveloppement
	 * @return le/la stadeDeveloppement
	 */
	public String getStadeDeveloppement() {
		return stadeDeveloppement;
	}


	/** Définition de stadeDeveloppement
	 * @param stadeDeveloppement le/la stadeDeveloppement à définir
	 */
	public void setStadeDeveloppement(String stadeDeveloppement) {
		this.stadeDeveloppement = stadeDeveloppement;
	}


	/** Obtenir le/la remarquable
	 * @return le/la remarquable
	 */
	public Boolean getRemarquable() {
		return remarquable;
	}


	/** Définition de remarquable
	 * @param remarquable le/la remarquable à définir
	 */
	public void setRemarquable(Boolean remarquable) {
		this.remarquable = remarquable;
	}
	 
	
	
	/** Obtenir le/la geographicalPoint2D
	 * @return le/la geographicalPoint2D
	 */
	public Float[] getGeographicalPoint2D() {
		return geographicalPoint2D;
	}


	/** Définition de geographicalPoint2D
	 * @param geographicalPoint2D le/la geographicalPoint2D à définir
	 */
	public void setGeographicalPoint2D(Float[] geographicalPoint2D) {
		this.geographicalPoint2D = geographicalPoint2D;
	}




}
