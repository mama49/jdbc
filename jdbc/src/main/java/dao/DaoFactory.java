package dao;

import model.Client;
import model.Emplacement;
import model.Reservation;
import model.Service;
import model.TypeEmplacement;
import model.Avis;
import model.Bloc;

public class DaoFactory {
	
	public static DAO<Client> getClientDAO(){
		return new ClientDao();
	}
	public static DAO<Bloc> getBlocDAO(){
		return new BlocDao();
	}
	public static DAO<Emplacement> EmplacementDAO() {
		return new EmplacementDao();
	}
	public static DAO<TypeEmplacement> getTypeEmplacementDAO() {
		return new TypeEmplacementDao();
	}
	public static DAO<Service> ServiceDAO() {
		// TODO Auto-generated method stub
		return new ServiceDao();
	}
	public static DAO<Avis> AvisDAO() {
		// TODO Auto-generated method stub
		return new AvisDao();
	}
	public static DAO<Reservation> getReservationDAO() {
		// TODO Auto-generated method stub
		return new ReservationDao();
	}
	
}
