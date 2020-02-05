import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmergencyDriverServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static String signal1;
	static String signal2;
	static String signal3;
	static String signal4;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		signal1=request.getParameter("Signal1");
		signal2=request.getParameter("Signal2");
		signal3=request.getParameter("Signal3");
		signal4=request.getParameter("Signal4");
		String signal_name="";
		String[] sigs=new String[4];
		sigs[0]=signal1;
		sigs[1]=signal2;
		sigs[2]=signal3;
		sigs[3]=signal4;
		for(int i=0;i<4;i++)
		{
			if(sigs[i]!=null)
			{
				signal_name=sigs[i];
			}
		}
		
		try {
			if(request.getSession().getAttribute("logged")=="true")
			emergency(signal_name,request,response,out);
			else
			{
				out.write("<html><body><p>You need to Login</p></body></html>");
				out.write("<body>" + 
						"        <center>\r\n" + 
						"            <form id=\"PersonServlet\" name=\"PersonServlet\" method=\"Get\" action=\"PersonServlet\">\r\n" + 
						"                <div id=\"loginBtn\">\r\n" + 
						"                    <input id=\"btn\" type=\"submit\" value=\"Go to Login Page\" />\r\n" + 
						"                </div>\r\n" + 
						"            </form>\r\n" + 
						"        </center>\r\n" + 
						"    </body>	");		
			}
		} catch (InterruptedException | IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	}
	public void emergency(String signalname,HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws InterruptedException, IOException, ServletException
	{
		if(signalname.equalsIgnoreCase("signal1"))
		{
			signal1="Green";
			signal3="Green";
			signal2="Red";
			signal4="Red";
			
		}
		if(signalname.equalsIgnoreCase("signal2"))
		{
			signal2="Green";
			signal4="Green";
			signal1="Red";
			signal3="Red";
			
		}
		if(signalname.equalsIgnoreCase("signal3"))
		{
			signal1="Green";
			signal3="Green";
			signal2="Red";
			signal4="Red";
			
		}
		if(signalname.equalsIgnoreCase("signal4"))
		{
			signal4="Green";
			signal2="Green";
			signal1="Red";
			signal3="Red";
		}
		Display(req,resp,out);
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
			"</p>";
		out1.write(write1);
		req.getSession().setAttribute("logged","true");
		req.getSession().setAttribute("Emergency", "false");
		out1.write("<body>" + 
				"        <center>\r\n" + 
				"            <form id=\"lightchangeServlet\" name=\"lightchangeServlet\" method=\"Get\" action=\"lightchangeServlet\">\r\n" + 
				"                <div id=\"loginBtn\">\r\n" + 
				"                    <input id=\"btn\" type=\"submit\" value=\"Go Back\" />\r\n" + 
				"                </div>\r\n" + 
				"            </form>\r\n" + 
				"        </center>\r\n" + 
				"    </body>	");		
		out1.flush();
		
		
	}
	}
