package io.github.web22109231705.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "controllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String forwardPath = getServletContext().getContextPath();

        if (request.getParameter("clear") != null) {
            HttpSession session = request.getSession();
            session.invalidate();
        }

        if (request.getParameter("x-select") != null
            && request.getParameter("y-select") != null
            && request.getParameter("r-select") != null)
        {
            forwardPath = this.getServletContext().getContextPath() + "/area-check?x-select=" + request.getParameter("x-select")
            + "&y-select=" + request.getParameter("y-select") + "&r-select=" + request.getParameter("r-select");
        }

        response.sendRedirect(forwardPath);
    }
}
