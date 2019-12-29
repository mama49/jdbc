package model;

public class EmplacementH {
	
	private int idemplH ;
	private int idempl ;
	private int prixtaxesejour ;
	private int prixelectricite ;
	private int fraisdossier ;
	private String dateannee ; 

	public EmplacementH(int prixtaxesejour, int prixelectricite, int fraisdossier, String dateannee) {
	this.prixtaxesejour = prixtaxesejour;
	this.prixelectricite = prixelectricite;
	this.fraisdossier = fraisdossier;
	this.dateannee = dateannee;

	}


	public int getIdemplH() {
	return idemplH;

	}


	public void setIdemplH(int idemplH) {
	this.idemplH = idemplH;

	}


	public int getIdempl() {
	return idempl;

	}


	public void setIdempl(int idempl) {
	this.idempl = idempl;

	}


	public int getPrixtaxesejour() {
	return prixtaxesejour;

	}


	public void setPrixtaxesejour(int prixtaxesejour) {
	this.prixtaxesejour = prixtaxesejour;

	}


	public int getPrixelectricite() {
	return prixelectricite;

	}


	public void setPrixelectricite(int prixelectricite) {
	this.prixelectricite = prixelectricite;

	}


	public int getFraisdossier() {
	return fraisdossier;

	}


	public void setFraisdossier(int fraisdossier) {
	this.fraisdossier = fraisdossier;

	}


	public String getDateannee() {
	return dateannee;

	}


	public void setDateannee(String dateannee) {
	this.dateannee = dateannee;

	}

	

}



