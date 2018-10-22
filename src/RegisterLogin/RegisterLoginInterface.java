package RegisterLogin;

import java.sql.SQLException;

public interface RegisterLoginInterface {
	public Korisnik getKorisnik(int userID) throws SQLException;

	public void updateKorisnik(Korisnik student) throws SQLException;

	public void deleteKorisnik(Korisnik student) throws SQLException;
	
	public void addKorisnik() throws SQLException;
}
