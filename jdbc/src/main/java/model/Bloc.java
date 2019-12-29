package model;

public class Bloc {
	
	private int idbloc ;
	private String nombloc ;
	private String newBlocName;

	public Bloc(String nombloc) {
	this.nombloc = nombloc; 

	}

	public String getNewBlocName() {
		return newBlocName;
	}

	public void setNewBlocName(String newBlocName) {
		this.newBlocName = newBlocName;
	}

	public int getIdbloc() {
	return idbloc;

	}


	public void setIdbloc(int idbloc) {
	this.idbloc = idbloc;

	}


	public String getNombloc() {
	return nombloc;

	}


	public void setNombloc(String nombloc) {
	this.nombloc = nombloc;

	}

	


}
