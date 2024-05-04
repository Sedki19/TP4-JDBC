package demoJDBC;


import java.util.ArrayList;

import JDBCProjet.beans.Client;
import JDBCProjet.service.ClientService;

public class Test {
	
	public static void main(String args[]) {
		//Creation des clients
		Client c1 = new Client (1,"Client1","Client2");
		Client c2 = new Client (2,"Sedki","Shabou");
		Client c3 = new Client (3,"Mortadha","Jouini");
		Client c4 = new Client (4,"Ahmed","Mohsen");
		Client c5 = new Client (5,"Samir","Ahmed");
		//Services
		ClientService cs = new ClientService();
		
		//Insertion
		cs.create(c1);
		cs.create(c2);
		cs.create(c3);
		cs.create(c4);
		cs.create(c5);
		
		
		
		Client cli = cs.findById(3);
		System.out.println(cli);
		
		cs.delete(c3);
		
		Client c2u = new Client (2,"Updated","Updated");
		cs.update(c2u);
		
		
		ArrayList <Client> cl = new ArrayList <>();
		
		cl = (ArrayList<Client>) cs.findAll();
		
		for (Client client : cl) {
			System.out.println(client);
		}
		
		
		
	}
	
	
}
