package RegisterLogin;

import java.sql.SQLException;

public interface RegisterLoginInterface {
	public Korisnik getKorisnik(int userID) throws SQLException;
	public Korisnik getKorisnik(String user,String pass) throws SQLException;
	public void updateKorisnik(Korisnik student) throws SQLException;

	public void deleteKorisnik(Korisnik student) throws SQLException;

	void addKorisnik(Korisnik user) throws SQLException;
	boolean isExist(String user,String pass) throws SQLException;
}
