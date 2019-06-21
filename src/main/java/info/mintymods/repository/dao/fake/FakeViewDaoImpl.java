package info.mintymods.repository.dao.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

	@Override
	public void addView(View view) {
		views.put(view.getId(), view);
	}

	@Override
	public Collection<View> getAllViews() {
		return views.values();
	}

	@Override
	public View getViewById(Long id) {
		return views.get(id);
	}

	@Override
	public void removeViewById(Long id) {
		views.remove(id);
	}

	@Override
	public void updateView(View view) {
		final View original = views.get(view.getId());
		original.setLabel(view.getLabel());
		views.put(view.getId(), original);
	}
}