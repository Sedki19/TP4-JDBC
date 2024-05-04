	package JDBCProjet.service;
	
	
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	
	
	
	import JDBCProject.connexion.Connexion;
	import JDBCProjet.beans.Client;
	import JDBCProjet.dao.IDao;
	
	public class ClientService implements IDao <Client> {
		
		@Override
		public boolean create(Client o) {
			try {
	
				PreparedStatement ps =Connexion.getcon().prepareStatement("Insert into Client (nom,prenom) values(?,?) ");
				ps.setString(1, o.getName());
				ps.setString(2, o.getPrenom());
				return ps.execute();
				
				
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				return false;
			}
			
		}
	
		@Override
		public List<Client> findAll() {
			ArrayList<Client> cl = new ArrayList <> ();
			try {
				Statement stmt =Connexion.getcon().createStatement();
				ResultSet rs = stmt.executeQuery("Select * from client");
				while (rs.next()) {
					cl.add(new Client (rs.getInt(1),rs.getString(2),rs.getString(3)));
					
				}
				return cl;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	
		@Override
		public Client findById(int id) {
			
			try {
	
				PreparedStatement ps =Connexion.getcon().prepareStatement("Select * from Client where id = ? ");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next())	
				return new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
				return null;
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				return null;
			}
		}
	
		@Override
		public boolean delete(Client o) {
			try {
				Statement stmt =Connexion.getcon().createStatement();
				int i = stmt.executeUpdate("delete from client where id ="+o.getId());
				if (i>0) {
					return true;
				}
				else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
	
		@Override
		public boolean update(Client o) {
			try {
				PreparedStatement ps =Connexion.getcon().prepareStatement("Update Client set nom = ? , prenom = ? where id = ? ");
				ps.setString(1, o.getName());
				ps.setString(2, o.getPrenom());
				ps.setInt(3, o.getId());
				int i = ps.executeUpdate();
				if (i>0) {
					return true;
				}
				else {
					return false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		
		
	}
