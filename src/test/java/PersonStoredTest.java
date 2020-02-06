
import static org.junit.Assert.*;

import org.junit.Test;

public class PersonStoredTest {

	
	//User creation Test and in this the test will succeed if the user created successfully.
	@Test
	public void UserCreationTest() {
		Boolean flag=false;
		DataStore ds=DataStore.getInstance();
		String username="Noorullah";
		String password="Noor786*";
		String fname="Noori";
		String role="Admin";
		Person p=new Person(username,password,fname,role);
		ds.putPerson(p);
		Person testPerson=ds.getPerson(username);
		assertEquals(username, testPerson.getName());;
	}
//	Test which checks weather the system accept null username while creating a new user
	@Test
	public void emptyUsernameUserCreationTest() {
		Boolean flag=false;
		DataStore ds=DataStore.getInstance();
		String username="";
		String password="Noor786*";
		String fname="Noori";
		String role="Admin";
		Person p=new Person(username,password,fname,role);
		ds.putPerson(p);
		Person testPerson=ds.getPerson(username);
		assertNull(testPerson);
	}
	
//	Test which checks weather the system accept null password while creating a new user
	@Test
	public void emptyPasswordUserCreationTest() {
		Boolean flag=false;
		DataStore ds=DataStore.getInstance();
		String username="Test";
		String password="";
		String fname="Noori";
		String role="Admin";
		Person p=new Person(username,password,fname,role);
		ds.putPerson(p);
		Person testPerson=ds.getPerson(password);
		assertNull(testPerson);
	}
	
//	Test which checks weather the system accept no role while creating a new user
	@Test
	public void notAssignedRoleUserCreationTest() {
		Boolean flag=false;
		DataStore ds=DataStore.getInstance();
		String username="Test";
		String password="Testing";
		String fname="Noori";
		String role="";
		Person p=new Person(username,password,fname,role);
		ds.putPerson(p);
		Person testPerson=ds.getPerson(role);
		assertNull(testPerson);
	}
//	Test which checks weather the system accept duplicated user or not
	@Test
	public void DuplicateUserTest() {
		DataStore ds=DataStore.getInstance();
		String username="Noorullah";
		String password="Noor786*";
		String fname="Noori";
		String role="Admin";
		Person testPerson=new Person(username,password,fname,role);
		Boolean testflag=ds.putPerson(testPerson);
		assertFalse(testflag);
	}

}
