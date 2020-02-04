import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AuthenticationTest {

	@Test
	public Boolean checkCredentialsTest(String uname,String pwd) throws IOException
	{
		Boolean flag;
		IntermediateServlet is=new IntermediateServlet();
		flag=is.CredentialCheck(uname, pwd);
        return flag;
	}
	}



