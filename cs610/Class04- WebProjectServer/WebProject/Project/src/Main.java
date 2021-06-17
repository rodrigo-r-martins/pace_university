import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/Main")
public class Main extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public Main() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse   
    response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();    
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter yes or no: ");
    String message = "";
    String string = scan.next();
    if (string.equalsIgnoreCase("yes")) {
    	message = "Hello there!";
    } else {
    	message = "Have a good night";
    }
    out.println("<html><title>Hello</title><body>\n");
    out.println("<font color = blue>");
    out.println("<h1>" + message + "</h1>\n");
    out.println("</font>");
    out.println("</body></html>");
    scan.close();
    out.close();
  }
}
