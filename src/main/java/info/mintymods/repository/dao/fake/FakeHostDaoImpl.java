package info.mintymods.repository.dao.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.HostDao;
import info.mintymods.repository.entities.Host;
import info.mintymods.repository.entities.Label;
import info.mintymods.repository.entities.enums.HostType;
import info.mintymods.repository.entities.enums.ProtocolType;

@Repository
@Qualifier("fakeData")
public abstract class FakeHostDaoImpl implements HostDao {

	private static Map<Long, Host> hosts;
	static {
		hosts = new HashMap<Long, Host>() {

			private static final long serialVersionUID = 5209229027622341474L;
			{
				put(0l, new Host(0l, HostType.LOCALHOST, ProtocolType.HTTPS, 8443, new Label(HostType.LOCALHOST)));
				put(1l, new Host(1l, HostType.LOCALHOST, ProtocolType.HTTP, 8080, new Label(HostType.LOCALHOST)));
				put(2l, new Host(2l, HostType.REMOTEHOST, ProtocolType.HTTPS, 8443, new Label(HostType.REMOTEHOST)));
				put(3l, new Host(3l, HostType.REMOTEHOST, ProtocolType.HTTP, 8080, new Label(HostType.REMOTEHOST)));
			}
		};
	}

	public void addHost(Host host) {
		hosts.put(host.getId(), host);
	}

	public Collection<Host> getAllHosts() {
		return hosts.values();
	}

	public Host getHostById(Long id) {
		return hosts.get(id);
	}

	public void removeHostById(Long id) {
		hosts.remove(id);
	}

	public void updateHost(Host host) {
		final Host original = hosts.get(host.getId());
		original.setLabel(host.getLabel());
		hosts.put(host.getId(), original);
	}
}
