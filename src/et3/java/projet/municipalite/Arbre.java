package et3.java.projet.municipalite;


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
        		idBase + ";" +
        		typeEmplacement + ";" +
        		domanialite + ";" +
        		arrondissement + ";" +
        		complementAdresse + ";" +
        		adresse + ";" +
        		idEmplacement + ";" +
        		libelleFrancais + ";" +
        		genre + ";" +
        		espece + ";" +
        		varieteOuCultivar + ";" +
        		circonferenceEnCm + ";" +
        		hauteurEnM + ";" +
        		stadeDeveloppement + ";" +
        		remarquable + ";" +
        		"(" + geographicalPoint2D[0] + "," + geographicalPoint2D[1] + ")";
		return s;
	}


	/** Obtenir le/la idBase
	 * @return le/la idBase
	 */
	public Integer getIdBase() {
		return idBase;
	}


	/** D�finition de idBase
	 * @param idBase le/la idBase � d�finir
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


	/** D�finition de typeEmplacement
	 * @param typeEmplacement le/la typeEmplacement � d�finir
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


	/** D�finition de domanialite
	 * @param domanialite le/la domanialite � d�finir
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


	/** D�finition de arrondissement
	 * @param arrondissement le/la arrondissement � d�finir
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


	/** D�finition de complementAdresse
	 * @param complementAdresse le/la complementAdresse � d�finir
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


	/** D�finition de adresse
	 * @param adresse le/la adresse � d�finir
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


	/** D�finition de idEmplacement
	 * @param idEmplacement le/la idEmplacement � d�finir
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


	/** D�finition de libelleFrancais
	 * @param libelleFrancais le/la libelleFrancais � d�finir
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


	/** D�finition de genre
	 * @param genre le/la genre � d�finir
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


	/** D�finition de espece
	 * @param espece le/la espece � d�finir
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


	/** D�finition de varieteOuCultivar
	 * @param varieteOuCultivar le/la varieteOuCultivar � d�finir
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


	/** D�finition de circonferenceEnCm
	 * @param circonferenceEnCm le/la circonferenceEnCm � d�finir
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


	/** D�finition de hauteurEnM
	 * @param hauteurEnM le/la hauteurEnM � d�finir
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


	/** D�finition de stadeDeveloppement
	 * @param stadeDeveloppement le/la stadeDeveloppement � d�finir
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


	/** D�finition de remarquable
	 * @param remarquable le/la remarquable � d�finir
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


	/** D�finition de geographicalPoint2D
	 * @param geographicalPoint2D le/la geographicalPoint2D � d�finir
	 */
	public void setGeographicalPoint2D(Float[] geographicalPoint2D) {
		this.geographicalPoint2D = geographicalPoint2D;
	}




}
