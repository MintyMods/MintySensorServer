package info.mintymods.repository.dao.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.ProviderDao;
import info.mintymods.repository.entities.Label;
import info.mintymods.repository.entities.Provider;
import info.mintymods.repository.entities.enums.ProviderType;

@Repository
@Qualifier("fakeData")
public abstract class FakeProviderDaoImpl implements ProviderDao {

	private static Map<Long, Provider> providers;
	static {
		providers = new HashMap<Long, Provider>() {

			private static final long serialVersionUID = 5209229027622341474L;
			{
				put(0l, new Provider(0l, ProviderType.HWINFO, new Label(ProviderType.HWINFO)));
				put(1l, new Provider(1l, ProviderType.GPUZ, new Label(ProviderType.GPUZ)));
				put(2l, new Provider(2l, ProviderType.OHM, new Label(ProviderType.OHM)));
			}
		};
	}

	public void addProvider(Provider provider) {
		providers.put(provider.getRecordId(), provider);
	}

	public Collection<Provider> getAllProviders() {
		return providers.values();
	}

	public Provider getProviderById(Long id) {
		return providers.get(id);
	}

	public void removeProviderById(Long id) {
		providers.remove(id);
	}

	public void updateProvider(Provider provider) {
		final Provider original = providers.get(provider.getRecordId());
		original.setLabel(provider.getLabel());
		providers.put(provider.getRecordId(), original);
	}
}