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
	
	public Float[] getGeographicalPoint2D() {
		return geographicalPoint2D;
	}


	public void setGeographicalPoint2D(Float[] geographicalPoint2D) {
		this.geographicalPoint2D = geographicalPoint2D;
	}
	


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
	 
	public Integer getIdBase() {
		return idBase;
	}
	public void setIdBase(Integer idBase) {
		this.idBase = idBase;
	}
	
	
	public String getTypeEmplacement() {
		return typeEmplacement;
	}
	public void setTypeEmplacement(String typeEmplacement) {
		this.typeEmplacement = typeEmplacement;
	}
	
	
	public String getDomanialite() {
		return domanialite;
	}
	public void setDomanialite(String domanialite) {
		this.domanialite = domanialite;
	}
	
	
	public String getArrondissement() {
		return arrondissement;
	}
	public void setArrondissement(String arrondissement) {
		this.arrondissement = arrondissement;
	}
	
	
	public String getComplementAdresse() {
		return complementAdresse;
	}
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}
	
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	public Integer getIdEmplacement() {
		return idEmplacement;
	}
	public void setIdEmplacement(Integer idEmplacement) {
		this.idEmplacement = idEmplacement;
	}

	
	public String getLibelleFrancais() {
		return libelleFrancais;
	}
	public void setLibelleFrancais(String libelleFrancais) {
		this.libelleFrancais = libelleFrancais;
	}
	
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	public String getEspece() {
		return espece;
	}
	public void setEspece(String espece) {
		this.espece = espece;
	}
	
	
	public String getVarieteOuCultivar() {
		return varieteOuCultivar;
	}
	public void setVarieteOuCultivar(String varieteOuCultivar) {
		this.varieteOuCultivar = varieteOuCultivar;
	}
	
	
	public Integer getCirconferenceEnCm() {
		return circonferenceEnCm;
	}
	public void setCirconferenceEnCm(Integer circonferenceEnCm) {
		this.circonferenceEnCm = circonferenceEnCm;
	}
	
	
	public Integer getHauteurEnM() {
		return hauteurEnM;
	}
	public void setHauteurEnM(Integer hauteurEnM) {
		this.hauteurEnM = hauteurEnM;
	}
	
	
	public String getStadeDeveloppement() {
		return stadeDeveloppement;
	}
	public void setStadeDeveloppement(String stadeDeveloppement) {
		this.stadeDeveloppement = stadeDeveloppement;
	}
	
	
	public Boolean getRemarquable() {
		return remarquable;
	}
	public void setRemarquable(Boolean remarquable) {
		this.remarquable = remarquable;
	}



}
