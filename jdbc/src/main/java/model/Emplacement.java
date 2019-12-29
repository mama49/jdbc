package model;

public class Emplacement {
	
	private int idempl ;
	private int superficieempl ;
	public int prixtaxesejour ;
	private int prixelectricite ;
	private int fraisdossier ; 
	private int NewPrixElectricite;
	

	


	public int getNewPrixElectricite() {
		return NewPrixElectricite;
	}


	public void setNewPrixElectricite(int newPrixElectricite) {
		NewPrixElectricite = newPrixElectricite;
	}


	public Emplacement( int superficieempl, int prixtaxesejour, int prixelectricite, int fraisdossier) {
	this.superficieempl = superficieempl;
	this.prixtaxesejour = prixtaxesejour;
	this.prixelectricite = prixelectricite;
	this.fraisdossier = fraisdossier;

	}


	public int getIdempl() {
	return idempl;

	}


	public void setIdempl(int idempl) {
	this.idempl = idempl;

	}


	public int getSuperficieempl() {
	return superficieempl;

	}


	public void setSuperficieempl(int superficieempl) {
	this.superficieempl = superficieempl;

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

}