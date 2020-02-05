public class Person {
	private String userid;
	private String Password;
	private String Role;
	
	public Person(String bs, String password, String Role, String Fname) {
		this.userid = bs;
		this.Password = password;
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