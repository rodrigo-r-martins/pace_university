import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet("/CookieTest")
public class CookieTest extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

  public CookieTest() {
    super();
  }   	
	
  protected void doGet(HttpServletRequest request, 
  HttpServletResponse response)throws ServletException, IOException {
	String name = "myName";
	String value = "myValue";
    Cookie aCookie = new Cookie(name, value);
    aCookie.setMaxAge(60*60*24*365); // 1 year
    response.addCookie(aCookie);
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>\n" +
      "<head><title>Processing Cookies</title></head>\n" +
	"<body bgcolor=\"#fdf5e6\">\n" +
	"<h1 align=\"center\"> Thanks I will remember you</h1>\n" +
	"</body></html>");
	}  	
}
