package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Avis;
import model.Bloc; 
import model.Client;


public class AvisDao extends DAO<Avis> {


@Override

public boolean create(Avis obj) {
Statement state;
    try {
    PreparedStatement prepare = connection.prepareStatement("INSERT INTO Avis(avis)" + "VALUES (?)");
    prepare.setString(1,obj.getAvis());
    prepare.execute();
    return true;
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     return false;
    }

}


@Override

public boolean delete(Avis obj) {
Statement state;
    try {
    PreparedStatement prepare = connection.prepareStatement("DELETE FROM Avis WHERE avis = ?");
    prepare.setString(1,obj.getAvis());
    prepare.execute();
    return true;
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     return false;
    }

}


@Override

public boolean update(Avis obj) {
Statement state;
    try {
    PreparedStatement prepare = connection.prepareStatement("UPDATE Avis SET avis = ? WHERE avis = ?");
    prepare.setString(1,obj.getNewavis());
    prepare.setString(2, obj.getAvis());
    prepare.execute();
    return true;
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     return false;
    }

}


@Override
public Avis find(Avis obj) {
Statement state;
    try {
    PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Avis WHERE avis = ? ");
    prepare.setString(1,obj.getAvis());
    prepare.execute();
    ResultSet resultats = prepare.executeQuery();
    boolean encore = resultats.next();
    while (encore) {
    //obj.setIdbloc(resultats.getInt(1));
    return obj;
    }
    
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();  
    }
    return null;
}


@Override
public ArrayList<Avis> findAll() {
Statement state;
    ArrayList<Avis> a1 = new ArrayList<Avis>();
    try {
    PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Avis");
    ResultSet resultats = prepare.executeQuery();
    boolean encore = resultats.next();
    while (encore) {
    Avis obj = new Avis(null);
    obj.setAvis(resultats.getString(1));
    //obj.setNomcli(resultats.getString(2));
    //obj.setIdservice(resultats.getInt(3));
    a1.add(obj);
    encore = resultats.next();
    }
    
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();  
    }
    return a1;

}

}
