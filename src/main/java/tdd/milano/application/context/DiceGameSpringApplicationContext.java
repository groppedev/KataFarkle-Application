package tdd.milano.application.context;

import org.apache.commons.lang3.Validate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import tdd.milano.domain.application.IDiceGameApplicationContext;
import tdd.milano.domain.application.IDiceGameApplicationLifeCycle;

public class DiceGameSpringApplicationContext implements IDiceGameApplicationContext, IDiceGameApplicationLifeCycle 
{
	private volatile AbstractApplicationContext applicationContext;
	
	/*
	 * (non-Javadoc)
	 * @see tdd.milano.domain.application.IDiceGameApplicationLifeCycle#start()
	 */
	public void start() 
	{
		Validate.validState(this.applicationContext == null, "Contesto dell'applicazione già avviato!");
		
		this.applicationContext = new ClassPathXmlApplicationContext("injector-config.xml");
		ConfigurableEnvironment ctxEnv = this.applicationContext.getEnvironment();
		ctxEnv.addActiveProfile("PRODUCTION");
		ctxEnv.addActiveProfile("TEST");
		this.applicationContext.refresh();
	}
	
	/*
	 * (non-Javadoc)
	 * @see tdd.milano.domain.application.IDiceGameApplicationLifeCycle#stop()
	 */
	public void stop() 
	{
		Validate.validState(this.applicationContext != null, "Contesto dell'applicazione non avviato,"
				+ " impossibile impossibile eseguire l'operazione di chiusura");
		
		this.applicationContext.close();
	}

	/*
	 * (non-Javadoc)
	 * @see tdd.milano.domain.application.IDiceGameApplicationContext#component(java.lang.String, java.lang.Class)
	 */
	public <T> T getComponent(String componentID, Class<T> componentType) 
	{
		Validate.validState(this.applicationContext != null, "Contesto dell'applicazione non avviato,"
				+ " impossibile risolvere il componente di ID '%s'", componentID);
		
		return this.applicationContext.getBean(componentID, componentType);
	}
}
