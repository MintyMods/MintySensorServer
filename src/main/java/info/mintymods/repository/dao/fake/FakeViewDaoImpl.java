package info.mintymods.repository.dao.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.dao.ViewDao;
import info.mintymods.repository.entities.Label;
import info.mintymods.repository.entities.View;
import info.mintymods.repository.entities.enums.ViewType;

@Repository
@Qualifier("fakeData")
public class FakeViewDaoImpl implements ViewDao {

	private static Map<Long, View> views;
	static {
		views = new HashMap<Long, View>() {

			private static final long serialVersionUID = 5209229027622341474L;
			{
				put(0l, new View(0l, new Label(ViewType.ADMIN)));
				put(1l, new View(1l, new Label(ViewType.SETTINGS)));
				put(2l, new View(2l, new Label(ViewType.PC)));
				put(3l, new View(3l, new Label(ViewType.TV)));
				put(4l, new View(4l, new Label(ViewType.PHONE)));
			}
		};
	}

	public void addView(View view) {
		views.put(view.getId(), view);
	}

	public Collection<View> getAllViews() {
		return views.values();
	}

	public View getViewById(Long id) {
		return views.get(id);
	}

	public void removeViewById(Long id) {
		views.remove(id);
	}

	public void updateView(View view) {
		final View original = views.get(view.getId());
		original.setLabel(view.getLabel());
		views.put(view.getId(), original);
	}

	@Override
	public <S extends View> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends View> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<View> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<View> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<View> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(View entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll(Iterable<? extends View> entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
	}
}