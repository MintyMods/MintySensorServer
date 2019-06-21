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
public class HostDaoImpl implements HostDao {

	private static Map<Integer, Host> hosts;

	static {
		hosts = new HashMap<Integer, Host>() {

			private static final long serialVersionUID = 5209229027622341474L;
			{
				put(0, new Host(0, HostType.LOCALHOST, ProtocolType.HTTPS, 8443, new Label(HostType.LOCALHOST)));
				put(1, new Host(1, HostType.LOCALHOST, ProtocolType.HTTP, 8080, new Label(HostType.LOCALHOST)));
				put(2, new Host(2, HostType.REMOTEHOST, ProtocolType.HTTPS, 8443, new Label(HostType.REMOTEHOST)));
				put(3, new Host(3, HostType.REMOTEHOST, ProtocolType.HTTP, 8080, new Label(HostType.REMOTEHOST)));
			}
		};
	}

	@Override
	public Collection<Host> getAllHosts() {
		return hosts.values();
	}

	@Override
	public Host getHostById(int id) {
		return hosts.get(id);
	}

	@Override
	public void removeHostById(int id) {
		hosts.remove(id);
	}

	@Override
	public void updateHost(Host host) {
		Host original = hosts.get(host.getId());
		original.setLabel(host.getLabel());
		hosts.put(host.getId(), original);
	}

	@Override
	public void addHost(Host host) {
		hosts.put(host.getId(), host);
	}
}
