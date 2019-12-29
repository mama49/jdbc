package model;

public class Reservation {
	
	private int idreserv ;
	private int NbPersEmplReserv ;
	private String DateDebutReserv ;
    private String DateFinReserv ; 
	private Boolean electricite ; 
	private String NewDateFinReserv;
	
	
	public Reservation( int NbPersEmplReserv, String DateDebutReserv, String DateFinReserv, Boolean electricite) {
	this.NbPersEmplReserv = NbPersEmplReserv;
	this.DateDebutReserv = DateDebutReserv;
	this.DateFinReserv = DateFinReserv;
	this.electricite = electricite;
	}


	public int getIdreserv() {
	return idreserv;
	}


	public void setIdreserv(int idreserv) {
	this.idreserv = idreserv;
	}


	public int getNbPersEmplReserv() {
	return NbPersEmplReserv;
	}


	public void setNbPersEmplReserv(int NbPersEmplReserv) {
	this.NbPersEmplReserv = NbPersEmplReserv;
	}



	public String getDateDebutReserv() {
		return DateDebutReserv;
	}


	public void setDateDebutReserv(String DateDebutReserv) {
		this.DateDebutReserv = DateDebutReserv;
	}


	public String getDateFinReserv() {
		return DateFinReserv;
	}


	public void setDateFinReserv(String DateFinReserv) {
		this.DateFinReserv = DateFinReserv;
	}


	public String getNewDateFinReserv() {
		return NewDateFinReserv;
	}


	public void setNewDateFinReserv(String newDateFinReserv) {
		this.NewDateFinReserv = NewDateFinReserv;
	}


	public Boolean getElectricite() {
	return electricite;
	}


	public void setElectricite(Boolean electricite) {
	this.electricite = electricite;
	}

	

}
