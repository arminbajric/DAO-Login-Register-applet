package RegisterLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KorisnikDaoImpl implements RegisterLoginInterface{

	@Override
	public Korisnik getKorisnik(int userID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConManager.getInstance().getConnection();
		Korisnik user=null;
		String upit="SELECT * FROM INFO WHERE id=?";
		ResultSet rs=null;
		try (
			PreparedStatement statement=con.prepareStatement(upit);)
				{
			
					statement.setInt(1, userID);
					rs=statement.executeQuery();
					user = new Korisnik( rs.getString("userName"), rs.getString("password"), rs.getString("email"),
							rs.getString("dob"),	rs.getString("gender"),rs.getString("country"),rs.getInt("role"));
					rs.close();
				}
		return user;
	}

	@Override
	public void updateKorisnik(Korisnik user) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConManager.getInstance().getConnection();
		
		String upit="UPDATE info SET userName=?,password=?,email=?,dob=?,gender=?,country=? WHERE id=?";
		
		try (
			PreparedStatement statement=con.prepareStatement(upit);)
				{
			statement.setString(1, user.getUserName());
			statement.setString(2,user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getDob());
			statement.setString(5, user.getGender());
			statement.setString(6, user.getCountry());
			statement.setInt(7, user.getID());
					
				
					statement.executeUpdate();
				}
	}

	@Override
	public void deleteKorisnik(Korisnik user) throws SQLException {
		// TODO Auto-generated method stub
Connection con = ConManager.getInstance().getConnection();
		
		String upit="DELETE * FROM info WHERE id=?";
		
		try (
			PreparedStatement statement=con.prepareStatement(upit);)
				{
			
			statement.setInt(7, user.getID());
					
				
					statement.executeUpdate();
				}
	}

	@Override
	public void addKorisnik(Korisnik user) throws SQLException {
		// TODO Auto-generated method stub
Connection con = ConManager.getInstance().getConnection();
		
		String upit="INSERT INTO info(userName,password,email,dob,gender,country) VALUES (?,?,?,?,?,?"  ;
		
		try (
			PreparedStatement statement=con.prepareStatement(upit);)
				{
			statement.setString(1, user.getUserName());
			statement.setString(2,user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getDob());
			statement.setString(5, user.getGender());
			statement.setString(6, user.getCountry());
			
					
				
					statement.executeUpdate();
				}
	}

	

}
