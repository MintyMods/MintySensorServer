package info.mintymods.repository.dao.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import info.mintymods.repository.entities.Label;
import info.mintymods.repository.entities.View;
import info.mintymods.repository.entities.enums.ViewType;


@Repository
@Qualifier("fakeData")
public class ViewDaoImpl implements ViewDao {

	private static Map<Integer, View> views;

	static {
		views = new HashMap<Integer, View>() {

			private static final long serialVersionUID = 5209229027622341474L;
			{
				put(0, new View(0, new Label(ViewType.PC)));
				put(1, new View(1, new Label(ViewType.TV)));
				put(2, new View(2, new Label(ViewType.PHONE)));
			}
		};
	}

	@Override
	public Collection<View> getAllViews() {
		return views.values();
	}

	@Override
	public View getViewById(int id) {
		return views.get(id);
	}

	@Override
	public void removeViewById(int id) {
		views.remove(id);
	}

	@Override
	public void updateView(View view) {
		View original = views.get(view.getId());
		original.setLabel(view.getLabel());
		views.put(view.getId(), original);
	}

	@Override
	public void addView(View view) {
		views.put(view.getId(), view);
	}
}