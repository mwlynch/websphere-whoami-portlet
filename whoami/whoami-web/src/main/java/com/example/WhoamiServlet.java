package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.ibm.websphere.security.auth.WSSubject;

@WebServlet("/servlet")
public class WhoamiServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter printWriter = response.getWriter();
    try {
      printWriter.print("Servlet says I am " + WSSubject.getCallerPrincipal());
      printWriter.flush();
      printWriter.close();
    } finally {
      IOUtils.closeQuietly(printWriter);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    doGet(request, response);
  }

}
