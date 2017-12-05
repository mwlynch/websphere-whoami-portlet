package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;

import com.ibm.websphere.security.auth.WSSubject;

public class WhoamiPortlet extends GenericPortlet {

  @Override
  public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
    PrintWriter printWriter = response.getWriter();
    try {
      printWriter.print("Serve Resource says I am " + WSSubject.getCallerPrincipal());
      printWriter.flush();
      printWriter.close();
    } finally {
      IOUtils.closeQuietly(printWriter);
    }
  }

  @Override
  protected void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
    PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
    request.setAttribute("whoami", "Do view says I am " + WSSubject.getCallerPrincipal());
    dispatcher.forward(request, response);
  }
}
