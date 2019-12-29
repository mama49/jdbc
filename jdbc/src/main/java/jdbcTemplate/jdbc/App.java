package jdbcTemplate.jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import dao.AvisDao;
import dao.DAO;
import dao.DaoFactory;
import model.Adresse;
import model.Client;
import model.Bloc;
import model.TypeEmplacement;
import model.Emplacement;
import model.Reservation;
import model.Service;
import model.Avis;

public class App 
{
	public static void main( String[] args ) throws ParseException
	{

		DAO<Client> clientDao = DaoFactory.getClientDAO();
		DAO<Bloc> blocDao = DaoFactory.getBlocDAO();
		DAO<TypeEmplacement> typeemplacement = DaoFactory.getTypeEmplacementDAO();
		DAO<Emplacement> emplacement = DaoFactory.EmplacementDAO();
		DAO<Service> service = DaoFactory.ServiceDAO();
		DAO<Avis> avis = DaoFactory.AvisDAO();
		DAO<Reservation> reservationDao = DaoFactory.getReservationDAO();

		//System.out.println("Quel type d'emplacement voulez vous ?");
		ArrayList<TypeEmplacement> t2 = new ArrayList<TypeEmplacement>();
		t2 = typeemplacement.findAll();
		for(int i=0;i<t2.size(); i++) {
			//	System.out.println("Liste des emplacements" + t2.get(i).getIdtypeempl()+ " Prix :" + t2.get(i).getPrixempl());
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Création de compte : ");
		System.out.println("Nom : ");
		String nom = scanner.next();
		System.out.println("Prénom : ");
		String prenom = scanner.next();
		System.out.println("Rue : ");
		String rue = scanner.next();
		System.out.println("Code Postal : ");
		int codePostal = scanner.nextInt();
		System.out.println("Ville : ");
		String ville = scanner.next();
		System.out.println("Numéro de téléphone : ");
		String numero = scanner.next();
		
		
		System.out.println("Prix de l'emplacement :");
		int prixEmplacement = scanner.nextInt();
		
		System.out.println("Prix taxe séjour :");
		int prixTaxeSejour = scanner.nextInt() ;
		
		System.out.println("Prix frais dossier :");
		int prixFraisDossier = scanner.nextInt();

		System.out.println("Nombre de personnes :");
		int NbrPersonne = scanner.nextInt();

		System.out.println("Electricité ? : true/false");
		boolean electriciteB = scanner.nextBoolean();
		
		System.out.println(" prix d'electricité ? ");
		int prixelectricite = scanner.nextInt();
		

		System.out.println("Date du début de séjour ? (DD/MM/AA ");
		String debutSejour = scanner.next();
		System.out.println("Date de fin de séjour ? (DD/MM/AA");
		String finSejour = scanner.next();
		long sejour = deltaNombreJours(debutSejour,finSejour);
		System.out.println("Réservation du "+ debutSejour + " au " + finSejour + "("+ sejour +"jours)");
		
		System.out.println("Recapitulatif de la réservation :\n"
				+ nom+ " "+ prenom + "\n"
				+ rue +" "+ codePostal +" "+ ville +"\n"
				+ numero +"\n \n" 
				+ "Réservation du "+ debutSejour + " au " + finSejour + "("+ sejour +"jours)"

				);
		System.out.println("Voici le prix du séjour :");
		long prixsejour =prixEmplacement * sejour+ NbrPersonne*prixTaxeSejour*sejour +prixFraisDossier + prixelectricite*sejour;
		System.out.println(prixsejour);
	    		
		System.out.println("Avis de la personne sur la réservation :");
		String avisIn = scanner.next(); 
		
		System.out.println("Voulez vous supprimer l'avis de la personne sur la réservation :");
		boolean deleteAvis;
		deleteAvis = scanner.nextBoolean();
		
		System.out.println("Modification de l'avis sur la réservation :");
		String newAvisUpdateIn ="";
		newAvisUpdateIn= scanner.next();
		
		System.out.println("Modification de la date de la fin de réservation :");
		String finSejourModified ="";
		finSejourModified = scanner.next();

		System.out.println("Suppression de la dernière réservation ? true/false");
		boolean deleteLastBooking;
		deleteLastBooking = scanner.nextBoolean();

		System.out.println("Chercher les réservations avec les dates données" + debutSejour + " " + finSejour + "true/false");
		boolean findBooking;
		findBooking = scanner.nextBoolean();
		
		System.out.println("Voulez vous la liste des réservations actuelles ? true/false");
		boolean showAllBooking;
		showAllBooking = scanner.nextBoolean();
		
		System.out.println("Voulez vous la liste des avis actuelles ? true/false");
		boolean showAllAvis;
		showAllAvis = scanner.nextBoolean();
		
		System.out.println("Voulez vous la liste des emplacements actuelles ? true/false");
		boolean showAllEmplacements;
		showAllEmplacements = scanner.nextBoolean();
		


		Client client1 = new Client("Fourreau","Candyce","23 rue Barra",49100,"Angers","09865567");
		Client client2 = new Client("Fourreau","Mama","23 rue Barra",49100,"Angers","09865567");
		Client client3 = new Client("Fréjoux","Montaine","23 rue Barra",49100,"Angers","09865567");
		Client client4 = new Client("Fréjoux","YOYO","23 rue Barra",49100,"Angers","09865567");
		Client newClient= new Client(nom,prenom,rue,codePostal,ville,numero);
		Client clienttrouver= new Client(null,null,null,0,null,null);
		
		ArrayList<Client> l1 = new ArrayList<Client>();
		
		clientDao.create(newClient);
		clientDao.create(client2);
		clientDao.create(client3);
		clientDao.create(client4);
		
		clientDao.delete(client1);
		clientDao.delete(client2);
		clientDao.delete(client3);
		clientDao.delete(client4);
		
		client4.setAdresseclient("PARIS");
		clientDao.update(client4);
		
		client3.setTelclient("0750891174");
		clientDao.update(client3);
		
		clienttrouver = clientDao.find(client4);
		System.out.println(clienttrouver.getPrenomclient()+" "+clienttrouver.getNomclient());
		l1 = clientDao.findAll();
		for(int i=0;i<l1.size();i++) {
			//	System.out.println (l1.get(i).getPrenomclient());
		}
		
		

		Bloc bloc4 = new Bloc("A");
		Bloc bloc5 = new Bloc("B");
		Bloc bloc6 = new Bloc("C");
		Bloc bloc7 = new Bloc("D");
		
		blocDao.create(bloc4);
		blocDao.create(bloc5);
		blocDao.create(bloc6);
		blocDao.create(bloc7);
		
		Bloc bloctrouver = new Bloc(null);
	    bloctrouver = blocDao.find(bloc4);
		System.out.println(bloctrouver.getNombloc());
		
		ArrayList<Bloc> b1 = new ArrayList<Bloc>();
		b1 = blocDao.findAll();
		for(int i=0;i<b1.size(); i++) {
			 System.out.println(b1.get(i).getNombloc());
			 
		}


		TypeEmplacement typemplac1 = new TypeEmplacement(150);
		TypeEmplacement typemplac2 = new TypeEmplacement(250);
		TypeEmplacement typemplac3 = new TypeEmplacement(350);
		TypeEmplacement typemplac4 = new TypeEmplacement(450);
		TypeEmplacement typemplac5 = new TypeEmplacement(550);
		
		typeemplacement.create(typemplac1);
		typeemplacement.create(typemplac2);
		typeemplacement.create(typemplac3);
		typeemplacement.create(typemplac4);
		typeemplacement.create(typemplac5);
		
		typemplac1.setNewPrixEmpl(150);
		typeemplacement.update(typemplac1);
		
		TypeEmplacement typeempltrouver = new TypeEmplacement(0);
		typeempltrouver = typeemplacement.find(typemplac1);
		System.out.println(typeempltrouver.getPrixempl());
		
		
		ArrayList<TypeEmplacement> t1 = new ArrayList<TypeEmplacement>();
		t1 = typeemplacement.findAll();
		for(int i=0;i<t1.size(); i++) {
			 System.out.println(t1.get(i).getPrixempl());
			 
		}



		Emplacement emplace1 = new Emplacement(35,330,20,30);
		Emplacement emplace2 = new Emplacement(45,340,20,30);
		Emplacement emplace3 = new Emplacement(55,350,20,30);
		
		emplacement.create(emplace1);
		emplacement.create(emplace2);
		emplacement.create(emplace3);
		
		emplace1.setNewPrixElectricite(150);
	    emplacement.update(emplace1);
	    
		Emplacement empltrouver = new Emplacement(0, 0, 0, 0);
		empltrouver = emplacement.find(emplace3);
		System.out.println(empltrouver.getPrixtaxesejour());
		
		ArrayList<Emplacement> e1 = new ArrayList<Emplacement>();
		e1 = emplacement.findAll();
		for(int i=0;i<e1.size(); i++) {
			 System.out.println(e1.get(i).getSuperficieempl());
			 
		}
		

		Service service1 = new Service("23 juillet ","25 aout");
		Service service2 = new Service("6 juillet ","9 aout");
		Service service3 = new Service("5 juillet ","9 aout");
		Service service4 = new Service("15 juillet ","4 aout");
		Service service5 = new Service("5 juillet ","8 juillet");
		Service service6 = new Service("1 aout ","9 aout");
		
		
		service.create(service1);
		service.create(service2);
		service.create(service3);
		service.create(service4);
		service.create(service5);
		service.create(service6);
		
		
		service2.setNewDateFermServ("3/98");
		service.update(service2);
		
		Service servicetrouver = new Service(null, null);
		servicetrouver = service.find(service3);
		System.out.println(servicetrouver.getDateouvserv() + servicetrouver.getDatefermserv());
		
		ArrayList<Service> s1 = new ArrayList<Service>();
		s1 = service.findAll();
		for(int i=0;i<s1.size(); i++) {
		System.out.println(s1.get(i).getDateouvserv() +" "+ s1.get(i).getDatefermserv());
		
		}

		Avis avis1 = new Avis("bien");
		Avis avis2 = new Avis("moyen");
		Avis newAvis = new Avis (avisIn);
		Avis newAvisUpdate = new Avis(newAvisUpdateIn);
		Avis avis3 = new Avis("faible");
		Avis avis4 = new Avis("très bien");
		
		avis.create(avis1);
		avis.create(avis2);
		avis.create(newAvis);
		avis.update(newAvisUpdate);
		avis.create(avis3);
		avis.create(avis4);
		avis.delete(avis2);
		
		
        avis1.setNewavis("good");
		avis.update(avis1);
		

		Avis avistrouver = new Avis("");
		avistrouver = avis.find(avis4);
		System.out.println(avistrouver.getAvis());
		
		
		ArrayList<Avis> a1 = new ArrayList<Avis>();
		a1 = avis.findAll();
		for(int i=0;i<a1.size(); i++) {
	    System.out.println(a1.get(i).getAvis());
	    
		}


		
		Reservation reserv2 = new Reservation(4, "18/02/2020","25/02/2020", false);
		Reservation reserv3 = new Reservation(8, "13/04/2020","27/04/2020", true);
		Reservation newReserv = new Reservation(NbrPersonne, debutSejour, finSejour, electriciteB);
		Reservation newReservModified = new Reservation(NbrPersonne, debutSejour, finSejourModified, electriciteB);
		reservationDao.update(newReservModified);

		reservationDao.create(newReserv);
		reservationDao.create(reserv2);
		reservationDao.create(reserv3);
		
		newReserv.setNewDateFinReserv("01/2020");
		reservationDao.update(reserv2);
		
		Reservation reservtrouver = new Reservation(0, null, null, null);
		reservtrouver = reservationDao.find(reserv3);
		System.out.println(reservtrouver.getDateDebutReserv()+" " + reservtrouver.getDateFinReserv()+" " + reservtrouver.getElectricite());
		
		ArrayList<Reservation> r1 = new ArrayList<Reservation>();
		r1 = reservationDao.findAll();
		for(int i=0;i<r1.size(); i++) {
	    System.out.println(r1.get(i).getDateDebutReserv() + " "+ r1.get(i).getDateFinReserv());
		}
		deltaNombreJours(reservtrouver.getDateDebutReserv(), reservtrouver.getDateFinReserv());
	
		
		if (deleteLastBooking) {
			reservationDao.delete(newReserv);
		}
		if (findBooking) {
			Reservation newReservFindBooking = new Reservation(0, debutSejour, finSejour, null);
			reservationDao.find(newReservFindBooking);
		}
		if (showAllBooking) {
			ArrayList<Reservation> r3 = new ArrayList<Reservation>();
			r3 = reservationDao.findAll();
			for(int i=0;i<r3.size(); i++) {
				 System.out.println(r3.get(i).getDateDebutReserv() + " "+ r3.get(i).getDateFinReserv());
			}
		}
		
		if(deleteAvis) {
			avis.delete(newAvis);
		}
		if (showAllAvis) {
			a1 = avis.findAll();
			for(int i=0;i<a1.size(); i++) {
				System.out.println(a1.get(i).getAvis());
			}
		}
		
		if (showAllEmplacements) {
			e1 = emplacement.findAll();
			for(int i=0;i<e1.size(); i++) {
				System.out.println(e1.get(i).getSuperficieempl());
			}
		}
			}

	private static long deltaNombreJours(String datedebutreserv, String datefinreserv) throws ParseException { 
		Date dateFrom=new SimpleDateFormat("dd/MM/yyyy").parse(datedebutreserv);
		Date dateTo=new SimpleDateFormat("dd/MM/yyyy").parse(datefinreserv);
		long diff = dateTo.getTime() - dateFrom.getTime();
		//  System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));    	
		long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return days;
	}
	
	//Tarif du séjour = 
			//prix emplacement*nombre de jours + nb de personnes * taxe de séjour * nombre de jours + frais de dossier + (électricité * nb de jours)


} 

