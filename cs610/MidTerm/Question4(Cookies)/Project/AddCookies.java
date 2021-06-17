import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCookies")
public class AddCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//This servlet is complete. Do not change it.       
	public AddCookies() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		addCookies(response);
		System.out.println("The program terminated with no error.");
	}

	private void addCookies(HttpServletResponse response) {
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File("C:\\Temp\\names.txt"));
			while(true) {
				String name = inputStream.next();
		        String value = inputStream.next();
		        Cookie c = new Cookie(name, value);
		        c.setMaxAge(365 * 24*60*60);
		        response.addCookie(c);
			}
		} catch(Exception e) {
		}
		inputStream.close();
	}
} 
