package com.boyar.roman.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"file-servlet"})
@MultipartConfig(location = "/home/projects/servletapp")
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Part> parts = req.getParts();
        for (Part part : parts) {
            if (part.getName().equals("author-name")) {
                InputStream inputStream = part.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                String authorName = new BufferedReader(inputStreamReader)
                        .lines()
                        .collect(Collectors.joining("\n"));
                log(authorName);
            } else {
                part.write(UUID.randomUUID().toString() + part.getSubmittedFileName());
            }
        }
        resp.sendRedirect("/my-app/cool-servlet");
    }
}
