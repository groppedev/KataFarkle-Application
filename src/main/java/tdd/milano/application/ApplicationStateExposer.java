package tdd.milano.application;

import javax.servlet.ServletContext;

public class ApplicationStateExposer 
{
	private static final ThreadLocal<ApplicationState> EXPOSER = new ThreadLocal<>();
	
	public static void expose(ServletContext sc)
	{
		EXPOSER.set(new ApplicationState(sc));
	}
	
	public static ServletContext getServletContext()
	{
		return EXPOSER.get().servletContext();
	}
	
	public static void dispose()
	{
		EXPOSER.remove();
	}

}
