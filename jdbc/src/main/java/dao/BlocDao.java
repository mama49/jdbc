
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bloc;

public class BlocDao extends DAO<Bloc> {
	Connection connection = PgConnection.getInstance();

	@Override
	public boolean create(Bloc obj) {
		Statement state;
		try {
			PreparedStatement prepare = connection.prepareStatement("INSERT INTO Bloc(nom_bloc)  Values (?)");
			prepare.setString(1,obj.getNombloc());
			prepare.execute();
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   return false;
		}
		
	}

	@Override
	public boolean delete(Bloc obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Bloc obj) {
		Statement state;
	    try {
	    PreparedStatement prepare = connection.prepareStatement("UPDATE Bloc SET nom_bloc = ? where nom_bloc =? ");
	    prepare.setString(1,obj.getNewBlocName());
	    prepare.setString(2,obj.getNombloc());
	    prepare.execute();
	    return true;
	    } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	     return false;
	    }
	}

	@Override
	public Bloc find(Bloc obj) {
		Statement state;
	    try {
	    PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Bloc WHERE nom_bloc = ?");
	    prepare.setString(1,obj.getNombloc());
	    prepare.execute();
	    ResultSet resultats = prepare.executeQuery();
	    boolean encore = resultats.next();
	    while (encore) {
	    obj.setIdbloc(resultats.getInt(1));
	    return obj;
	    }

	    } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();  
	    }
	    return null;
	}

	@Override
	public ArrayList<Bloc> findAll() {
		
		Statement state;
	    ArrayList<Bloc> b1 = new ArrayList<Bloc>();
	    try {
	    PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Bloc");
	    ResultSet resultats = prepare.executeQuery();
	    boolean encore = resultats.next();
	    while (encore) {
	    Bloc obj = new Bloc(null);
	    obj.setIdbloc(resultats.getInt(1));
	    obj.setNombloc(resultats.getString(2));
	    b1.add(obj);
	    encore = resultats.next();
	    }

	    } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();  
	    }
	    return b1;

	    }
}