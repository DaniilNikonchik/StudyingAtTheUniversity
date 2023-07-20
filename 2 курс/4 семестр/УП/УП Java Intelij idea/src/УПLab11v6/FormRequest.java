package УПLab11v6;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormRequest extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        performTask(req, resp);
    }

    public void performTask(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int deg = Integer.parseInt(req.getParameter("deg"));
            double coefficient;

            String input = req.getParameter("coefficients");
            String[] coefficients = input.split(" ");

            double point = Double.parseDouble(req.getParameter("point"));

            double sum = 0;

            for(int i = 0; i <= deg; i++) {
                coefficient = Double.parseDouble(coefficients[i]);
                sum += coefficient * Math.pow(point, deg - i);
            }

            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html; charset=\"UTF-8\"");

            out.println("<HTML>");
            out.println("<TITLE>FormRequest</TITLE>");
            out.println("<h1 align=\"left\">Polynomial value at point: P(" + point + ") = " + sum + "</h1>");
            out.println("</BODY></HTML>");
            out.close();
        }
        catch (Throwable e) {
                e.printStackTrace();
        }
    }
}

