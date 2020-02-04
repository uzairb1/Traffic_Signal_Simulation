public class Person {
	private String userid;
	private String Password;
	private String First_Name;
	private String Role;
	
	public Person(String Username, String password, String Role, String Fname) {
		this.userid = Username;
		this.Password = password;
		this.First_Name=Fname;
		this.Role=Role;

	}

	public String getName() {
		return userid;
	}

	public String getPassword() {
		return Password;
	}

	public String getRole() {
		return Role;
	}
}