package io.github.web22109231705;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "areaCheckServlet", value = "/area-check")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String ctx = this.getServletContext().getContextPath();

        final String x = request.getParameter("x-select");
        final String y = request.getParameter("y-select");
        final String r = request.getParameter("r-select");

        boolean result = checkArea(x,y,r);

        // Hello
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\" />");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <link rel=\"stylesheet\" href=\"" + ctx + "/styles/style.css\">");
        out.println("    <title>Calculation result</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div id=\"header\" class=\"blured-container round-container margin\">");
        out.println("        <h1>Calculation results</h1>");
        out.println("    </div>");
        out.println("    <div id=\"result-table-container\" class=\"blured-container margin\">");
        out.println("        <table>");
        out.println("            <tr>");
        out.println("                <th>Parameter</th>");
        out.println("                <th>Received Value</th>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td>X</td>");
        out.println("                <td>" + x + "</td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td>Y</td>");
        out.println("                <td>" + y + "</td>");
        out.println("            </tr>");
        out.println("            <tr>");
        out.println("                <td>R</td>");
        out.println("                <td>" + r + "</td>");
        out.println("            </tr>");
        out.println("        </table>");
        out.println("    </div>");
        out.println("    <div class=\"blured-container round-container fit-content-container margin\">");
        out.println("        <p>Result: " + (result ? "Right in target!" : "Are you a bad shooter? No problem! Fortunately, the armed forces of the Russian Federation invite men to military service under contract. Call 117!") + "</p>");
        out.println("    </div>");
        out.println("    <div class=\"blured-container round-container fit-content-container margin\">"); // Здесь подставьте результат вычислений
        out.println("        <p><a href=\"" + ctx + "\">Return to homepage</a></p>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    private boolean checkArea(String x, String y, String r) {
        return false;
    }
}
