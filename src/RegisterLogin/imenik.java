package RegisterLogin;

public class imenik {
String ime;
String prezime;
String email;
String grad;
String dob;
public imenik(String ime, String prezime, String email, String grad, String dob) {
	super();
	this.ime = ime;
	this.prezime = prezime;
	this.email = email;
	this.grad = grad;
	this.dob = dob;
}
public void setIme(String ime) {
	this.ime = ime;
}
public void setPrezime(String prezime) {
	this.prezime = prezime;
}
public void setEmail(String email) {
	this.email = email;
}
public void setGrad(String grad) {
	this.grad = grad;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getIme() {
	return ime;
}
public String getPrezime() {
	return prezime;
}
public String getEmail() {
	return email;
}
public String getGrad() {
	return grad;
}
public String getDob() {
	return dob;
}

}
