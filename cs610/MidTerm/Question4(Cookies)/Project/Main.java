import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet("/Main")
public class Main extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private String head, tail; 
  
	public Main() {
		super();
		head = "<html><title>Not In The List</title><body><font color = blue><h1>";
		tail = "</h1></font></body></html>";
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // This method is complete. Do not change it.  
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		String reEnteredPassword = request.getParameter("reEnterPassword");
		displayCookies(request);
    
		if (isIn(request, userName, password)) {
			if (isTheSame(newPassword, reEnteredPassword)) {
				replace (request, response, userName, password, newPassword);
				success(response);
			} else {
				isNotTheSame (response, newPassword, reEnteredPassword);
			}
		} else {
			isNotInTheList (response, userName, password);
		}
		displayCookies (request);
	}
  
	private boolean isIn(HttpServletRequest request, String userName, String password) {
    /*
     * Check the cookies. 
     * If one of them has the name userName and the value password, then return true
     */ 
		boolean found = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];
				if ((c.getName().equalsIgnoreCase(userName)) && (c.getValue().equalsIgnoreCase(password))) {
		        	found = true;
		        	break;  
		        }
			}
		}
		return found;
	}  

	private boolean isTheSame(String newPassword, String reEnteredPassword) {
    /*
     * Make sure the user entered the same new password twice. 
     * If both newPassword and reEnteredPassword have the same string return true otherwise return false.
     */ 
		boolean isTheSame;
		if (newPassword.equals(reEnteredPassword)) {
			isTheSame = true;
		} else {
			isTheSame = false;
		}
		return isTheSame;
	}
  
	private void replace(HttpServletRequest request, HttpServletResponse response, String userName, String password, String newPassword) {
    /* 
     * This is the case that the program is sure there is a cookie with the name user name and the value password. 
     * Replace the value of this cookie by the value of newPassword.
     */
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];
				if ((c.getName().equalsIgnoreCase(userName)) && (c.getValue().equalsIgnoreCase(password))) {
		        	c.setValue(newPassword);
					break;  
		        }
			}
		}
	}
  
	private void isNotInTheList(HttpServletResponse response, String userName, String password) throws IOException {
    /*
     * Make a html document to display the content of the console.
     */ 
		String message = userName + " with the password: " + password + " is not in the list";
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html><title>Processing Cookies</title><body>\n");
	    out.println("<font color = blue>");
	    out.println("<h1>");
	    out.println(message);
	    out.println("</h1>\n");
	    out.println("</font>");
	    out.println("</body></html>");
		System.out.println(message);
	}

	private void isNotTheSame(HttpServletResponse response, String newPassword, String reEnteredPassword) throws IOException {
    /*
     * Make a html document to display the content of the console.
     */
	
		String message = newPassword + " must be the same as " + reEnteredPassword;
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html><title>Processing Cookies</title><body>\n");
	    out.println("<font color = blue>");
	    out.println("<h1>");
	    out.println(message);
	    out.println("</h1>\n");
	    out.println("</font>");
	    out.println("</body></html>");
		System.out.println(message);
	}  
  
	private void success(HttpServletResponse response) throws IOException {
    /*
     * Make an html document to display the content of the console.
     */

		String message = "The password is changed successfully.";
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html><title>Processing Cookies</title><body>\n");
	    out.println("<font color = blue>");
	    out.println("<h1>");
	    out.println(message);
	    out.println("</h1>\n");
	    out.println("</font>");
	    out.println("</body></html>");
		System.out.println(message);
	}
  
	private void displayCookies(HttpServletRequest request) {
    // This method is complete. Do not change it.
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for(int i=0; i<cookies.length; i++) {
				System.out.println(cookies[i].getName() + ", " + cookies[i].getValue());
			}
			System.out.println("********************************************************");
		}
	}
}
