package model;

public class Client {
	
	private int idclient;
	private String nomclient;
	private String prenomclient;
	private String adresseclient;
	private int codepostalclient;
	private String villeclient;
	private String telclient;
	
	public Client( String nomcli, String prenomcli, String adressecli,int codepostalcli,String villecli, String telcli) {
		this.nomclient = nomcli;
		this.prenomclient = prenomcli;
		this.adresseclient = adressecli;
		this.codepostalclient = codepostalcli;
		this.villeclient = villecli;
		this.telclient = telcli;
		
	}
	public String toString() {
		return  this.prenomclient+" "+ this.nomclient;
	}

	public int getCodepostalclient() {
		return codepostalclient;
	}

	public void setCodepostalclient(int codepostalclient) {
		this.codepostalclient = codepostalclient;
	}

	public String getVilleclient() {
		return villeclient;
	}

	public void setVilleclient(String villeclient) {
		this.villeclient = villeclient;
	}

	public int getIdclient() {
		return idclient;
	}

	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}

	public String getNomclient() {
		return nomclient;
	}

	public void setNomclient(String nomclient) {
		this.nomclient = nomclient;
	}

	public String getPrenomclient() {
		return prenomclient;
	}

	public void setPrenomclient(String prenomclient) {
		this.prenomclient = prenomclient;
	}



	public String getAdresseclient() {
		return adresseclient;
	}

	public void setAdresseclient(String adresseclient) {
		this.adresseclient = adresseclient;
	}

	public String getTelclient() {
		return telclient;
	}

	public void setTelclient(String telclient) {
		this.telclient = telclient;
	}
}