package dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Bloc;
import model.Service;


public class ServiceDao extends DAO<Service> {


@Override

public boolean create(Service obj) {

Statement state;

    try {
    PreparedStatement prepare = connection.prepareStatement("INSERT INTO Service(date_ouvserv, date_fermserv)" + "VALUES (?,?)");
    prepare.setString(1,obj.getDateouvserv());
    prepare.setString(2,obj.getDatefermserv());
    prepare.execute();
    return true;

    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
     return false;

    }

}


@Override

public boolean delete(Service obj) {
// TODO Auto-generated method stub
return false;

}


@Override

public boolean update(Service obj) {
Statement state;
    try {
    PreparedStatement prepare = connection.prepareStatement("UPDATE Service SET date_fermserv = ?where date_fermserv = ? ");
    prepare.setString(1,obj.getNewDateFermServ());
    prepare.setString(2,obj.getDatefermserv());
    prepare.execute();
    return true;

    } catch (Exception e) {

    // TODO Auto-generated catch block
    e.printStackTrace();
     return false;

    }


}


@Override

public Service find(Service obj) {

Statement state;
    try {
    PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Service WHERE date_ouvserv = ? AND date_fermserv = ?");
    prepare.setString(1,obj.getDateouvserv());
    prepare.setString(2,obj.getDatefermserv());
    prepare.execute();
    ResultSet resultats = prepare.executeQuery();
    boolean encore = resultats.next();
    while (encore) {
    obj.setIdservice(resultats.getInt(1));
    return obj;

    }

    

    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();  

    }
    return null;

}


@Override

public ArrayList<Service> findAll() {

Statement state;
    ArrayList<Service> s1 = new ArrayList<Service>();
    try {
    PreparedStatement prepare = connection.prepareStatement("SELECT * FROM Service");
    ResultSet resultats = prepare.executeQuery();
    boolean encore = resultats.next();
    while (encore) {
    Service obj = new Service("","");
    obj.setIdservice(resultats.getInt(1));
    obj.setDateouvserv(resultats.getString(2));
    obj.setDatefermserv(resultats.getString(3));
    s1.add(obj);
    encore = resultats.next();

    }

    

    } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();  

    }

    return s1;

}

}


