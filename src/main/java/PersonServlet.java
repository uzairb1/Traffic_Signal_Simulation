import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	String uname="";
	String pass="";
	String role="";
	String fname="";
		
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		uname=(String) request.getParameter("addname");
		pass=(String) request.getParameter("addpass");
		role=(String) request.getParameter("addrole");
		fname=(String) request.getParameter("FName");
		request.getSession().setAttribute("Emergency","false");
		
		
		////start checks
		if(uname!=null && pass!=null && role!=null)
		{
			out.write("<body>" + 
					"        <center>\r\n" + 
					"            <form id=\"PersonServlet\" name=\"PersonServlet\" method=\"Get\" action=\"PersonServlet\">\r\n" + 
					"                <p>Person Added</p>\r\n" + 
					"                <div id=\"loginBtn\">\r\n" + 
					"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
					"                </div>\r\n" + 
					"            </form>\r\n" + 
					"        </center>\r\n" + 
					"    </body>	");		
			parseparams(out);
			Person p=new Person(uname,pass,fname,role);
			Boolean flag=DataStore.getInstance().putPerson(p);
			if(!flag)
			{
				out.write("<body>" + 
						"        <center>\r\n" + 
						"            <form id=\"PersonServlet\" name=\"PersonServlet\" method=\"Get\" action=\"PersonServlet\">\r\n" + 
						"                <p>Person not Added</p>\r\n" + 
						"                <div id=\"loginBtn\">\r\n" + 
						"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
						"                </div>\r\n" + 
						"            </form>\r\n" + 
						"        </center>\r\n" + 
						"    </body>	");		
				
			}
			
		}
		
		else if(uname==null)
		{
				out.write("<body>\r\n" + 
						"        <center>\r\n" + 
						"            <h2>Servlet Send Redirect Example</h2>\r\n" + 
						"            <form id=\"IntermediateServlet\" name=\"IntermediateServlet\" method=\"Get\" action=\"IntermediateServlet\">\r\n" + 
						"                <div id=\"usernameDiv\" class=\"paddingBtm\">\r\n" + 
						"                    <span id=\"user\">Username: </span><input id=\"userInput\" type=\"text\" name=\"username\" />\r\n" + 
						"                </div>\r\n" + 
						"                <div id=\"passwordDiv\" class=\"paddingBtm\">\r\n" + 
						"                    <span id=\"pass\">Password: </span><input id=\"passInput\" type=\"password\" name=\"password\" />\r\n" + 
						"                </div>\r\n" + 
						"                <div id=\"loginBtn\">\r\n" + 
						"                    <input id=\"btn\" type=\"submit\" value=\"Login\" />\r\n" + 
						"                </div>\r\n" + 
						"            </form>\r\n" + 
						"        </center>\r\n" + 
						"    </body>	");		
		}
		else parseparams(out);

		
	}
	
	

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	
	public void parseparams(PrintWriter out)
	{
		if(role==null)
		{
			out.write("<body>" + 
					"        <center>\r\n" + 
					"            <form id=\"SignupServlet\" name=\"SignupServlet\" method=\"Get\" action=\"SignupServlet\">\r\n" + 
					"                <p>role cannot be null</p>\r\n" + 
					"                <div id=\"loginBtn\">\r\n" + 
					"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
					"                </div>\r\n" + 
					"            </form>\r\n" + 
					"        </center>\r\n" + 
					"    </body>	");		
		}
		else if(pass==null)
		{
			out.write("<body>" + 
					"        <center>\r\n" + 
					"            <form id=\"SignupServlet\" name=\"SignupServlet\" method=\"Get\" action=\"SignupServlet\">\r\n" + 
					"                <p>password cannot be null</p>\r\n" + 
					"                <div id=\"loginBtn\">\r\n" + 
					"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
					"                </div>\r\n" + 
					"            </form>\r\n" + 
					"        </center>\r\n" + 
					"    </body>	");	
		}
		else if(uname==null)
		{
			out.write("<body>" + 
					"        <center>\r\n" + 
					"            <form id=\"SignupServlet\" name=\"SignupServlet\" method=\"Get\" action=\"SignupServlet\">\r\n" + 
					"                <p>Username cannot be null</p>\r\n" + 
					"                <div id=\"loginBtn\">\r\n" + 
					"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
					"                </div>\r\n" + 
					"            </form>\r\n" + 
					"        </center>\r\n" + 
					"    </body>	");	
			}
		out.close();
		}
	}
