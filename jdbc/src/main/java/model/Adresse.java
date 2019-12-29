package model;

public class Adresse {

	private int id;
    private int numero;
    private String voie;
    private String ville;
    private int codePostal;
    
    
    
	public Adresse(int id, int numero, String voie, String ville, int codePostal) {
		super();
		this.id = id;
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	public Adresse(int numero, String voie, String ville, int codePostal) {
		super();
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
    
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numero=" + numero + ", voie=" + voie + ", ville=" + ville + ", codePostal="
				+ codePostal + "]";
	}
}
