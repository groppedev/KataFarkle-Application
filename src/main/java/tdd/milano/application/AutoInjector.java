package tdd.milano.application;

import org.springframework.context.support.AbstractApplicationContext;

public class AutoInjector 
{
	private final AbstractApplicationContext applicationContext;

	public AutoInjector(AbstractApplicationContext applicationContext) 
	{
		this.applicationContext = applicationContext;
	}
}
