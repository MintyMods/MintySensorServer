package info.mintymods.mss.tomcat;

import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

public class TomcatLifeCycleListener implements LifecycleListener {

	@Override
	public void lifecycleEvent(LifecycleEvent event) {
		System.out.println("*** Tomcat Event " + event.getType());
	}

}
