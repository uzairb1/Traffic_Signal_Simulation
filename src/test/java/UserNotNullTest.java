import org.junit.Test;

public class UserNotNullTest {

	@Test
	public Boolean userNotNullTest() {
		DataStore ds = DataStore.getInstance();
		String uname = "";
		String pwd = "test";
		String role = "Admin";
		Person p = new Person(uname, pwd, role,"test");
		Boolean result = ds.putPerson(p);
		return result;
	}

}
