package io.github.web22109231705.servlet;

import io.github.web22109231705.model.AreaData;
import io.github.web22109231705.model.UserAreaDatas;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.LinkedList;

@WebServlet(name = "areaCheckServlet", value = "/area-check")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final long startExec = System.nanoTime();

        final String ctx = this.getServletContext().getContextPath();

        final String x = request.getParameter("x-select");
        final String y = request.getParameter("y-select");
        final String r = request.getParameter("r-select");

        final double dx;
        final double dy;
        final double dr;

        try {
            dx = Double.parseDouble(x);
            dy = Double.parseDouble(y);
            dr = Double.parseDouble(r);
        } catch (NumberFormatException | NullPointerException e) {
            response.sendError(400);
            return;
        }

        final boolean result = checkArea(dx, dy, dr);

        final HttpSession currentSession = request.getSession();
        UserAreaDatas datas = (UserAreaDatas) currentSession.getAttribute("points");
        if (datas == null) {
            datas = new UserAreaDatas();
            currentSession.setAttribute("points", datas);
        }
        if (datas.getAreaDataList() == null)
            datas.setAreaDataList(new LinkedList<>());

        final long endExec = System.nanoTime();
        final long executionTime = endExec - startExec;
        final LocalDateTime executedAt = LocalDateTime.now();

        final AreaData data = new AreaData();
        data.setX(dx);
        data.setY(dy);
        data.setR(dr);
        data.setResult(result);
        data.setCalculationTime(executionTime);
        data.setCalculatedAt(executedAt);

        datas.getAreaDataList().addFirst(data);

        // Hello
        response.setContentType("text/html;charset=UTF-8");
        final PrintWriter out = response.getWriter();

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

    private boolean checkArea(final double x, final double y, final double r) {

        final double firstAreaA = Math.abs(x) / (r / 7) - 3;
        final double firstSecondAreaA = Math.abs(y / (r / 7) + (double) 3 / 7 * Math.sqrt(33));
        final double firstSecondAreaB = Math.pow((y / (r / 7)) / 3, 2);
        final double firstSecondAreaC = Math.sqrt(Math.abs(firstSecondAreaA) / firstSecondAreaA);
        final boolean firstArea = (y / (r / 7)) >= 0 && Math.pow(x / r, 2)
                * Math.sqrt(Math.abs(firstAreaA) / (firstAreaA))
                + firstSecondAreaB
                * firstSecondAreaC
                - 1 <= 0;

        final double secondAreaA = Math.abs(x) / (r / 7) - 4;
        final boolean secondArea = (y / (r / 7)) < 0 && Math.pow(x / r, 2)
                * Math.sqrt(Math.abs(secondAreaA) / (secondAreaA))
                + firstSecondAreaB
                * firstSecondAreaC
                - 1 <= 0;

        final boolean thirdArea = (y / (r / 7)) < 0 && Math.abs((x / (r / 7)) / 2)
                - (3 * Math.sqrt(33) - 7) * Math.pow((x / (r / 7)), 2) / 112
                - 3 + Math.sqrt(1 - Math.pow(Math.abs(Math.abs(x) / (r / 7) - 2) - 1, 2))
                - y / (r / 7) <= 0;

        final boolean fourthArea = Math.abs(x) / (r / 7) <= 1 && Math.abs(x) / (r / 7) >= 0.75
                && y / (r / 7) <= 3 && y / (r / 7) >= 0
                && 9 - 8 * Math.abs(x) / (r / 7) >= y / (r / 7);

        final boolean fifthArea = y / (r / 7) >= 0
                && Math.abs(x) / (r / 7) <= 0.75 && Math.abs(x) / (r / 7) >= 0.5
                && 3 * Math.abs(x) / (r / 7) + 0.75 >= y / (r / 7);

        final boolean sixthArea = x / (r / 7) <= 0.5 && x / (r / 7) >= -0.5
                && y / (r / 7) >= 0
                && y / (r / 7) <= 2.25;

        final double seventhAreaA = Math.abs(x) / (r / 7) - 1;
        final boolean seventhArea = y / (r / 7) >= 0 && 6 * Math.sqrt(10) / 7
                + (1.5 - 0.5 * Math.abs(x) / (r / 7))
                * Math.sqrt(Math.abs(seventhAreaA) / seventhAreaA)
                - 6 * Math.sqrt(10) / 14
                * Math.sqrt(4 - Math.pow(seventhAreaA, 2)) >= y / (r / 7);

        return firstArea || secondArea || thirdArea
                || fourthArea || fifthArea || sixthArea || seventhArea;
    }
}
