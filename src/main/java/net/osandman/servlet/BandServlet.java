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
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        try (PrintWriter pw = resp.getWriter()) {

//        Cookie[] cookies = req.getCookies();
            pw.println("<title>" + this.getServletName() + "</title>");
            String bandName = req.getParameter("name");
            printQuery(pw, bandName);

            pw.println("<br>\n" +
                    "<a href=\"/\">HOME</a>");
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
            bands.forEach((k, v) -> pw.println("[" + v + "] " + k + "<br>"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
