package tdd.milano.application;

import java.io.File;

import javax.servlet.ServletContext;

public class PathResolverInitializer 
{
	private final ServletContext sc;

	public PathResolverInitializer(ServletContext sc) 
	{
		this.sc = sc;
	}
	
	public PathResolver initPathResolver()
	{
		return new PathResolver(new File(sc.getRealPath("/")));
	}
}
