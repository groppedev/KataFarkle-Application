package tdd.milano.application;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationContextListener
 *
 */
@WebListener
public class ApplicationContextListener implements ServletContextListener 
{
    public void contextInitialized(ServletContextEvent sce)  
    { 
		final ServletContext servletContext = sce.getServletContext();

    	ApplicationStateExposer.expose(servletContext);
    	try
    	{
    		// Avvio dell'injector
    		
    		// Configurazione componente per autoinjection.
    	}
    	finally
    	{
    		ApplicationStateExposer.dispose();
    	}
    	servletContext.setAttribute("injector", null);
    }
    
    public void contextDestroyed(ServletContextEvent sce)  
    { 
    	// Chiusura dell'injector.
		final ServletContext servletContext = sce.getServletContext();
    	servletContext.removeAttribute("injector");
    }
}
