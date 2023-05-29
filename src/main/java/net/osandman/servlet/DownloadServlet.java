package net.osandman.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"download.txt\"");
        try (OutputStream outputStream = resp.getOutputStream();
             InputStream inputStream = BandServlet.class.getClassLoader().getResourceAsStream("test.json")) {
            outputStream.write(inputStream.readAllBytes());
        }

    }
}
