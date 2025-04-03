package was.httpserver;

import was.httpserver.exception.PageNotFoundException;
import was.httpserver.servlet.InternalErrorServlet;
import was.httpserver.servlet.NotFoundServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServletManager {
    private final Map<String, HttpServlet> servletMap = new HashMap<>();
    private HttpServlet defaultServlet;
    private HttpServlet notFoundErrorServlet = new NotFoundServlet();
    private HttpServlet internalErrorServlet = new InternalErrorServlet();

    public ServletManager() {
    }

    public void add(String path, HttpServlet servlet){
        servletMap.put(path, servlet);
    }

    public void setDefaultServlet(HttpServlet defaultServlet) {
        this.defaultServlet = defaultServlet;
    }

    public void setNotFoundError(HttpServlet notFoundError) {
        this.notFoundErrorServlet = notFoundError;
    }

    public void setInternalError(HttpServlet internalError) {
        this.internalErrorServlet = internalError;
    }

    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        try{
            HttpServlet servlet = servletMap.getOrDefault(request.getPath(), defaultServlet);
            if(servlet == null){
                throw new PageNotFoundException("request url=" + request.getPath());
            }
            servlet.service(request,response);

        }catch(PageNotFoundException e) {
            e.printStackTrace();
            notFoundErrorServlet.service(request, response);
        }catch (Exception e){
            e.printStackTrace();
            internalErrorServlet.service(request,response);
        }
    }
}
