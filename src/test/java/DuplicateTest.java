import static org.junit.Assert.*;

import org.junit.Test;

public class DuplicateTest {

	@Test
	public Boolean Duptest() {
		Boolean flag=false;
		DataStore ds=DataStore.getInstance();
		String username="Noorullah";
		String password="Noor786*";
		String fname="Noori";
		String role="Admin";
		Person testPerson=new Person(username,password,fname,role);
		Boolean testflag=ds.putPerson(testPerson);
		return testflag;
	}

}
