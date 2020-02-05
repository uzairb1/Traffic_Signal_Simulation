import org.junit.Test;

public class PersonStoredTest {

	@Test
	public Boolean test() {
		Boolean flag=false;
		DataStore ds=DataStore.getInstance();
		String username="Noorullah";
		String password="Noor786*";
		String fname="Noori";
		String role="Admin";
		Person p=new Person(username,password,fname,role);
		ds.putPerson(p);
		Person testPerson=ds.getPerson(username);
		String testuser=testPerson.getName();
		if(testuser.equalsIgnoreCase(username))
			flag=true;
		return flag;
		
	}

}
