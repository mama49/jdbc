package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Client;
import model.Reservation;


public class ReservationDao extends DAO<Reservation>{


@Override

public boolean create(Reservation obj) {
Statement state;
    try {
    PreparedStatement prepare = connection.prepareStatement("INSERT INTO Reservation(nb_pers_empl_reserv, date_debutreserv, date_finreserv, electricite)" + "VALUES (?,?,?,?)");
    prepare.setInt(1,obj.getNbPersEmplReserv());
    prepare.setString(2,obj.getDateDebutReserv());
    prepare.setString(3,obj.getDateFinReserv());
    prepare.setBoolean(4,obj.getElectricite());
    System.out.println(prepare.toString());
    prepare.execute();
    return true;
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     return false;
    }

}


@Override

public boolean delete(Reservation obj) {

Statement state;

    try {

    PreparedStatement prepare = connection.prepareStatement("DELETE FROM Reservation WHERE nb_pers_empl_reserv = ? and  date_debutreserv = ? and date_finreserv = ? and electricite = ?");
    prepare.setInt(1,obj.getNbPersEmplReserv());
    prepare.setString(2,obj.getDateDebutReserv());
   prepare.setString(3,obj.getDateFinReserv());
    prepare.setBoolean(4,obj.getElectricite());
    prepare.execute();
    System.out.println("LOG SQL STATEMENT : "+prepare);
    return true;
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     return false;
    }

}


@Override

public boolean update(Reservation obj) {

Statement state;

    try {
    PreparedStatement prepare = connection.prepareStatement("UPDATE Reservation SET  date_finreserv = ? WHERE date_finreserv = ? ");
    prepare.setString(1,obj.getNewDateFinReserv());
    prepare.setString(2,obj.getDateFinReserv());
    //prepare.setString(3,obj.getDatefinreserv());
   // prepare.setString(4,obj.getElectricite());
    System.out.println("LOG SQL STATEMENT : "+prepare);
    prepare.execute();
    return true;
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     return false;
    }

}


@Override

public Reservation find(Reservation obj) {

Statement state;

    try {
    PreparedStatement prepare = connection.prepareStatement("SELECT * from Reservation  WHERE nb_pers_empl_reserv = ? and  date_debutreserv = ? and date_finreserv = ?");
    prepare.setInt(1,obj.getNbPersEmplReserv());
    prepare.setString(2,obj.getDateDebutReserv());
    prepare.setString(3,obj.getDateFinReserv());
    prepare.execute();
    ResultSet resultats = prepare.executeQuery();
    boolean encore = resultats.next();
    while (encore) {
    obj.setIdreserv(resultats.getInt(1));
    obj.setNbPersEmplReserv(resultats.getInt(2));
    obj.setDateDebutReserv(resultats.getString(3));
    obj.setDateFinReserv(resultats.getString(4));
    obj.setElectricite(resultats.getBoolean(5));
    return obj;
    }
    
    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();  
    }
    return null;
}


@Override

public ArrayList<Reservation> findAll() {
Statement state;
    ArrayList<Reservation> r1 = new ArrayList<Reservation>();
    try {
    PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Reservation ");
    ResultSet resultats = prepare.executeQuery();
    boolean encore = resultats.next();
    while (encore) {
    Reservation obj = new Reservation(0, "", "", null);
    obj.setIdreserv(resultats.getInt(1));
    obj.setNbPersEmplReserv(resultats.getInt(2));
    obj.setDateDebutReserv(resultats.getString(3));
    obj.setDateFinReserv(resultats.getString(4));
    obj.setElectricite(resultats.getBoolean(5));
    r1.add(obj);
    encore = resultats.next();
    }
    
    } catch (Exception e) {
    // TODO Auto-generated catch bloc
    e.printStackTrace();  
    }
    return r1;

}


}
