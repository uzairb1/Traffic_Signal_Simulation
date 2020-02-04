import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IntermediateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    String param1,param2;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		param1=request.getParameter("username");
		param2=request.getParameter("password");
		request.getSession().setAttribute("username", param1);
		request.getSession().setAttribute("password", param2);
		request.getSession().setAttribute("logged", "true");
		request.getSession().setAttribute("Emergency","false");
		Person p = null;
		
		if(checkCredentials(request, response, p))
		{
			
		out.write("	"
				+ "<form id=\"SignupServlet\" name=\"SignupServlet\" method=\"Get\" action=\"SignupServlet\">"
				
				+ "<br><br><input type=\"submit\" name=\"Signup\" value=\"Signup\">"
			
				+ "</form>"
				+"	<form id=\"lightchangeServlet\" name=\"lightchangeServlet\" method=\\\"Get\\\" action=\"lightchangeServlet\">"
		
				+ "<br><br><input type=\"submit\" name=\"submit\" value=\"Monitor Signal States\">"
			
				+ "</form>");
		}
		
	}
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
	}
	
	@SuppressWarnings("unused")
	public Boolean checkCredentials(HttpServletRequest request, HttpServletResponse response, Person p) throws IOException
	{
		Boolean flag=false;
		response.setContentType("text/html");
		response.setHeader("Refresh", "5");

        PrintWriter out = response.getWriter();
        
       
        String role="";
        p=DataStore.getInstance().getPerson(param1);
	    
        if(p!=null)  
		{

		    	if(CredentialCheck(param1, param2))   //check credentials
		    	{
		    	  out.write("<html><body><p>all checks passed</p></body></html>");	
		    	  return true;
		    	}
		    	
		    	
		    	else   //check credentials else condition
		    	{
		    		out.write("<body>" + 
							"        <center>\r\n" + 
							"            <form id=\"PersonServlet\" name=\"PersonServlet\" method=\"Get\" action=\"PersonServlet\">\r\n" + 
							"                <p>Wrong Credentials</p>\r\n" + 
							"                <div id=\"loginBtn\">\r\n" + 
							"                    <input id=\"btn\" type=\"submit\" value=\"Go to Login Page\" />\r\n" + 
							"                </div>\r\n" + 
							"            </form>\r\n" + 
							"        </center>\r\n" + 
							"    </body>	");	
		    	}
		        	
		        	
		}
		
		
		else  //check permissions else condition
		{
			out.write("<body>" + 
					"        <center>\r\n" + 
					"            <form id=\"PersonServlet\" name=\"PersonServlet\" method=\"Get\" action=\"PersonServlet\">\r\n" + 
					"                <p>Wrong or no Credentials</p>\r\n" + 
					"                <div id=\"loginBtn\">\r\n" + 
					"                    <input id=\"btn\" type=\"submit\" value=\"Go to Login Page\" />\r\n" + 
					"                </div>\r\n" + 
					"            </form>\r\n" + 
					"        </center>\r\n" + 
					"    </body>	");		
		}
        
        out.close();
        return flag;
	}
	public Boolean CredentialCheck(String uname,String pwd) throws IOException
	{
		Boolean flag=false;
		DataStore ds=DataStore.getInstance();
        Person testPerson=DataStore.getInstance().getPerson(uname);
        if(testPerson!=null)  
		{

            String param1=testPerson.getName();
            String param2=testPerson.getPassword();
		    	if(uname.equals(param1) && pwd.equals(param2))   //check credentials
		    	{
		    	  return true;
		    	}
		    	
		        	
		}
		
		
        return flag;
	}
	}
