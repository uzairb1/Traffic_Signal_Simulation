
 
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/loginServlet")
public class lightchangeServlet extends HttpServlet {
	static String signal1;
	static String signal2;
	static String signal3;
	static String signal4;
	private static final long serialVersionUID = 1L;
	private String param1,param2;
  
	 
	
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException 
    {

        resp.setHeader("Refresh", "5");
    	 param1= (String) req.getSession().getAttribute("username");
         param2= (String) req.getSession().getAttribute("password");
    		try 
			{
				handleRequest(req, resp);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
    	
    }
 
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, InterruptedException {
 
    	resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        
       
        String role="";
        Person p=DataStore.getInstance().getPerson(param1);
	    
        String uname=p.getName();
        String pwd=p.getPassword(); 
        if(p!=null) //check if credentials were not null
        {

    		role = p.getRole();
    		System.out.println(role);
			        if((role.equalsIgnoreCase("Admin") || role.equalsIgnoreCase("LightChanger")))  //check permissions
			        {
			        	

		        	
				        	if(uname.equals(param1) && pwd.equals(param2))   //check credentials
				        	{
				        	trafficlight(req,resp,out);
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
								"                <p>No Permission</p>\r\n" + 
								"                <div id=\"loginBtn\">\r\n" + 
								"                    <input id=\"btn\" type=\"submit\" value=\"Go to Login Page\" />\r\n" + 
								"                </div>\r\n" + 
								"            </form>\r\n" + 
								"        </center>\r\n" + 
								"    </body>	");		
					}
			        
			        
		}
        
        
        else//check if credentials were not null else condition
        {
        	out.write("<body>" + 
					"        <center>\r\n" + 
					"            <form id=\"PersonServlet\" name=\"PersonServlet\" method=\"Get\" action=\"PersonServlet\">\r\n" + 
					"                <p>Credentials Missing</p>\r\n" + 
					"                <div id=\"loginBtn\">\r\n" + 
					"                    <input id=\"btn\" type=\"submit\" value=\"Go to Login Page\" />\r\n" + 
					"                </div>\r\n" + 
					"            </form>\r\n" + 
					"        </center>\r\n" + 
					"    </body>	");		
        }
        out.close();
        
    }
    public void trafficlight(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws InterruptedException, IOException, ServletException
    {
		if(req.getSession().getAttribute("flag")=="true")
		changeRedtoGreen(req,resp,out);
		else if(req.getSession().getAttribute("flag")=="false")
		changeGreentoRed(req, resp, out);
		else
		changeRedtoGreen(req,resp,out);	
    }
    public void dopost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, InterruptedException {
        handleRequest(req, resp);
    }
	public static Boolean isconflicted()
	{
		Boolean flag=false;
		if(signal1==signal2)
		{
			flag=true;
		}
		if(signal3==signal4)
		{
			flag=true;
		}
		return flag;
	}
	public void Display(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws IOException, ServletException, InterruptedException
	{
		String color1=signal1;
		String color2=signal2;
		String color3=signal3;
		String color4=signal4;
	    
			Thread.sleep(2000);
			PrintWriter out1 = resp.getWriter();	
		String write1="<p>"+
				"<span>Light 1 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+
				"<span>Light 2 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+
				"<span>Light 3 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+
				"<span>Light 4 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+
			"</p>"+

			"<p>"+
				"<span style=\"color:"+color1+"\">"+signal1+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+
				"<span style=\"color:"+color2+"\">"+signal2+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+
				"<span style=\"color:"+color3+"\">"+signal3+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+
				"<span style=\"color:"+color4+"\">"+signal4+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>"+
			"</p>"+

			"<form id=\"EmergencyDriverServlet\" name=\"EmergencyDriverServlet\" method=\\\"Get\\\" action=\"EmergencyDriverServlet\"> "+
				"<span><input type=\"submit\" name=\"Signal1\" value=\"Signal1\"></span>"+
				"<span><input type=\"submit\" name=\"Signal2\" value=\"Signal2\"></span>"+
				"<span><input type=\"submit\" name=\"Signal3\" value=\"Signal3\"></span>"+
				"<span><input type=\"submit\" name=\"Signal4\" value=\"Signal4\"></span>"+
			"</form>";
		out1.write(write1);
		out1.flush();
		
		
	}
	public void changeGreentoRed(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws InterruptedException, IOException, ServletException
	{
		signal1="Yellow";
		signal2="Yellow";
		signal3="Yellow";
		signal4="Yellow";
		try {
			Display(req,resp,out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//
		signal1="Red";
		signal3="Red";
		signal2="Green";
		signal4="Green";
		try {
			Display(req,resp,out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!isconflicted())
		{
		req.getSession().setAttribute("flag", "true");	
		}
	}
	public void changeRedtoGreen(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws InterruptedException, IOException, ServletException
	{
		signal1="Yellow";
		signal2="Yellow";
		signal3="Yellow";
		signal4="Yellow";
		try {
			Display(req,resp,out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		signal1="Green";
		signal3="Green";
		signal2="Red";
		signal4="Red";
		try {
			Display(req,resp,out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!isconflicted()) {
			req.getSession().setAttribute("flag", "false");		
		}
	}
	
   
}