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
public class ProviderDaoImpl implements ProviderDao {

	private static Map<Integer, Provider> providers;

	static {
		providers = new HashMap<Integer, Provider>() {

			private static final long serialVersionUID = 5209229027622341474L;
			{
				put(0, new Provider(0, ProviderType.HWINFO,  new Label(ProviderType.HWINFO)));
				put(1, new Provider(1, ProviderType.GPUZ, new Label(ProviderType.GPUZ)));
				put(2, new Provider(2, ProviderType.OHM, new Label(ProviderType.OHM)));
			}
		};
	}

	@Override
	public Collection<Provider> getAllProviders() {
		return providers.values();
	}

	@Override
	public Provider getProviderById(int id) {
		return providers.get(id);
	}

	@Override
	public void removeProviderById(int id) {
		providers.remove(id);
	}

	@Override
	public void updateProvider(Provider provider) {
		Provider original = providers.get(provider.getId());
		original.setLabel(provider.getLabel());
		providers.put(provider.getId(), original);
	}

	@Override
	public void addProvider(Provider provider) {
		providers.put(provider.getId(), provider);
	}
}