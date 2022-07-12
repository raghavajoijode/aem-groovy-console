package org.cid15.aem.groovy.console.servlets;

import com.google.common.net.MediaType;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.cid15.aem.groovy.console.constants.GroovyConsoleConstants;

import java.io.IOException;

abstract class AbstractJsonResponseServlet extends SlingAllMethodsServlet {

    void writeJsonResponse(SlingHttpServletResponse response, Object json) throws IOException {
        response.setContentType(MediaType.JSON_UTF_8.withoutParameters().toString());
        response.setCharacterEncoding(GroovyConsoleConstants.CHARSET);
        response.getWriter().write(new Gson().toJson(json));
    }
}
