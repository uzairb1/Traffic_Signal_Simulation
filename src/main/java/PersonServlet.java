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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		////start checks
		//check if not null
		uname=(String) request.getParameter("addname");
		pass=(String) request.getParameter("addpass");
		role=(String) request.getParameter("addrole");
		fname=(String) request.getParameter("FName");
		if(uname!=null && pass!=null && role!=null)
		{
			doPost(request, response);
		}
		
		else
		{
		
				out.write("<body>\r\n" + 
						"        <center>\r\n" + 
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
		out.close();
	}
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		uname=(String) request.getParameter("addname");
		pass=(String) request.getParameter("addpass");
		role=(String) request.getParameter("addrole");
		fname=(String) request.getParameter("FName");
		request.getSession().setAttribute("Emergency","false");
		
		
			//check if formats are correct
			if(checkParams(uname, pass, role) )
			{
				
				parseparams(out);
				Person p=new Person(uname,pass,role,fname);
				String empRole=(String) request.getSession().getAttribute("role");
				
				if(isPermitted(empRole, role))
				{
					if(DataStore.getInstance().putPerson(p))
					{
						PrintWriter out1=response.getWriter();
						output1("Person Added", out1);	
						System.out.println("Person Added");
					}
					else
					{
						PrintWriter out1=response.getWriter();
						output("Person not added as Person might already exists or Some data is missing", out1);	
					}
				}
				else
				{
					output1("Employee cannot add Admin or LightChanger ", out);	
				}
			}
			else
			{
					output("Invalid data, role not valid or required fields are null", out);	
				
			}
		
	}
	
	
	public Boolean parseparams(PrintWriter out)
	{
		if(role==null)
		{
				return false;
		}
		else if(pass==null)
		{
				return false;
		}
		else if(uname==null)
		{	
				return false;
		}
		return true;
		}
	
	
	public Boolean checkParams(String uname, String pwd, String role)
	{
		
		if(role.equalsIgnoreCase("Admin")|| role.equalsIgnoreCase("LightChanger") ||role.equalsIgnoreCase("Employee") )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public Boolean isPermitted(String role1, String role2)
	{
		Boolean flag=true;
		System.out.println(role1 + " is adding " + role2);
		if(role1.equalsIgnoreCase("Employee"))
		{
			if(!role2.equalsIgnoreCase("Employee"))
				return false;
			
		}
		return flag;
	}
	
	
	public void output(String msg, PrintWriter out)
	{
		out.write("<body>" + 
				"        <center>\r\n" + 
				"            <form id=\"SignupServlet\" name=\"SignupServlet\" method=\"Get\" action=\"SignupServlet\">\r\n" + 
				"                <p>"+msg+"</p>\r\n" + 
				"                <div id=\"loginBtn\">\r\n" + 
				"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
				"                </div>\r\n" + 
				"            </form>\r\n" + 
				"        </center>\r\n" + 
				"    </body>	");	
	}
	
	
	public void output1(String msg, PrintWriter out)
	{
		out.write("<body>" + 
				"        <center>\r\n" + 
				"            <form id=\"PersonServlet\" name=\"PersonServlet\" method=\"Get\" action=\"PersonServlet\">\r\n" + 
				"                <p>"+msg+"</p>\r\n" + 
				"                <div id=\"loginBtn\">\r\n" + 
				"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
				"                </div>\r\n" + 
				"            </form>\r\n" + 
				"        </center>\r\n" + 
				"    </body>	");	
		}
}
	
