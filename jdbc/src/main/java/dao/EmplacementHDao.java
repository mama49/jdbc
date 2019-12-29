package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.EmplacementH;
import model.Bloc;

import model.Emplacement;

public class EmplacementHDao extends DAO<EmplacementH> {
		Connection connection = PgConnection.getInstance();
	
	
	public ArrayList<EmplacementH> findAll() {
		Statement state;
		ArrayList<EmplacementH> e1 = new ArrayList<EmplacementH>();
		try {
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM EmplacementH");
			ResultSet resultats = prepare.executeQuery();
			boolean encore = resultats.next();
			while (encore) {
				EmplacementH obj = new EmplacementH(0, 0, 0, "0");
				obj.setIdemplH(resultats.getInt(1));
				obj.setPrixtaxesejour(resultats.getInt(2));
				obj.setPrixtaxesejour(resultats.getInt(3));
				obj.setPrixelectricite(resultats.getInt(4));
				obj.setDateannee(resultats.getString(5));
				//obj.setNombloc(resultats.getString(7));
				//obj.setPrixempl(resultats.getString(8));
				e1.add(obj);
				encore = resultats.next();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		return e1;

	}


	@Override
	public boolean create(EmplacementH obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(EmplacementH obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(EmplacementH obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public EmplacementH find(EmplacementH obj) {
		// TODO Auto-generated method stub
		return null;
	}

}


