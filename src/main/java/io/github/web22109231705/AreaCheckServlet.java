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

        final String x = request.getParameter("x-select");
        final String y = request.getParameter("y-select");
        final String r = request.getParameter("r-select");

        // Hello
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + x + " " + y + " " + r + "</h1>");
        out.println("</body></html>");
    }
}
