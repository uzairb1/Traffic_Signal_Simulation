import org.junit.Test;

public class SignupPermissionTest {

	@Test
	public Boolean SignupTest() {
		PersonServlet ps=new PersonServlet();
		Boolean flag=false;
		DataStore ds=DataStore.getInstance();
		String username="Noorullah";
		String password="Noor786*";
		String fname="Noori";
		String role="Employee";
		Person p=new Person(username,password,fname,role);
		ds.putPerson(p);
		String username1="Noorullah";
		String password1="Noor786*";
		String fname1="Noori";
		String role1="Admin";
		if(ps.isPermitted(role, role1))
		{
			Person p1=new Person(username1,password1,fname1,role1);
			ds.putPerson(p1);
			flag=true;
		}
		
		return flag;
	}

}
