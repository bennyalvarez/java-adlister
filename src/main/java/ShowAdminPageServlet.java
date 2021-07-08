import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.ServletException;

@WebServlet(name = "ShowAdminPageServlet", urlPatterns = "/secret-admin-page")
public class ShowAdminPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if((Boolean) session.getAttribute("isAdmin") == false){   //if they are not an admin, we resend them to login
            response.sendRedirect("/login");
            return;
        }

        //if they are admin, we will send them here...
        request.getRequestDispatcher("/WEB-INF/secret-admin-page.jsp").forward(request, response);

    }
}