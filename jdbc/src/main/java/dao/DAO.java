package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO<T> {

	// ici je récupère ma connexion qui est initialisée à l'aide de la classe que l'on a créé ¨gConnection
	protected Connection connection = PgConnection.getInstance();
	
	public abstract boolean create(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean update(T obj);
	public abstract T find(T obj);
	public abstract ArrayList<T> findAll();
	
}
