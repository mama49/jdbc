package model;

public class Service {


	private int idservice ;
	private String dateouvserv ;
	private String datefermserv ;
	private String NewDateFermServ;
	private String NewDateOuvServ;

	public String getNewDateFermServ() {
		return NewDateFermServ;
	}


	public void setNewDateFermServ(String newDateFermServ) {
		NewDateFermServ = newDateFermServ;
	}


	public String getNewDateOuvServ() {
		return NewDateOuvServ;
	}


	public void setNewDateOuvServ(String newDateOuvServ) {
		NewDateOuvServ = newDateOuvServ;
	}


	public Service(String dateouvserv, String datefermserv) {
		this.dateouvserv = dateouvserv; 
		this.datefermserv = datefermserv;
	}


	public int getIdservice() {
    	return idservice;

	}


	public void setIdservice(int idservice) {
		this.idservice = idservice;

	}


	public String getDateouvserv() {
		return dateouvserv;
	}


	public void setDateouvserv(String dateouvserv) {
		this.dateouvserv = dateouvserv;
	}


	public String getDatefermserv() {
		return datefermserv;
	}


	public void setDatefermserv(String datefermserv) {
		this.datefermserv = datefermserv;
	}




}
