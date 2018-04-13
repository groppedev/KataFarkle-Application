package tdd.milano.application;

import javax.servlet.ServletContext;

public class ApplicationState 
{
	private final ServletContext sc;

	public ApplicationState(ServletContext sc) 
	{
		this.sc = sc;
	}

	public ServletContext servletContext() 
	{
		return sc;
	}
}
