package RegisterLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class KorisnikDaoImpl implements RegisterLoginInterface {

	@Override
	public Korisnik getKorisnik(int userID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConManager.getInstance().getConnection();
		Korisnik user = null;
		String upit = "SELECT * FROM INFO WHERE id=?";
		ResultSet rs = null;
		try (PreparedStatement statement = con.prepareStatement(upit);) {

			statement.setInt(1, userID);
			rs = statement.executeQuery();
			if (rs.next()) {

				user = new Korisnik(userID, rs.getString("userName"), rs.getString("password"), rs.getString("email"),
						rs.getString("dob"), rs.getString("gender"), rs.getString("country"), rs.getInt("role"));
				rs.close();
			}
		}
		return user;
	}

	@Override
	public void updateKorisnik(Korisnik user) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConManager.getInstance().getConnection();

		String upit = "UPDATE info SET userName=?,password=?,email=?,dob=?,gender=?,country=? WHERE id=?";

		try (PreparedStatement statement = con.prepareStatement(upit);) {
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
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

		String upit = "DELETE * FROM info WHERE id=?";

		try (PreparedStatement statement = con.prepareStatement(upit);) {

			statement.setInt(7, user.getID());

			statement.executeUpdate();
		}
	}

	@Override
	public void addKorisnik(Korisnik user) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = ConManager.getInstance().getConnection();

		String upit = "INSERT INTO info(userName,password,email,dob,gender,country) VALUES (?,?,?,?,?,?";

		try (PreparedStatement statement = con.prepareStatement(upit);) {
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getDob());
			statement.setString(5, user.getGender());
			statement.setString(6, user.getCountry());

			statement.executeUpdate();
		}
	}

	@Override
	public boolean isExist(String user, String pass) throws SQLException {
		// TODO Auto-generated method stub
		Korisnik korisnik = null;
		korisnik = getKorisnik(user, pass);
		try {
			if (korisnik.getID() >= 0) {
				return true;
			}

		} catch (NullPointerException e) {
			// e.printStackTrace();
		}
		return false;
	}

	public int setKorisnikId(String user, String pass) throws SQLException {
		// TODO Auto-generated method stub
		int userId = 0;
		Connection con = ConManager.getInstance().getConnection();
		Korisnik korisnik = null;
		String upit = "SELECT * FROM info WHERE userName=? AND password=?";
		ResultSet rs = null;
		try (PreparedStatement statement = con.prepareStatement(upit);) {

			statement.setString(1, user);
			statement.setString(2, pass);
			rs = statement.executeQuery();
			if (rs.next()) {

				korisnik = new Korisnik(rs.getInt("id"));
				rs.close();
			}
		}
		return userId;
	}
public JTable getTable(int userID) throws SQLException
{
	Connection con = ConManager.getInstance().getConnection();
	String query="SELECT ime,prezime,grad,email,dob FROM imeniklist WHERE 'info.id'=?";
	ResultSet rs=null;
	DefaultTableModel model=new DefaultTableModel();
	Vector temp = new Vector();
	temp.add("Ime");
	temp.add("Prezime");
	temp.add("Grad");
	temp.add("Email");
	temp.add("Datum rodjenja");
	model.addRow(temp);
	JTable t;
	try (PreparedStatement statement = con.prepareStatement(query);) {

		statement.setInt(1, userID);
		
		rs = statement.executeQuery();
		while(rs.next())
		{
			
			temp=new Vector();
			temp.add(rs.getString("ime"));
			temp.add(rs.getString("prezime"));
			temp.add(rs.getString("grad"));
			temp.add(rs.getString("email"));
			temp.add(rs.getString("dob"));
			model.addRow(temp);
		}
		 t = new JTable(model);
	
	}
	return t;
}

@Override
public Korisnik getKorisnik(String user, String pass) throws SQLException {
	// TODO Auto-generated method stub
	Connection con = ConManager.getInstance().getConnection();
	Korisnik korisnik = null;
	String upit = "SELECT * FROM INFO WHERE userName=? AND password=?";
	ResultSet rs = null;
	try (PreparedStatement statement = con.prepareStatement(upit);) {

		statement.setString(1, user);
		statement.setString(2, pass);
		rs = statement.executeQuery();
		if (rs.next()) {

			korisnik = new Korisnik(rs.getInt("id"), rs.getString("userName"), rs.getString("password"),
					rs.getString("email"), rs.getString("dob"), rs.getString("gender"), rs.getString("country"),
					rs.getInt("role"));
			rs.close();
		}
	}
	return korisnik;
}
}
