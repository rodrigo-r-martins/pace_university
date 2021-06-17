import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
@WebServlet("/Main")

public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Main() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> htmlParameters = request.getParameterNames();
		PrintWriter out = response.getWriter();
		String message = " ";
		
		while (htmlParameters.hasMoreElements()) {
			String parameter = (String)htmlParameters.nextElement();
			String value = request.getParameter(parameter);
			
			if (parameter.equalsIgnoreCase("yourName") && value.isEmpty()) {
				message = "You need to enter your name";
				break;
			} 
			
			if (parameter.equalsIgnoreCase("yourAge")) {
			
				if (value.isEmpty()) {
					message = "You need to enter your age";
					break;
				
				} else if (!value.matches("[0-9]+") || Integer.parseInt(value) < 0) {
					message = "You need to enter a positive integer for your age";
					break;
				
				} else {
					
					if (Integer.parseInt(value) > 17) {
						message = "You are eligible to drive";
					
					} else {
						message = "You are not eligible to drive";
					
					}
				}
			}
		}
		out.println("<html><title>Hello</title><body>\n");
		out.println("<font color = blue>");
		out.println("<h1>");
		out.println(message);
		out.println("</h1>\n");
		out.println("</font>");
		out.println("</body></html>");
		out.close();
	}
}
