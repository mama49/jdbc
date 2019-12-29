package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Emplacement;
import model.Bloc;

public class EmplacementDao extends DAO<Emplacement> {
	Connection connection = PgConnection.getInstance();

	@Override
	public boolean create(Emplacement obj) {
		Statement state;
		try {
			PreparedStatement prepare = connection.prepareStatement("INSERT INTO Emplacement(superficie_empl, prix_taxe_sejour, prix_electricite, frais_dossier)" + "VALUES(?,?,?,?)");
			prepare.setInt(1,obj.getSuperficieempl());
			prepare.setInt(2,obj.getPrixtaxesejour());
			prepare.setInt(3,obj.getPrixelectricite());
			prepare.setInt(4,obj.getFraisdossier());
			prepare.execute();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}    
	}
	@Override
	public boolean delete(Emplacement obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Emplacement obj) {
		Statement state;
		try {
			PreparedStatement prepare = connection.prepareStatement("UPDATE Emplacement SET prix_electricite = ? WHERE prix_electricite = ?");
			prepare.setInt(1,obj.getNewPrixElectricite());
			prepare.setInt(2,obj.getPrixelectricite());
			prepare.execute();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Emplacement find(Emplacement obj) {
		Statement state;
		try {
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Emplacement WHERE superficie_empl = ?");
			prepare.setInt(1,obj.getSuperficieempl());
			prepare.execute();
			ResultSet resultats = prepare.executeQuery();
			boolean encore = resultats.next();
			while (encore) {

				obj.setIdempl(resultats.getInt(1));
				obj.setSuperficieempl(resultats.getInt(2));
				obj.setPrixtaxesejour(resultats.getInt(3));
				obj.setPrixelectricite(resultats.getInt(4));
				obj.setFraisdossier(resultats.getInt(5));
				return obj;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}
		return null;

	}
	@Override
	public ArrayList<Emplacement> findAll() {
		Statement state;
		ArrayList<Emplacement> e1 = new ArrayList<Emplacement>();
		try {
			PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Emplacement");
			ResultSet resultats = prepare.executeQuery();
			boolean encore = resultats.next();
			while (encore) {
				Emplacement obj = new Emplacement(0, 0, 0, 0);
				obj.setIdempl(resultats.getInt(1));
				obj.setSuperficieempl(resultats.getInt(2));
				obj.setPrixtaxesejour(resultats.getInt(3));
				obj.setPrixelectricite(resultats.getInt(4));
				obj.setFraisdossier(resultats.getInt(5));
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

}
