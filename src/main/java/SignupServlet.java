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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
			request.getSession().setAttribute("role", request.getSession().getAttribute("role"));
		request.getSession().getAttribute("logged").equals("true");
		out.write("	<form name=\"signup\" action=\"PersonServlet\">"
				+ "<input type=\"text\" name=\"addname\" placeholder=\"*Name\">"
				+ "<br><br>"
				+ "<input type=\"password\" name=\"addpass\" placeholder=\"*Password\">"
				+ "<br><br>"
				+ "<input type=\"text\" name=\"FName\" placeholder=\"First Name\">"
				+ "<br><br>"
				+ "<input type=\"text\" name=\"addrole\" placeholder=\"*Role\">"
				+ "<br><br><input type=\"submit\" name=\"submit\" value=\"Submit\"></form>"
				+"<br/><p>Fields with \"*\" must not be left empty</p>");
		out.flush();
		}
		catch(Exception e)
		{
			out.write("<body>" + 
					"        <center>\r\n" + 
					"            <form id=\"PersonServlet\" name=\"PersonServlet\" method=\"Get\" action=\"PersonServlet\">\r\n" + 
					"                <p>You must login</p>\r\n" + 
					"                <div id=\"loginBtn\">\r\n" + 
					"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
					"                </div>\r\n" + 
					"            </form>\r\n" + 
					"        </center>\r\n" + 
					"    </body>	");	
		}
	}
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	}
