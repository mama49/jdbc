package dao;


	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import model.Bloc;
	import model.TypeEmplacement;


	public class TypeEmplacementDao extends DAO<TypeEmplacement> {


		@Override

		public boolean create(TypeEmplacement obj) {

			Statement state;
			try {
				PreparedStatement prepare = connection.prepareStatement("INSERT INTO typeemplacement(prix_empl)" + "VALUES (?)");
				prepare.setInt(1,obj.getPrixempl());
				prepare.execute();
				return true;
			} catch (Exception e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		@Override
		public boolean delete(TypeEmplacement obj) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean update(TypeEmplacement obj) {
			Statement state;
			try {
				PreparedStatement prepare = connection.prepareStatement("UPDATE typeemplacement SET prix_empl = ? where prix_empl = ?");
				prepare.setInt(1,obj.getNewPrixEmpl());
				prepare.setInt(2,obj.getPrixempl());
				prepare.execute();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

			}

		}


		@Override

		public TypeEmplacement find(TypeEmplacement obj) {
			Statement state;
			try {
				PreparedStatement prepare = connection.prepareStatement("SELECT * FROM typeemplacement WHERE prix_empl = ?");
				prepare.setInt(1,obj.getPrixempl());
				System.out.println(prepare);
				prepare.execute();
				ResultSet resultats = prepare.executeQuery();
				boolean encore = resultats.next();
				while (encore) {
					obj.setIdtypeempl(resultats.getInt(1));
					return obj;
				}


			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();  
			}
			return null;

		}


		@Override

		public ArrayList<TypeEmplacement> findAll() {
			Statement state;
			ArrayList<TypeEmplacement> t1 = new ArrayList<TypeEmplacement>();
			try {
				PreparedStatement prepare = connection.prepareStatement("SELECT * FROM typeemplacement");
				ResultSet resultats = prepare.executeQuery();
				boolean encore = resultats.next();
				while (encore) {
					TypeEmplacement obj = new TypeEmplacement(0);
					obj.setIdtypeempl(resultats.getInt(1));
					obj.setPrixempl(resultats.getInt(2));
					t1.add(obj);
					encore = resultats.next();

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();  
			}
			return t1;

		}


	}


