package RegisterLogin;

public class Korisnik {
	private String userName;
	private String password;
	private String email;
	private String dob;
	private String gender;
	private String country;
	private int role;
	private int ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Korisnik(int id,String userName, String password, String email, String dob, String gender, String country, int role) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.country = country;
		this.role = role;
	}
	public Korisnik(int userID)
	{
		this.ID=userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getDob() {
		return dob;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public int getRole() {
		return role;
	}

}
