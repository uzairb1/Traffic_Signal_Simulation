import java.io.IOException;
import org.junit.Test;
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



