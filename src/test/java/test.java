import static org.junit.Assert.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.junit.Test;

public class test {

	@Test
	public void test() throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException, IOException {
		RSATest test=new RSATest();
		String testString="This is a test";
	//RSAtest	
		String dec=RSATest.PublicKeyTest(testString);
		assertEquals(testString, dec);
	//PersonTest
		PersonStoredTest pst=new PersonStoredTest();
		Boolean testFlag=pst.test();
		assertTrue(testFlag);
	//DuplicateTest
		DuplicateTest dup=new DuplicateTest();
		testFlag=dup.Duptest();
		assertFalse(testFlag);
		
		//Usernotnull test
		UserNotNullTest obj = new UserNotNullTest();
		testFlag = obj.userNotNullTest();
		assertFalse(testFlag);
		
		//AuthenticationTest
		AuthenticationTest at = new AuthenticationTest();
		testFlag = at.checkCredentialsTest("Uzair", "Uzair786*");
		assertTrue(testFlag);
		
		//UnAuthorizedCheckTest
		testFlag = at.checkCredentialsTest("UzairTest", "Uzair786*");
		assertFalse(testFlag);
	}

}
