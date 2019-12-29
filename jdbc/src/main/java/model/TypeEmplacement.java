package model;

public class TypeEmplacement {
	
	private int idtypeempl  ;
	private int prixempl ; 
	private int NewPrixEmpl;
	
	public int getNewPrixEmpl() {
		return NewPrixEmpl;
	}


	public void setNewPrixEmpl(int newPrixEmpl) {
		NewPrixEmpl = newPrixEmpl;
	}


	public TypeEmplacement (int prixempl) {
	this.prixempl = prixempl;

	}


	public int getIdtypeempl() {
	return idtypeempl;

	}


	public void setIdtypeempl(int idtypeempl) {
	this.idtypeempl = idtypeempl;

	}


	public int getPrixempl() {
	return prixempl;

	}


	public void setPrixempl(int prixempl) {
	this.prixempl = prixempl;

	}

	}



