import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest2")
public class CookieTest2 extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	   
  public CookieTest2() {
    super();
  }   	
		
  protected void doGet(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {
    boolean found = false;
    String message = "Thank you for visiting us again";
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0)
      for(int i=0; i<cookies.length; i++) {
        Cookie c = cookies[i];
        if ((c.getName().equals("myName")) && (c.getValue().equals("myValue"))){
          found = true;
	    break;  
	  }
    }
    if(! found)
      message = "I am sorry you have not visited us before.";
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>\n" +
	         "<head><title>Processing Cookies</title></head>\n" +
	    	   "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	    	   "<h1 alighn\"center\">" + message + "</h1>\n" +
	    	   "</body></html>");
  } 
}  	   	  	    

