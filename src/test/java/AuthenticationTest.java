
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AuthenticationTest {

//	This method checks the user with valid credintial and has to return true because 
//	we passed the valid username and password to it
	@Test
	public void checkValidCredentialsLoginTest() throws IOException
	{
		
		Boolean flag;
		IntermediateServlet is=new IntermediateServlet();
		flag=is.CredentialCheck("Uzair", "Uzair786*");
        assertTrue(flag);
	}

//	This method checks the user with invalid credintial and has to return false because 
//	we passed the invalid username to it
	@Test
	public void checkInValidUsernameCredentialsLoginTest() throws IOException
	{
		
		Boolean flag;
		IntermediateServlet is=new IntermediateServlet();
		flag=is.CredentialCheck("UzairTest", "Uzair786*");
        assertFalse(flag);
	}
	
//	This method checks the user with invalid credintial and has to return false because 
//	we passed the invalid password to it
	
	@Test
	public void checkInValidPasswordCredentialsLoginTest() throws IOException
	{
		
		Boolean flag;
		IntermediateServlet is=new IntermediateServlet();
		flag=is.CredentialCheck("Uzair", "Uzair786*Test");
        assertFalse(flag);
	}
	
//	This method checks the user with empty username and has to return false because 
//	we passed an empty username to it
	
	@Test
	public void checkEmptyUserNameLoginTest() throws IOException
	{
		
		Boolean flag;
		IntermediateServlet is=new IntermediateServlet();
		flag=is.CredentialCheck("", "Uzair786*");
        assertFalse(flag);
	}
	
//	This method checks the user with empty password and has to return false because 
//	we passed an empty password to it
	@Test
	public void checkEmptyPasswordLoginTest() throws IOException
	{
		
		Boolean flag;
		IntermediateServlet is=new IntermediateServlet();
		flag=is.CredentialCheck("Uzair", "");
        assertFalse(flag);
	}
//	This method checks the user with empty username and password and has to return false because 
//	we passed an empty username and password to it
	@Test
	public void checkEmptyCredentialsLoginTest() throws IOException
	{
		
		Boolean flag;
		IntermediateServlet is=new IntermediateServlet();
		flag=is.CredentialCheck("", "");
        assertFalse(flag);
	}
//	Test for checking weather only admin can add the new user
	@Test
		public void isAdminRoleAddedbyEmployeeTest() {
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
			assertFalse(flag);
		}

	}



