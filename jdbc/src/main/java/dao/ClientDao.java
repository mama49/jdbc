package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Client;

public class ClientDao extends DAO<Client> {
	
	Connection connection = PgConnection.getInstance();
	
    @Override
    public boolean create(Client obj)  {
    	Statement state;
		try {
			PreparedStatement prepare = connection.prepareStatement("INSERT INTO Client(nom_cli,prenom_cli,adresse_cli,codepostal_cli,ville_cli,tel_cli)  Values (?,?,?,?,?,?)");
			prepare.setString(1,obj.getNomclient());
			prepare.setString(2,obj.getPrenomclient());
			prepare.setString(3,obj.getAdresseclient());
			prepare.setInt(4,obj.getCodepostalclient());
			prepare.setString(5,obj.getVilleclient());
			prepare.setString(6, obj.getTelclient());
			prepare.execute();
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   return false;
		}
    	
    } 
    

    @Override
    public boolean delete(Client obj)  {
    	Statement state;
		try {
			PreparedStatement prepare = connection.prepareStatement("DELETE FROM Client  WHERE nom_cli=? and prenom_cli = ?");
			prepare.setString(1,obj.getNomclient());
			prepare.setString(2,obj.getPrenomclient());
			prepare.execute();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   return false;
			   
		}
    }

    @Override
    public boolean update(Client obj) {
    	Statement state;
		try {
			PreparedStatement prepare = connection.prepareStatement("UPDATE  Client  set adresse_cli=?,codepostal_cli=?,ville_cli =?, tel_cli= ? where nom_cli= ? and prenom_cli = ?");
			prepare.setString(1,obj.getAdresseclient());
			prepare.setInt(2,obj.getCodepostalclient());
			prepare.setString(3,obj.getVilleclient());
		    prepare.setString(4,obj.getTelclient());
			prepare.setString(5,obj.getNomclient());
			prepare.setString(6,obj.getPrenomclient());
			prepare.execute();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   return false;
		}
    }
    

    @Override
    public Client find(Client obj) {
    	Statement state;
		try {
			PreparedStatement prepare = connection.prepareStatement("SELECT * from Client  WHERE nom_cli=? and prenom_cli=?");
			prepare.setString(1,obj.getNomclient());
			prepare.setString(2,obj.getPrenomclient());
			prepare.execute();
			ResultSet resultats = prepare.executeQuery();
			boolean encore =resultats.next();
			while(encore) {
				obj.setIdclient(resultats.getInt(1));
				obj.setAdresseclient(resultats.getString(4));
				obj.setCodepostalclient(resultats.getInt(5));
				obj.setVilleclient(resultats.getString(6));
				obj.setTelclient(resultats.getString(7));
				return obj; 
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   
		}
		return null;
  
    }
   
        
    

    @Override
    public ArrayList<Client> findAll() {
    	Statement state;
    	ArrayList<Client> l1 = new ArrayList<Client>();
		try {
			
			PreparedStatement prepare = connection.prepareStatement("SELECT * from Client ");
			ResultSet resultats = prepare.executeQuery();
			boolean encore =resultats.next();
			while(encore) {
				Client obj = new Client(null,null,null,0,null,null);
				obj.setIdclient(resultats.getInt(1));
				obj.setNomclient(resultats.getString(2));
				obj.setPrenomclient(resultats.getString(3));
				obj.setAdresseclient(resultats.getString(4));
				obj.setCodepostalclient(resultats.getInt(5));
				obj.setVilleclient(resultats.getString(6));
				obj.setTelclient(resultats.getString(7));
				l1.add(obj);
				encore =resultats.next();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			   
		}
		return  l1;
  
    }
    
}

