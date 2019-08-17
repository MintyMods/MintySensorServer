package info.mintymods.mss.tomcat;

import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TomcatLifeCycleListener implements LifecycleListener {

	private static final Logger log = LoggerFactory.getLogger(TomcatLifeCycleListener.class);

	@Override
	public void lifecycleEvent(final LifecycleEvent event) {
		log.debug("*** Tomcat Event " + event.getType());
	}
}
