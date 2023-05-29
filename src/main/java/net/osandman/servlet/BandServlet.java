package net.osandman.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import net.osandman.db_service.GetData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "bandServlet", value = "/band")
public class BandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try (PrintWriter pw = resp.getWriter()) {

            pw.println("<title>" + this.getServletName() + "</title>");
            String bandName = req.getParameter("name");
            printQuery(pw, bandName);

            pw.println("<br>\n" +
                    "<a href=\"/\">HOME</a>");

//        Cookie[] cookies = req.getCookies();
//        for (Cookie cookie : cookies) {
//            pw.println("<p>");
//            pw.printf("%s : %s, MaxAge = %d, version = %s",
//                    cookie.getName(), cookie.getValue(), cookie.getMaxAge(), cookie.getVersion());
//            pw.println("</p>");
//        }

//        Cookie cookie = new Cookie("band_name", "");
//        cookie.setMaxAge(60 * 5);
        }
    }

    private void printQuery(PrintWriter pw, String bandName) {
        Map<String, String> bands = new GetData().getAlbums(bandName);
        if (bands == null || bands.size() == 0) {
            pw.println("<br>Nothing found ... <br>");
        } else {
            pw.println("<p>Get all albums from band name contains word '" + bandName + "'</p>");
            pw.println("<ul>");
            bands.forEach((k, v) -> {
                pw.println("<li>");
                pw.println("<a href=\"./download?album=" +
                        k.replace(" ", "_") + "\">");
                pw.println("[" + v + "] " + k + "<br>");
                pw.println("</a>");
            });
            pw.println("</ul>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
