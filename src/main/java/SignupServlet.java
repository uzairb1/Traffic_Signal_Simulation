import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.write("	<form name=\"signup\" action=\"PersonServlet\">"
				+ "<input type=\"text\" name=\"addname\" placeholder=\"Name\">"
				+ "<br><br>"
				+ "<input type=\"password\" name=\"addpass\" placeholder=\"Password\">"
				+ "<br><br>"
				+ "<input type=\"text\" name=\"FName\" placeholder=\"First Name\">"
				+ "<br><br>"
				+ "<input type=\"text\" name=\"addrole\" placeholder=\"Role\">"
				+ "<br><br><input type=\"submit\" name=\"submit\" value=\"Submit\"></form>");

		
	}
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	}
