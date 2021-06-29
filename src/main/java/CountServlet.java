import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name="CountServlet", urlPatterns = "/count")
//public class CountServlet extends HttpServlet{
//    private int counter = 0;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        counter+=1;
//
//        PrintWriter out = res.getWriter();
//        out.println("Your visitor count is: " + counter);
//    }
//}

@WebServlet(name="CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet{
    int counter = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        counter+=1;

        PrintWriter out = res.getWriter();
        out.println("Your visitor count is: " + counter);
    }
}