package io.github.web22109231705;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "controllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {
//    private String message;

//    public void init() {
//        message = "Hello World!";
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");

        String path = getServletContext().getContextPath();

        if (request.getParameter("x-select") != null
            && request.getParameter("y-select") != null
            && request.getParameter("r-select") != null)
        {
            path = this.getServletContext().getContextPath() + "/area-check?x-select=" + request.getParameter("x-select")
            + "&y-select=" + request.getParameter("y-select") + "&r-select=" + request.getParameter("r-select");
        }

        response.sendRedirect(path);
    }
}
