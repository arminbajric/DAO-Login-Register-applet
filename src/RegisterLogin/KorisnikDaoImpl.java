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
	public void updateKorisnik(Korisnik student) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKorisnik(Korisnik student) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addKorisnik() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
